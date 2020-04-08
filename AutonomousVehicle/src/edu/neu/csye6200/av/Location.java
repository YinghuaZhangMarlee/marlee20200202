package edu.neu.csye6200.av;

public class Location {

	private final double laneLen = 180;
	private int xPosition;
	private int yPosition;
	
	public Location() {
		this.xPosition = 0;
		this.yPosition = 0;
	}
	
	
	public Location(int x, int y) {
		this.xPosition = x;
		this.yPosition = y;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	
	public void moveRight() {
		this.yPosition += this.laneLen;
	}
	
	public void moveLeft() {
		this.yPosition -= this.laneLen;
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
