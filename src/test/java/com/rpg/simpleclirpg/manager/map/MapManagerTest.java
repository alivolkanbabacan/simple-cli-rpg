package com.rpg.simpleclirpg.manager.map;

import org.junit.jupiter.api.Test;

import com.rpg.simpleclirpg.data.character.player.Player;
import com.rpg.simpleclirpg.data.map.Area;
import com.rpg.simpleclirpg.data.map.Map;
import com.rpg.simpleclirpg.data.theme.HauntedMansionTheme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for {@link MapManager}
 */
public class MapManagerTest {
	private Map map = MapManager.generateNewMap(new Player("Test_Player"), new HauntedMansionTheme());

	/*
	 * Testing if the player has been positioned on the game map.
	 */
	@Test
	public void testHasPlayerPositionOnMap() {
		assertNotNull(map.getPlayerPosition());
	}

	/*
	 * Testing if the winning area has been positioned on the game map.
	 */
	@Test
	public void testHasOneWinAreaOnMap() {
		int winAreaCount = 0;
		Area[][] areas = map.getAreas();
		for (int i = 0; i < areas.length; i++) {
			for (int j = 0; j < areas.length; j++) {
				if (areas[i][j].isWinArea()) {
					winAreaCount++;
				}
			}
		}
		assertEquals(1, winAreaCount);
	}

	/*
	 * Testing if the characters and winning area has been positioned on passable
	 * areas on the game map.
	 */
	@Test
	public void testCharactersAndWinConditionPlacedOnPassableAreas() {
		boolean onPassableAreas = true;
		Area[][] areas = map.getAreas();
		for (int i = 0; i < areas.length; i++) {
			for (int j = 0; j < areas.length; j++) {
				if (areas[i][j].isOccupied() && !areas[i][j].isPassable()) {
					onPassableAreas = false;
				}
			}
		}

		assertTrue(onPassableAreas);
	}
}
