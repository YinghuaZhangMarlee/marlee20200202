package edu.neu.csye6200.robot;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RobotSimulation {
	
	private RobotIO robotLog;
	private String path = "robot.txt";

	public RobotSimulation() {
		this.robotLog = new RobotIO();
		File fRobot = new File(this.path);
	}

	
	public void update(List<RobotTask> rsList) {
		Random r = new Random();
		RobotTest rtInstance = RobotTest.getInstance();
		for (RobotTask rTask : rsList) {
			int moveX = r.nextInt(10);
			int moveY = r.nextInt(10);

			Robot robot = rtInstance.robotList[rTask.getAssignedRobotID()];

			System.out.println(robot);
			System.out.println("now robot move x for: " + moveX + " move y for " + moveY);
			this.robotLog.saveStrToDisk(robot + "\n", this.path);
			this.robotLog.saveStrToDisk("now robot move x for: " + moveX + " move y for " + moveY + "\n", this.path);

			robot.setPosition(
					new Robot.Position(robot.getPosition().getX() + moveX, robot.getPosition().getY() + moveY));

			System.out.println(robot);
			this.robotLog.saveStrToDisk(robot + "\n", this.path);
		}
	}
	
	
}
