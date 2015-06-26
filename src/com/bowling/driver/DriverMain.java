package com.bowling.driver;

import com.bowling.iface.IPlay;
import com.bowling.iface.IStartGameInLane;
import com.bowling.impl.BowlingAlley;
import com.bowling.impl.Lane;
import com.bowling.pojo.LaneElement;
import com.bowling.pojo.WinnerInLane;

public class DriverMain {
	public static void main(String[] args) {
		/*IPlay bowAlley = BowlingAlley.getAlleyInstance(5);
		
		System.out.println("Starting the game");
		bowAlley.play();
		
		int winnerID = bowAlley.decideWinner();
		if(winnerID != -1 )
			System.out.println("And the winner of the game is: " +bowAlley.decideWinner());
		
		*/
		/*int[] numOfPlrInLane = {3, 2, 3};
		IStartGameInLane lane = new Lane(3, numOfPlrInLane);
		lane.startGame();*/
		
		LaneElement[] elem = new LaneElement[3];
		for(int i = 0; i < 3; i++) {
			elem[i] = new LaneElement(i, 4);
		}
		IStartGameInLane lane = new Lane(elem);
		lane.startGame();
		
		WinnerInLane[] declareWinnerInLane = lane.declareWinnerInLane();
		
		for(WinnerInLane winner : declareWinnerInLane) {
			if(winner.getWinnerId() != -1) {
				System.out.println("winner for lane "+ winner.getLaneId() +" is " +winner.getWinnerId());
			}
		}
	}
}
