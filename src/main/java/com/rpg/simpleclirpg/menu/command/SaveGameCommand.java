package com.rpg.simpleclirpg.menu.command;

import com.rpg.simpleclirpg.constant.Color;
import com.rpg.simpleclirpg.data.Game;
import com.rpg.simpleclirpg.manager.resource.ResourceManager;
import com.rpg.simpleclirpg.menu.GameMenu;
import com.rpg.simpleclirpg.menu.Menu;

/**
 * Command representing saving the game.
 */
public class SaveGameCommand implements Command {

	@Override
	public Menu execute() {
		String menuMessage;
		try {
			ResourceManager.save(Game.getInstance());
			menuMessage = Color.GREEN.getValue() + "Progress saved." + Color.RESET.getValue();
		} catch (Exception e) {
			menuMessage = Color.RED.getValue() + "Couldn't save game!" + Color.RESET.getValue();
		}

		return new GameMenu(menuMessage);
	}
}
