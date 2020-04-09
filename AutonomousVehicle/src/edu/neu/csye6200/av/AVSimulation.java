package edu.neu.csye6200.av;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class AVSimulation {

	private static AVSimulation simulationInstance = new AVSimulation();

	public AVSimulation() {
		this.GenerateRoad();
	}

	public static AVSimulation getInstance() {
		return simulationInstance;
	}

	private void GenerateRoad() {
		// generate road
		Road road = Road.getInstance();
		HashSet<Integer> xPositionSet = new HashSet<Integer>();

		Random rand = new Random();
		while(xPositionSet.size() <= 5) {
			int x = rand.nextInt(1200);
			boolean flag = true;
			for(int num: xPositionSet) {
				if(num+100 < x || num -100 > x)
					flag = true;
			}
			xPositionSet.add(x);
		}
		List<Integer> xPositionList = new ArrayList<> (xPositionSet);

		// generate vehicles
		Vehicle v1 = new Vehicle("Yellow", "AUDI", 4, new Location(xPositionList.get(0), 130), 30, 10);
		Vehicle v2 = new Vehicle("Yellow", "AUDI", 4, new Location(xPositionList.get(1), 300), 60, 100);
		Vehicle v3 = new Vehicle("Green", "FORD", 6, new Location(xPositionList.get(2), 480), 80, 100);

		// generate blocks
		Block b1 = new Block(xPositionList.get(3), 130);
		Block b2 = new Block(xPositionList.get(4), 300);

		// add vehicles into list
		road.addVehicle(v1);
		road.addVehicle(v2);
		road.addVehicle(v3);

		// add blocks
		road.addBlock(b1);
		road.addBlock(b2);
	}

	public void resetInstance() {
		Road.getInstance().setVehicleList(new ArrayList<Vehicle>());
		Road.getInstance().setBlockList(new ArrayList<Block>());
		this.GenerateRoad();
	}
}
