package edu.neu.csye6200.av;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {

	private String vehicleColor;
	private String vehicleCompany;
	private int vehicleSeating;
	private Location location;
	private int speed; // m/s
	private boolean speedDecrease = false;
	private int stopDistance; // m
	private final int imageLength = 100;
	private List<Vehicle> sensingOtherVehicles;

	public Vehicle() {
		this.vehicleColor = "Red";
		this.vehicleCompany = "Volkswagen";
		this.vehicleSeating = 4;
		this.location = new Location(0, 130);
		this.speed = 30;
		this.stopDistance = 10;
		this.sensingOtherVehicles = new ArrayList<Vehicle>();
	}

	public Vehicle(String color, String company, int seating, Location location, int speed, int instance) {
		this.vehicleColor = color;
		this.vehicleCompany = company;
		this.vehicleSeating = seating;
		this.location = location;
		this.speed = speed;
		this.stopDistance = instance;
		this.sensingOtherVehicles = new ArrayList<Vehicle>();
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public String getVehicleCompany() {
		return vehicleCompany;
	}

	public void setVehicleCompany(String vehicleCompany) {
		this.vehicleCompany = vehicleCompany;
	}

	public int getVehicleSeating() {
		return vehicleSeating;
	}

	public void setVehicleSeating(int vehicleSeating) {
		this.vehicleSeating = vehicleSeating;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStopDistance() {
		return stopDistance;
	}

	public void setStopDistance(int stopDistance) {
		this.stopDistance = stopDistance;
	}

	public List<Vehicle> getSensingOtherVehicles() {
		return sensingOtherVehicles;
	}

	public void setSensingOtherVehicles(List<Vehicle> sensingOtherVehicles) {
		this.sensingOtherVehicles = sensingOtherVehicles;
	}

	public boolean isSpeedDecrease() {
		return speedDecrease;
	}

	public void setSpeedDecrease(boolean speedDecrease) {
		this.speedDecrease = speedDecrease;
	}

	public void addSensingOtherVehicles(Vehicle v) {
		this.sensingOtherVehicles.add(v);
	}

	public void deleteSensingOtherVehicles(Vehicle v) {
		this.sensingOtherVehicles.remove(v);
	}

	public boolean reachStopDistance(Location l) {
		if (this.location.getyPosition() == l.getyPosition()
				&& (this.location.getxPosition() + this.speed + this.stopDistance + this.imageLength > l
						.getxPosition() && (this.location.getxPosition() + this.speed + this.stopDistance + this.imageLength < l
								.getxPosition() + 2 * this.imageLength)))
			return true;
		return false;
	}

	public void stopMove() {
		this.speed = 0;
	}

	public boolean isStop() {
		return (this.speed == 0);
	}

	public void moveOneStep() {
		this.location.setxPosition(this.location.getxPosition() + this.speed);
	}

	public void decreaseHalfSpeed() {
		this.speed /= 2;
		this.speedDecrease = true;
	}

}
