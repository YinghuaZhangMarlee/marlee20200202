package Assignment2;

public class RobotTest {

	  private static RobotTest robotInstance = new RobotTest();
	  public Robot robotList[];

	  public static RobotTest getInstance() {
	        return robotInstance;
	    }
//assignment2a  	• use the ‘new’ operation with your  Robot constructor  to generate five instances of  a Robot.
    public RobotTest() {
    	this.robotList = new Robot[10];
        sampleRobots();
    }

    public void sampleRobots() {
        this.robotList[0] = new Robot();
        this.robotList[1] = new Robot("BBB", "Marlee", "(1,2)", 45, 3, 19, 3, 5);
        this.robotList[2] = new Robot("CCC", "Marlee", "(3,4)", 30, 5, 19, 7, 2);
        this.robotList[3] = new Robot("DDD", "Marlee", "(-5,6)", 90, 6, 22, 5, 5);
        this.robotList[4] = new Robot("EEE", "Marlee", "(7,8)", 180, 9, 25, 8, 10);
        this.robotList[5] = new Robot("FFF", "Marlee", "(9,19)", 270, 10, 28, 6, 11);
    }

//assignment2a  	• Add a method to print an attractive display of the  Robot information
    public void PrintNormal() {
        System.out.println(" *Robot Name* " + " *Manufacturer* " + " *Position(X,Y)* " + " *Heading/degree* "
                + " *Speed* " + " *Weight/Kg* " + " *EnginePowerDraw/mA* " + " *BatteryCapacity/mA-Hour* " + "\n");
        for (int i = 1; i <= 5; i++) {
            Robot robot = this.robotList[i];
            System.out.println(robot.toFormattedString());

        }
    }

//assignment2a  • Have your  test code print details about all of the Robot instances
    public void PrintFormat() {
        Robot robot1 = this.robotList[0];
        System.out.println(robot1.toString());
    }

    public void PrintMoveto() {
        for (int i = 1; i <= 5; i++) {
            Robot robot = this.robotList[i];
            robot.moveTo();
        }

    }


}
