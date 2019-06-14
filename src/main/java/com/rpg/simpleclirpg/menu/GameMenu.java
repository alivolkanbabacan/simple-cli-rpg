package com.rpg.simpleclirpg.menu;

import java.util.Arrays;

import com.rpg.simpleclirpg.constant.Direction;
import com.rpg.simpleclirpg.data.Game;
import com.rpg.simpleclirpg.menu.command.MoveCommand;
import com.rpg.simpleclirpg.menu.command.NavigateToMainMenuCommand;
import com.rpg.simpleclirpg.menu.command.SaveGameCommand;
import com.rpg.simpleclirpg.menu.command.ShowPlayerStatsCommand;

import static java.lang.System.lineSeparator;

/**
 * Menu holding instructions for game.
 * 
 * @see {@link Menu}
 */
public class GameMenu extends Menu {
	private static final String NO_MESSAGE = "";

	public GameMenu() {
		this(NO_MESSAGE);
	}

	public GameMenu(String message){
		super(Game.getInstance().getMap().toString() + lineSeparator() + message + lineSeparator() + "What would you like to do?", Arrays.asList(
				new MenuItem("N", "Move North", new MoveCommand(Direction.N)),
				new MenuItem("W", "Move West", new MoveCommand(Direction.W)),
				new MenuItem("S", "Move South", new MoveCommand(Direction.S)),
				new MenuItem("E", "Move East", new MoveCommand(Direction.E)),
				new MenuItem("SG", "Save Game", new SaveGameCommand()),
				new MenuItem("ST", "Show Player Stats", new ShowPlayerStatsCommand()),
				new MenuItem("Q", "Back to Main Menu", new NavigateToMainMenuCommand())
				));
	}
}
