package com.rpg.simpleclirpg.data.theme;

import static java.lang.System.lineSeparator;

import com.rpg.simpleclirpg.factory.character.MagicLampMonsterFactory;

/**
 * Theme class for Magic Lamp game.
 * 
 * @see {@link Theme}
 */
public class MagicLampTheme extends Theme {
	private static final long serialVersionUID = 8026165595872707974L;

	private static final String DESCRIPTION = "You are a genie, a creature of magic! You have been trapped" + lineSeparator()
			+ "in a magic lamp for 3000 years waiting to grant three wishes to the first person wielding the lamp," + lineSeparator()
			+ "thus gaining your freedom. One day a wizard has found you and you granted him three wishes." + lineSeparator()
			+ "But rather than gaining your freedom, the wizard has cast a spell to bound you in the lamp!" + lineSeparator()
			+ "After some struggle you have managed to break the magical chains, now it is up to you to find" + lineSeparator() 
			+ "a way out of the lamp and confront that evil wizard!" + lineSeparator();

	private static final String WIN_MESSAGE = "After searching a way out of the labyrinth full of monsters of magic," + lineSeparator()
			+ "finally you have come across a yellow glow. It is the portal that took you to this lamp some 3000 years ago." + lineSeparator()
			+ "It is now open as all the wishes have been granted! Now it is time to go and confront that evil wizard!" + lineSeparator();

	public MagicLampTheme() {
		super(DESCRIPTION, WIN_MESSAGE, new MagicLampMonsterFactory());
	}
}
