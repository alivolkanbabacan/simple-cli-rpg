package com.rpg.simpleclirpg.menu;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.lineSeparator;

/**
 * Class representing a menu to show options for the player to choose from.
 */
public class Menu {
	protected final String header;
	protected final LinkedHashMap<String, MenuItem> items;

	public Menu(String header, List<MenuItem> menuItems) {
		this.header = header;

		LinkedHashMap<String, MenuItem> items = menuItems.stream()
				.collect(Collectors.toMap(MenuItem::getKey, Function.identity(), (e1, e2) -> e1, LinkedHashMap::new));

		this.items = items;
	}

	public MenuItem getMenuItem(String key) {
		return items.get(key.toUpperCase());
	}

	public String getHeader() {
		return header;
	}

	public void addNewMenuItem(MenuItem item) {
		items.put(item.getKey(), item);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(header + lineSeparator() + lineSeparator());
		items.values().stream().forEach(e -> builder.append(e + lineSeparator()));
		return builder.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Menu)) {
			return false;
		}

		Menu menu = (Menu) o;
		if (header.equals(menu.header) && items.equals(menu.items)) {
			return true;
		} else {
			return false;
		}
	}
}
