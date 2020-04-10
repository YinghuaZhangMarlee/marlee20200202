package edu.neu.csye6200.av;

import java.util.ArrayList;
import java.util.List;

public abstract class AVRule {

	private String description;

	public AVRule(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return this.description;
	}

	public abstract boolean exeSelfRule(Road road, Vehicle veihicle, List<Location> locations);

	public void process(Road road) {

		for (Vehicle vehicle : road.getVehicleList()) {

			List<Location> allLocation = new ArrayList();
			for (Vehicle v : vehicle.getSensingOtherVehicles()) {
				allLocation.add(v.getLocation());
			}
			for (Block b : road.getBlockList()) {
				allLocation.add(b.getBlockLocation());
			}

			vehicle.moveOneStep();
			// if vehicle does not cash other blocks, it would notify other vehicles its new
			// location and move
			if (!vehicle.isCashNow(allLocation)) {
				// wake up the car
				if (vehicle.isStop())
					vehicle.setStop(false);
				continue;
			} else {
				vehicle.moveBackOneStep();
				if (this.exeSelfRule(road, vehicle, allLocation)) {
					System.out.println("move self");
					continue;
				}

				vehicle.setStop(true);
			}
		}
	}
}
