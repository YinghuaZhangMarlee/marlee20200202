package edu.neu.csye6200.ui;

import java.util.Observable;


public class Simulation extends Observable implements Runnable {

	private Thread thread = null;//the thread that run my simulation
	private boolean paused = false;
	private boolean done = false;
	private int ctr=0;
	
	public void startSim() {
		System.out.println("Starting the simulation");
		if (thread != null) return;//A thread is already running
		
		thread = new Thread(this);//creat a worker thread
		paused = false;
		done = false;//reset the done flag.
		ctr=0;//reset the loop counter
		thread.start();

	}
	
	public void pauseSim() {

		paused = !paused;
		System.out.println("Pause the simulation: " + paused);
	}
	
	public void stopSim() {
		System.out.println("stop the simulation");
		if (thread == null) return;//defensive coding in case the thread is null
		done= true;
	}

	@Override
	public void run() {
		runSimLoop();
		thread = null;//flag that the simulation thread is finished
		
	}
	
	private void runSimLoop() {
		while(! done) {
			//do something simulation work
			if (!paused)
				updateSim();
			sleep(500L);// a half second sleep
		}
	}
	
	//make the current thread sleep a little
	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//Allow access to the simulation data
	public int getCtr(){
		return ctr;
	}
	
	private void updateSim() {
		System.out.println("Updating the simulation"+ ctr++);
		setChanged();
		notifyObservers(this);//Send a copy of the simulation
		
	}
}
