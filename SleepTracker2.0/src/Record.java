import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Record {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Record window = new Record();
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
	public Record() {
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRecord = new JButton("Record ");
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String day = textField.getText();
				Days user = new Days(day);
				user.get().setVisible(true);
				frame.dispose();
			}
		});
		btnRecord.setBounds(295, 215, 97, 25);
		frame.getContentPane().add(btnRecord);
		
		textField = new JTextField();
		textField.setBounds(123, 114, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDay = new JLabel("Day(Mon, Tues, Wed, Thurs, Fri, Sat, Sun)");
		lblDay.setBounds(124, 85, 252, 16);
		frame.getContentPane().add(lblDay);
		
		JLabel lblCongratulations = new JLabel("Congratulations, <Dynamic>");
		lblCongratulations.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCongratulations.setBounds(50, 13, 342, 32);
		frame.getContentPane().add(lblCongratulations);
	}
}
