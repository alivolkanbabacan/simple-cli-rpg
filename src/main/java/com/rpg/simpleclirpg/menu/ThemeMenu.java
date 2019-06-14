package com.rpg.simpleclirpg.menu;

import java.util.Arrays;

import com.rpg.simpleclirpg.data.theme.HauntedMansionTheme;
import com.rpg.simpleclirpg.data.theme.MagicLampTheme;
import com.rpg.simpleclirpg.menu.command.CreateNewCharacterCommand;

/**
 * Menu holding instructions for choosing a theme for the game.
 * 
 * @see {@link Menu}
 */
public class ThemeMenu extends Menu {
	private static final String HEADER = "\tPlease Choose your Theme";

	public ThemeMenu() {
		super(HEADER, Arrays.asList(
				new MenuItem("1", "Magic Lamp", new CreateNewCharacterCommand(new MagicLampTheme())),
				new MenuItem("2", "Haunted Mansion", new CreateNewCharacterCommand(new HauntedMansionTheme()))
				));
	}
}
