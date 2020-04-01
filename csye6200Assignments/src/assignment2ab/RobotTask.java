package assignment2ab;

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
    private String taskName;
    private String objective;
    private Date startDate;
    private int assignedRobotID;
    private static int idCounter = 0;

    public RobotTask() throws ParseException {
        this.id = idCounter++;
        this.taskName = "TaskTest";
        this.objective = "ObjectiveTest";
        this.startDate = new SimpleDateFormat("yyyy-mm-dd").parse("2020-02-02");
        this.assignedRobotID = 123;
    }
    
    public RobotTask(String taskName, String objective, int robotID){
        this.taskName = taskName;
        this.objective = objective;
        this.assignedRobotID = robotID;
        this.startDate = new Date();
        this.id = this.idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getAssignedRobotID() {
        return assignedRobotID;
    }

    public void setAssignedRobotID(int assignedRobotID) {
        this.assignedRobotID = assignedRobotID;
    }
    

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        RobotTask.idCounter = idCounter;
    }


    public String toString() {
        return String.format("ID : %1$-4d TaskName: %2$-12s Objective: %3$-12s StartDate: %4$-12s AssignedRobotID: %5$-4d",
                getId(), getTaskName(), getObjective(), getStartDate(), this.getAssignedRobotID());
    }

}
