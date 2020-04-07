package edu.neu.csye6200.av;

import java.util.ArrayList;
import java.util.List;

public class Road {

	private static Road roadInstance = new Road();
	private int yMarginLimit; // in fact, it is the lane number
	private int xMarginLimit;
	private List<Vehicle> vehicleList;
	private List<Block> blockList;

	public Road() {
		this.yMarginLimit = 800;
		this.xMarginLimit = 1600;
		this.vehicleList = new ArrayList<Vehicle>();
		this.blockList = new ArrayList<Block>();
	}

	public Road(int laneNum, int limit) {
		this.yMarginLimit = laneNum;
		this.xMarginLimit = limit;
		this.vehicleList = new ArrayList<Vehicle>();
		this.blockList = new ArrayList<Block>();
	}

	public static Road getInstance() {
		return roadInstance;
	}

	public int getyMarginLimit() {
		return yMarginLimit;
	}

	public void setyMarginLimit(int yMarginLimit) {
		this.yMarginLimit = yMarginLimit;
	}

	public int getxMarginLimit() {
		return xMarginLimit;
	}

	public void setxMarginLimit(int xMarginLimit) {
		this.xMarginLimit = xMarginLimit;
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
		if(l.getxPosition() < 0 || l.getxPosition() > this.xMarginLimit)
			return false;
		if(l.getyPosition() < 0 || l.getyPosition() > this.yMarginLimit)
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
		if(l.getyPosition() == this.yMarginLimit)
			return true;
		return false;
	}
	
	public boolean meetLeftSideMargin(Location l) {
		if(l.getyPosition() == 0)
			return true;
		return false;
	}

}
