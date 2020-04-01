/**
 * 
 */
package edu.neu.csye6200.timer;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author zhangyinghua
 *
 */
public class TimerDemo {

	private Timer timer;
	
	//Constructor
	public TimerDemo() {
		timer = new Timer();
		//task, delay 3seconds,period 1second
		timer.schedule(new RemindTask(), 3000L, 1000L);
	}
	
	//A repeatable Task
	class RemindTask extends TimerTask{

		private int counter =0;
		
		@Override
		public void run() {
			System.out.println("Timer alert"+ counter++);
			Toolkit.getDefaultToolkit().beep();//ring bell
			if (counter >5) timer.cancel();
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TimerDemo();
		System.out.println("we are done!");
		
	}

}
