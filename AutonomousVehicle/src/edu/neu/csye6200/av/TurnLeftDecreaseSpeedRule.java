package edu.neu.csye6200.av;

import java.util.ArrayList;

public class TurnLeftDecreaseSpeedRule extends AVRule{
	
	public TurnLeftDecreaseSpeedRule(String description) {
		super(description);
	}

	public boolean exeSelfRule(Road road, Vehicle vehicle) {
		if(road.meetLeftSideMargin(vehicle.getLocation())) {
			return false;
		}
		vehicle.turnLeft();
		vehicle.decreaseHalfSpeed();
		vehicle.moveOneStep();
		System.out.println("move self succeed");
		return true;
	}
}
