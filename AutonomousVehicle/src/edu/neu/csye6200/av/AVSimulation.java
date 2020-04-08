package edu.neu.csye6200.av;

public class AVSimulation {

	private static AVSimulation simulationInstance = new AVSimulation();
	
	public AVSimulation() {
		//generate road
		Road road = Road.getInstance();
		
		//generate vehicles
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Vehicle("Yellow", "AUDI", 4, new Location(0, 300), 60, 100);
		Vehicle v3 = new Vehicle("Green", "FORD", 6, new Location(0, 480), 80, 100);
		
		//generate blocks
		Block b1 = new Block(800, 120);
		Block b2 = new Block(1200, 300);
		
		//add vehicles into list
		road.addVehicle(v1);
		road.addVehicle(v2);
		road.addVehicle(v3);
		
		//add blocks
		road.addBlock(b1);
		road.addBlock(b2);
	}
	
	public static AVSimulation getInstance() {
		return simulationInstance;
	}
}
