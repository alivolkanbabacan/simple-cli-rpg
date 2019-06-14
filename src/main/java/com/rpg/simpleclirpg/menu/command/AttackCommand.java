package com.rpg.simpleclirpg.menu.command;

import com.rpg.simpleclirpg.constant.Color;
import com.rpg.simpleclirpg.data.Game;
import com.rpg.simpleclirpg.data.map.Area;
import com.rpg.simpleclirpg.io.Console;
import com.rpg.simpleclirpg.io.InputOutput;
import com.rpg.simpleclirpg.menu.FightMenu;
import com.rpg.simpleclirpg.menu.GameMenu;
import com.rpg.simpleclirpg.menu.MainMenu;
import com.rpg.simpleclirpg.menu.Menu;
import com.rpg.simpleclirpg.data.character.monster.Monster;
import com.rpg.simpleclirpg.data.character.player.Player;

import static java.lang.System.lineSeparator;

/**
 * Command representing the player attacking a monster.
 */
public class AttackCommand implements Command {
	private static final String GAME_OVER_MESSAGE = "Albeit showing great struggle, you have fallen in battle :("
			+ lineSeparator() + "\tGame Over!";
	private Area areaToAttack;
	private final InputOutput io;

	public AttackCommand(Area areaToAttack) {
		this.io = Console.getInstance();
		this.areaToAttack = areaToAttack;
	}

	public AttackCommand(Area areaToAttack, InputOutput io) {
		this.io = io;
		this.areaToAttack = areaToAttack;
	}

	@Override
	public Menu execute() {
		Player player = Game.getInstance().getPlayer();
		Monster enemy = (Monster) areaToAttack.getCharacter();
		player.attack(enemy);

		showStats(player, enemy);

		if (player.getCurrentHp() <= 0) {
			io.printErrorMessage(GAME_OVER_MESSAGE);
			return new MainMenu();

		} else if (enemy.getCurrentHp() <= 0) {
			areaToAttack.setCharacter(null);
			return new GameMenu(Color.GREEN.getValue() + enemy.getName() + " has been vanquished! You have gained: "
					+ enemy.getXpBonus() + " experience." + Color.RESET.getValue());
		} else {
			return new FightMenu(enemy.getName() + " still standing!" + lineSeparator() + "What are you going to do?",
					areaToAttack);
		}
	}

	public void showStats(Player player, Monster enemy) {
		io.print(player.getStats());
		io.print(enemy.getStats());
	}
}
