package com.bowling.pojo;

public enum Bonus {
	STRIKE(10), SPARE(5);
	
	int bonus;
	private Bonus(int bonus) {
		this.bonus = bonus;
	}
	
	public int getBonus() {
		return bonus;
	}
}
