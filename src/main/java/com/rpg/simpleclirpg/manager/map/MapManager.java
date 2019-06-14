package com.rpg.simpleclirpg.manager.map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.rpg.simpleclirpg.constant.Passable;
import com.rpg.simpleclirpg.data.character.player.Player;
import com.rpg.simpleclirpg.data.map.Area;
import com.rpg.simpleclirpg.data.map.Map;
import com.rpg.simpleclirpg.data.map.Position;
import com.rpg.simpleclirpg.data.theme.Theme;

/**
 * Manager class for map operations
 */
public class MapManager {
	private static final int ROOM_DIMENSION_WITH_WALLS = 7;
	private static final int MAP_SIZE = 40;
	private static final int ROOM_PLACEMENT_TRY_LIMIT = 150;
	private static final int PLACABLE_AREA_TO_MONSTER_BASE_RATIO = 30;

	private static Area[][] areas;

	/**
	 * Generates a new map with the given player and for the given theme.
	 * 
	 * @param player {@link Player}
	 * @param theme  {@link Theme}
	 * @return map generated {@link Map}
	 */
	public static Map generateNewMap(Player player, Theme theme) {
		areas = new Area[MAP_SIZE][MAP_SIZE];

		List<Room> rooms = placeRooms();
		placeCorridors(rooms);

		Position playerPosition = placePlayer(rooms, player);
		markExploredAreas(areas, playerPosition);

		List<Area> placableAreas = getPlacableAreas();
		placeMonsters(placableAreas, theme);
		placeWinArea(placableAreas);

		return new Map(areas, playerPosition);
	}

	/**
	 * Marks areas as explored according to the player position.
	 * 
	 * @param areas
	 * @param playerPosition {@link Position}
	 */
	public static void markExploredAreas(Area[][] areas, Position playerPosition) {
		int x = playerPosition.getX();
		int y = playerPosition.getY();

		for (int i = x - 2; i < x + 3; i++) {
			for (int j = y - 2; j < y + 3; j++) {
				if (i >= 0 && j >= 0 && i < MAP_SIZE && j < MAP_SIZE) {
					areas[i][j].setExplored(true);
				}
			}
		}
	}

	/*
	 * Places rooms on the map randomly
	 */
	private static List<Room> placeRooms() {
		List<Room> rooms = new ArrayList<>();
		for (int i = 0; i < ROOM_PLACEMENT_TRY_LIMIT; i++) {
			Random random = new Random();
			int x = random.nextInt(MAP_SIZE);
			int y = random.nextInt(MAP_SIZE);

			if (x + ROOM_DIMENSION_WITH_WALLS <= MAP_SIZE && y + ROOM_DIMENSION_WITH_WALLS <= MAP_SIZE) {
				boolean createRoom = true;

				for (int j = x; j < x + ROOM_DIMENSION_WITH_WALLS; j++) {
					for (int k = y; k < y + ROOM_DIMENSION_WITH_WALLS; k++) {
						if (areas[j][k] != null) {
							createRoom = false;
						}
					}
				}

				if (createRoom) {
					for (int j = x + 1; j < x + ROOM_DIMENSION_WITH_WALLS - 1; j++) {
						for (int k = y + 1; k < y + ROOM_DIMENSION_WITH_WALLS - 1; k++) {
							areas[j][k] = new Area(Passable.PASSABLE);
						}
					}
					Room room = new Room(x + ROOM_DIMENSION_WITH_WALLS / 2, y + ROOM_DIMENSION_WITH_WALLS / 2);
					rooms.add(room);
				}
			}
		}

		return sortRoomsByDistance(rooms);
	}

	/*
	 * Places corridors between rooms
	 */
	private static void placeCorridors(List<Room> rooms) {
		for (int i = 0; i < rooms.size() - 1; i++) {

			if (rooms.get(i).xCenter < rooms.get(i + 1).xCenter) {
				for (int j = rooms.get(i).xCenter; j < rooms.get(i + 1).xCenter + 1; j++) {
					areas[j][rooms.get(i).yCenter] = new Area(Passable.PASSABLE);
				}
			} else if (rooms.get(i).xCenter > rooms.get(i + 1).xCenter) {
				for (int j = rooms.get(i).xCenter; j > rooms.get(i + 1).xCenter - 1; j--) {
					areas[j][rooms.get(i).yCenter] = new Area(Passable.PASSABLE);
				}
			}

			if (rooms.get(i).yCenter < rooms.get(i + 1).yCenter) {
				for (int j = rooms.get(i).yCenter; j < rooms.get(i + 1).yCenter + 1; j++) {
					areas[rooms.get(i + 1).xCenter][j] = new Area(Passable.PASSABLE);
				}
			} else if (rooms.get(i).yCenter > rooms.get(i + 1).yCenter) {
				for (int j = rooms.get(i).yCenter; j > rooms.get(i + 1).yCenter - 1; j--) {
					areas[rooms.get(i + 1).xCenter][j] = new Area(Passable.PASSABLE);
				}
			}
		}

		placeImPassableAreas();
	}

	/*
	 * Places player on the center of the first room
	 */
	private static Position placePlayer(List<Room> rooms, Player player) {
		Room room = rooms.get(0);
		areas[room.xCenter][room.yCenter].setCharacter(player);
		return new Position(room.xCenter, room.yCenter);
	}

	/*
	 * Returns areas that are placable on the map
	 */
	private static List<Area> getPlacableAreas() {
		List<Area> placableAreas = new ArrayList<>();
		for (int x = 0; x < areas.length; x++) {
			for (int y = 0; y < areas[x].length; y++) {
				if (areas[x][y].isPassable() && !areas[x][y].isOccupied()) {
					placableAreas.add(areas[x][y]);
				}
			}
		}

		return placableAreas;
	}

	/*
	 * Places the winning area randomly on one of the placable areas on the map
	 */
	private static void placeWinArea(List<Area> placableAreas) {
		Area areaToPlace = placableAreas.get(new Random().nextInt(placableAreas.size()));
		areaToPlace.setWinArea(true);
		placableAreas.remove(areaToPlace);
	}

	/*
	 * Places monsters randomly on the placable areas on the map
	 */
	private static void placeMonsters(List<Area> placableAreas, Theme theme) {
		int numberOfMonsters = (int) (((placableAreas.size() / PLACABLE_AREA_TO_MONSTER_BASE_RATIO) + 1)
				* (Math.random() + 1));
		for (int i = 0; i < numberOfMonsters; i++) {
			Area areaToPlace = placableAreas.get(new Random().nextInt(placableAreas.size()));
			areaToPlace.setCharacter(theme.getMonsterFactory().createMonster());
			placableAreas.remove(areaToPlace);
		}
	}

	/*
	 * Returns a list of rooms sorted by the distance between their centers. First
	 * one is the first room, then second room is the nearest room to the first
	 * room. Then the third is the nearest room to the second room other than the
	 * first room and sorting continues like this.
	 */
	private static List<Room> sortRoomsByDistance(List<Room> rooms) {
		List<Room> sortedByDistance = new ArrayList<>();
		Room room = rooms.get(0);

		while (room != null) {
			sortedByDistance.add(room);
			int xCenter = room.xCenter;
			int yCenter = room.yCenter;
			Optional<Room> nearest = rooms.stream()
					.filter(e -> e.xCenter != xCenter && e.yCenter != yCenter && !sortedByDistance.contains(e))
					.sorted(Comparator.comparing(e -> Math.sqrt((e.xCenter - xCenter) * (e.xCenter - xCenter)
							+ (e.yCenter - yCenter) * (e.yCenter - yCenter))))
					.findFirst();

			room = nearest.orElse(null);
		}

		for (Room rm : rooms) {
			if (!sortedByDistance.contains(rm)) {
				int xCenter = rm.xCenter;
				int yCenter = rm.yCenter;

				Optional<Room> nearest = rooms.stream().filter(e -> e.xCenter != xCenter && e.yCenter != yCenter)
						.sorted(Comparator.comparing(e -> Math.sqrt((e.xCenter - xCenter) * (e.xCenter - xCenter)
								+ (e.yCenter - yCenter) * (e.yCenter - yCenter))))
						.findFirst();

				if (nearest.isPresent()) {
					sortedByDistance.add(nearest.get());
				}
			}
		}

		return sortedByDistance;
	}

	/*
	 * Places the impassable areas on the map
	 */
	private static void placeImPassableAreas() {
		for (int x = 0; x < areas.length; x++) {
			for (int y = 0; y < areas[x].length; y++) {
				if (areas[x][y] == null) {
					areas[x][y] = new Area(Passable.IMPASSABLE);
				}
			}
		}
	}

	private static class Room {
		private int xCenter;
		private int yCenter;

		Room(int xCenter, int yCenter) {
			this.xCenter = xCenter;
			this.yCenter = yCenter;
		}
	}
}
