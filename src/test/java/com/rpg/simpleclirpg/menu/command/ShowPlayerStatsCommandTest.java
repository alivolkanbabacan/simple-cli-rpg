package com.rpg.simpleclirpg.menu.command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rpg.simpleclirpg.data.Game;
import com.rpg.simpleclirpg.data.character.player.Player;
import com.rpg.simpleclirpg.io.Console;
import com.rpg.simpleclirpg.menu.ContinueGameMenu;
import com.rpg.simpleclirpg.menu.Menu;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link ShowPlayerStatsCommand}
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ShowPlayerStatsCommandTest {

	@Mock
	private Console console;

	@InjectMocks
	private ShowPlayerStatsCommand command;

	@Test
	public void testContinueGameAfterShowingStats() {
		Game.getInstance().setPlayer(new Player("Test_Player"));
		
		Menu menu = command.execute();
		assertEquals(new ContinueGameMenu(), menu);
	}

}
