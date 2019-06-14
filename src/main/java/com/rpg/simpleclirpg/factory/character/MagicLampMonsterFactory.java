package com.rpg.simpleclirpg.factory.character;

import com.rpg.simpleclirpg.data.character.monster.Monster;
import com.rpg.simpleclirpg.data.character.monster.Wisp;

/**
 * Monster factory class for Magic Lamp game.
 * 
 * @see {@link MonsterFactory}
 */
public class MagicLampMonsterFactory implements MonsterFactory {
	private static final long serialVersionUID = -5864674271217970187L;

	public Monster createMonster() {
		return new Wisp();
	}
}
