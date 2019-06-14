package com.rpg.simpleclirpg.menu.command;

import com.rpg.simpleclirpg.menu.Menu;

/**
 * A command of execution. Commands are fired when a player chooses an option in
 * a Menu
 */
public interface Command {
	public Menu execute();
}
