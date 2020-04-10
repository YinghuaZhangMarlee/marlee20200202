package edu.neu.csye6200.ui;



import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import edu.neu.csye6200.av.AVSimulation;

/**
 * A sample Autonomous Vehicle Abstract application class
 * @author MMUNSON
 *
 */
public abstract class AVApp implements ActionListener, WindowListener {
	protected JFrame frame = null;
	protected MenuManager menuMgr = null;

	/**
	 * The Autonomous Vehicle Abstract constructor
	 */
	public AVApp() {
		initGUI();
	}
	
	/**
	 * Initialize the Graphical User Interface
	 */
    public void initGUI() {
    	AVSimulation.getInstance();
    	frame = new JFrame();
		frame.setTitle("AVApp");

		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame.DISPOSE_ON_CLOSE)
		
		// Permit the app to hear about the window opening
		frame.addWindowListener(this); 
		
		menuMgr = new MenuManager(this);
		
		frame.setJMenuBar(menuMgr.getMenuBar()); // Add a menu bar to this application
		
		frame.setLayout(new BorderLayout());
		frame.add(getMainPanel(), BorderLayout.CENTER);
    }
    
    /**
     * Override this method to provide the main content panel.
     * @return a JPanel, which contains the main content of of your application
     */
    public abstract JPanel getMainPanel();

    
    /**
     * A convenience method that uses the Swing dispatch threat to show the UI.
     * This prevents concurrency problems during component initialization.
     */
    public void showUI() {
    	
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	frame.setVisible(true); // The UI is built, so display it;
            }
        });
    	
    }
    
    /**
     * Shut down the application
     */
    public void exit() {
    	frame.dispose();
    	System.exit(0);
    }
    
    public void maxmizedWindow() {
    	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public void undockWindow() {
    	frame.setExtendedState(JFrame.ICONIFIED);
    }

    /**
     * Override this method to show a About Dialog
     */
    public void showHelp() {
    	//public void actionPerformed(ActionEvent e) {// 实现ActionListener接口的actionPerformed接口。
            JDialog frame = new JDialog();//构造一个新的JFrame，作为新窗口。
            frame.setBounds(// 让新窗口与SwingTest窗口示例错开50像素。
                    new Rectangle(500,500,500,500)
                );
            JLabel jl = new JLabel();// 注意类名别写错了。
        
            frame.getContentPane().add(jl);
            jl.setText("<html><p>User Guidance:</p><p></p><p>1. There are 4 different rules for you to choose</p><p>*Turn Left and stop</p><p> *Turn right and stop</p><p>*Turn left and slow down</p><p>*Turn right and slow down</p><p></p><p>2.Press Start Button to process</p><p></p><p>3. Press Pause Button to pause all cars</p><p>* press again to let all cars continue to move</p><p></p><p>4. Press Stop Button to end process</p><p> </p><p>5. The location of cars and blocks will change randomly when process restart</p></html>");
            jl.setVerticalAlignment(JLabel.TOP);
            jl.setHorizontalAlignment(JLabel.CENTER);
            
         //APPLICATION_MODAL
            frame.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);    
            frame.setVisible(true);
        }
   
    }
	
