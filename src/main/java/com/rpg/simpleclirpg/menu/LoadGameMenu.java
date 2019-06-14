package com.rpg.simpleclirpg.menu;

import java.util.List;

/**
 * Menu holding instructions for loading a game.
 * 
 * @see {@link Menu}
 */
public class LoadGameMenu extends Menu {
	private static final String HEADER = "Choose one of the following games to load:";

	public LoadGameMenu(List<MenuItem> menuItems) {
		super(HEADER, menuItems);
	}
}
