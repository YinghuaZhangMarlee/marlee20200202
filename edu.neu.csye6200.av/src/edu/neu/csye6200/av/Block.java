package edu.neu.csye6200.av;

public class Block {
	
	private Location blockLocation;
	
	public Block() {
		this.blockLocation = new Location();
	}
	
	public Block(int x, int y) {
		this.blockLocation = new Location(x, y);
	}
	
	public Block(double x, double y) {
		this.blockLocation = new Location(x, y);
	}

	public Location getBlockLocation() {
		return blockLocation;
	}

	public void setBlockLocation(Location blockLocation) {
		this.blockLocation = blockLocation;
	}
	
}
