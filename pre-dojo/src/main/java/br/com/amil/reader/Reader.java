package br.com.amil.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import br.com.amil.model.game.Match;
import br.com.amil.model.player.Player;
import br.com.amil.util.RegexUtil;

public class Reader {

	private Map<String, MatchReader> mapMatchReader = new HashMap<String, MatchReader>();
	
	private Map<String, Player> mapOfPlayers = new HashMap<String, Player>();
	
	private Map<String, Match> mapOfMatch = new HashMap<String, Match>();

	public void read(InputStream is) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String strLine;

		String match = null;

		while ((strLine = br.readLine()) != null) {

			if (strLine.matches(RegexUtil.REGEX_MATCH_STARTED)) {
				
				match = strLine.replaceAll(
						RegexUtil.REGEX_MATCH_STARTED_REPLACE, "").split(
						RegexUtil.REGEX_MATCH_LOG_SEPARATOR)[1].trim();
				mapMatchReader.put(match, new MatchReader(mapOfPlayers, mapOfMatch));
				
			}

			mapMatchReader.get(match).read(strLine);
		}

		br.close();

	}

	public Map<String, MatchReader> getMapMatchReader() {
		return mapMatchReader;
	}

	public void setMapMatchReader(Map<String, MatchReader> mapMatchReader) {
		this.mapMatchReader = mapMatchReader;
	}

	public Map<String, Player> getMapOfPlayers() {
		return mapOfPlayers;
	}

	public void setMapOfPlayers(Map<String, Player> mapOfPlayers) {
		this.mapOfPlayers = mapOfPlayers;
	}

	public Map<String, Match> getMapOfMatch() {
		return mapOfMatch;
	}

	public void setMapOfMatch(Map<String, Match> mapOfMatch) {
		this.mapOfMatch = mapOfMatch;
	}
	
}
