package com.rpg.simpleclirpg.menu;

import java.util.Arrays;

import com.rpg.simpleclirpg.data.theme.Theme;
import com.rpg.simpleclirpg.menu.command.NavigateToMainMenuCommand;

/**
 * Menu holding instructions for the end of the game.
 * 
 * @see {@link Menu}
 */
public class WinMenu extends Menu {

	public WinMenu(Theme theme) {
		super(theme.getWinMessage(),
				Arrays.asList(new MenuItem("Q", "Back to Main Menu", new NavigateToMainMenuCommand())));
	}
}
