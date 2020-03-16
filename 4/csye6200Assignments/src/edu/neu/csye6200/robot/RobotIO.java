package edu.neu.csye6200.robot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//This class will permit Robot information to be stored (and possibly retrieved) from disk
public class RobotIO {
	
	
	public void saveStrToDisk(String str, String path) {
        File fRobot = new File(path);
        if (!fRobot.exists()) {
            try {
            	fRobot.createNewFile();
            }
            catch (IOException e) {
            	e.printStackTrace();
            }
        }
               
        try {
            FileWriter writer = new FileWriter(fRobot, true);
            writer.write(str);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	

    public void Save(TransportRobot ts, File fRobot) {
        try {
            fRobot.createNewFile();
            FileWriter writer = new FileWriter(fRobot, true);
            writer.write(ts.toString() + "\n\n");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Save(ArrayList<TransportRobot> tsList, File fRobot) {
        try {
            fRobot.createNewFile();
            FileWriter writer = new FileWriter(fRobot, true);
            writer.write(" *Robot Name* " + " *Manufacturer* " + " *Position(X,Y)* " + " *Heading/degree* "
                    + " *Speed* " + " *Weight/Kg* " + " *EnginePowerDraw/mA* " + " *BatteryCapacity/mA-Hour* " + " *Height/mA* "
                    + " *Width/mA* " + " *Length/mA* " + " *Area/mA* " + "\n");
            for (TransportRobot ts : tsList) {
                writer.write(ts.toFormattedString() + "\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void load(String pathName) {
        try {
            FileReader fr = new FileReader(pathName);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            ArrayList<String> lineData = new ArrayList();
            while ((str = bf.readLine()) != null) {
                lineData.add(str);
            }
            bf.close();
            fr.close();

            System.out.println("RobotIO start loads:");
            ArrayList<Robot> robotList = new ArrayList();
            ArrayList<TransportRobot> tsList = new ArrayList();
            
            for (String line : lineData) {
                if (!line.contains(">>>")) {
                    continue;
                }
                String[] data = line.replaceAll(">", "").trim().split("\\s+");

                robotList.add(new Robot(data[0], data[1], data[2], Integer.parseInt(data[3]), 
                        Integer.parseInt(data[4]),Integer.parseInt(data[5]), Integer.parseInt(data[6]),Integer.parseInt(data[7])));
                tsList.add(new TransportRobot(data[0], data[1], data[2], Integer.parseInt(data[3]), 
                        Integer.parseInt(data[4]),Integer.parseInt(data[5]),
                        Integer.parseInt(data[6]),Integer.parseInt(data[7]), 
                        Integer.parseInt(data[8]), Integer.parseInt(data[9]), Integer.parseInt(data[10])));
            }
            
            System.out.println("load file to init Robot");
            System.out.println(String.format("%1$12s %2$15s %3$15s %4$15s %5$15s %6$15s %7$15s %8$15s ", " *Robot Name* "," *Manufacturer* " , " *Position(X,Y)* " , " *Heading/degree* "
                ," *Speed* ", " *Weight/Kg* ", " *EnginePowerDraw/mA* ", " *BatteryCapacity/mA-Hour* \n"));
            for(Robot robot : robotList){
                System.out.println(robot.toFormattedString());
            }

            System.out.println("\nload file to init TransportRobot");
            System.out.println(String.format("%1$12s %2$15s %3$15s %4$15s %5$15s %6$15s %7$15s %8$15s %9$15s %10$15s %11$15s ", " *Robot Name* "," *Manufacturer* " , " *Position(X,Y)* " , " *Heading/degree* "
                ," *Speed* ", " *Weight/Kg* ", " *EnginePowerDraw/mA* ", " *BatteryCapacity/mA-Hour* " , " *Height/mA* "
                ," *Width/mA* "," *Length/mA* "," *Area/mA* \n"));
            for(TransportRobot ts : tsList){
                System.out.println(ts.toFormattedString());
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

