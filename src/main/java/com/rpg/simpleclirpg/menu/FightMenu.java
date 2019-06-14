package com.rpg.simpleclirpg.menu;

import java.util.Arrays;

import com.rpg.simpleclirpg.data.map.Area;
import com.rpg.simpleclirpg.menu.command.AttackCommand;
import com.rpg.simpleclirpg.menu.command.NavigateToGameCommand;

import static java.lang.System.lineSeparator;

/**
 * Menu holding instructions for combat.
 * 
 * @see {@link Menu}
 */
public class FightMenu extends Menu {

	public FightMenu(String header, Area areaToAttack) {
		super(header, Arrays.asList(new MenuItem("A", "Attack!", new AttackCommand(areaToAttack)),
				new MenuItem("F", "Flee!", new NavigateToGameCommand())));
	}

	public FightMenu(Area areaToAttack) {
		this("You see a " + areaToAttack.getCharacter().getName() + " coming towards you!" + lineSeparator()
				+ "What are you going to do?", areaToAttack);
	}
}
