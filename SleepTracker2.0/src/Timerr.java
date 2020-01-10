import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Timerr {

	private JFrame frame;
	private double start;
	private double stop;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timerr window = new Timerr();
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
	public Timerr() {
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start = System.currentTimeMillis();
			}
		});
		btnNewButton.setBounds(86, 91, 97, 25);
		frame.getContentPane().add(btnNewButton);

		JLabel label = new JLabel("<Dynamic>");
		label.setBounds(145, 47, 236, 16);
		frame.getContentPane().add(label);
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop = System.currentTimeMillis();
				int hours = (int)(stop - start)/600;
				int minutes = (int)(((stop -start)/600)/60);
				label.setText("Hours: "+hours+"Minutes: "+minutes);
			}
		});
		btnStop.setBounds(232, 91, 97, 25);
		frame.getContentPane().add(btnStop);
		
	}

}
