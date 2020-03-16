package edu.neu.csye6200.robot;


public class Robot {

//assignment2a  	• Add Strings for the robot name and manufacturer
    int robotID;
    String name;
    String manufacture;

//assignment2a  	• Add values for the position (X, Y), heading (in degrees), and speed
    Position position = this.position;
    int heading;
    int speed;
    private static int idCounter = 1000;

    static class Position {

        double X;
        double Y;

        Position(double x, double y) {
            this.X = x;
            this.Y = y;
        }

        public double getX() {
            return X;
        }

        public void setX(double x) {
            this.X = x;
        }

        public double getY() {
            return Y;
        }

        public void setY(double y) {
            this.Y = y;
        }

        public String toString() {
            return "(" + this.getX() + "," + this.getY() + ")";
        }
    }
//assignment2a  	• Add values for weight (i.e. total mass Kg), engine power draw (mA), battery capacity (mA-Hour)
    int weight;
    int enginePowerDraw;
    int batteryCapacity;


	//assignment2a  	• Add a constructor that sets the  name and other major values	
    public Robot() {

        this.name = "AAA";
        this.manufacture = "Marlee";

        this.position = new Position(10,9.8);
        this.heading = 45;
        this.speed = 5;

        this.weight = 20;
        this.enginePowerDraw = 2;
        this.batteryCapacity = 5;
        this.robotID = this.idCounter++;
        System.out.println("Robot constructed called.");
    }
//assignment2a  	• Add getter and setter methods for major  variables

    public Robot(String name, String manufacture, String position, int heading, int speed, int weight,
            int enginePowerDraw, int batteryCapacity) {
        this.name = name;
        this.manufacture = manufacture;
        //	*getposition( X,Y )values
        position = position.replace(" ", "");
        position = position.replace("(", "");
        position = position.replace(")", "");
        String[] positionStr = position.split(",");
        this.position = new Position(Double.valueOf(positionStr[0]).intValue(), Double.valueOf(positionStr[1]).intValue());

        this.heading = heading;
        this.speed = speed;
        this.weight = weight;
        this.enginePowerDraw = enginePowerDraw;
        this.batteryCapacity = batteryCapacity;
        this.robotID = this.idCounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getEnginePowerDraw() {
        return enginePowerDraw;
    }

    public void setEnginePowerDraw(int enginePowerDraw) {
        this.enginePowerDraw = enginePowerDraw;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String toFormattedString() {
        return String.format(">>>%1$12s %2$15s %3$15s %4$ 15d %5$ 15d %6$ 15d %7$ 15d %8$ 15d", name, manufacture, this.getPosition(),
                heading, speed, weight, enginePowerDraw, batteryCapacity);
    }

    public String toString() {
        return ("Robot[Name=" + name
                + ", Manufacturer=" + manufacture
                + ",Position=(" + this.getPosition()
                + "),Heading=" + heading
                + "/degree,Speed=" + speed
                + ", Weight=" + weight
                + "/Kg, EnginePowerDraw=" + enginePowerDraw
                + "/mA, BatteryCapacity=" + batteryCapacity
                + "/mA-Hour]");
    }

//assignment2a  	• Add a  “ moveTo ”  method that moves your robot and prints the cell boundary transitions
    public void moveTo() {
        double i;
        double j;
        double distance;
        distance = 1.0 * enginePowerDraw / batteryCapacity * speed;
        double radians = Math.toRadians(heading);
        i = position.X + distance * Math.cos(radians);
        j = position.Y + distance * Math.sin(radians);

        System.out.println();
        System.out.println("the largest distance it can go is " + distance);
        System.out.println("the boundary point is (" + i + "," + j + ")");
    }

	public int getRobotID() {
		// TODO Auto-generated method stub
		return robotID;
	}

	public void setRobotID(int robotID) {
		this.robotID = robotID;
	}

}
