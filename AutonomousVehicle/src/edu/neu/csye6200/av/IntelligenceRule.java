package edu.neu.csye6200.av;

import java.util.List;

public class IntelligenceRule extends AVRule {

	public IntelligenceRule(String description) {
		super(description);
	}
	
	public boolean exeSelfRule(Road road, Vehicle vehicle, List<Location> locations) {
		return true;
	}
}
