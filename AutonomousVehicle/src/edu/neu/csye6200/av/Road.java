package edu.neu.csye6200.av;

import java.util.ArrayList;
import java.util.List;

public class Road {

	private static Road roadInstance = new Road();
	private int downLimit;
	private int upLimit;
	private List<Vehicle> vehicleList;
	private List<Block> blockList;

	public Road() {
		this.downLimit = 660;
		this.upLimit = 130;
		this.vehicleList = new ArrayList<Vehicle>();
		this.blockList = new ArrayList<Block>();
	}

	public Road(int downLimit, int upLimit) {
		this.downLimit = downLimit;
		this.upLimit = upLimit;
		this.vehicleList = new ArrayList<Vehicle>();
		this.blockList = new ArrayList<Block>();
	}

	public static Road getInstance() {
		return roadInstance;
	}

	public int getDownLimit() {
		return downLimit;
	}

	public void setDownLimit(int downLimit) {
		this.downLimit = downLimit;
	}

	public int getUpLimit() {
		return upLimit;
	}

	public void setUpLimit(int upLimit) {
		this.upLimit = upLimit;
	}

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public List<Block> getBlockList() {
		return blockList;
	}

	public void setBlockList(List<Block> blockList) {
		this.blockList = blockList;
	}

	private boolean checkLocationDuplicate(Location newLocation, Location existLocation) {
		return (newLocation.equals(existLocation));
	}

	private boolean checkValidLocation(Location l) {
		if(l.getyPosition() < this.upLimit || l.getyPosition() > this.downLimit)
			return false;
		return true;
	}

	public void addVehicle(Vehicle v) {
		boolean existFlag = false;
		for (Vehicle vehicle : this.vehicleList) {
			if (this.checkLocationDuplicate(v.getLocation(), vehicle.getLocation())) {
				existFlag = true;
				break;
			}
		}
		

		if (!existFlag && this.checkValidLocation(v.getLocation())) {
			for (Vehicle vehicle : this.vehicleList) {
				vehicle.addSensingOtherVehicles(v);
			}

			this.vehicleList.add(v);
			System.out.println("add vehicle succeed:" + v.getLocation());
		}
	}

	public void addBlock(Block b) {
		this.blockList.add(b);
	}
	
	public boolean meetRightSideMargin(Location l) {
		if(l.getyPosition() == this.downLimit)
			return true;
		return false;
	}
	
	public boolean meetLeftSideMargin(Location l) {
		if(l.getyPosition() == this.upLimit)
			return true;
		return false;
	}

}
