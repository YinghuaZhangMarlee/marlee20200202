package edu.neu.csye6200.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import edu.neu.csye6200.av.Road;
import edu.neu.csye6200.av.Vehicle;

@SuppressWarnings("deprecation")
public class MyPanel extends JPanel implements Observer {
	Image car1 = GameUtil.getImage("images/car1.jpg");
	Image car2 = GameUtil.getImage("images/car2.jpg");
	Image car3 = GameUtil.getImage("images/car3.jpg");
	
	Image b2 = GameUtil.getImage("images/b2.jpeg");
	Image b3 = GameUtil.getImage("images/b3.png");

	private static final long serialVersionUID = 2105533625224637015L;
	//private int counter = 0;
	private Simulation sim = null;
	private Color bgColor = Color.BLACK;

	// Don't call paint directly !! -> Use repaint() to trigger a redraw
	public void paint(Graphics g)  {
		Road road = Road.getInstance();
		Graphics2D g2d = (Graphics2D) g;
		
		Dimension size = getSize();
		
		Color c= g2d.getColor();
		Font f= g2d.getFont();
		
		g2d.setColor(bgColor); // get the assigned Background color
		g2d.fillRect(0, 0, size.width, size.height); // fill entire screen
		
		g2d.setColor(Color.WHITE); // white pen
		g2d.setFont(new Font("Times New Rome",Font.BOLD,30));
	
		g2d.drawString("Start " , 10, 40);
		g2d.drawString("Finish " , size.width-100, 40);
		
		g2d.setColor(Color.WHITE); // red pen
		g2d.fillRect(0, 80, size.width, 30);
		g2d.drawLine(0, 260, size.width, 260);
		g2d.drawLine(0, 440, size.width, 440);
		//g2d.drawLine(0, 560, size.width, 560);
		g2d.fillRect(0, 620, size.width, 30);
		
		//三辆车的初始位置
		g2d.drawImage(car1, road.getVehicleList().get(0).getLocation().getxPosition(), road.getVehicleList().get(0).getLocation().getyPosition(), 100, 100, null);
		g2d.drawImage(car2, road.getVehicleList().get(1).getLocation().getxPosition(), road.getVehicleList().get(1).getLocation().getyPosition(), 100, 100, null);
		g2d.drawImage(car3, road.getVehicleList().get(2).getLocation().getxPosition(), road.getVehicleList().get(2).getLocation().getyPosition(), 100, 100, null);
		//	路障位置
		g2d.drawImage(b2,800, 130, 100, 100, null);
		g2d.drawImage(b3, 1200, 300, 100, 100, null);
	//	g2d.drawImage(img, x, y, width, height, observer)
		
		g2d.setColor(c);
		g2d.setFont(f);
		
	}
	
//Update 改成车子的移动
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("MyPanel received an update");
		
		if (arg instanceof Simulation) {
			sim = (Simulation) arg;
			for(Vehicle vehicle: Road.getInstance().getVehicleList()) {
				vehicle.moveOneStep();
			}
			this.repaint(); // Notify that we need to paint the canvas
		}
		
	}
	
	
	
	
	
}
