package br.com.amil.service;

import java.util.HashMap;
import java.util.Map;

import br.com.amil.model.game.Match;
import br.com.amil.model.player.Player;

public class GameService {

	private Map<String, Match> matchs;

	private Map<String, Player> players;

	public GameService() {

		setMatchs(new HashMap<String, Match>());
		setPlayers(new HashMap<String, Player>());

	}

	public Map<String, Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(Map<String, Match> matchs) {
		this.matchs = matchs;
	}

	public Map<String, Player> getPlayers() {
		return players;
	}

	public void setPlayers(Map<String, Player> players) {
		this.players = players;
	}

}
