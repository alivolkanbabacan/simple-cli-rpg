package com.rpg.simpleclirpg.data.character.monster;

import com.rpg.simpleclirpg.constant.Color;
import com.rpg.simpleclirpg.data.character.Character;

import static java.lang.System.lineSeparator;

/**
 * Parent class for the enemies in the game
 */
public abstract class Monster extends Character {
	private static final long serialVersionUID = -6381723273178805241L;

	protected final int xpBonus;

	public Monster(int hp, String name, int damage, int xpBonus, String symbol) {
		super(hp, name, damage, symbol);
		this.xpBonus = xpBonus;
	}

	public int getXpBonus() {
		return xpBonus;
	}

	/**
	 * Returns the unique symbol of the monster.
	 * 
	 * @return symbol of the monster
	 */
	@Override
	public String getSymbol() {
		return Color.RED.getValue() + symbol + Color.RESET.getValue();
	}

	/**
	 * Returns stats of the monster in an organized manner.
	 * 
	 * @return stats of the monster
	 */
	@Override
	public String getStats() {
		StringBuilder builder = new StringBuilder();
		builder.append("\tMonster" + lineSeparator());
		builder.append("name: " + name + lineSeparator());
		builder.append("hit points: " + currentHp + "/" + totalHp + lineSeparator());
		builder.append("damage: " + damage + lineSeparator());
		return builder.toString();
	}
}
