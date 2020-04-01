package Inheritance;

import java.util.ArrayList;
import java.util.logging.Logger;

public class MeterManager {
	
	private static MeterManager instance = null;
	private static Logger log = Logger.getLogger(MeterManager.class.getName());
	private ArrayList<Meter> meterList = new ArrayList<Meter>();
	private MeterManager() {
	
	}
	
	public static MeterManager instance() {
		if (instance == null) instance = new MeterManager();
		return instance;
	}
	public void add(Meter meter) {
		meterList.add(meter);
		log.info("Added meter "+ meter);
	}
	public void displayMeters() {
		for(Meter meter : meterList) {
			System.out.println("Measure is " + meter.measure());
		}
	}
}
