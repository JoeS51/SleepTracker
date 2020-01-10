import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Timer {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timer window = new Timer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Timer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setBounds(231, 91, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setBounds(49, 91, 97, 25);
		frame.getContentPane().add(btnStop);
	}

}
