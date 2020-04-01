package edu.neu.csye6200.concurrentrunnable;

public class MyRunTest {

	
	MyRunnable myRunA= null;
	Thread threadA = null;
	
	MyRunnable myRunB= null;
	Thread threadB = null;
	
	//Constructor
	public MyRunTest() {
		myRunA= new MyRunnable("A");
		threadA= new Thread(myRunA);
		
		myRunB= new MyRunnable("B");
		threadB= new Thread(myRunB);
	}
	
	
	public void run() {
		threadA.start();//start the thread running
		
		threadB.start();
	}
	
	public static void main(String[] args) {
		MyRunTest mrtest = new MyRunTest();
		mrtest.run();
		System.out.println("Main thread is done!");
	}
}
