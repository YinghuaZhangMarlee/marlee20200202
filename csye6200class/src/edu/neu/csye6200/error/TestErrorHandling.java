package edu.neu.csye6200.error;
import java.io.IOException;
public class TestErrorHandling {

	public TestErrorHandling() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private void run() {
		try {
			testError(1);//Let's produce an error;
		}catch(IllegalArgumentException e1) {
			System.out.println("We caught an IllegalArgument error");
			e1.printStackTrace();
		}
		catch( IOException e2) {
			System.out.println("We caught an IOException error");
			e2.printStackTrace();
		}
		finally{
			System.out.println("Final cleanup");
		}
		
	}
	
	public void testError(int val) throws IllegalArgumentException, IOException{
		if(val<2)
			throw new IllegalArgumentException();
		if(val>5)
			throw new IOException();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestErrorHandling testerrorhandling = new TestErrorHandling();
		testerrorhandling.run();

	}
	
	
}
