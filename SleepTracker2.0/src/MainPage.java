import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.ArrayList;

public class MainPage {
	private String[] a = {"Don't drink caffeine before you go to bed", 
						  "Get at least 8 hours of sleep each night", 
						  "Make sure that your bed supports your back",
						  "Try not to look at screens before you go to bed",
						  "Reduce irregular naps as it can mess up your internal clock"};
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
		lblHomePage.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblHomePage.setBounds(0, 0, 747, 50);
		frame.getContentPane().add(lblHomePage);
		
		JLabel lblTips = new JLabel("Tip: ");
		lblTips.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblTips.setBounds(8, 331, 102, 80);
		frame.getContentPane().add(lblTips);
		String rand = a[(int) (Math.random()*5)];
		JLabel lblNull = new JLabel(rand);
		lblNull.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNull.setBounds(122, 302, 625, 155);
		frame.getContentPane().add(lblNull);
	}
}
