package edu.neu.csye6200.av;

public class Location {

	private double xPosition;
	private double yPosition;
	
	public Location() {
		this.xPosition = 0;
		this.yPosition = 0;
	}
	
	public Location(double x, double y) {
		this.xPosition = x;
		this.yPosition = y;
	}
	
	public Location(int x, int y) {
		this.xPosition = Double.valueOf(x);
		this.yPosition = Double.valueOf(y);
	}

	public double getxPosition() {
		return xPosition;
	}

	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	public double getyPosition() {
		return yPosition;
	}

	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}
	
	public boolean equals(Location l) {
		if(this.xPosition == l.xPosition && this.yPosition == l.yPosition)
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return "(" + this.xPosition + ", " + this.yPosition + ")";
	}
}
