package com.rpg.simpleclirpg.data.character;

import org.junit.jupiter.api.Test;

import com.rpg.simpleclirpg.constant.Color;
import com.rpg.simpleclirpg.data.character.monster.SmallAnimatedObject;
import com.rpg.simpleclirpg.data.character.player.Player;

import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link Player}
 */
public class PlayerTest {
	private static final String PLAYER_NAME = "Test_player";

	@Test
	public void testGainExperienceAfterPlayerAttacks() {
		Player player = new Player(PLAYER_NAME);
		SmallAnimatedObject sa = new SmallAnimatedObject();

		player.attack(sa);
		assertEquals(0, player.getExperiencePoints());

		player.attack(sa);
		assertEquals(sa.getXpBonus(), player.getExperiencePoints());
	}

	@Test
	public void testGetStats() {
		StringBuilder builder = new StringBuilder();
		builder.append("\tPlayer" + lineSeparator());
		builder.append("name: " + PLAYER_NAME + lineSeparator());
		builder.append("hit points: 100/100" + lineSeparator());
		builder.append("damage: 15" + lineSeparator());
		builder.append("experience points: 0" + lineSeparator());
		String statsPlayer = builder.toString();

		Player player = new Player(PLAYER_NAME);
		assertEquals(statsPlayer, player.getStats());
	}

	@Test
	public void testGetPlayerSymbol() {
		assertEquals(Color.GREEN.getValue() + 'C' + Color.RESET.getValue(), new Player(PLAYER_NAME).getSymbol());
	}
}
