package com.rpg.simpleclirpg.data;

import java.io.Serializable;

import com.rpg.simpleclirpg.data.character.player.Player;
import com.rpg.simpleclirpg.data.map.Map;
import com.rpg.simpleclirpg.data.theme.Theme;

/**
 * This class holds the data of the Game.
 */
public class Game implements Serializable {
	private static final long serialVersionUID = 6236228013247619949L;
	private static Game game;

	private Player player;
	private Theme theme;
	private Map map;

	private Game() {
	}

	public static Game getInstance() {
		if (game == null) {
			game = new Game();
		}

		return game;
	}

	public static void setGame(Game game) {
		Game.game = game;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
}
