package com.rpg.simpleclirpg.menu.command;

import com.rpg.simpleclirpg.data.Game;
import com.rpg.simpleclirpg.io.Console;
import com.rpg.simpleclirpg.io.InputOutput;
import com.rpg.simpleclirpg.menu.ContinueGameMenu;
import com.rpg.simpleclirpg.menu.Menu;

/**
 * Command representing showing the player stats.
 */
public class ShowPlayerStatsCommand implements Command {
	private final InputOutput io;

	public ShowPlayerStatsCommand() {
		this.io = Console.getInstance();
	}

	public ShowPlayerStatsCommand(InputOutput io) {
		this.io = io;
	}

	@Override
	public Menu execute() {
		io.print(Game.getInstance().getPlayer().getStats());
		return new ContinueGameMenu();
	}
}
