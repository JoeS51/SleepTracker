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
import java.awt.event.ActionEvent;

public class Days {
	private JFrame frame;
	private JTable table;
	private JButton button;
	private int hours;
	private int column;
	private boolean input;
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
	public Days(String day, int hours) {
		System.out.println(day);
		this.hours = hours;
		input = true;
		this.column = number(day);
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 767, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Measurements", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"},
				{"Average hrs", null, null, null, null, null, null, null},
				{"Hrs for this week", null, null, null, null, null, null, null},
				{"Meet rec'd hours?", null, null, null, null, null, null, null},
				{"Total hrs this week", null, null, null, null, null, null, null},
			},
			new String[] {
				"Measurements", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(76);
		if(input) {
			table.setValueAt(hours, 1, column);
		}
		table.setRowHeight(43);
		table.setBounds(0, 82, 749, 215);
		frame.getContentPane().add(table);
		
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
		lblNewLabel.setBounds(0, 0, 747, 81);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnRecordTime = new JButton("Record Time");
		btnRecordTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Timerr record = new Timerr();
				record.get().setVisible(true);
				frame.dispose();
			}
		});
		lblNewLabel.setBounds(0, 0, 747, 81);
		frame.getContentPane().add(btnRecordTime);
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
}
