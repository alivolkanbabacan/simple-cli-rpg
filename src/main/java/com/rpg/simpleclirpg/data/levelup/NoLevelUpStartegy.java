package com.rpg.simpleclirpg.data.levelup;

import com.rpg.simpleclirpg.data.character.player.Player;

/**
 * No level up strategy implementation of {@link LevelUpStrategy}.
 */
public class NoLevelUpStartegy implements LevelUpStrategy {
	private static final long serialVersionUID = -4304115325515891883L;

	@Override
	public boolean isLevelUp(int experience) {
		return false;
	}

	@Override
	public void levelUpPlayer(Player player) {
		throw new UnsupportedOperationException("This player cannot level up!");
	}
}
