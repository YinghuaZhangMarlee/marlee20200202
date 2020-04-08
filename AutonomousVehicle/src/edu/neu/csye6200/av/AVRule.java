package edu.neu.csye6200.av;

import java.util.ArrayList;

public abstract class AVRule {

	private String description;
	
	public AVRule(String description) {
		this.description  = description;
	}
	
	@Override
	public String toString() {
		return this.description;
	}

	public abstract void process(Road road);
}
