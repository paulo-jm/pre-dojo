package br.com.amil.statistic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.com.amil.model.game.Match;
import br.com.amil.model.game.event.Event;
import br.com.amil.model.game.event.Murder;

public class MatchStatistic {

	public static final String AWARD_WINNER = "Não morreu durante a partida.";

	private Match match;

	private Map<String, PlayerStatistic> statisticOfPlayes;

	private Map<String, WeaponRanking> rankingOfWeapon;

	public MatchStatistic(Match match) {
		setMatch(match);
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public List<WeaponRanking> rankingOfWeapon() {

		rankingOfWeapon = new HashMap<String, WeaponRanking>();

		for (Event event : match.getEvents()) {

			if (event instanceof Murder) {

				Murder murder = (Murder) event;

				if (!rankingOfWeapon.containsKey(murder.getWeapon())) {
					WeaponRanking ranking = new WeaponRanking(
							murder.getWeapon());
					rankingOfWeapon.put(murder.getWeapon(), ranking);
				}

				rankingOfWeapon.get(murder.getWeapon()).count();

			}

		}

		List<WeaponRanking> list = new ArrayList<WeaponRanking>();

		for (Entry<String, WeaponRanking> entry : rankingOfWeapon.entrySet()) {

			list.add(entry.getValue());
		}

		Collections.sort(list);
		return list;

	}

	public List<PlayerStatistic> statisticOfPlayes() {

		statisticOfPlayes = new HashMap<String, PlayerStatistic>();

		for (Event event : match.getEvents()) {

			if (event instanceof Murder) {

				Murder murder = (Murder) event;

				if (!statisticOfPlayes
						.containsKey(murder.getPlayer().getName())) {
					PlayerStatistic ranking = new PlayerStatistic(murder
							.getPlayer().getName());
					statisticOfPlayes
							.put(murder.getPlayer().getName(), ranking);
				}

				if (!statisticOfPlayes
						.containsKey(murder.getVictim().getName())) {
					PlayerStatistic ranking = new PlayerStatistic(murder
							.getVictim().getName());
					statisticOfPlayes
							.put(murder.getVictim().getName(), ranking);
				}

				statisticOfPlayes.get(murder.getPlayer().getName())
						.countKiller();
				statisticOfPlayes.get(murder.getVictim().getName())
						.countVictim();

			}

		}

		addAwards();

		List<PlayerStatistic> list = new ArrayList<PlayerStatistic>();

		for (Entry<String, PlayerStatistic> entry : statisticOfPlayes
				.entrySet()) {

			list.add(entry.getValue());
		}

		return list;

	}

	private void addAwards() {

		for (Entry<String, PlayerStatistic> entry : statisticOfPlayes
				.entrySet()) {

			PlayerStatistic playerStatistic = entry.getValue();

			if (playerStatistic.getVictim() == 0) {
				playerStatistic.addAward(new Award(AWARD_WINNER));
			}
		}

	}

}
