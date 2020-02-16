package Assignment2ab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * * assignment2ab * 
 */

public class RobotScheduler {
//* assignment2ab *  Add a private  ArrayList for holding  RTs , 
	private ArrayList<RobotTask> robotList= new ArrayList<RobotTask>();
	public RobotScheduler() {
	}
//* assignment2ab *  add public convenience methods that support adding, getting and removing  of RT instances.
	public void add(RobotTask rTask) {
		robotList.add(rTask);
	}
//	public void get(RobotTask rTask) {
//		int num= indexOf(RobotTask.getId);
//		robotList.get(num);
//	}
//	public void remove(RobotTask rTask) {
//		robotList.remove(rTask);
//	}

//* assignment2ab * Create a public method that loops through all  RTs and prints an attractive listing

	public void list() {
		for (RobotTask task: robotList) {
			System.out.println("Robot:"+task);
		}
	}
	
	
//* assignment2ab *  Add a private  HashMap that stores  RTs by Robot ID

	private HashMap<String,String> rtMap = new HashMap<String,String>();
	
	private void run() {//这里是不对的 
		rtMap.put("robot1", "This is Object 1");
		rtMap.put("robot2", "This is Object 2");
		rtMap.put("robot3", "This is Object 3");
		rtMap.put("robot4", "This is Object 4");
		rtMap.put("robot5", "This is Object 5");
		
	}
	
//* assignment2ab *  public method to allow retrieval by the  same ID .	
	public  void find() {
		
			boolean done = false;
			while(!done) {
				System.out.println("Please enter the Roblt ID to search!");
				Scanner sc0 = new Scanner(System.in); 
				String searching = sc0.nextLine(); 
		
            			switch(searching) {
            			case"robot1":{
            				if (rtMap.containsKey("robot1"))
            					System.out.println("we found robot1 "+ rtMap.get("robot1"));
                    		break;
            			}
            			case "robot2": {
            				if (rtMap.containsKey("robot2"))
            					System.out.println("we found robot2 "+ rtMap.get("robot2"));
                    		break;            			}
            			case "robot3": {
            				if (rtMap.containsKey("robot3"))
            					System.out.println("we found robot3 "+ rtMap.get("robot3"));
                    		break;                       
            			}
            			case "robot4": {
            				if (rtMap.containsKey("robot4"))
            					System.out.println("we found robot4 "+ rtMap.get("robot4"));
                    		break;
    					}
            			case "robot5": {
            				if (rtMap.containsKey("robot5"))
            					System.out.println("we found robot5 "+ rtMap.get("robot5"));
                    		break;
                        }
                        default: {
                        	System.out.println("the Roblt ID not in the List!");
                        	break;
            			}
            			}
            			
			}
	}	
		
	
	public static void main(String[] args) {
		

	}

}
