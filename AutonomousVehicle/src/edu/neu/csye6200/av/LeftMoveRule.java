package edu.neu.csye6200.av;

import java.util.List;

public class LeftMoveRule extends AVRule {

	public LeftMoveRule(String description) {
		super(description);
	}
	
	public boolean exeSelfRule(Road road, Vehicle vehicle, List<Location> locations) {
		if(road.meetLeftSideMargin(vehicle.getLocation())) {
			return false;
		}
		
		vehicle.turnLeft();
		//detach new location collision, if so, then move back
		if(vehicle.isCashNow(locations)) {
			vehicle.turnRight();
			return false;
		}
		
		vehicle.moveOneStep();
		System.out.println("move self succeed");
		return true;
	}
}
