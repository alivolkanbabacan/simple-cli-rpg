package com.rpg.simpleclirpg.data.map;

import org.junit.jupiter.api.Test;

import com.rpg.simpleclirpg.constant.Color;
import com.rpg.simpleclirpg.constant.Passable;
import com.rpg.simpleclirpg.data.character.monster.SmallAnimatedObject;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link Area}
 */
public class AreaTest {

	@Test
	public void testGetSymbolForUnexploredArea() {
		Area area = new Area(Passable.PASSABLE);

		assertEquals("?", area.getSymbol());
	}

	@Test
	public void testGetSymbolForExploredAreaWithCharacter() {
		SmallAnimatedObject sa = new SmallAnimatedObject();
		Area area = new Area(Passable.PASSABLE);
		area.setCharacter(sa);
		area.setExplored(true);

		assertEquals(Color.RED.getValue() + "S" + Color.RESET.getValue(), area.getSymbol());
	}

	@Test
	public void testGetSymbolForWinningArea() {
		Area area = new Area(Passable.PASSABLE);
		area.setExplored(true);
		area.setWinArea(true);

		assertEquals(Color.MAGENTA.getValue() + "W" + Color.RESET.getValue(), area.getSymbol());
	}

	@Test
	public void testGetSymbolForExploredImpassableArea() {
		Area area = new Area(Passable.IMPASSABLE);
		area.setExplored(true);

		assertEquals("#", area.getSymbol());
	}

	@Test
	public void testGetSymbolForExploredPassableUnOccupiedArea() {
		Area area = new Area(Passable.PASSABLE);
		area.setExplored(true);

		assertEquals(" ", area.getSymbol());
	}

	@Test
	public void testIsOccupiedWhenAreaHasCharacter() {
		Area area = new Area(Passable.PASSABLE);
		area.setCharacter(new SmallAnimatedObject());

		assertTrue(area.isOccupied());
	}

	@Test
	public void testIsOccupiedWhenAreaIsWinArea() {
		Area area = new Area(Passable.PASSABLE);
		area.setWinArea(true);

		assertTrue(area.isOccupied());
	}
}
