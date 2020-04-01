package edu.neu.csye6200.iofile;

import java.io.File;

public class FileTest {

	public FileTest() {
		// TODO Auto-generated constructor stub
		
	}
	public void run() {
		//File baseDir = new File("test");
		File baseDir = new File(".");
		if(!baseDir.exists())
			baseDir.mkdirs();
		System.out.println("BaseDir: " + baseDir.getAbsolutePath());
		listDir(baseDir);
	}
	public void listDir(File dirFile) {
		if (!dirFile.isDirectory()) return;
		System.out.println("Dir: " + dirFile.getAbsolutePath());
		
		//show dir date file contents
		for(File file : dirFile.listFiles()) {
			if (file.isDirectory()) continue;//skip found directories
			String fTxt = String.format("%1$32s %2$10d", 
					file.getName(), file.length());
			System.out.println(fTxt);
		}
		
		for (File file:dirFile.listFiles()) {
			if(file.isDirectory())
				listDir(file);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileTest fileTest = new FileTest();
		fileTest.run();
	}

}
