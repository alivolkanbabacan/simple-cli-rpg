package com.rpg.simpleclirpg.menu.command;

import com.rpg.simpleclirpg.io.Console;
import com.rpg.simpleclirpg.io.InputOutput;
import com.rpg.simpleclirpg.menu.MainMenu;
import com.rpg.simpleclirpg.menu.Menu;

/**
 * Command representing going back to the main menu.
 */
public class NavigateToMainMenuCommand implements Command {
	private static final String NAVIGATE_TO_MAIN_MENU = "Navigating to main menu...";
	private final InputOutput io;

	public NavigateToMainMenuCommand() {
		this.io = Console.getInstance();
	}

	public NavigateToMainMenuCommand(InputOutput io) {
		this.io = io;
	}

	@Override
	public Menu execute() {
		io.print(NAVIGATE_TO_MAIN_MENU);
		return new MainMenu();
	}
}
