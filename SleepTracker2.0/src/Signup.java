import java.awt.EventQueue;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Signup extends Main{
	
//	public static File f = new File ("c:/Users/s-sluisj/user.txt");
	private JFrame frame;
	private JPasswordField passwordField_1;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args)  {
		String user = "test test";
		try {
			write(user);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
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
	public Signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		Container random = new Container();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JFormattedTextField frmtdtxtfldWelcomeToSleep = new JFormattedTextField();
		frmtdtxtfldWelcomeToSleep.setBounds(28, 13, 347, 43);
		frmtdtxtfldWelcomeToSleep.setText("Welcome To Sleep Tracker");
		frmtdtxtfldWelcomeToSleep.setForeground(Color.WHITE);
		frmtdtxtfldWelcomeToSleep.setFont(new Font("Tahoma", Font.PLAIN, 28));
		frmtdtxtfldWelcomeToSleep.setBackground(Color.BLACK);
		frame.getContentPane().add(frmtdtxtfldWelcomeToSleep);
		
		JLabel lblSignup = new JLabel("Signup");
		lblSignup.setBounds(76, 69, 56, 16);
		lblSignup.setBackground(Color.WHITE);
		frame.getContentPane().add(lblSignup);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(76, 145, 214, 22);
		frame.getContentPane().add(passwordField_1);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(76, 127, 56, 16);
		label_1.setBackground(Color.WHITE);
		frame.getContentPane().add(label_1);
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(290, 204, 97, 25);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login window = new Login();
							window.get().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnLogin.setBackground(Color.WHITE);
		frame.getContentPane().add(btnLogin);
		
		textField = new JTextField();
		textField.setBounds(76, 92, 214, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	public static void write(String s) throws IOException {
		 FileWriter fw = null;
	        BufferedWriter bw = null;
	        PrintWriter pw = null;

	        try {
	            fw = new FileWriter("c:/Users/s-sluisj/user.txt", true);
	            bw = new BufferedWriter(fw);
	            pw = new PrintWriter(bw);

	            pw.println(s);
	            

	            System.out.println("Data Successfully appended into file");
	            pw.flush();

	        } finally {
	            try {
	                pw.close();
	                bw.close();
	                fw.close();
	            } catch (IOException io) {// can't do anything }
	            }

	        }
	}
}
