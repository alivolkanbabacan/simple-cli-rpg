package com.rpg.simpleclirpg.menu;

import com.rpg.simpleclirpg.menu.command.Command;

/**
 * This class represents an option in a Menu
 * 
 * @see {@link Menu}
 */
public class MenuItem {
	private final String key;
	private final String description;
	private final Command command;

	public MenuItem(String key, String description, Command command) {
		this.key = key;
		this.description = description;
		this.command = command;
	}

	public String getKey() {
		return key;
	}

	public Command getCommand() {
		return command;
	}

	public Menu execute() {
		return command.execute();
	}

	@Override
	public String toString() {
		return String.format("%s : %s", key, description);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof MenuItem)) {
			return false;
		}

		MenuItem item = (MenuItem) o;
		if (key.equals(item.key) && description.equals(item.description)) {
			return true;
		} else {
			return false;
		}
	}
}
