package com.bowling.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Players {
	private int id;
	private List<ScoreCard> score;
	private AtomicInteger count;			//keep the player's played count
	
	public Players(int id, int maxScore) {
		score = new ArrayList<ScoreCard>(maxScore);
		count = new AtomicInteger(0);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public List<ScoreCard> getScore() {
		return score;
	}

	public void setScore(List<ScoreCard> score) {
		this.score = score;
	}

	public int incrementAndGetCount() {
		return this.count.getAndIncrement();
	}
}
