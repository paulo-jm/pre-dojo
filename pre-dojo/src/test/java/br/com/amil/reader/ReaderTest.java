package br.com.amil.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.amil.model.game.Match;

public class ReaderTest {

	private static final String PATH_FILE_LOG = "log-reader-test.txt";

	private static final int NUMBER_MATCH = 3;

	private static final int NUMBER_PLAYER = 3;

	private static final int NUMBER_MURDER_EVENT = 2;

	private Reader reader;

	@Before
	public void testPrintHelloWorld() {

		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(PATH_FILE_LOG);

		reader = new Reader();

		try {
			reader.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void countNumberOfMatchsTest() {
		int size = reader.getMapOfMatch().size();
		Assert.assertTrue(size == NUMBER_MATCH);
	}

	@Test
	public void countNumberOfPlayersTest() {
		int size = reader.getMapOfPlayers().size();
		Assert.assertTrue(size == NUMBER_PLAYER);
	}

	@Test
	public void countNumberOfMurderEventTest() {

		for (Entry<String, Match> entry : reader.getMapOfMatch().entrySet()) {

			int size = entry.getValue().getEvents().size();
			Assert.assertTrue(size == NUMBER_MURDER_EVENT);

		}

	}

}
