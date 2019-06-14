package com.rpg.simpleclirpg.data.map;

import java.io.Serializable;

import com.rpg.simpleclirpg.constant.Color;
import com.rpg.simpleclirpg.constant.Passable;
import com.rpg.simpleclirpg.data.character.Character;

/**
 * Class representing a square in the game map.
 */
public class Area implements Serializable {
	private static final long serialVersionUID = -94549657027781338L;

	private final Passable passable;
	private Character character;
	private boolean isWinArea;
	private boolean isExplored;

	public Area(Passable passable) {
		this.passable = passable;
	}

	public Area(Passable passable, Character character) {
		this(passable);
		this.character = character;
	}

	/**
	 * Returns symbol representing the area
	 * 
	 * @return symbol of the area
	 */
	public String getSymbol() {
		String symbol;
		if (!isExplored) {
			symbol = "?";
		} else if (character != null) {
			symbol = character.getSymbol();
		} else if (isWinArea) {
			symbol = Color.MAGENTA.getValue() + "W" + Color.RESET.getValue();
		} else {
			symbol = isPassable() ? " " : "#";
		}

		return symbol;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public boolean isWinArea() {
		return isWinArea;
	}

	public void setWinArea(boolean isWinArea) {
		this.isWinArea = isWinArea;
	}

	public boolean isExplored() {
		return isExplored;
	}

	public void setExplored(boolean isExplored) {
		this.isExplored = isExplored;
	}

	/**
	 * Returns if the area is passable
	 * 
	 * @return true if area is passable, false otherwise
	 */
	public boolean isPassable() {
		return Passable.PASSABLE.equals(passable);
	}

	/**
	 * Returns if the area is occupied by something
	 * 
	 * @return true if area is occupied, false otherwise
	 */
	public boolean isOccupied() {
		return character != null || isWinArea;
	}
}
