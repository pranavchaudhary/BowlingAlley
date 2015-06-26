package com.bowling.iface;

import com.bowling.pojo.WinnerInLane;

public interface IStartGameInLane {
	void startGame();
	WinnerInLane[] declareWinnerInLane();
}
