package br.com.amil.model.player;

import java.util.ArrayList;
import java.util.List;

import br.com.amil.model.game.Match;
import br.com.amil.model.game.event.Event;

public class Player {

	private String name;

	private List<Match> matchs;
	
	private List<Event> events;

	public Player(String name) {
		this.name = name;
		setMatchs(new ArrayList<Match>());
		setEvents(new ArrayList<Event>());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}

	public void starNewMatch(Match match) {

		if (!matchs.contains(match)) {
			matchs.add(match);
		}
	}
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void addEvent(Event event) {
		events.add(event);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
