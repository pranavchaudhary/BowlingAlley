package com.bowling.impl;

import com.bowling.iface.IPlay;
import com.bowling.pojo.LaneElement;
import com.bowling.pojo.Players;
import com.bowling.pojo.ScoreCard;
import com.bowling.pojo.Tries;

public class BowlingAlley implements IPlay {
	private Players[] players;
	private int turn;		//to keep track of current running cycle
	private final int MAX_TURNS = 10;		//can be enhanced to take input via property file or user to provide min bowling kind of facility
	private final int DEFAULT_PINS = 10;
	private LaneElement laneElem;
	
	private BowlingAlley(int n) {
		players = new Players[n]; 
		for(int i = 0; i < n; i++) {
			players[i] = new Players(i, MAX_TURNS);
		}
		turn = 0;
	}

	private BowlingAlley(LaneElement laneElem) {
		this.laneElem = laneElem;
		players = new Players[laneElem.getNumOfPlayers()];
		for(int i = 0; i < laneElem.getNumOfPlayers(); i++) {
			players[i] = new Players(i, MAX_TURNS);
		}
		turn = 0;
	}
	
	
	//factory initialization
	public static BowlingAlley getAlleyInstance(Object obj) {
		if(obj instanceof LaneElement) {
			return new BowlingAlley((LaneElement) obj);
		} else if(obj instanceof Integer) {
			return new BowlingAlley((Integer) obj);
		} else 
			return null;
	}
	
	@Override
	public int play() {
		while(turn < MAX_TURNS) {
			for(Players player : players) {
				PinDown.logger("Player " +player.getId() +" is playing his " +turn +" th game" +" in"
						+ " lane " + (null != laneElem ? laneElem.getLaneId() : 1));
				ScoreCard score = new ScoreCard();
				try {
					score.setTotal(player.getScore().get(turn - 1).getTotal());
				} catch (Exception e) {
					//do nothing
				}
				int tri = score.getTryNum();
				int pins = DEFAULT_PINS;
				int remainingPins = -1;
				
				while(tri < 2) {
					remainingPins = PinDown.pinDown(pins);
					int scored = PinDown.getScore((pins - remainingPins), pins, tri);
					if(tri == Tries.TRY1.getValue()) {
						score.setTry1(scored);
						int total = score.getTotal() + scored;
						score.setTotal(total);
						
						PinDown.logger("Player " +player.getId() +" got " +score.getTry1() +" in " +tri +"th try and total score is: " +total
								+ " in lane " + (null != laneElem ? laneElem.getLaneId() : 1));
						
						//if user hits a strike
						if(remainingPins == 0) {
							break;
						}
					}
					if(tri == Tries.TRY2.getValue()) {
						score.setTry2(scored);
						int total = score.getTotal() + scored;
						score.setTotal(total);
						
						PinDown.logger("Player " +player.getId() +" got " +score.getTry2() +" in " +tri +"th try and total score is: " +total
								+ " in lane " + (null != laneElem ? laneElem.getLaneId() : 1));
						
					}
					score.setTryNum(++tri);
					tri = score.getTryNum();
					pins = remainingPins;
				}
				
				//handle spare of strike to roll extra ball in last game
				if(turn == MAX_TURNS && remainingPins == 0) {
					remainingPins = PinDown.pinDown(DEFAULT_PINS);
					int scored = PinDown.getScore((DEFAULT_PINS - remainingPins), DEFAULT_PINS, Tries.TRY3.getValue());
					int total = score.getTotal() + scored;
					
					score.setBonusTry(scored);
					score.setTotal(total);
					score.setTryNum(tri);
					
					PinDown.logger("Player " +player.getId() +" got " +score.getBonusTry() +" in " +tri +"th try and total score is: " +total
							+" in lane " + (null != laneElem ? laneElem.getLaneId() : 1));
				}
				
				player.getScore().add(score);
			}
			turn++;		
		}
		
		return turn;
	}

	@Override
	public int decideWinner() {
		int playerId = -1;
		if(turn < 10)
			return playerId;
		else {
			int maxScore = 0;
			//Decide the winners depending on their final score
			for(Players player : players) {
				int playerMax = player.getScore().get(9).getTotal();		//can be enhanced to check for the players total played
				if( playerMax > maxScore) {
					maxScore = playerMax;
					playerId = player.getId();
				}
			}
		}
		return playerId;
	}

}
