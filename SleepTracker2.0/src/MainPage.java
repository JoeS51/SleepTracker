import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class MainPage {
	private String[] a = {"Don't drink caffeine before you go to bed", 
						  "Get at least 8 hours of sleep each night", 
						  "Make sure that your bed supports your back",
						  "Try not to look at screens before you go to bed",
						  "Reduce irregular naps as it can mess up your circadian rhythm",
						  "Try to sleep and wake up at consisten times",
						  "Exercise daily for better sleep",
						  "If you have trouble sleeping, get professional help",
						  };
	private JFrame frame;
	private static String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			//test
			public void run() {
				try {
					MainPage window = new MainPage(username);
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
	public MainPage(String username) {
		this.username = username;
		initialize();
	}
	public MainPage() {
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
		frame.setBounds(100, 100, 765, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHomePage = new JLabel("Welcome back, " + username, SwingConstants.CENTER);
		lblHomePage.setBounds(8, 42, 747, 50);
		lblHomePage.setFont(new Font("Tahoma", Font.PLAIN, 35));
		frame.getContentPane().add(lblHomePage);
		
		JLabel lblTips = new JLabel("Tip: " + a[(int) (Math.random()*5)] + ".", SwingConstants.CENTER);
		lblTips.setBounds(8, 382, 727, 41);
		lblTips.setFont(new Font("Tahoma", Font.PLAIN, 21));
		frame.getContentPane().add(lblTips);
		
		//back button (return to sign in/up)
		JButton btnNewButton = new JButton("<-");
		btnNewButton.setBounds(12, 13, 47, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login back = new Login();
				back.get();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		//weekly tracker button
		JButton btnWeeklyTracker = new JButton("Weekly Tracker");
		btnWeeklyTracker.setBounds(596, 425, 139, 25);
		btnWeeklyTracker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Days weekdays = null;
				try {
					weekdays = new Days(username);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				weekdays.get().setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnWeeklyTracker);
		
		JLabel sleep = new JLabel("", new ImageIcon("src/download (1).jpg"), SwingConstants.CENTER);
		sleep.setBounds(70, 60, 130, 120);
		frame.getContentPane().add(sleep);
		sleep.setHorizontalTextPosition(SwingConstants.LEFT);
		sleep.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setBounds(638, 13, 97, 25);
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Profile userProfile = new Profile(username);
				userProfile.get().setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnProfile);
	}
}
