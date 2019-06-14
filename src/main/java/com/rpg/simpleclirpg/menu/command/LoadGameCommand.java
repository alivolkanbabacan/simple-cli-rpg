package com.rpg.simpleclirpg.menu.command;

import com.rpg.simpleclirpg.data.Game;
import com.rpg.simpleclirpg.io.Console;
import com.rpg.simpleclirpg.io.InputOutput;
import com.rpg.simpleclirpg.manager.resource.ResourceManager;
import com.rpg.simpleclirpg.menu.GameMenu;
import com.rpg.simpleclirpg.menu.MainMenu;
import com.rpg.simpleclirpg.menu.Menu;

/**
 * Command representing loading the chosen game.
 */
public class LoadGameCommand implements Command {
	private String fileName;
	private final InputOutput io;

	public LoadGameCommand(String fileName) {
		this.io = Console.getInstance();
		this.fileName = fileName;
	}

	@SuppressWarnings("static-access")
	@Override
	public Menu execute() {
		Game game = null;
		try {
			game = ResourceManager.load(fileName);
		} catch (Exception e) {
			io.printErrorMessage("Couldn't load file with name: " + fileName);
		}
		
		if (game == null) {
			return new MainMenu();
		} else {
			Game.getInstance().setGame(game);
			return new GameMenu();
		}		
	}
}
