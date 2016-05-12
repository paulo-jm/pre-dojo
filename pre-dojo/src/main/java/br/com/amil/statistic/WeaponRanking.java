package br.com.amil.statistic;

public class WeaponRanking implements Comparable<WeaponRanking> {

	private String name;

	private int count;

	public WeaponRanking(String name) {
		this.name = name;
		count = 0;
	}

	public void count() {
		count++;
	}

	public int getCount() {
		return count;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(WeaponRanking obj) {
		
		Integer valueOne = Integer.valueOf(this.getCount());
		Integer valueTwo = Integer.valueOf(obj.getCount());

		return valueTwo.compareTo(valueOne);
	}

}
