package com.rpg.simpleclirpg.io;

/**
 * Interface regarding input-output operations.
 */
public interface InputOutput {
	/**
	 * Prints the given message.
	 * 
	 * @param message
	 */
	void print(String message);

	/**
	 * Prints given message as error message.
	 * 
	 * @param message
	 */
	void printErrorMessage(String message);

	/**
	 * Prints game opening message.
	 */
	void printWelcome();

	/**
	 * Prints given message and takes input for it from the user.
	 * 
	 * @param message
	 * @return input of the user
	 */
	String getInputForMessage(String message);
}
