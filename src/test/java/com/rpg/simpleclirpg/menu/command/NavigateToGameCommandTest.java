package com.rpg.simpleclirpg.menu.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.rpg.simpleclirpg.data.Game;
import com.rpg.simpleclirpg.data.character.player.Player;
import com.rpg.simpleclirpg.data.theme.HauntedMansionTheme;
import com.rpg.simpleclirpg.manager.map.MapManager;
import com.rpg.simpleclirpg.menu.GameMenu;

/**
 * Test class for {@link NavigateToGameCommand}
 */
public class NavigateToGameCommandTest {

	/*
	 * Testing returning to game menu after fleeing from a fight.
	 */
	@Test
	public void testReturnToGameAfterFleeing() {
		Game game = Game.getInstance();
		game.setMap(MapManager.generateNewMap(new Player("Test_Player"), new HauntedMansionTheme()));

		NavigateToGameCommand command = new NavigateToGameCommand();
		assertEquals(new GameMenu(), command.execute());
	}
}
