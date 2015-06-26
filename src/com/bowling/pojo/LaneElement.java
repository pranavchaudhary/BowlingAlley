package com.bowling.pojo;

public class LaneElement {
	private int laneId;
	private int numOfPlayers;
	
	public LaneElement() {
		// TODO Auto-generated constructor stub
	}
	
	public LaneElement(int laneId, int numOfPlayers) {
		this.laneId = laneId;
		this.numOfPlayers = numOfPlayers;
	}
	
	public int getLaneId() {
		return laneId;
	}
	public void setLaneId(int laneId) {
		this.laneId = laneId;
	}
	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	
}
