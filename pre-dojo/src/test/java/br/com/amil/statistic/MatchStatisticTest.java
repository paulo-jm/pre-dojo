package br.com.amil.statistic;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.amil.reader.Reader;

public class MatchStatisticTest {

	private static final String PATH_FILE_LOG = "log-statistic-test.txt";

	private static final String MATCH_ID = "11348965";

	private static final int WEAPON_PREFERIDA_COUNT = 5;

	private static final String WEAPON_PREFERIDA = "M16";

	private static final String ROMAN = "Roman";
	private static final int ROMAN_KILLER = 6;
	private static final int ROMAN_VICTIM = 1;
	private static final int ROMAN_STREAK = 5;

	private static final String PAULO = "Paulo";
	private static final int PAULO_AWARD_COUNT = 1;

	private Reader reader;

	private MatchStatistic matchStatistic;

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
	public void rankingOfWeaponTest() {

		matchStatistic = new MatchStatistic(reader.getMapOfMatch()
				.get(MATCH_ID));
		List<WeaponRanking> list = matchStatistic.rankingOfWeapon();

		Assert.assertTrue(WEAPON_PREFERIDA_COUNT == list.get(0).getCount());
		Assert.assertTrue(WEAPON_PREFERIDA.equals(list.get(0).getName()));

	}

	@Test
	public void statisticOfPlayesTest() {

		matchStatistic = new MatchStatistic(reader.getMapOfMatch()
				.get(MATCH_ID));
		List<PlayerStatistic> list = matchStatistic.statisticOfPlayes();

		for (PlayerStatistic playerStatistic : list) {

			if (playerStatistic.getName().equalsIgnoreCase(ROMAN)) {
				Assert.assertTrue(ROMAN_KILLER == playerStatistic.getKiller());
				Assert.assertTrue(ROMAN_STREAK == playerStatistic.getStreak());
				Assert.assertTrue(ROMAN_VICTIM == playerStatistic.getVictim());
			} else if (playerStatistic.getName().equalsIgnoreCase(PAULO)) {
				Assert.assertTrue(PAULO_AWARD_COUNT == playerStatistic
						.getAwards().size());
				Assert.assertTrue(playerStatistic.getAwards().get(0)
						.getDescription().equals(MatchStatistic.AWARD_WINNER));
			}
		}

	}
}
