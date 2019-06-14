package com.rpg.simpleclirpg.menu;

import java.util.Arrays;

import com.rpg.simpleclirpg.menu.command.CreateNewGameCommand;
import com.rpg.simpleclirpg.menu.command.ExitGameCommand;
import com.rpg.simpleclirpg.menu.command.GetLoadFilesCommand;

/**
 * Main menu of the game.
 * 
 * @see {@link Menu}
 */
public class MainMenu extends Menu {
	private static final String HEADER = "\tMain Menu";

	public MainMenu() {
		super(HEADER, Arrays.asList(
				new MenuItem("1", "Start a New Game", new CreateNewGameCommand()),
				new MenuItem("2", "Load Game", new GetLoadFilesCommand()),
				new MenuItem("3", "Exit", new ExitGameCommand())
				));
	}
}
