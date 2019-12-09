import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends Main{

	private JFrame frame;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private String userName;
	private String passWord;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JFrame get() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	 public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new java.awt.Color(244,244,243));
		frame.getContentPane().setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon sleep_icon = new ImageIcon("download.jpg");
		
		JLabel sleep;
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		panel.setBackground(Color.white);
		panel.setPreferredSize(new Dimension (200, 300));
		
		frame.getContentPane().add(panel);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(12, 80, 56, 16);
		lblLogin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblLogin.setBackground(Color.WHITE);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 138, 214, 16);
		lblPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblPassword.setBackground(Color.WHITE);
		frame.getContentPane().add(lblPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(12, 156, 228, 22);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(12, 191, 97, 25);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Signup newUser = new Signup();
				newUser.get().setVisible(true);
//				frame.setContentPane(newUser.get().getContentPane());
			}
		});
		frame.getContentPane().add(btnSignUp);
		
		JFormattedTextField frmtdtxtfldSleepTracker = new JFormattedTextField();
		frmtdtxtfldSleepTracker.setBounds(12, 24, 200, 43);
		frmtdtxtfldSleepTracker.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldSleepTracker.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
		frmtdtxtfldSleepTracker.setForeground(Color.BLACK);
		frmtdtxtfldSleepTracker.setBackground(Color.ORANGE);
		frmtdtxtfldSleepTracker.setText("SLEEP TRACKER");
		frame.getContentPane().add(frmtdtxtfldSleepTracker);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(143, 191, 97, 25);
		frame.getContentPane().add(btnSignIn);
		
		textField = new JTextField();
		textField.setBounds(12, 103, 228, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		sleep = new JLabel("", new ImageIcon("C:\\Users\\s-sluisj\\Documents\\download.jpg"), SwingConstants.CENTER);
		sleep.setBounds(167, 0, 304, 209);
		frame.getContentPane().add(sleep);
		sleep.setHorizontalTextPosition(SwingConstants.LEFT);
		sleep.setVerticalTextPosition(SwingConstants.BOTTOM);
		frame.setVisible(true);
	}
}
