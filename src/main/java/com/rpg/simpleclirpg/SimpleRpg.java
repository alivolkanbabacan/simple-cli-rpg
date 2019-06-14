package com.rpg.simpleclirpg;

import com.rpg.simpleclirpg.io.Console;
import com.rpg.simpleclirpg.io.InputOutput;
import com.rpg.simpleclirpg.menu.MainMenu;
import com.rpg.simpleclirpg.menu.Menu;
import com.rpg.simpleclirpg.menu.MenuItem;

/**
 * Handles the operations about the flow of the game including starting the game
 * and executing the commands according to the inputs from the user.
 */
public class SimpleRpg {
	private final InputOutput io;

	public SimpleRpg() {
		io = Console.getInstance();
	}

	public SimpleRpg(InputOutput io) {
		this.io = io;
	}

	public void startGame() {
		io.printWelcome();

		Menu menu = new MainMenu();

		while (menu != null) {
			String key = io.getInputForMessage(menu.toString());

			MenuItem item = menu.getMenuItem(key);
			if (item != null) {
				menu = item.execute();
			} else {
				io.printErrorMessage("You have entered wrong input!");
			}
		}
	}
}
