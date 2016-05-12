package br.com.amil.statistic;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatistic {

	private String name;

	private int killer;

	private int victim;

	private int streak;

	private List<Award> awards;

	private boolean countStreak = true;

	public PlayerStatistic(String name) {
		this.name = name;
		killer = 0;
		victim = 0;
		awards = new ArrayList<Award>();
	}

	public List<Award> getAwards() {
		return awards;
	}

	public void addAward(Award award) {
		awards.add(award);
	}

	public String getName() {
		return name;
	}

	public int getKiller() {
		return killer;
	}

	public void countKiller() {
		
		if(countStreak){
			streak++;
		}
		killer++;
	}

	public int getVictim() {
		return victim;
	}

	public void countVictim() {
		countStreak = false;
		victim++;
	}
	
	public int getStreak() {
		return streak;
	}

}
