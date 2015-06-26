package com.bowling.pojo;

public class WinnerInLane {
	private int laneId;
	private int winnerId;

	public int getLaneId() {
		return laneId;
	}

	public int getWinnerId() {
		return winnerId;
	}
	
	public WinnerInLane(int laneId, int winnerId) {
		this.laneId = laneId;
		this.winnerId = winnerId;
	}
}
