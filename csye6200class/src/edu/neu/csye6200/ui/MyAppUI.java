package edu.neu.csye6200.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyAppUI implements ActionListener {
	
	private Logger log = Logger.getLogger(MyAppUI.class.getName());
	
	private JFrame frame = null;
	private JPanel northPanel = null;
	private JButton startBtn = null;
	private JButton pauseBtn = null;
	private JButton stopBtn = null;
	private MyPanel myPanel = null;
	
	private Simulation sim= null;

	// Constructor
	public MyAppUI() {
		initSim();
		initGUI();
		//make the subscription
		sim.addObserver(myPanel);//Allow the panel to hear about the simulation  events
}
	private void initSim() {
		sim = new Simulation();
	}
	private void initGUI() {
		frame = new JFrame();
		frame.setSize(400, 300);
		frame.setTitle("MyAppUI");
		frame.setResizable(true); // Allow the frame to resize
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close box exits the app
		
		frame.setLayout(new BorderLayout());
		frame.add(getNorthPanel(), BorderLayout.NORTH);
		
		myPanel = new MyPanel();
		frame.add(myPanel, BorderLayout.CENTER);
		
		frame.setVisible(true);  // <-- We shouldn't really do this
	}
	
	public JPanel getNorthPanel() {
		northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		
		northPanel.setBackground(Color.RED); // Set the background red
		
		startBtn = new JButton("Start");//or"Begin"
		//startBtn.addActionListener(this);//subscribe to button events
		startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Start was pressed");
				sim.startSim();
			}
			
		});
		
		pauseBtn = new JButton("Pause");
		pauseBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pause was pressed");
				sim.pauseSim();
			}
			
			
		});
		
		stopBtn = new JButton("Stop");
		stopBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Stop was pressed");
				sim.stopSim();
			}
			
			
		});
		
		northPanel.add(startBtn);
		northPanel.add(pauseBtn);
		northPanel.add(stopBtn);
		
		
		return northPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("we received an ActionEvent"+e);
	//	if (e.getActionCommand().equalsIgnoreCase("Start"));
	//		System.out.println("Start was pressed");
		
		if (e.getSource()== stopBtn) {
			System.out.println("Stop was pressed");
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyAppUI myApp = new MyAppUI();
        System.out.println("MyAppUI is exiting !!!!!!!!!!");
	}


}