/**
 * 
 */
package edu.neu.csye6200.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Observer;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import edu.neu.csye6200.av.AVRule;
import edu.neu.csye6200.av.AVSimulation;
import edu.neu.csye6200.av.LeftMoveRule;
import edu.neu.csye6200.av.RightMoveRule;
import edu.neu.csye6200.av.Road;
import edu.neu.csye6200.av.TurnLeftDecreaseSpeedRule;
import edu.neu.csye6200.av.TurnRightDecreaseSpeedRule;


/**
 * @author mgmunson
 *
 */
public class MyAppUI extends AVApp implements ActionListener {

    private Logger log = Logger.getLogger(MyAppUI.class.getName());
	
	private MyPanel myPanel;
    protected JPanel mainPanel;
    protected JPanel northPanel;
    
	private JButton startBtn;
	private JButton pauseBtn;
	private JButton stopBtn;
	private JButton resetBtn;

	private JComboBox<Object> ruleComboBox;

	private Simulation sim = null;
	
	
	/**
	 * Constructor
	 */
	@SuppressWarnings("deprecation")
	public MyAppUI() {
		
		frame.setLocation(100, 80);
	 	frame.setSize(1600, 800);
		frame.setTitle("MyAutonomous Vehicle");
		
		menuMgr.createDefaultActions(); // Set up default menu items
		
		initSim(); // Initialize the sim

		showUI(); // Cause the Swing Dispatch thread to display the JFrame
		// make the subscription
		sim.addObserver(myPanel); // Allow the panel to hear about simulation events
		
	}
	
	/*
	 * Initialize the simulation
	 */
	private void initSim() {
		sim = new Simulation();
	}
	

   /**
    * Get the North panel - this includes buttons and a combo box	
    * @return the JPanel which contains the north panel
    */
	public JPanel getNorthPanel() {
		northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		
		//northPanel.setBackground(Color.BLUE); // Set the background blue
		
		JLabel ruleLbl = new JLabel("Rule:");
		ruleComboBox = new JComboBox<Object> ();
		ruleComboBox.addItem("");
		ruleComboBox.addItem(new LeftMoveRule("LeftMoveRule"));
		ruleComboBox.addItem(new RightMoveRule("RightMoveRule"));
		ruleComboBox.addItem(new TurnLeftDecreaseSpeedRule("TurnLefttDecreaseSpeedRule"));
		ruleComboBox.addItem(new TurnRightDecreaseSpeedRule("TurnRightDecreaseSpeedRule"));
		
		ruleComboBox.addActionListener(this);
		
		
		startBtn = new JButton("Start");
		//startBtn.addActionListener(this); // subscribe to button events
		
	    startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Start was pressed");
				sim.startSim();
				sim.setRunning(true); // force this on early, because we're about to reset the buttons
				resetButtons();
			}
	    	
	    });
		
	    pauseBtn = new JButton("Pause");
	    pauseBtn.setEnabled(false); // Disable until 'start' has been pressed
	    pauseBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pause was pressed");
				sim.pauseSim();
				resetButtons();
			}
			
		});
	    
		stopBtn = new JButton("Stop");
		stopBtn.setEnabled(false);  // Disable until 'start' has been pressed
		stopBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Stop was pressed");
				sim.stopSim();
				sim.setRunning(false); // Force this off early, because we're about to reset the buttons
				AVSimulation.getInstance().resetInstance();
				myPanel.autoUpdate();
				resetButtons();
			}
			
		});
		
		northPanel.add(ruleLbl);
		northPanel.add(ruleComboBox);
		
		northPanel.add(startBtn);
		northPanel.add(pauseBtn);
		northPanel.add(stopBtn);
		
		
		return northPanel;
	}
	
	private void resetButtons() {
		if (sim == null) return;
		
		ruleComboBox.setEnabled(!sim.isRunning());
		
		startBtn.setEnabled(!sim.isRunning());
		pauseBtn.setEnabled(sim.isPausable());
		stopBtn.setEnabled(sim.isRunning());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("We received an ActionEvent " + e);
		if (e.getSource() == ruleComboBox) {
			AVRule rule = (AVRule) ruleComboBox.getSelectedItem();
			this.sim.setRule(rule);
			System.out.println("ruleComboBox was pressed:" + rule);
		}

		if (e.getSource() == stopBtn) {
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

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {	
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {	
	}

	@Override
	public void windowActivated(WindowEvent e) {	
	}

	@Override
	public void windowDeactivated(WindowEvent e) {	
	}

	@Override
	public JPanel getMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
    	mainPanel.add(BorderLayout.NORTH, getNorthPanel());
    	
    	myPanel = new MyPanel();
    	mainPanel.add(BorderLayout.CENTER, myPanel);
		return mainPanel;
	}



}
