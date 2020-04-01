package edu.neu.csye6200.obs;

import java.util.Observable;

public class EventPublisher extends Observable{

	private boolean done = false;//set true to stop the run method
	private int ctr = 0;
	
	public EventPublisher() {
		System.out.println("EventPublisher- we are constructing");
	}
	
	//do something that will generate an observable event
	public void doAction() {
		setChanged();//something happend
		notifyObservers(new String("A message "+ctr));
	}
	
	public void run() {
		while (!done) {
			ctr++;
			doAction();
			if (ctr>10)
				done = true;//leave the whil loop
		}
	}
	
	public static void main(String[] args) {
		EventPublisher ep= new EventPublisher();
		
		EventSubscriber sub1 = new EventSubscriber();
		ep.addObserver(sub1);//make the subscription
		
		ep.run();//start the while loop
	}

}
