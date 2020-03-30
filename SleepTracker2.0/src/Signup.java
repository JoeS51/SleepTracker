import java.awt.EventQueue;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.mindrot.BCrypt;

public class Signup{
	
//	public static File f = new File ("c:/Users/s-sluisj/user.txt");
	private JFrame frame;
	private static JPasswordField passwordField_1;
	private static JTextField textField;
	private static String passWord = "";
	private static String hashed = "";
	private static String userName = "";
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args)  {
		//String hashed = BCrypt.hashpw(passWord, BCrypt.gensalt());
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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToSleep = new JLabel("Welcome To Sleep Tracker!");
		lblWelcomeToSleep.setBounds(12, 13, 347, 43);
		lblWelcomeToSleep.setText("Welcome To Sleep Tracker!");
		lblWelcomeToSleep.setForeground(Color.BLACK);
		lblWelcomeToSleep.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblWelcomeToSleep.setBackground(Color.ORANGE);
		frame.getContentPane().add(lblWelcomeToSleep);
		
		ImageIcon sleep_icon = new ImageIcon("moon.jpg");
		
		JLabel sleep;
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		panel.setBackground(Color.white);
		panel.setPreferredSize(new Dimension (200, 300));
		
		frame.getContentPane().add(panel);
		
		JLabel lblSignup = new JLabel("Sign Up");
		lblSignup.setBounds(12, 69, 56, 16);
		lblSignup.setBackground(Color.WHITE);
		frame.getContentPane().add(lblSignup);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(12, 145, 214, 22);
		frame.getContentPane().add(passwordField_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 127, 120, 16);
		lblPassword.setBackground(Color.WHITE);
		frame.getContentPane().add(lblPassword);
		
		
		//login button
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(129, 219, 97, 25);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login window = new Login();
							window.get().setVisible(true);
							frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		frame.getContentPane().add(btnLogin);
		
		textField = new JTextField();
		textField.setBounds(12, 92, 214, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		//sign up button
		JButton btnSignUpNow = new JButton(" Sign Up");
		btnSignUpNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName = textField.getText();
				passWord = passwordField_1.getText();
				hashed = BCrypt.hashpw(passWord, BCrypt.gensalt());
				try {
					write(userName, hashed);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//erase 
			}
		});
		btnSignUpNow.setBounds(32, 181, 174, 25);
		frame.getContentPane().add(btnSignUpNow);
		
		sleep = new JLabel("", new ImageIcon("src/panda.png"), SwingConstants.CENTER);
		sleep.setBounds(169, 35, 304, 209);
		frame.getContentPane().add(sleep);
		sleep.setHorizontalTextPosition(SwingConstants.LEFT);
		sleep.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		JLabel lblAlreadyAMember = new JLabel("Already a member?");
		lblAlreadyAMember.setBackground(Color.WHITE);
		lblAlreadyAMember.setBounds(12, 223, 132, 16);
		frame.getContentPane().add(lblAlreadyAMember);
		frame.setVisible(true);
	}
	
	//write into file
	public static void write(String u, String p) throws IOException {
		 	FileWriter fw = null;
	        BufferedWriter bw = null;
	        PrintWriter pw = null;
	        BufferedReader b;
	        try {
	        	b = new BufferedReader(new FileReader("src/users.txt"));
	        	String line = b.readLine();
	        	String temp;
	        	boolean al = false;
	        	//check every username in the file
	        	while(line!=null) {
	        		temp = line.substring(9+1,line.indexOf("Password: ")-1);
	        		if(temp.equals(u)) {
	        			al = true;
	        		}
	        		line = b.readLine();
	        	}
	            fw = new FileWriter("src/users.txt", true);
	            bw = new BufferedWriter(fw);
	            pw = new PrintWriter(bw);
	            //if found same username
	            if(al == true) {
	            	System.out.println("User with same username exists.");
	            }
	            //sequence to allow username
	            else if(!u.equals("")) {
	            	pw.print("Username: "+ u);
	            	pw.println(" Password: " +p);
	            	System.out.println("Data Successfully appended into file");
	            	textField.setText("");
					passwordField_1.setText("");
	            }
	            else {
	            	System.out.println("Nothing entered as username");
	            }
	            

	            
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
