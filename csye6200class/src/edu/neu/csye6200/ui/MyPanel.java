package edu.neu.csye6200.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements Observer {
	private int counter = 0;
	private Simulation sim= null;
	private Color bgColor = Color.BLUE;

	
	//Do not call paint directly !!->>Use repaint() to trigger a redraw
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		Dimension size = getSize();
		
		
		g2d.setColor(bgColor); // get the assigned Background color
		g2d.fillRect(0, 0, size.width, size.height); // fill entire screen
		
		g2d.setColor(Color.WHITE); // white pen
		g2d.drawString("Hello World 2D - " + counter++, 10, 20);
		
		g2d.setColor(Color.RED); // red pen
		g2d.drawLine(0, 0, size.width, size.height);
		
	}

	@Override
	public void update(Observable o, Object arg) {

		System.out.println("MyPanel received an update");
		
		if (arg instanceof Simulation) {
			sim= (Simulation) arg;
			
			int ctr = sim.getCtr();
			bgColor = ((ctr%2)==0 )? Color.BLUE : Color.CYAN;
			
			this.repaint();//notify that we need to paint the canvas
		}
	}
	
	
	
}