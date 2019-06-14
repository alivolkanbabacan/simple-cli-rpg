package com.rpg.simpleclirpg.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.rpg.simpleclirpg.constant.Color;

import static java.lang.System.lineSeparator;

/**
 * Console implementation of {@link InputOutput} interface. Prints outputs to
 * and gets inputs from console.
 */
@SuppressWarnings("resource")
public class Console implements InputOutput {
	private static Console console;

	private Console() {
	}

	public static Console getInstance() {
		if (console == null) {
			console = new Console();
		}

		return console;
	}

	@Override
	public void print(String message) {
		System.out.println(message);
	}

	@Override
	public void printErrorMessage(String message) {
		print(Color.RED.getValue() + message + Color.RESET.getValue() + lineSeparator());
	}

	@Override
	public void printWelcome() {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/opening.txt")))) {

			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(lineSeparator());
			}

			print(builder.toString());
		} catch (IOException e) {
			printErrorMessage("There has been a problem trying to start game!");
		}
	}

	@Override
	public String getInputForMessage(String message) {
		print(message);

		return new Scanner(System.in).next();
	}
}
