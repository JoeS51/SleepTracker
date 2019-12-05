import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JTextField;

public class Login extends Main{

	private JFrame frame;
	private JPasswordField passwordField_1;
	private JTextField textField;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setBounds(109, 80, 56, 16);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setBounds(109, 138, 56, 16);
		frame.getContentPane().add(lblPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(109, 156, 214, 22);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Signup newUser = new Signup();
				newUser.get().setVisible(true);
//				frame.setContentPane(newUser.get().getContentPane());
			}
		});
		btnSignUp.setBackground(Color.WHITE);
		btnSignUp.setBounds(323, 215, 97, 25);
		frame.getContentPane().add(btnSignUp);
		
		JFormattedTextField frmtdtxtfldSleepTracker = new JFormattedTextField();
		frmtdtxtfldSleepTracker.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frmtdtxtfldSleepTracker.setForeground(Color.WHITE);
		frmtdtxtfldSleepTracker.setBackground(Color.BLACK);
		frmtdtxtfldSleepTracker.setText("SLEEP TRACKER");
		frmtdtxtfldSleepTracker.setBounds(109, 24, 189, 43);
		frame.getContentPane().add(frmtdtxtfldSleepTracker);
		
		textField = new JTextField();
		textField.setBounds(109, 103, 214, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
