package Assignment2ab;

public class RobotTest {

	Robot robotInstance[];

//assignment2a  	• use the ‘new’ operation with your  Robot constructor  to generate five instances of  a Robot.
	public RobotTest() {
		robotInstance = new Robot[10];
		sampleRobots();
	}
		public void sampleRobots() {
		robotInstance[0] = new Robot(); 
		robotInstance[1] = new Robot("BBB","Marlee","(1,2)",45,3,19,3,5); 
		robotInstance[2] = new Robot("CCC","Marlee","(3,4)",30,5,19,7,2); 
		robotInstance[3] = new Robot("DDD","Marlee","(-5,6)",90,6,22,5,5); 
		robotInstance[4] = new Robot("EEE","Marlee","(7,8)",180,9,25,8,10); 
		robotInstance[5] = new Robot("FFF","Marlee","(9,19)",270,10,28,6,11); 
		}

//assignment2a  	• Add a method to print an attractive display of the  Robot information
		public void PrintNormal() {
			System.out.println(" *Robot Name* " +" *Manufacturer* " + " *Position(X,Y)* "+" *Heading/degree* "
		+" *Speed* "+" *Weight/Kg* " + " *EnginePowerDraw/mA* " + " *BatteryCapacity/mA-Hour* "+"\n");
			for (int i =1; i<=5; i++) {
				Robot robot = robotInstance[i];
				System.out.println(robot.toFormattedString());
			
			}
		}

//assignment2a  • Have your  test code print details about all of the Robot instances
		   
		
		public void PrintFormat() {
			Robot robot1 = robotInstance[0];
			System.out.println(robot1.toString());
		}	
			

		public void PrintMoveto() {
			for (int i =1; i<=5; i++) {
				Robot robot = robotInstance[i];
				robot.moveTo();
			}
			
		}	
		
//* assignment2ab * Move all test code and place it into a run() method. Call run() from main
		
		public void run() {
			PrintFormat();
			System.out.println();
			PrintNormal();
			System.out.println();
			PrintMoveto();
			
		}
		
		
		public static void main(String[] args) {
			RobotTest robotTest = new RobotTest();
			robotTest.run();

   }
}
