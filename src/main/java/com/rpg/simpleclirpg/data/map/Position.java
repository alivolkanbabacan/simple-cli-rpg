package com.rpg.simpleclirpg.data.map;

import java.io.Serializable;

/**
 * This class represents a position on a map.
 * 
 * @see {@link com.rpg.simpleclirpg.data.map.Map}
 */
public class Position implements Serializable {
	private static final long serialVersionUID = -3911504542873042941L;

	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
