import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel label = new JLabel("Click start to start timer");
		label.setFont(new Font("Tahoma", Font.PLAIN, 34));
		label.setBounds(195, 13, 439, 84);
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
				JLabel timer;
				timer = new JLabel("", new ImageIcon("src/msg_loader.gif"), SwingConstants.CENTER);
				timer.setBounds(200, 300, 500, 500);
				frame.getContentPane().add(timer);
				timer.setHorizontalTextPosition(SwingConstants.LEFT);
				timer.setVerticalTextPosition(SwingConstants.BOTTOM);
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
