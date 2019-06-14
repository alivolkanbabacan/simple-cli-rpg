package com.rpg.simpleclirpg.data.theme;

import java.io.Serializable;

import com.rpg.simpleclirpg.factory.character.MonsterFactory;

/**
 * This class represents the Theme of the game.
 */
public abstract class Theme implements Serializable {
	private static final long serialVersionUID = 7994415331201782668L;

	protected final String description;
	protected final String winMessage;
	protected final MonsterFactory monsterFactory;

	Theme(String description, String winMessage, MonsterFactory monsterFactory) {
		this.description = description;
		this.winMessage = winMessage;
		this.monsterFactory = monsterFactory;
	}

	public String getDescription() {
		return description;
	}

	public String getWinMessage() {
		return winMessage;
	}

	public MonsterFactory getMonsterFactory() {
		return monsterFactory;
	}
}
