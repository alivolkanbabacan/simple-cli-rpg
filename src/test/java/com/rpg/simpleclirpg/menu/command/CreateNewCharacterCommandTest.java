package com.rpg.simpleclirpg.menu.command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rpg.simpleclirpg.data.theme.HauntedMansionTheme;
import com.rpg.simpleclirpg.data.theme.Theme;
import com.rpg.simpleclirpg.io.Console;
import com.rpg.simpleclirpg.menu.GameMenu;
import com.rpg.simpleclirpg.menu.Menu;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link CreateNewCharacterCommand}
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CreateNewCharacterCommandTest {

	@Mock
	private Console console;

	@Spy
	private Theme theme = new HauntedMansionTheme();

	@InjectMocks
	private CreateNewCharacterCommand command;

	@Test
	public void testNavigateToGameAfterCharacterCreation() {
		when(console.getInputForMessage(anyString())).thenReturn("Test_Player");

		Menu menu = command.execute();
		assertEquals(new GameMenu(), menu);
	}
}
