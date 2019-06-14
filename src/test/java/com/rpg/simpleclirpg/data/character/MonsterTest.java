package com.rpg.simpleclirpg.data.character;

import org.junit.jupiter.api.Test;

import com.rpg.simpleclirpg.data.character.monster.Monster;
import com.rpg.simpleclirpg.data.character.monster.Wisp;

import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link Monster}
 */
public class MonsterTest {

	@Test
	public void testGetStats() {
		StringBuilder builder = new StringBuilder();
		builder.append("\tMonster" + lineSeparator());
		builder.append("name: " + "Wisp" + lineSeparator());
		builder.append("hit points: 20/20" + lineSeparator());
		builder.append("damage: 5" + lineSeparator());
		String statsWisp = builder.toString();

		Monster monster = new Wisp();
		assertEquals(statsWisp, monster.getStats());
	}
}
