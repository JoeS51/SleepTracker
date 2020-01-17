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
	private boolean won = true;
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
	public Timerr(double time) {
		this.start = time;
		won = false;
		initialize();
	}
	public Timerr() {
		initialize();
	}
	public JFrame get() {
		return frame;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel label = new JLabel("Click start to start timer");
		label.setBounds(145, 47, 236, 16);
		frame.getContentPane().add(label);
		if(!won) {
			stop = System.currentTimeMillis();
			int seconds = (int)((stop - start)/1000)%60;
			int minutes = (int)((stop-start)/60000)%60;
			int hours = (int)((stop - start)/600000);
			label.setText("Hours: "+hours+" Minutes: "+minutes + "Seconds: "+seconds);
		}
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TicTacToeCPU confirmAwake = new TicTacToeCPU(start);
				confirmAwake.get().setVisible(true);
				frame.dispose();
//				boolean running = true;
//				while(running) {
//					if(isAwake) {
//						running = false;
//					}
//				}
				stop = System.currentTimeMillis();
				int seconds = (int)((stop - start)/1000)%60;
				int minutes = (int)((stop-start)/60000)%60;
				int hours = (int)((stop - start)/600000);
				label.setText("Hours: "+hours+" Minutes: "+minutes + "Seconds: "+seconds);
			}
		});
		
		btnStop.setBounds(232, 91, 97, 25);
		frame.getContentPane().add(btnStop);
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(label.getText() == "Started") {
					System.out.println("You already started timer. Click the reset button to reset timer.");
				}
				else {
				start = System.currentTimeMillis();
				label.setText("Started");
				}
			}
		});
		btnNewButton.setBounds(86, 91, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start = 0;
				if(label.getText() == "Started") {
					label.setText("Click start to start timer");
				}
			}
		});
		btnReset.setBounds(161, 193, 97, 25);
		frame.getContentPane().add(btnReset);
		
		JButton btnNextPage = new JButton("Next Page");
		btnNextPage.setBounds(323, 193, 97, 25);
		frame.getContentPane().add(btnNextPage);

	}
}
