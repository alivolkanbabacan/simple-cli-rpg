package com.rpg.simpleclirpg.data.map;

import java.io.Serializable;

import static java.lang.System.lineSeparator;

/**
 * Class representing game map.
 * 
 * @see {@link Area}
 * @see {@link Position}
 */
public class Map implements Serializable {
	private static final long serialVersionUID = -3280965615025379745L;

	private final Area[][] areas;
	private Position playerPosition;

	public Map(Area[][] areas, Position playerPosition) {
		this.areas = areas;
		this.playerPosition = playerPosition;
	}

	public Area[][] getAreas() {
		return areas;
	}

	public Position getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(Position playerPosition) {
		this.playerPosition = playerPosition;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int x = 0; x < areas.length; x++) {
			for (int y = 0; y < areas[x].length; y++) {
				builder.append(areas[x][y].getSymbol());
			}

			builder.append(lineSeparator());
		}

		return builder.toString();
	}
}
