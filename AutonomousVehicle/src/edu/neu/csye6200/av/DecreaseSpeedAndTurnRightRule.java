package edu.neu.csye6200.av;

import java.util.ArrayList;

public class DecreaseSpeedAndTurnRightRule extends AVRule{
	
	public DecreaseSpeedAndTurnRightRule(String description) {
		super(description);
	}

	@Override
	public void process(Road road) {
		ArrayList<Vehicle> afterCaculateBlock = new ArrayList();

		for (Vehicle vehicle : road.getVehicleList()) {

			for (Block block : road.getBlockList()) {
				if (vehicle.reachStopDistance(block.getBlockLocation()) && !vehicle.isStop()) {
					if(!vehicle.isSpeedDecrease())
						vehicle.decreaseHalfSpeed();
					if (!road.meetRightSideMargin(vehicle.getLocation()))
						vehicle.getLocation().moveRight();
					else {
						if (!road.meetLeftSideMargin(vehicle.getLocation()))
							vehicle.getLocation().moveLeft();
						else
							vehicle.stopMove();
					}
				}
			}
			
			vehicle.moveOneStep();
			
		}
	}
}
