package com.rpg.simpleclirpg.factory.character;

import java.io.Serializable;

import com.rpg.simpleclirpg.data.character.monster.Monster;

/**
 * Factory class for Monster creation
 */
public interface MonsterFactory extends Serializable {

	/**
	 * Creates a Monster object
	 * 
	 * @return monster {@link Monster}
	 */
	Monster createMonster();
}
