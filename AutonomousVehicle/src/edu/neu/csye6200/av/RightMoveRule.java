package edu.neu.csye6200.av;

import java.util.ArrayList;
import java.util.List;

public class RightMoveRule extends AVRule {

	public RightMoveRule(String description) {
		super(description);
	}

	public boolean exeSelfRule(Road road, Vehicle vehicle) {
		if(road.meetRightSideMargin(vehicle.getLocation())) {
			return false;
		}
		vehicle.turnRight();
		vehicle.moveOneStep();
		System.out.println("move self succeed");
		return true;
	}
	
}
