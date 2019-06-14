package com.rpg.simpleclirpg.data.character;

import java.io.Serializable;

/**
 * Parent class for all the Monsters and the Player
 */
public abstract class Character implements Serializable {
	private static final long serialVersionUID = -1270521902016907358L;

	protected final String name;
	protected final String symbol;
	protected final int totalHp;
	protected int currentHp;
	protected int damage;

	public Character(int totalHp, String name, int damage, String symbol) {
		this.totalHp = currentHp = totalHp;
		this.name = name;
		this.damage = damage;
		this.symbol = symbol;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}

	public int getTotalHp() {
		return totalHp;
	}

	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getSymbol() {
		return symbol;
	}

	/**
	 * Returns stats of the character in an organized manner.
	 * 
	 * @return stats of the character
	 */
	public abstract String getStats();
}
