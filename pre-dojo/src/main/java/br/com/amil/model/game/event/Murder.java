package br.com.amil.model.game.event;

import java.util.Calendar;

import br.com.amil.model.game.Match;
import br.com.amil.model.player.Player;

public class Murder extends Event {

	private Player victim;

	private String weapon;
	
	public Murder(Match match, Calendar time, Player player, Player victim,
			String weapon) {

		super(match, time, player);

		setVictim(victim);
		setWeapon(weapon);

	}

	public Player getVictim() {
		return victim;
	}

	public void setVictim(Player victim) {
		this.victim = victim;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

}
