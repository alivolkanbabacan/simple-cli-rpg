package com.rpg.simpleclirpg.data.theme;

import static java.lang.System.lineSeparator;

import com.rpg.simpleclirpg.factory.character.HauntedMansionMonsterFactory;

/**
 * Theme class for Haunted Mansion game.
 * 
 * @see {@link Theme}
 */
public class HauntedMansionTheme extends Theme {
	private static final long serialVersionUID = 6579324841907790786L;

	private static final String DESCRIPTION = "Welcome to Haunted Mansion!" + lineSeparator()
			+ "You wake up founding your furniture come alive and overrun your mansion!" + lineSeparator()
			+ "Maybe you shouldn't have fought the witch on the traffic yesterday" + lineSeparator()
			+ "or should have given more attention to her yelling about cursing your house!" + lineSeparator()
			+ "Alas, it is too late right now... You recall the book you borrowed from" + lineSeparator()
			+ "the library about black magic. It was written that for a curse to be broken" + lineSeparator()
			+ "you would have to destroy the object causing the curse and it cannot be that far..." + lineSeparator()
			+ "You stand up and start your search of the house... Just not that record player that your friend has" + lineSeparator() 
			+ "given to you as a gift! :(((( " + lineSeparator();

	private static final String WIN_MESSAGE = "After struggling with hordes of furnitures, finally you have found" + lineSeparator()
			+ "the object you are looking for. It is a spoon glowing with a faint color. You have smashed it on" + lineSeparator()
			+ "the ground and suddenly all the animated furnitures have stopped moving and stand still! The mansion have been" + lineSeparator()
			+ "cleansed! But what about all the broken wine bottles in your cellar... :(" + lineSeparator();

	public HauntedMansionTheme() {
		super(DESCRIPTION, WIN_MESSAGE, new HauntedMansionMonsterFactory());
	}
}
