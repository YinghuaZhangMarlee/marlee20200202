package edu.neu.csye6200.av;

import java.util.ArrayList;

public class DefaultLeftMoveRule extends AVRule {
	
	public DefaultLeftMoveRule(String description) {
		super(description);
	}

	@Override
	// the second rule: if a vehicle meets blocks/vehicles, then move to left side
	public void process(Road road) {
		ArrayList<Vehicle> afterCaculateBlock = new ArrayList();

		for (Vehicle vehicle : road.getVehicleList()) {

			for (Block block : road.getBlockList()) {
				
				if (vehicle.reachStopDistance(block.getBlockLocation()) && !vehicle.isStop()) {
					if (!road.meetLeftSideMargin(vehicle.getLocation()))
						vehicle.getLocation().moveLeft();
					else {
						if (!road.meetRightSideMargin(vehicle.getLocation()))
							vehicle.getLocation().moveRight();
						else
							vehicle.stopMove();
					}
				}
			}
			
			vehicle.moveOneStep();
			
		}
	}
}
