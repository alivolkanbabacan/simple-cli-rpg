package com.rpg.simpleclirpg.menu.command;

import com.rpg.simpleclirpg.menu.GameMenu;
import com.rpg.simpleclirpg.menu.Menu;

/**
 * Command representing going back to the game menu.
 */
public class NavigateToGameCommand implements Command {

	@Override
	public Menu execute() {
		return new GameMenu();
	}
}
