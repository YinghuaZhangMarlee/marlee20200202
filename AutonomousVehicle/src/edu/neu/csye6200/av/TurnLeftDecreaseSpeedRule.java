package edu.neu.csye6200.av;

import java.util.List;

public class TurnLeftDecreaseSpeedRule extends AVRule{
	
	public TurnLeftDecreaseSpeedRule(String description) {
		super(description);
	}

	public boolean exeSelfRule(Road road, Vehicle vehicle, List<Location> locations) {
		if(road.meetLeftSideMargin(vehicle.getLocation())) {
			return false;
		}
		
		vehicle.turnLeft();
		vehicle.decreaseHalfSpeed();
		if(vehicle.isCashNow(locations)) {
			vehicle.turnRight();
			vehicle.accelerateDoubleSpeed();
			return false;
		}
		
		vehicle.moveOneStep();
		System.out.println("move self succeed");
		return true;
	}
}
