package com.rpg.simpleclirpg.menu.command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rpg.simpleclirpg.io.Console;

import static org.junit.Assert.assertNull;

/**
 * Test class for {@link ExitGameCommand}
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ExitGameCommandTest {

	@Mock
	private Console console;

	@InjectMocks
	private ExitGameCommand command;

	@Test
	public void testExitGame() {
		assertNull(command.execute());
	}
}
