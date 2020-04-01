package edu.neu.csye6200.concurrentthread;

public class MyThreadTest {
	
	private MyThread threadA = null;
	
	private MyThread[] threads = new MyThread[10];
	
	//constructor
	public MyThreadTest() {
		threadA = new MyThread("A");
		
		for (int i= 0; i< threads.length; i++)
			threads[i] = new MyThread("Threads" +i);
		
	}
	
	public void run() {
		threadA.start();//begin execution of my thread
		
		for (int i= 0; i< threads.length; i++)
			threads[i].start();
		
		for (int i= 0; i< threads.length; i++)
			try {
				threads[i].join();//show last print sentense
			} catch (InterruptedException e) {
				e.printStackTrace();
			};
	}

	public static void main(String[] args) {

		MyThreadTest mtt= new MyThreadTest();
		mtt.run();
		System.out.println("we are done with the main ");
	}

}
