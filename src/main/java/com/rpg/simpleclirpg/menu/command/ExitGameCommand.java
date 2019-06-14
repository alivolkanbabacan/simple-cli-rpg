package com.rpg.simpleclirpg.menu.command;

import com.rpg.simpleclirpg.io.Console;
import com.rpg.simpleclirpg.io.InputOutput;
import com.rpg.simpleclirpg.menu.Menu;

/**
 * Command representing exiting the game.
 */
public class ExitGameCommand implements Command {
	private final InputOutput io;
	
	public ExitGameCommand() {
		this.io = Console.getInstance();
	}
	
	public ExitGameCommand(InputOutput io) {
		this.io = io;
	}

	@Override
	public Menu execute() {
		io.print("Exiting game!");
		return null;
	}
}
