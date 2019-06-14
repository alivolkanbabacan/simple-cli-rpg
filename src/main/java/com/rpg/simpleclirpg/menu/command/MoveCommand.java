package com.rpg.simpleclirpg.menu.command;

import com.rpg.simpleclirpg.constant.Color;
import com.rpg.simpleclirpg.constant.Direction;
import com.rpg.simpleclirpg.data.Game;
import com.rpg.simpleclirpg.data.map.Position;
import com.rpg.simpleclirpg.manager.map.MapManager;
import com.rpg.simpleclirpg.menu.FightMenu;
import com.rpg.simpleclirpg.menu.GameMenu;
import com.rpg.simpleclirpg.menu.Menu;
import com.rpg.simpleclirpg.menu.WinMenu;

/**
 * Command representing the player moving on the game map.
 */
public class MoveCommand implements Command {
	private final Direction direction;
	private Game game = Game.getInstance();

	public MoveCommand(Direction direction) {
		this.direction = direction;
	}

	@Override
	public Menu execute() {
		boolean canMove = false;
		Position oldPosition = game.getMap().getPlayerPosition();
		Position newPosition = null;
		switch (direction) {
		case N:
			newPosition = new Position(oldPosition.getX() - 1, oldPosition.getY());
			break;
		case W:
			newPosition = new Position(oldPosition.getX(), oldPosition.getY() - 1);
			break;
		case S:
			newPosition = new Position(oldPosition.getX() + 1, oldPosition.getY());
			break;
		case E:
			newPosition = new Position(oldPosition.getX(), oldPosition.getY() + 1);
			break;
		}

		if (newPosition == null) {
			canMove = false;
		} else if (game.getMap().getAreas()[newPosition.getX()][newPosition.getY()].isWinArea()) {

			return new WinMenu(game.getTheme());

		} else if (game.getMap().getAreas()[newPosition.getX()][newPosition.getY()].isOccupied()) {

			return new FightMenu(game.getMap().getAreas()[newPosition.getX()][newPosition.getY()]);

		} else if (game.getMap().getAreas()[newPosition.getX()][newPosition.getY()].isPassable()) {
			canMove = true;
			game.getMap().getAreas()[oldPosition.getX()][oldPosition.getY()].setCharacter(null);
			game.getMap().getAreas()[newPosition.getX()][newPosition.getY()].setCharacter(game.getPlayer());
			game.getMap().setPlayerPosition(newPosition);
			MapManager.markExploredAreas(game.getMap().getAreas(), newPosition);
		}

		GameMenu gameMenu;
		if (!canMove) {
			gameMenu = new GameMenu(Color.RED.getValue() + "Cannot move there!" + Color.RESET.getValue());
		} else {
			gameMenu = new GameMenu();
		}

		return gameMenu;
	}
}
