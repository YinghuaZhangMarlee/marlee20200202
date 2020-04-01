package edu.neu.csye6200.obs;

import java.util.Observable;
import java.util.Observer;

public class EventSubscriber implements Observer{

	@Override
	public void update(Observable o, Object arg) {
//react to update
		System.out.println("ES received update from " + o);
		System.out.println("         message " + arg);
		
	}

}
