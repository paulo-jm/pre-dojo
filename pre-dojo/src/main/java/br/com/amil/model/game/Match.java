package br.com.amil.model.game;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.amil.model.game.event.Event;
import br.com.amil.model.player.Player;

public class Match {

	private List<Player> players;

	private List<Event> events;

	private Calendar start;

	private Calendar end;

	private String id;

	public Match() {
		setPlayers(new ArrayList<Player>());
		setEvents(new ArrayList<Event>());
	}

	public Match(Calendar start, String id) {
		setPlayers(new ArrayList<Player>());
		setEvents(new ArrayList<Event>());
		setStart(start);
		setId(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void addPlayer(Player player) {
		if (!players.contains(player)) {
			
			player.starNewMatch(this);
			players.add(player);
			
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

	public Calendar getStart() {
		return start;
	}

	public void setStart(Calendar start) {
		this.start = start;
	}

	public Calendar getEnd() {
		return end;
	}

	public void setEnd(Calendar end) {
		this.end = end;
	}

	public boolean isStart() {

		return start != null && start.before(Calendar.getInstance());

	}

	public boolean isEnd() {

		return end != null && end.after(Calendar.getInstance());

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Match other = (Match) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
