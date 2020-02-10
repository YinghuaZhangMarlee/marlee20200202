package Assignment2ab;
/*
 * * assignment2ab * 
 * 
 * Write a  RobotTask (RT)  class
 * Add an ID,  Task name, Objective, start date/time,  and  assigned Robot/ID.
 * 
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RobotTask {
	private int id;
	private static int idCounter=0;
	private String taskName="";
	private String objective="";
	private Date startDate;
	private String dateString= "2020-02-02";
	private String assignedRobotID;
	
	public RobotTask() throws ParseException {
		this.id= idCounter++;
		this.taskName="unknown";
		this.objective= "unknown";
		this.startDate= new SimpleDateFormat("yyyy-mm-dd").parse(dateString);
		this.assignedRobotID="-?-";
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public int getId() {
		return id;
	}

	public String getAssignedRobotID() {
		return assignedRobotID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	
	
	public String toString() {
	
		
		return String.format("ID : %1$-4d TaskName: %2$-12s Objective: %3$-12s StartDate: %4$-12s AssignedRobotID: %5$-4d",
				getId(),getTaskName(),getObjective(),getStartDate(),getAssignedRobotID());
		}
		
	}

