package com.bowling.pojo;

public enum Tries {
	TRY1(0),TRY2(1),TRY3(2);
	
	int tryNum;
	
	private Tries(int tryNum) {
		this.tryNum = tryNum;
	}
	
	public int getValue() {
		return tryNum;
	}
}
