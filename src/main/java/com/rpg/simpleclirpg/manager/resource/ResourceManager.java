package com.rpg.simpleclirpg.manager.resource;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.rpg.simpleclirpg.data.Game;

/**
 * This class handles the save and load game operations.
 */
public class ResourceManager {
	private static final String BASE_FILE_PATH = "saves";
	private static final String FILE_FORMAT = ".srpg";

	/**
	 * Saves the given game to the saves folder.
	 * 
	 * @param game {@link Game}
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void save(Game game) throws FileNotFoundException, IOException {
		Files.createDirectories(Paths.get(BASE_FILE_PATH));

		String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM_dd_yyyy__hh_mm_ss")) + "_"
				+ game.getPlayer().getName() + FILE_FORMAT;

		Path savegame = Paths.get(BASE_FILE_PATH, fileName);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savegame.toFile()))) {
			oos.writeObject(game);
		}
	}

	/**
	 * Loads the game file given with the filename from the saves folder.
	 * 
	 * @param fileName
	 * @return game {@link Game}
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Game load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		Game game = null;

		File file = Paths.get(BASE_FILE_PATH, fileName).toFile();
		try (ObjectInput input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
			game = (Game) input.readObject();
		}

		return game;
	}

	/**
	 * Returns the file names of all saved games if there are any.
	 * 
	 * @return list of file names of saved games
	 * @throws IOException
	 */
	public static List<String> getAllLoadFileNames() throws IOException {
		return Files.list(Paths.get(BASE_FILE_PATH)).filter(path -> path.toString().endsWith(FILE_FORMAT))
				.map(e -> e.getFileName().toString()).collect(Collectors.toList());
	}
}
