package com.rpg.simpleclirpg.menu.command;

import com.rpg.simpleclirpg.menu.Menu;
import com.rpg.simpleclirpg.menu.ThemeMenu;

/**
 * Command representing a new game creation.
 */
public class CreateNewGameCommand implements Command {

	@Override
	public Menu execute() {
		return new ThemeMenu();
	}
}
