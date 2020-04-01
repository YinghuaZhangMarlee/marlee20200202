package assignment3;

import java.io.File;
import java.util.ArrayList;

//Create a Transport Robot class.
//Use  inheritance to extend from your Assignment 2b Robot class 
public class TransportRobot extends Robot {

//Add member variables to this class that track the height, width and length of the main cargo hold.
    private int height;
    private int width;
    private int length;

//Add a new public method that calculates the cargo area
    public int cargoArea() {
        return this.height * this.width * this.length;
    }

    public TransportRobot() {
        super();
        this.height = 0;
        this.width = 0;
        this.length = 0;
    }

    public TransportRobot(int height, int width, int length) {
        super();
        this.height = height;
        this.width = width;
        this.length = length;

    }

    public TransportRobot(String name, String manufacture, String position, int heading, int speed, int weight,
            int enginePowerDraw, int batteryCapacity, int height, int width, int length) {
        super(name, manufacture, position, heading, speed, weight, enginePowerDraw, batteryCapacity);
        this.height = height;
        this.width = width;
        this.length = length;
    }
    
    public TransportRobot(Robot robot, int height, int width, int length) {
        super(robot.getName(), robot.getManufacture(), robot.getPosition().toString(), 
                robot.getHeading(), robot.getSpeed(), robot.getWeight(), robot.getEnginePowerDraw(), robot.getBatteryCapacity());
        this.height = height;
        this.width = width;
        this.length = length;
    }

//Add an attractive print routine to the  TransportRobot class that leverages the Robot print routine from 2b
//but add on information about the cargo area
    public String printFormat() {
        return super.toString() + ("Height =" + this.height
                + ", Width=" + this.width
                + ",length=" + this.length
                + ", Area=" + this.cargoArea());
    }

    public String toFormattedString() {
        return super.toFormattedString() + String.format("%1$15s %2$15s %3$15s %4$ 15d", this.height, this.width, this.length, this.cargoArea());
    }

    public String toString() {
        return (super.toString()
                + ", Height=" + this.height
                + "/mA, Width=" + this.width
                + "/mA, Length=" + this.length
                + "/mA, Area=" + this.cargoArea()
                + "/mA^3]");
    }

    public static void runRun() {
        RobotTest robotTest = new RobotTest();
        ArrayList<TransportRobot> tsList = new ArrayList();
        for (int i = 1; i < 6; i++) {
            tsList.add(new TransportRobot(robotTest.getInstance().robotList[i], i, i, i));
        }

        TransportRobot ts0 = new TransportRobot();
        System.out.println(ts0.toString());
        System.out.println();
        System.out.println(String.format("%1$12s %2$15s %3$15s %4$15s %5$15s %6$15s %7$15s %8$15s %9$15s %10$15s %11$15s ", " *Robot Name* ", " *Manufacturer* ", " *Position(X,Y)* ", " *Heading/degree* ",
                 " *Speed* ", " *Weight/Kg* ", " *EnginePowerDraw/mA* ", " *BatteryCapacity/mA-Hour* ", " *Height/mA* ",
                 " *Width/mA* ", " *Length/mA* ", " *Area/mA* \n"));
        for (TransportRobot ts : tsList) {
            System.out.println(ts.toFormattedString());
        }

        RobotIO rIO = new RobotIO();
        File file = new File("Robot.txt");
        if (file.exists()) {
            file.delete();
        }
        File fRobot = new File("Robot.txt");
        rIO.Save(ts0, fRobot);
        rIO.Save(tsList, fRobot);

        rIO.load("Robot.txt");
    }

    public static void main(String[] args) {
        runRun();
    }

}
