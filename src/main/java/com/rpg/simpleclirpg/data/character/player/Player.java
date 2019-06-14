package com.rpg.simpleclirpg.data.character.player;

import com.rpg.simpleclirpg.constant.Color;
import com.rpg.simpleclirpg.data.character.Character;
import com.rpg.simpleclirpg.data.character.monster.Monster;
import com.rpg.simpleclirpg.data.levelup.LevelUpStrategy;
import com.rpg.simpleclirpg.data.levelup.NoLevelUpStartegy;

import static java.lang.System.lineSeparator;

/**
 * This class represents the Player in the game.
 */
public class Player extends Character {
	private static final long serialVersionUID = 2839370004387765228L;

	protected int experiencePoints = 0;
	protected LevelUpStrategy levelUpStrategy;

	public Player(String name) {
		super(100, name, 15, "C");
		this.levelUpStrategy = new NoLevelUpStartegy();
	}

	public int getExperiencePoints() {
		return experiencePoints;
	}

	public void setLevelUpStrategy(LevelUpStrategy levelUpStrategy) {
		this.levelUpStrategy = levelUpStrategy;
	}

	/**
	 * Attacks the given monster. If the monster is killed, then player gains
	 * experience equal to the monster's xp bonus. If the player levels up as a
	 * result of this experience increase, then his stats increase according to the
	 * level up strategy the character has.
	 * 
	 * @param enemy {@link Monster}
	 */
	public void attack(Monster enemy) {
		currentHp = currentHp - enemy.getDamage();
		enemy.setCurrentHp(enemy.getCurrentHp() - damage);
		if (enemy.getCurrentHp() <= 0) {
			experiencePoints = enemy.getXpBonus();

			if (levelUpStrategy!= null && levelUpStrategy.isLevelUp(experiencePoints)) {
				levelUpStrategy.levelUpPlayer(this);
			}
		}
	}

	/**
	 * Returns the unique symbol of the player.
	 * 
	 * @return symbol of the player
	 */
	@Override
	public String getSymbol() {
		return Color.GREEN.getValue() + symbol + Color.RESET.getValue();
	}

	/**
	 * Returns stats of the player in an organized manner.
	 * 
	 * @return stats of the player
	 */
	@Override
	public String getStats() {
		StringBuilder builder = new StringBuilder();
		builder.append("\tPlayer" + lineSeparator());
		builder.append("name: " + name + lineSeparator());
		builder.append("hit points: " + currentHp + "/" + totalHp + lineSeparator());
		builder.append("damage: " + damage + lineSeparator());
		builder.append("experience points: " + experiencePoints + lineSeparator());
		return builder.toString();
	}
}
