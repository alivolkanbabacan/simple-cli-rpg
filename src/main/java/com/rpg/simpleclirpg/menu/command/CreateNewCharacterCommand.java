package com.rpg.simpleclirpg.menu.command;

import com.rpg.simpleclirpg.data.Game;
import com.rpg.simpleclirpg.data.character.player.Player;
import com.rpg.simpleclirpg.data.theme.Theme;
import com.rpg.simpleclirpg.io.Console;
import com.rpg.simpleclirpg.io.InputOutput;
import com.rpg.simpleclirpg.manager.map.MapManager;
import com.rpg.simpleclirpg.menu.GameMenu;
import com.rpg.simpleclirpg.menu.Menu;

/**
 * Command representing new character creation.
 */
public class CreateNewCharacterCommand implements Command {
	private static final String CHOOSE_NAME = "Choose a name for your character:";
	private Game game = Game.getInstance();
	private final Theme theme;
	private final InputOutput io;

	public CreateNewCharacterCommand(Theme theme) {
		this.io = Console.getInstance();
		this.theme = theme;
	}

	public CreateNewCharacterCommand(InputOutput io, Theme theme) {
		this.io = io;
		this.theme = theme;
	}

	@Override
	public Menu execute() {
		String playerName = io.getInputForMessage(CHOOSE_NAME);

		game.setPlayer(new Player(playerName));
		game.setTheme(theme);
		game.setMap(MapManager.generateNewMap(game.getPlayer(), game.getTheme()));

		io.print(game.getTheme().getDescription());
		return new GameMenu();
	}
}
