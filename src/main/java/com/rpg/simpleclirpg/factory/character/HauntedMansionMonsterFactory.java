package com.rpg.simpleclirpg.factory.character;

import com.rpg.simpleclirpg.data.character.monster.Monster;
import com.rpg.simpleclirpg.data.character.monster.SmallAnimatedObject;

/**
 * Monster factory class for Haunted Mansion game.
 * 
 * @see {@link MonsterFactory}
 */
public class HauntedMansionMonsterFactory implements MonsterFactory {
	private static final long serialVersionUID = 4616607518561649639L;

	public Monster createMonster() {
		return new SmallAnimatedObject();
	}
}
