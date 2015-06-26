package com.bowling.impl;

import com.bowling.iface.IStartGameInLane;
import com.bowling.pojo.LaneElement;
import com.bowling.pojo.WinnerInLane;

public class Lane implements IStartGameInLane {
	private int numOfLanes;
	private BowlingAlley[] alley;
	private WinnerInLane[] winnersInLaneWise;
	private int[] numOfPlayerInLane;
	private LaneElement[] laneElem;
	
	public Lane() {
		this.numOfLanes = 1;
	}
	
	public Lane(int numOfLanes, int[] numOfPlayerInLane) {
		this.numOfLanes = numOfLanes;
		this.numOfPlayerInLane = numOfPlayerInLane;
		alley = new BowlingAlley[numOfLanes];
		winnersInLaneWise = new WinnerInLane[numOfLanes];
	}
	
	public Lane(LaneElement[] laneElem) {
		this.laneElem = laneElem;
		int[] numOfPlayerInLane = new int[laneElem.length];
		for(int i = 0; i < laneElem.length; i++) {
			numOfPlayerInLane[i] = laneElem[i].getNumOfPlayers();
		}

		this.numOfLanes = laneElem.length;
		this.numOfPlayerInLane = numOfPlayerInLane;
		alley = new BowlingAlley[numOfLanes];
		winnersInLaneWise = new WinnerInLane[numOfLanes];
	}

	@Override
	public void startGame() {
		for(int i = 0; i < numOfLanes; i++) {
			if(null != laneElem) {
				alley[i] = BowlingAlley.getAlleyInstance(laneElem[i]);
			} else 
				alley[i] = BowlingAlley.getAlleyInstance(numOfPlayerInLane[i]);
			alley[i].play();
		}
	}

	@Override
	public WinnerInLane[] declareWinnerInLane() {
		for(int i = 0; i < numOfLanes; i++) {
			int winnerId = alley[i].decideWinner();
			winnersInLaneWise[i] = new  WinnerInLane(i, winnerId);
		}
		return winnersInLaneWise;
	}
	
	
}
