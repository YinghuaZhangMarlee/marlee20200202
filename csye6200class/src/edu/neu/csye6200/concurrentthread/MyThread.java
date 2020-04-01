package edu.neu.csye6200.concurrentthread;

public class MyThread extends Thread {

	private boolean done= false;
	private int counter =0;
	
	
	public MyThread(String name) {
		super(name);//set the name of that thread
	}
	
	public void run() {
		while (!done) {
			doWork();
			counter++;
			if ((counter %10)==0)
			System.out.println("Thread " + this.getName()
			                    +"-  loop#" + counter);
			
			if (counter > 10000) done = true;//stop at 10K
			
		}
	}
	
	private void doWork(){
		for (int  i= 0; i <100000; i++) {
			double val = Math.exp((double) i);
		}
	}
	
}
