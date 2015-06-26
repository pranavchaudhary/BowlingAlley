package com.bowling.impl;

import com.bowling.pojo.Bonus;
import com.bowling.pojo.Tries;


public class PinDown {

	public static int pinDown(int pins) {
		int pinsDown = (int) (Math.random() * pins);
		if (pinsDown > pins - 1)
			pinsDown = pins;

		return pinsDown;
	}
	
	public static int getScore(int pinDowns, int totalPins, int tryNum) {
		int score = pinDowns;
		if(pinDowns == totalPins) {
			if(tryNum == Tries.TRY1.getValue()) {
				//scenario of Strike
				score += Bonus.STRIKE.getBonus();
			}
			if(tryNum == Tries.TRY2.getValue()) {
				//scenario of spare
				score += Bonus.SPARE.getBonus();
			}
		}
		return score;
	}
	
	public static void logger(String msg) {
		System.out.println(msg);
	}
}
