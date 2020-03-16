package edu.neu.csye6200.robot;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RobotScheduler {

	private static RobotScheduler rsInstance = new RobotScheduler();
	private ArrayList<RobotTask> rsList;
	private HashMap<Integer, RobotTask> rsMap;
	private RobotIO robotLog;
	private String path = "robot.txt";

	public RobotScheduler() {
		this.rsList = new ArrayList<RobotTask>();
		this.rsMap = new HashMap<Integer, RobotTask>();
		this.robotLog = new RobotIO();
		File fRobot = new File(this.path);
		if (fRobot.exists()) {
			fRobot.delete();
		}
	}

	public static RobotScheduler getInstance() {
		return rsInstance;
	}

	public void add(RobotTask rTask) {
		this.rsList.add(rTask);
		this.rsMap.put(rTask.getAssignedRobotID(), rTask);
	}

	public RobotTask get(int taskID) {
		return rsMap.get(taskID);
	}

	public void remove(int taskID) {
		for (RobotTask rTask : this.rsList) {
			if (rTask.getAssignedRobotID() == taskID) {
				this.rsList.remove(rTask);
				break;
			}
		}

		for (HashMap.Entry<Integer, RobotTask> entry : this.rsMap.entrySet()) {
			if (entry.getValue().getId() == taskID) {
				this.rsMap.remove(entry.getKey());
				break;
			}
		}
	}

	public RobotTask find(int taskID) {
		for (RobotTask rTask : this.rsList) {
			if (rTask.getId() == taskID) {
				return rTask;
			}
		}
		System.out.println("RobotTask ID: " + taskID + " not find.");
		return null;
	}

	// quick sort for assigned_robot_id
	public ArrayList<RobotTask> quickSortTask(int start, int end) {
		int mid = this.rsList.get(start).getAssignedRobotID();
		int i = start;
		int j = end;
		while (i < j) {
			while ((i < j) && (this.rsList.get(j).getAssignedRobotID() > mid)) {
				j--;
			}
			while ((i < j) && (this.rsList.get(i).getAssignedRobotID() < mid)) {
				i++;
			}
			if ((this.rsList.get(i).getAssignedRobotID() == this.rsList.get(j).getAssignedRobotID()) && (i < j)) {
				i++;
			} else {
				RobotTask temp = this.rsList.get(i);
				this.rsList.set(i, this.rsList.get(j));
				this.rsList.set(j, temp);
			}
		}

		if (i - 1 > start)
			this.rsList = quickSortTask(start, i - 1);
		if (j + 1 < end)
			this.rsList = quickSortTask(j + 1, end);

		return this.rsList;
	}

	public void loopTask() {
		System.out.println("ArrayList :");
		this.robotLog.saveStrToDisk("**************************   I am asterisk   *************************************************************\n", this.path);
		this.robotLog.saveStrToDisk("ArrayList :\n", this.path);
		for (RobotTask rTask : this.rsList) {
			System.out.println("Robot:" + rTask);
			this.robotLog.saveStrToDisk("Robot:" + rTask + "\n", this.path);
		}
	}


	public static void main(String[] args) throws ParseException {
		runScheduler();
	}

	
	public static void runScheduler() throws ParseException {
		RobotScheduler rsInstance = RobotScheduler.getInstance();
		rsInstance.add(new RobotTask());
		rsInstance.add(new RobotTask("Task5", "test5", 5));
		rsInstance.add(new RobotTask("Task6", "test6", 6));
		rsInstance.add(new RobotTask("Task7", "test7", 7));
		rsInstance.add(new RobotTask("Task8", "test8", 8));
		rsInstance.add(new RobotTask("Task9", "test9", 9));
		rsInstance.add(new RobotTask("Task1", "test1", 1));
		rsInstance.add(new RobotTask("Task2", "test2", 2));
		rsInstance.add(new RobotTask("Task3", "test3", 3));
		rsInstance.add(new RobotTask("Task4", "test4", 4));

		System.out.println(
				"**************************   After adding, getting    *************************************************************");

		rsInstance.loopTask();

		System.out.println(
				"**************************   After quick sort   *************************************************************");
		rsInstance.quickSortTask(0, rsInstance.rsList.size() - 1);
		rsInstance.loopTask();
		
		RobotSimulation rbSimulation = new RobotSimulation();
		rbSimulation.update(rsInstance.rsList);

	}

}
