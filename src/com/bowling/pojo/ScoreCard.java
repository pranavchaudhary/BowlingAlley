package com.bowling.pojo;

public class ScoreCard {
	private int try1;
	private int try2;
	private int bonusTry;
	private Bonus bonus;
	private int total;
	private int tryNum;
	
	public int getTry1() {
		return try1;
	}
	public void setTry1(int try1) {
		this.try1 = try1;
	}
	public int getTry2() {
		return try2;
	}
	public void setTry2(int try2) {
		this.try2 = try2;
	}
	public Bonus getBonus() {
		return bonus;
	}
	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getBonusTry() {
		return bonusTry;
	}
	public void setBonusTry(int bonusTry) {
		this.bonusTry = bonusTry;
	}
	public int getTryNum() {
		return tryNum;
	}
	public void setTryNum(int tryNum) {
		this.tryNum = tryNum;
	}
	
	
}
