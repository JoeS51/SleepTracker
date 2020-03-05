import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class Days {
	private JFrame frame;
	private static JTable table;
	private JButton button;
	public static Object[][] info;
	private int hours;
	private int column;
	private boolean input;
	private String username;
	private boolean second;
	private static int sum;
	private int totalHours;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Days window = new Days();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Days() {
		input = false;
		initialize();
	}
	public Days(String username) throws NumberFormatException, IOException {
		input = false;
		second = false;
		this.username = username;
		write("Username: "+ username + ",5");
		this.totalHours = Integer.parseInt(recieveInformation(username, 11+username.length()));
		//this.totalHours = 100;
		initialize();
	}
	public Days(String day, int hours) {
		second = true;
		this.hours = hours;
		input = true;
		this.column = number(day);
		initialize();
	}
	private void initialize() {
		String[] header = {"Measurements", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", ""};
		String[] margin = {"Hours for this week", "Average hours", "Meets reccomended", "Total hours"};
		if(!second) {
			info = new Object[5][9];
		}
		for(int i=0; i< 8;i++) {
			info[0][i] = header[i];
			if(i>0&&i<5) {
			info[i][0] = margin[i-1];	
			}
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 1197, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(info, header));
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(76);
		table.setValueAt(this.totalHours, 4, 8);
		if(input) {
			sum+= hours;
			sum+=this.totalHours;
			info[1][column] = hours;
			table.setValueAt(hours, 1, column);
			if(hours>8) {
				table.setValueAt("yes", 3, column);
			}
			else {
				table.setValueAt("No", 3, column);
			}
			table.setValueAt(sum, 4, 8);
		}
		
//		JButton btnRecordTime = new JButton("Record Time");
//		btnRecordTime.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				Timerr record = new Timerr(username);
//				record.get().setVisible(true);
//				frame.dispose();
//			}
//		});
//		
		JButton btnRecord = new JButton("Record");
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Timerr time = new Timerr(username);
				time.get().setVisible(true);
				frame.dispose();
			}
		});
		btnRecord.setBounds(1043, 0, 97, 25);
		frame.getContentPane().add(btnRecord);
//		frame.getContentPane().add(btnRecordTime);
		
		button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage back = new MainPage();
				back.get().setVisible(true);
				frame.dispose();
			}
		});
		button.setBounds(0, 0, 56, 25);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("Your Stats for this Week:", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lblNewLabel.setBounds(0, 0, 1016, 81);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setBounds(0, 0, 1016, 81);
		table.setRowHeight(43);
		table.setBounds(0, 82, 1167, 233);
		frame.getContentPane().add(table);
	}	
	
	public JFrame get() {
		return frame;
	}
	public int number(String s) {
		if(s.equals("Mon")) {
			return 1;
		}
		else if(s.equals("Tues")){
			return 2;
		}
		else if(s.equals("Wed")){
			return 3;
		}
		else if(s.equals("Thurs")){
			return 4;
		}
		else if(s.equals("Fri")){
			return 5;
		}
		else if(s.equals("Sat")){
			return 6;
		}
		else if(s.equals("Sun")){
			return 7;
		}
		return -1;
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
	public String recieveInformation(String user, int indexStart) throws IOException {
		String userInfo = "";
		try {
			BufferedReader b = new BufferedReader(new FileReader("src/userInformation.txt"));
			String line = b.readLine();
			boolean found = false;
			while(!found) {
				if(line.indexOf(user) != -1) {
					found = true;
					userInfo = line.substring(indexStart, line.length());
				}
				line = b.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfo;
	}
}
