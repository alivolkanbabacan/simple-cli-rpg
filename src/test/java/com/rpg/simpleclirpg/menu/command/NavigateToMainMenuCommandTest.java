package com.rpg.simpleclirpg.menu.command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rpg.simpleclirpg.io.Console;
import com.rpg.simpleclirpg.menu.MainMenu;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link NavigateToMainMenuCommand}
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class NavigateToMainMenuCommandTest {

	@Mock
	private Console console;

	@InjectMocks
	private NavigateToMainMenuCommand command;

	@Test
	public void testNavigatingToMainMenu() {
		assertEquals(new MainMenu(), command.execute());
	}
}
