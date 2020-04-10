package edu.neu.csye6200.av;

import java.util.List;

public class RightMoveRule extends AVRule {

	public RightMoveRule(String description) {
		super(description);
	}

	public boolean exeSelfRule(Road road, Vehicle vehicle, List<Location> locations) {
		if(road.meetRightSideMargin(vehicle.getLocation())) {
			return false;
		}
		
		vehicle.turnRight();
		//detach new location collision, if so, then move back
		if(vehicle.isCashNow(locations)) {
			vehicle.turnLeft();
			return false;
		}
		
		vehicle.moveOneStep();
		System.out.println("move self succeed");
		return true;
	}
	
}
