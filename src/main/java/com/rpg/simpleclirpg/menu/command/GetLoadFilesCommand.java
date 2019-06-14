package com.rpg.simpleclirpg.menu.command;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.rpg.simpleclirpg.io.Console;
import com.rpg.simpleclirpg.io.InputOutput;
import com.rpg.simpleclirpg.manager.resource.ResourceManager;
import com.rpg.simpleclirpg.menu.LoadGameMenu;
import com.rpg.simpleclirpg.menu.MainMenu;
import com.rpg.simpleclirpg.menu.Menu;
import com.rpg.simpleclirpg.menu.MenuItem;

/**
 * Command representing opening the load game menu for the player to choose a game to load.
 */
public class GetLoadFilesCommand implements Command {
	private static final String NO_SAVED_GAMES = "There are no saved games to load!";
	private static final String GAMES_LOAD_ERROR = "Couldn't load games!";
	private final InputOutput io;

	public GetLoadFilesCommand() {
		this.io = Console.getInstance();
	}

	public GetLoadFilesCommand(InputOutput io) {
		this.io = io;
	}

	@Override
	public Menu execute() {
		try {
			List<String> loadFiles = ResourceManager.getAllLoadFileNames();
			if (loadFiles.isEmpty()) {
				io.printErrorMessage(NO_SAVED_GAMES);
			} else {
				List<MenuItem> menuItems = IntStream.range(0, loadFiles.size())
						.mapToObj(i -> new MenuItem(String.valueOf(i + 1), loadFiles.get(i),
								new LoadGameCommand(loadFiles.get(i))))
						.collect(Collectors.toList());

				return new LoadGameMenu(menuItems);
			}
		} catch (Exception e) {
			io.printErrorMessage(GAMES_LOAD_ERROR);
		}

		return new MainMenu();
	}
}
