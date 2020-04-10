package edu.neu.csye6200.av;

import java.util.ArrayList;

public class TurnRightDecreaseSpeedRule extends AVRule{
	
	public TurnRightDecreaseSpeedRule(String description) {
		super(description);
	}

	public boolean exeSelfRule(Road road, Vehicle vehicle) {
		if(road.meetRightSideMargin(vehicle.getLocation())) {
			return false;
		}
		vehicle.turnRight();
		vehicle.decreaseHalfSpeed();
		vehicle.moveOneStep();
		System.out.println("move self succeed");
		return true;
	}
}
