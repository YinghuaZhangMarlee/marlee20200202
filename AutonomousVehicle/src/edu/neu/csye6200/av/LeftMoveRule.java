package edu.neu.csye6200.av;

import java.util.ArrayList;
import java.util.List;

public class LeftMoveRule extends AVRule {

	public LeftMoveRule(String description) {
		super(description);
	}
	
	public boolean exeSelfRule(Road road, Vehicle vehicle) {
		if(road.meetLeftSideMargin(vehicle.getLocation())) {
			return false;
		}
		vehicle.turnLeft();
		vehicle.moveOneStep();
		System.out.println("move self succeed");
		return true;
	}
}
