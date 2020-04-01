package edu.neu.csye6200.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public FileWriterTest() {
		// TODO Auto-generated constructor stub
	}
	private void run() {
		
		String base = "/Users/zhangyinghua/eclipse-workspace/csye6200class/src/edu/neu/csye6200/io/";
		
		
		try {
			FileReader reader = new FileReader(base +"FileWriterTest.java");
			FileWriter writer = new FileWriter(base +"FWDuplicateX.txt");
			
			int inval = reader.read();
			while(inval >=0) {
				//loop around and read date;
				System.out.print(((char)inval));
				writer.write(((char)inval)+ "*");
				inval = reader.read();
			}
			
			reader.close();
			writer.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found�� " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOError caught was�� " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriterTest fwt = new FileWriterTest();
		fwt.run();
	}

}
