package com.rpg.simpleclirpg.menu;

import java.util.Arrays;

import com.rpg.simpleclirpg.menu.command.NavigateToGameCommand;

/**
 * Menu holding instructions to return to game menu.
 * 
 * @see {@link Menu}
 * @see {@link GameMenu}
 */
public class ContinueGameMenu extends Menu {
	private static final String HEADER = "";

	public ContinueGameMenu() {
		super(HEADER, Arrays.asList(new MenuItem("C", "Continue Game", new NavigateToGameCommand())));
	}
}
