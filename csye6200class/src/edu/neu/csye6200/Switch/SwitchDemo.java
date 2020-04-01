package edu.neu.csye6200.Switch;
import java.io.IOException;

public class SwitchDemo {
	
	
	//int gameBoard[] [] = new int [8] [8];
	int gameBoard[] [] = { 
	{1,1,7,1,1,3,1,1},
	{1,6,1,1,1,1,1,1},
	{1,1,2,1,1,5,1,1},
	{1,1,1,9,1,1,1,6},
	{1,1,1,1,1,1,1,1},
	{7,1,2,1,3,1,3,1},
	{1,1,1,1,1,1,1,1},
	{1,4,1,1,1,7,9,1},	
	
	};
	
	
	void displayGameBoard() {
		for(int row = 0; row <8; row++) {
			int rowVals[] = gameBoard[row];
			for (int cel : rowVals) {
				System.out.print(cel + " ");//keep on line
			}
			System.out.println("");//Print a carriage return
		}
	}
	
	
	//Constructor
	public SwitchDemo() throws IOException {
		System.out.println("SwitchDemo constructor start");
		
		displayGameBoard();
		
		int values[] = gameBoard[0];
		
		int sum = 0;
		
		for (int val : values) {
			sum += val; //sum = sum+val;
		}
		boolean done = false;//We' re not done yet
		
		char inVal; // My input value (16 bit unicode)
		while(!done) {//Loop until done == true
			
			inVal = (char) System.in.read();//Read a character
			if(inVal == '\r') continue;//carriage return
			if(inVal == '\n') continue;//newline
			
			System.out.println("We read a " + inVal + " character " + 
			(int) inVal);
			
			switch (inVal) {
			case 'a':
			case 'A':
				System.out.println("We have an 'a'");
				break;
			case 'b':
				System.out.println("We have an 'b'");
				break;
			default:
				System.out.println("We have a default value " + (int) inVal);
				break;
			case 'q':
				System.out.println("We are quitting");
				done = true;//Indicate that we are quitting
				break;
			}//switch
			
		}//While !done
		
	}//constructor

	//We start here
	public static void main(String[] args) throws IOException {
	   new SwitchDemo();//Create class and run constructor		
	   System.out.println("Exiting program");
	}

}
