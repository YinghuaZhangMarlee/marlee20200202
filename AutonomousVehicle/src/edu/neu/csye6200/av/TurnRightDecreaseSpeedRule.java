package edu.neu.csye6200.av;

import java.util.List;

public class TurnRightDecreaseSpeedRule extends AVRule{
	
	public TurnRightDecreaseSpeedRule(String description) {
		super(description);
	}

	public boolean exeSelfRule(Road road, Vehicle vehicle, List<Location> locations) {
		if(road.meetRightSideMargin(vehicle.getLocation())) {
			return false;
		}

		vehicle.turnRight();
		vehicle.decreaseHalfSpeed();
		if(vehicle.isCashNow(locations)) {
			vehicle.turnLeft();
			vehicle.accelerateDoubleSpeed();
			return false;
		}
		
		System.out.println("move self succeed");
		return true;
	}
}
