package com.rpg.simpleclirpg.menu.command;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.rpg.simpleclirpg.constant.Color;
import com.rpg.simpleclirpg.constant.Direction;
import com.rpg.simpleclirpg.constant.Passable;
import com.rpg.simpleclirpg.data.Game;
import com.rpg.simpleclirpg.data.character.monster.SmallAnimatedObject;
import com.rpg.simpleclirpg.data.character.player.Player;
import com.rpg.simpleclirpg.data.map.Area;
import com.rpg.simpleclirpg.data.map.Map;
import com.rpg.simpleclirpg.data.map.Position;
import com.rpg.simpleclirpg.data.theme.HauntedMansionTheme;
import com.rpg.simpleclirpg.manager.map.MapManager;
import com.rpg.simpleclirpg.menu.FightMenu;
import com.rpg.simpleclirpg.menu.GameMenu;
import com.rpg.simpleclirpg.menu.Menu;
import com.rpg.simpleclirpg.menu.WinMenu;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link MoveCommand}
 */
public class MoveCommandTest {
	private static Player player;
	private static Map map;
	private static Position playerPosition;
	private static Area areaToMove;
	private static Game game;

	@BeforeAll
	static void initAll() {
		player = new Player("Test_player");
		map = MapManager.generateNewMap(player, new HauntedMansionTheme());
		playerPosition = map.getPlayerPosition();
		areaToMove = new Area(Passable.PASSABLE);

		game = Game.getInstance();
		game.setMap(map);
		game.setPlayer(player);
		game.setTheme(new HauntedMansionTheme());
	}

	@AfterAll
	static void resetPlayerPosition() {
		game.getMap().setPlayerPosition(playerPosition);
	}

	@Test
	public void testMoveToUnOccupiedArea() {
		areaToMove.setCharacter(null);
		areaToMove.setWinArea(false);
		map.getAreas()[playerPosition.getX() - 1][playerPosition.getY()] = areaToMove;

		MoveCommand command = new MoveCommand(Direction.N);
		Menu menu = command.execute();
		assertEquals(new GameMenu(), menu);
	}

	@Test
	public void testMoveToMonsterOccupiedArea() {
		areaToMove.setCharacter(new SmallAnimatedObject());
		areaToMove.setWinArea(false);
		map.getAreas()[playerPosition.getX() + 1][playerPosition.getY()] = areaToMove;

		MoveCommand command = new MoveCommand(Direction.S);
		Menu menu = command.execute();
		assertEquals(new FightMenu(game.getMap().getAreas()[playerPosition.getX() + 1][playerPosition.getY()]), menu);
	}

	@Test
	public void testMoveToWinArea() {
		areaToMove.setCharacter(null);
		areaToMove.setWinArea(true);
		map.getAreas()[playerPosition.getX()][playerPosition.getY() + 1] = areaToMove;

		MoveCommand command = new MoveCommand(Direction.E);
		Menu menu = command.execute();
		assertEquals(new WinMenu(game.getTheme()), menu);
	}

	@Test
	public void testMoveToImPassableArea() {
		Area areaToMove = new Area(Passable.IMPASSABLE);
		map.getAreas()[playerPosition.getX()][playerPosition.getY() - 1] = areaToMove;

		MoveCommand command = new MoveCommand(Direction.W);
		Menu menu = command.execute();
		assertEquals(new GameMenu(Color.RED.getValue() + "Cannot move there!" + Color.RESET.getValue()), menu);
	}
}
