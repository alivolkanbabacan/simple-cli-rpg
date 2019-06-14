package com.rpg.simpleclirpg.menu.command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rpg.simpleclirpg.constant.Color;
import com.rpg.simpleclirpg.constant.Passable;
import com.rpg.simpleclirpg.data.Game;
import com.rpg.simpleclirpg.data.character.monster.SmallAnimatedObject;
import com.rpg.simpleclirpg.data.character.player.Player;
import com.rpg.simpleclirpg.data.map.Area;
import com.rpg.simpleclirpg.data.theme.HauntedMansionTheme;
import com.rpg.simpleclirpg.io.Console;
import com.rpg.simpleclirpg.manager.map.MapManager;
import com.rpg.simpleclirpg.menu.FightMenu;
import com.rpg.simpleclirpg.menu.GameMenu;
import com.rpg.simpleclirpg.menu.MainMenu;

import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link AttackCommand}
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class AttackCommandTest {
	private static final String PLAYER_NAME = "Test_player";

	@Mock
	private Console console;

	@Spy
	private Area area = new Area(Passable.PASSABLE);

	@InjectMocks
	private AttackCommand command;

	@Test
	public void testContinueFightIfMonsterIsAlive() {
		SmallAnimatedObject sa = new SmallAnimatedObject();
		area.setCharacter(sa);

		Player player = new Player(PLAYER_NAME);
		Game.getInstance().setPlayer(player);

		FightMenu menu = new FightMenu(
				sa.getName() + " still standing!" + lineSeparator() + "What are you going to do?", area);
		assertEquals(menu, command.execute());
	}

	@Test
	public void testGameOverWhenPlayersHealthBelowZero() {
		area.setCharacter(new SmallAnimatedObject());

		Player player = new Player(PLAYER_NAME);
		player.setCurrentHp(5);
		Game.getInstance().setPlayer(player);

		assertEquals(new MainMenu(), command.execute());
	}

	@Test
	public void testFightWonWhenEnemyHealthBelowZero() {
		SmallAnimatedObject sa = new SmallAnimatedObject();
		sa.setCurrentHp(5);
		area.setCharacter(sa);

		Player player = new Player(PLAYER_NAME);
		Game game = Game.getInstance();
		game.setPlayer(player);
		game.setMap(MapManager.generateNewMap(player, new HauntedMansionTheme()));

		GameMenu menu = new GameMenu(Color.GREEN.getValue() + sa.getName() + " has been vanquished! You have gained: "
				+ sa.getXpBonus() + " experience." + Color.RESET.getValue());
		assertEquals(menu, command.execute());
	}
}
