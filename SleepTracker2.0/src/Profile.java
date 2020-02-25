import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Profile {
	private boolean pressed = false;
	private JFrame frame;
	private String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile();
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
	public Profile() {
		this.username = "User";
		initialize();
	}
	public Profile(String username) {
		this.username = username;
		try {
			String comb = "Username: " + username;
			write(comb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		frame.setBounds(100, 50, 1500, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(650, 135, 97, 22);
		frame.getContentPane().add(formattedTextField);
		formattedTextField.setEditable(false);
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!pressed) {
					formattedTextField.setEditable(true);
					pressed = true;
					btnEditProfile.setText("Done");
					String bruh = formattedTextField.toString();
				}
				else {
					formattedTextField.setEditable(false);
					pressed = false;
					btnEditProfile.setText("Edit Profile");
				}
				
			}
		});
		btnEditProfile.setBounds(1358, 26, 97, 25);
		frame.getContentPane().add(btnEditProfile);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(652, 106, 56, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblUser = new JLabel(this.username + "'s Profile:");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblUser.setBounds(554, 0, 1000, 109);
		frame.getContentPane().add(lblUser);
		
		Forecast weather = new Forecast(0,0);
		String icon = weather.getDailyIcon();
		if(icon.equals("partly-cloudy-day")) {
			JLabel weatherIcon = new JLabel("", new ImageIcon("src/partly-sunny.png"), SwingConstants.CENTER);
			weatherIcon.setBounds(120, 60, 400, 300);
			frame.getContentPane().add(weatherIcon);
			weatherIcon.setHorizontalTextPosition(SwingConstants.LEFT);
			weatherIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		else if(icon.equals("clear-day")){
			JLabel weatherIcon = new JLabel("", new ImageIcon("src/sunny.png"), SwingConstants.CENTER);
			weatherIcon.setBounds(120, 60, 400, 300);
			frame.getContentPane().add(weatherIcon);
			weatherIcon.setHorizontalTextPosition(SwingConstants.LEFT);
			weatherIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		else if(icon.equals("clear-night")){
        	JLabel weatherIcon = new JLabel("", new ImageIcon("src/clear-night.png"), SwingConstants.CENTER);
			weatherIcon.setBounds(120, 60, 400, 300);
			frame.getContentPane().add(weatherIcon);
			weatherIcon.setHorizontalTextPosition(SwingConstants.LEFT);
			weatherIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		else if(icon.equals("rain")){
        	JLabel weatherIcon = new JLabel("", new ImageIcon("src/rain.png"), SwingConstants.CENTER);
			weatherIcon.setBounds(120, 60, 400, 300);
			frame.getContentPane().add(weatherIcon);
			weatherIcon.setHorizontalTextPosition(SwingConstants.LEFT);
			weatherIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		else if(icon.equals("snow")){
        	JLabel weatherIcon = new JLabel("", new ImageIcon("src/Snow.png"), SwingConstants.CENTER);
			weatherIcon.setBounds(120, 60, 400, 300);
			frame.getContentPane().add(weatherIcon);
			weatherIcon.setHorizontalTextPosition(SwingConstants.LEFT);
			weatherIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		else if(icon.equals("sleet")){
        	JLabel weatherIcon = new JLabel("", new ImageIcon("src/sleet.png"), SwingConstants.CENTER);
			weatherIcon.setBounds(120, 60, 400, 300);
			frame.getContentPane().add(weatherIcon);
			weatherIcon.setHorizontalTextPosition(SwingConstants.LEFT);
			weatherIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		else if(icon.equals("wind")){
        	JLabel weatherIcon = new JLabel("", new ImageIcon("src/windy.png"), SwingConstants.CENTER);
			weatherIcon.setBounds(120, 60, 400, 300);
			frame.getContentPane().add(weatherIcon);
			weatherIcon.setHorizontalTextPosition(SwingConstants.LEFT);
			weatherIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		else if(icon.equals("fog")){
        	JLabel weatherIcon = new JLabel("", new ImageIcon("src/cloudy.png"), SwingConstants.CENTER);
			weatherIcon.setBounds(120, 60, 400, 300);
			frame.getContentPane().add(weatherIcon);
			weatherIcon.setHorizontalTextPosition(SwingConstants.LEFT);
			weatherIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		else if(icon.equals("cloudy")){
        	JLabel weatherIcon = new JLabel("", new ImageIcon("src/cloudy.png"), SwingConstants.CENTER);
			weatherIcon.setBounds(120, 60, 400, 300);
			frame.getContentPane().add(weatherIcon);
			weatherIcon.setHorizontalTextPosition(SwingConstants.LEFT);
			weatherIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		else if(icon.equals("partly-cloudy-night")){
        	JLabel weatherIcon = new JLabel("", new ImageIcon("src/night.png"), SwingConstants.CENTER);
			weatherIcon.setBounds(120, 60, 400, 300);
			frame.getContentPane().add(weatherIcon);
			weatherIcon.setHorizontalTextPosition(SwingConstants.LEFT);
			weatherIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		
	}
	public static void write(String u) throws IOException {
	 	FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        BufferedReader b;
        try {
        	b = new BufferedReader(new FileReader("src/userInformation.txt"));
            fw = new FileWriter("src/userInformation.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            String line = b.readLine();
        	String temp;
        	boolean al = false;
        	//check every username in the file
        	while(line!=null) {
        		temp = line.substring(0,line.length());
        		System.out.println(temp);
        		if(temp.equals(u)) {
        			al = true;
        		}
        		line = b.readLine();
        	}
            //sequence to allow username
        	System.out.println(al);
        	System.out.println(u);
            if(!u.equals("") && !al) {
            	pw.println(u);
            	System.out.println("Data Successfully appended into file");
            }
            else {
            	System.out.println("invalid");
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
