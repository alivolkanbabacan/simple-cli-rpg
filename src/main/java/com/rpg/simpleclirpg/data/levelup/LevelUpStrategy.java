package com.rpg.simpleclirpg.data.levelup;

import java.io.Serializable;

import com.rpg.simpleclirpg.data.character.player.Player;

/**
 * Interface for level up strategy for player
 * 
 * @see {@link Player}
 */
public interface LevelUpStrategy extends Serializable{

	/**
	 * Returns if the player can level up
	 * 
	 * @param experince point of the player
	 * @return true if player can level up, false otherwise
	 */
	boolean isLevelUp(int experience);

	/**
	 * Levels up the player.
	 * 
	 * @param player {@link Player}
	 */
	void levelUpPlayer(Player player);
}
