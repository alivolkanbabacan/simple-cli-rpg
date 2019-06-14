package com.rpg.simpleclirpg.menu.command;

import org.junit.jupiter.api.Test;

import com.rpg.simpleclirpg.menu.ThemeMenu;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link CreateNewGameCommand}
 */
public class CreateNewGameCommandTest {

	@Test
	public void testThemeMenuOpensAfterNewGameSelected() {
		CreateNewGameCommand command = new CreateNewGameCommand();
		assertEquals(new ThemeMenu(), command.execute());
	}
}
