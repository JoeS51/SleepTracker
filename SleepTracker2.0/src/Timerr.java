import java.awt.Component;
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
	private int hoursRecord = 0;
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
		frame.setBounds(100, 100, 626, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel label = new JLabel("Click start to start timer", SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 34));
		label.setBounds(0, 13, 607, 84);
		frame.getContentPane().add(label);
		if(!won) {
			stop = System.currentTimeMillis();
			int seconds = (int)((stop - start)/1000)%60;
			int minutes = (int)((stop-start)/60000)%60;
			int hours = (int)((stop - start)/600000);
			label.setText("Hours: "+hours+" Minutes: "+minutes + " Seconds: "+seconds);
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
				hoursRecord = (int)((stop - start)/600000);
				label.setText("Hours: "+hoursRecord+" Minutes: "+minutes + "Seconds: "+seconds);
			}
		});
		
		btnStop.setBounds(349, 91, 97, 25);
		frame.getContentPane().add(btnStop);
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(label.getText() == "Started") {
					System.out.println("You already started the timer. Click the reset button to reset timer.");
				}
				else {
				start = System.currentTimeMillis();
				label.setText("Started");
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				JLabel timer;
				timer = new JLabel("", new ImageIcon("src/msg_loader.gif"), SwingConstants.CENTER);
				timer.setBounds(100, 100, 400, 500);
				frame.getContentPane().add(timer);
				timer.setHorizontalTextPosition(SwingConstants.LEFT);
				timer.setVerticalTextPosition(SwingConstants.BOTTOM);
				}
			}
		});
		btnNewButton.setBounds(161, 91, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start = 0;
				if(label.getText() == "Started" || label.getText().indexOf("Hours") != -1) {
					label.setText("Click start to start timer");
				}
			}
		});
		btnReset.setBounds(161, 193, 97, 25);
		frame.getContentPane().add(btnReset);
		
		JButton btnNextPage = new JButton("Next Page");
		btnNextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Record record = new Record(hoursRecord);
				record.get().setVisible(true);
				frame.dispose();
			}
		});
		btnNextPage.setBounds(349, 193, 97, 25);
		frame.getContentPane().add(btnNextPage);

	}
}
