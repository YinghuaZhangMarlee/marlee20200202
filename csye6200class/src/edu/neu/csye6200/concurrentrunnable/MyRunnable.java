package edu.neu.csye6200.concurrentrunnable;

public class MyRunnable implements Runnable{
	private String name;
	private boolean done= false;
	private int counter =0;
	
	public MyRunnable(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {

		while (!done) {
			doWork();
			counter++;
			if ((counter %10)==0)
			System.out.println("Thread " + name
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
