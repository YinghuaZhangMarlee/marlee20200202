package assignment1;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.util.Scanner;
/**
 * 
 * @author yinghuazhang
 * NUID:001375957
 *
 */
public class RobotTraversal {
	private int originRow;
	private int originCol;
	private int destRow;
	private int destCol;
	private ArrayList<Point> path1 = new ArrayList();
    private ArrayList<Point> path2 = new ArrayList();
	private ArrayList<String> robotRecord = new ArrayList();//moving path of the robot
	
	class Point {

        int col;
        int row;
        int cost;

        Point(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
	
	
	//start here
 	public static void main(String[] args) throws IOException{
		RobotTraversal robot= new RobotTraversal();
		robot.Start();
	}
 	public RobotTraversal() {
 		System.out.println("Robot Traversal Begin !");      
 	}
	public void Start() {
			boolean done = false;
			displayGameBoard();
    	
		      while(!done) {
		    		System.out.println("Please enter (input),(path),(move),(print)or(end) to take action");
            		Scanner sc0 = new Scanner(System.in); 
					String action = sc0.nextLine(); 
		
            			switch(action) {
            			case"input":{
            		   		inputTarget();
                    		displayPath();
                    		break;
            			}
            			case "path": {
            				displayPath();
            				break;
            			}
            			case "move": {
            				if (this.path1.size() == 0 && this.path2.size ()== 0) {
                                System.out.println("please input the destination first");
                                break;
                            };
                            moveRobot();
            				break;
            			}
            			case "end": {
            				System.out.println("we are quitting");
    						done = true;
    				        break;
    					}
            			case "print": {
                            this.printPoint();
                        }
                        default: {
                        	break;
                        }
            			}
            		}
	}	

	//display the displayGameBoard and start location
	void displayGameBoard(){
		char gameBoard[][]= {
				{'1','2','3','4','5','6','7','8'},
				{'8','1','2','3','4','5','6','7'},
				{'7','8','1','2','3','4','5','6'},
				{'6','7','8','1','2','3','4','5'},
				{'5','6','7','8','1','2','3','4'},
				{'4','5','6','7','8','1','2','3'},
				{'3','4','5','6','7','8','1','2'},
				{'2','3','4','5','6','7','8','1'},
		};
		
		gameBoard[this.destRow][this.destCol]='*';

		for (int row= 0; row<8; row++) {
			for (int column= 0; column<8; column++) {
				System.out.print(gameBoard[row][column]+" ");//keep on line				
			}
			System.out.println();//print a carriage return
		}
		  
	}

	//input target location
	void inputTarget() {		
			System.out.println("Please enter the row number of target location");
			Scanner sc1 = new Scanner(System.in); 
			this.destRow = sc1.nextInt();	
		
			System.out.println("Please enter the column number of target location");
			Scanner sc2 = new Scanner(System.in);
			this.destCol = sc2.nextInt();
			
			if (this.destRow>7 || this.destCol>7 || this.destRow<0 || this.destCol<0) {
				System.out.println("~Robot must move in the grid~");
			}else {
				displayGameBoard();
				System.out.println("You are going to (" + this.destRow + "," + this.destCol + ")");
			}
		}
	
	//show the path and cost
	void displayPath(){
		char gameBoard[][]= {
				{'1','2','3','4','5','6','7','8'},
				{'8','1','2','3','4','5','6','7'},
				{'7','8','1','2','3','4','5','6'},
				{'6','7','8','1','2','3','4','5'},
				{'5','6','7','8','1','2','3','4'},
				{'4','5','6','7','8','1','2','3'},
				{'3','4','5','6','7','8','1','2'},
				{'2','3','4','5','6','7','8','1'},
		};
		
		//path option 1
		System.out.println("the first road");
		if (this.originRow< this.destRow) { 
			int row, col;
			for(row= this.originRow; row< this.destRow; row++) {
				System.out.print(gameBoard[row][this.originCol]+ " ");
				this.path1.add(new Point(row, this.originCol, (int)gameBoard[row][this.originCol]-'0'));
			}
			if (this.originCol < this.destCol) {
				for(col = this.originCol; col< this.destCol;col++) {
					System.out.print(gameBoard[this.destRow][col]+ " ");
					this.path1.add(new Point(this.destRow, col, (int)gameBoard[this.destRow][col]-'0'));
				}
			}else {
				for(col = this.originCol; col> this.destCol;col--) {
					System.out.print(gameBoard[this.destRow][col]+ " ");
					this.path1.add(new Point(this.destRow, col, (int)gameBoard[this.destRow][col]-'0'));
				}
			}
			
		}else {
			int row, col;
			for(row= this.originRow; row> this.destRow; row--) {
				System.out.print(gameBoard[row][this.originCol]+ " ");
				this.path1.add(new Point(row, this.originCol, (int)gameBoard[row][this.originCol]-'0'));
			}
			if (this.originCol < this.destCol) {
				for(col = this.originCol; col< this.destCol;col++) {
					System.out.print(gameBoard[this.destRow][col]+ " ");
					this.path1.add(new Point(this.destRow, col, (int)gameBoard[this.destRow][col]-'0'));
				}
			}else {
				for(col = this.originCol; col> this.destCol;col--) {
					System.out.print(gameBoard[this.destRow][col]+ " ");
					this.path1.add(new Point(this.destRow, col, (int)gameBoard[this.destRow][col]-'0'));
				}
			}
		}System.out.println();
		
		//path option 2
		   System.out.println("the second road");
		if (this.originCol< this.destCol) { 
			int row, col;
			for(col= this.originCol; col< this.destCol; col++) {
				System.out.print(gameBoard[this.originRow][col]+ " ");
				this.path2.add(new Point(this.originRow, col, (int)gameBoard[this.originRow][col]-'0'));
			
			}
			if (this.originRow < this.destRow) {
				for(row = this.originRow; row< this.destRow;row++) {
					System.out.print(gameBoard[row][this.destCol]+ " ");
					this.path2.add(new Point(row, this.destCol, (int)gameBoard[row][this.destCol]-'0'));
				
				}
			}else {
				for(row = this.originRow; row> this.destRow;row--) {
					System.out.print(gameBoard[row][this.destCol]+ " ");
					this.path2.add(new Point(row, this.destCol, (int)gameBoard[row][this.destCol]-'0'));
				}
			}
			
		}else {
			int row, col;
			for(col= this.originCol; col> this.destCol; col--) {
				System.out.print(gameBoard[this.originRow][col]+ " ");
				this.path2.add(new Point(this.originRow, col, (int)gameBoard[this.originRow][col]-'0'));
			}
			if (this.originCol < this.destCol) {
				for(row = this.originRow; row< this.destRow;row++) {
					System.out.print(gameBoard[row][this.originCol]+ " ");
					this.path2.add(new Point(row, this.originCol, (int)gameBoard[row][this.originCol]-'0'));
				}
			}else {
				for(row = this.originRow; row> this.destRow;row--) {
					System.out.print(gameBoard[row][this.originCol]+ " ");
					this.path2.add(new Point(row, this.originCol, (int)gameBoard[row][this.originCol]-'0'));
				}
			}
		}System.out.println();
			
			}
	
	//select path option and cost
	private void  moveRobot(){
		originRow= destRow;
		originCol= destCol;
		
		System.out.println("Please select path(input 1 or 2)");
		
		System.out.println("now the robot moved: ");
		boolean choose = false;
		while (!choose) {
			Scanner scan = new Scanner(System.in);
			int selectPath = scan.nextInt();
			if ( selectPath == '\r') continue;//carriage return
			if ( selectPath == '\n') continue;//newline//
			
			  int sum = 0;
			  String record = "Now the path: ";
			  switch (selectPath) {
					
					case 1: 
			      
			        for (Point point : this.path1) {
			            sum += point.cost;
			            record += point.row + "," + point.col + "(" + point.cost + ")-> ";
			        }
			        break;

					case 2:
			        for (Point point : this.path2) {
			            sum += point.cost;
			            record += point.row + "," + point.col + "(" + point.cost + ")-> ";
			        }			
			        break;
			        
			        default:
			        	System.out.println("please choose 1 or 2 !");
			   
			}
			record += "target \nSum of Cost :" + sum;
	        System.out.println(record);
	        this.robotRecord.add(record);
	        choose= true;
	        
	        this.path1.clear();
	        this.path2.clear();
	        }
	}
	

      //Print history and cost of 3 last trips
        private void printPoint() {
            ArrayList<String> printList = new ArrayList(this.robotRecord);
            Collections.reverse(printList);
            for(int i=0; i<3 && i<printList.size(); i++){
                System.out.println("Path " + i + "->" + printList.get(i));
            }
        }
    }
