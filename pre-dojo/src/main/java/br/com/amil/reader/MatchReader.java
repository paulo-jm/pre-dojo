package br.com.amil.reader;

import java.util.Calendar;
import java.util.Map;

import br.com.amil.model.game.Match;
import br.com.amil.model.game.event.Murder;
import br.com.amil.model.player.Player;
import br.com.amil.util.CalendarUtil;
import br.com.amil.util.RegexUtil;

public class MatchReader {

	private Match match;

	private Map<String, Player> mapOfPlayers;
	
	private Map<String, Match> mapOfMatch;
	
	public MatchReader(Map<String, Player> mapOfPlayers, Map<String, Match> mapOfMatch) {
		this.mapOfPlayers = mapOfPlayers;
		this.mapOfMatch = mapOfMatch;
	}

	public void read(String line) {

		if (line.matches(RegexUtil.REGEX_MATCH_STARTED)) {

			String[] values = RegexUtil.split(line,
					RegexUtil.REGEX_MATCH_STARTED_REPLACE,
					RegexUtil.REGEX_MATCH_LOG_SEPARATOR);

			String id = values[1].trim();
			Calendar date = CalendarUtil.toCalendar(values[0].trim(),
					RegexUtil.DATE_LOG_FORMAT);

			match = new Match(date, id);
			mapOfMatch.put(id, match);

		} else if (line.matches(RegexUtil.REGEX_MATCH_ENDED)) {

			String[] values = RegexUtil.split(line,
					RegexUtil.REGEX_MATCH_ENDED_REPLACE,
					RegexUtil.REGEX_MATCH_LOG_SEPARATOR);

			String id = values[1].trim();
			Calendar date = CalendarUtil.toCalendar(values[0].trim(),
					RegexUtil.DATE_LOG_FORMAT);

			if (match.getId().equals(id)) {
				match.setEnd(date);
				;
			}

		} else if (line.matches(RegexUtil.REGEX_MURDER)) {

			String[] values = RegexUtil.split(line,
					RegexUtil.REGEX_MURDER_REPLACE,
					RegexUtil.REGEX_MATCH_LOG_SEPARATOR);
			
			String time = values[0].trim();
			String event = values[1].trim();
			
			Calendar date = CalendarUtil.toCalendar(time,
					RegexUtil.DATE_LOG_FORMAT);
			
			String[] events = RegexUtil.split(event,
					RegexUtil.REGEX_MURDER_REPLACE,
					RegexUtil.REGEX_EVENT_LOG_SEPARATOR);
			
			Player player = getPlayer(events[0].trim());
			Player victim = getPlayer(events[1].trim());
			String weapon = events[2].trim();

			if(match != null){
				
				Murder murder = new Murder(match, date, player, victim, weapon);
				match.addEvent(murder);
				match.addPlayer(player);
				match.addPlayer(victim);
				
				player.addEvent(murder);
				victim.addEvent(murder);
			}
			
		}

	}

	private Player getPlayer(String name) {

		if (!mapOfPlayers.containsKey(name)) {

			Player player = new Player(name);
			mapOfPlayers.put(name, player);

		}

		return mapOfPlayers.get(name);

	}

}
