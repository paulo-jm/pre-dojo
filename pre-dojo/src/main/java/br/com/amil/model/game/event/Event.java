package br.com.amil.model.game.event;

import java.util.Calendar;

import br.com.amil.model.game.Match;
import br.com.amil.model.player.Player;

public abstract class Event {

	private Match match;

	private Calendar time;

	private Player player;

	public Event(Match match, Calendar time, Player player) {
		setMatch(match);
		setTime(time);
		setPlayer(player);
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
