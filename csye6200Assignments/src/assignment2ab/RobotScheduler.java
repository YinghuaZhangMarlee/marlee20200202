package assignment2ab;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * * assignment2ab * 
 */
public class RobotScheduler {
//* assignment2ab *  Add a private  ArrayList for holding  RTs 
//* assignment2ab *  Add a private  HashMap that stores  RTs by Robot ID

    private ArrayList<RobotTask> robotList;
    private HashMap<Integer, RobotTask> robotMap;

    public RobotScheduler() {
        this.robotList = new ArrayList<RobotTask>();
        this.robotMap = new HashMap<Integer, RobotTask>();
    }
//* assignment2ab *  add public convenience methods that support adding, getting and removing  of RT instances.

    public void add(RobotTask rTask) {
        this.robotList.add(rTask);
        this.robotMap.put(rTask.getAssignedRobotID(), rTask);
    }

    	public RobotTask get(int taskID) {
            for(RobotTask rTask : this.robotList){
                if(rTask.getId() == taskID){
                    return rTask;
                }
            }
            return null;
        }


    	public void remove(int taskID) {
            int deleteIndex = -1;
            for (int i = 0; i < this.robotList.size(); i++) {
                if (this.robotList.get(i).getId() == taskID) {
                    deleteIndex = i;
                    break;
                }
            }
            if (deleteIndex != -1) {
                this.robotList.remove(deleteIndex);
            }else {
            	System.out.println("Please check the remove taskID !");
            }
            for (HashMap.Entry<Integer, RobotTask> entry : this.robotMap.entrySet()) {
                if (entry.getValue().getId() == taskID) {
                    this.robotMap.remove(entry.getKey());
                    return;
                }
            }
        }
 

//* assignment2ab * Create a public method that loops through all  RTs and prints an attractive listing

    	public void loopTask() {
            System.out.println("ArrayList :");
            for (RobotTask rTask : this.robotList) {
                System.out.println("Robot:" + rTask);
            }
            System.out.println(" HashMap:");
            System.out.println(this.robotMap);
        }

//* assignment2ab *  public method to allow retrieval by the  same ID .	
    public RobotTask find(int taskID) {
        for (RobotTask rTask : this.robotList){
            if (rTask.getId() == taskID){
                return rTask;
            }
        }
        System.out.println("RobotTask ID: " + taskID + " not find.");
        return null;
    }

//* assignment2ab *  public method to allow retrieval by the  same ID .	


    public static void main(String[] args) throws ParseException {
        run();
        runScheduler();
    }

//* assignment2ab * Move all test code and place it into a run() method. Call run() from main
    public static void run() {
    	RobotTest rInstance = RobotTest.getInstance();
        rInstance.PrintFormat();
        System.out.println();
        rInstance.PrintNormal();
        System.out.println();
        rInstance.PrintMoveto();
    }
    public static void runScheduler() throws ParseException {
    	RobotScheduler rScheduler = new RobotScheduler();
        RobotTest rInstance = RobotTest.getInstance();
        rScheduler.add(new RobotTask());
        rScheduler.add(new RobotTask("Task1", "test1", rInstance.robotList[1].getRobotID()));
        rScheduler.add(new RobotTask("Task2", "test2", rInstance.robotList[2].getRobotID()));
        rScheduler.add(new RobotTask("Task3", "test3", rInstance.robotList[3].getRobotID()));
        rScheduler.add(new RobotTask("Task4", "test4", rInstance.robotList[4].getRobotID()));
        rScheduler.add(new RobotTask("Task5", "test5", rInstance.robotList[5].getRobotID()));
        
        System.out.println("**************************   After adding, getting    *************************************************************");
        rScheduler.loopTask();
        
        System.out.println("**************************   After removing   *************************************************************");
        rScheduler.remove(5);
        rScheduler.loopTask();
        
        
    }
        
}

