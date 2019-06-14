package com.rpg.simpleclirpg;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rpg.simpleclirpg.io.Console;

import static org.mockito.Mockito.*;

/**
 * Test class for {@link SimpleRpg}
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class SimpleRpgTest {

	@Mock
	private Console console;

	@InjectMocks
	private SimpleRpg simpleRpg;

	/*
	 * Testing if welcome message is printed at the start
	 */
	@Test
	public void testPrintWelcomeAtStart() {
		when(console.getInputForMessage(any())).thenReturn("3");

		simpleRpg.startGame();
		verify(console, times(1)).printWelcome();
	}
}