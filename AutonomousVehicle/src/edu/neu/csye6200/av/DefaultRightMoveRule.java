package edu.neu.csye6200.av;

import java.util.ArrayList;

public class DefaultRightMoveRule extends AVRule {

	public DefaultRightMoveRule(String description) {
		super(description);
	}

	@Override
	// the first rule: if a vehicle meets blocks/vehicles, then move to right side
	public void process(Road road) {
		ArrayList<Vehicle> afterCaculateBlock = new ArrayList();

		// judge whether each vehicles meet block, if it is then generate a position
		// move to right
		for (Vehicle vehicle : road.getVehicleList()) {

			for (Block block : road.getBlockList()) {
				System.out.println("block position :" + block.getBlockLocation());
				System.out.println("now position: " + vehicle.getLocation()
						+ (vehicle.getLocation().getyPosition() == block.getBlockLocation().getyPosition())
						+ ((vehicle.getLocation().getxPosition() + vehicle.getSpeed()
								+ vehicle.getStopDistance()) > block.getBlockLocation().getxPosition()));
				if (vehicle.reachStopDistance(block.getBlockLocation()) && !vehicle.isStop()) {
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
