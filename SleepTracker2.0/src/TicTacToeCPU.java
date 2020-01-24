import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.concurrent.TimeUnit;

public class TicTacToeCPU {

	private static JFrame frame;
	private static String[][] a = new String[3][3];
	private static int O;
	private static int X;
	private static JButton btn1;
	private static JButton btn2;
	private static JButton btn3;
	private static JButton btn4;
	private static JButton btn5;
	private static JButton btn6;
	private static JButton btn7;
	private static JButton btn8;
	private static JButton btn9;
	private static double time;
	/**
	 * Launch the application.
	 */
	public JFrame get() {
		for(int i =0; i <3;i++) {
			for(int j = 0; j<3;j++) {
				a[i][j] = "";
			}
		}
		return frame;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				for(int i =0; i <3;i++) {
					for(int j = 0; j<3;j++) {
						a[i][j] = "";
					}
				}
				try {
					TicTacToeCPU window = new TicTacToeCPU();
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
	public TicTacToeCPU(double v) {
		this.time = v;
		initialize();
	}
	public TicTacToeCPU() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblPlayerTurn = new JLabel("Player Turn: ");
		lblPlayerTurn.setBounds(12, 25, 114, 16);
		frame.getContentPane().add(lblPlayerTurn);
		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setBounds(86, 25, 56, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		
			
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(117, 53, 66, 60);
		frame.getContentPane().add(btnNewButton);
		this.btn1 = btnNewButton;
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button.getText()!="") {
					System.out.println("choose a different spot");
				}
				else {
					if(lblNewLabel.getText().indexOf('1') != -1) {
						button.setText("X");
						a[0][1] = "X";
						if(isWon("X")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("X wins");
							X++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
						cpuTurn();
						if(isWon("O")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("O wins");
							O++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
					}
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button.setBounds(179, 53, 66, 60);
		frame.getContentPane().add(button);
		this.btn2 = button;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton.getText()!="") {
					System.out.println("choose a different spot");
				}
				else {
					if(lblNewLabel.getText().indexOf('1') != -1) {
						btnNewButton.setText("X");
						a[0][0] = "X";
						if(isWon("X")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("X wins");
							X++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
						cpuTurn();
						if(isWon("O")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("O wins");
							O++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
					}
				}
			}
		});
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button_1.getText()!="") {
					System.out.println("choose a different spot");
				}
				else {
					if(lblNewLabel.getText().indexOf('1') != -1) {
						button_1.setText("X");
						a[0][2] = "X";
						if(isWon("X")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("X wins");
							X++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
						cpuTurn();
						if(isWon("O")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("O wins");
							O++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
					}
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_1.setBounds(241, 53, 66, 60);
		frame.getContentPane().add(button_1);
		this.btn3 = button_1;
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button_2.getText()!="") {
					System.out.println("choose a different spot");
				}
				else {
					if(lblNewLabel.getText().indexOf('1') != -1) {
						button_2.setText("X");
						a[1][0] = "X";
						if(isWon("X")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("X wins");
							X++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
						cpuTurn();
						if(isWon("O")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("O wins");
							O++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
					}
				}
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_2.setBounds(117, 111, 66, 60);
		frame.getContentPane().add(button_2);
		this.btn4 = button_2;
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button_3.getText()!="") {
					System.out.println("choose a different spot");
				}
				else {
					if(lblNewLabel.getText().indexOf('1') != -1) {
						button_3.setText("X");
						a[1][1] = "X";
						if(isWon("X")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("X wins");
							X++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
						cpuTurn();
						if(isWon("O")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("O wins");
							O++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
					}
				}
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_3.setBounds(179, 111, 66, 60);
		frame.getContentPane().add(button_3);
		this.btn5 = button_3;
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button_4.getText()!="") {
					System.out.println("choose a different spot");
				}
				else {
					if(lblNewLabel.getText().indexOf('1') != -1) {
						button_4.setText("X");
						a[1][2] = "X";
						if(isWon("X")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("X wins");
							X++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
						cpuTurn();
						if(isWon("O")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("O wins");
							O++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
					}
				}
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_4.setBounds(241, 111, 66, 60);
		frame.getContentPane().add(button_4);
		this.btn6 = button_4;
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button_5.getText()!="") {
					System.out.println("choose a different spot");
				}
				else {
					if(lblNewLabel.getText().indexOf('1') != -1) {
						button_5.setText("X");
						a[2][0] = "X";
						if(isWon("X")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("X wins");
							X++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
						cpuTurn();
						if(isWon("O")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("O wins");
							O++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
					}
				}
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_5.setBounds(117, 168, 66, 60);
		frame.getContentPane().add(button_5);
		this.btn7 = button_5;
		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button_6.getText()!="") {
					System.out.println("choose a different spot");
				}
				else {
					if(lblNewLabel.getText().indexOf('1') != -1) {
						button_6.setText("X");
						a[2][1] = "X";
						if(isWon("X")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("X wins");
							X++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
						cpuTurn();
						if(isWon("O")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("O wins");
							O++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
					}
				}
			}
		});
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_6.setBounds(179, 168, 66, 60);
		frame.getContentPane().add(button_6);
		this.btn8 = button_6;
		JButton button_7 = new JButton("");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button_7.getText()!="") {
					System.out.println("choose a different spot");
				}
				else {
					if(lblNewLabel.getText().indexOf('1') != -1) {
						button_7.setText("X");
						a[2][2] = "X";
						if(isWon("X")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("X wins");
							X++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
						cpuTurn();
						if(isWon("O")) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("O wins");
							O++;
							stats();
							champion();
						}
						if(full()) {
							frame.dispose();
							TicTacToeCPU newUser = new TicTacToeCPU();
							newUser.get().setVisible(true);
							System.out.println("Its a tie");
							stats();
						}
					}
				}
			}
		});
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_7.setBounds(241, 168, 66, 60);
		frame.getContentPane().add(button_7);
		this.btn9 = button_7;
		JLabel lblTicTacToe = new JLabel("Tic Tac Toe vs CPU");
		lblTicTacToe.setBounds(154, 13, 144, 16);
		frame.getContentPane().add(lblTicTacToe);
		
//		JButton btnComputer = new JButton("1v1");
//		btnComputer.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				frame.dispose();
//				TicTacToe newUser = new TicTacToe();
//				newUser.get().setVisible(true);
//			}
//		});
//		btnComputer.setBounds(8, 54, 97, 25);
//		frame.getContentPane().add(btnComputer);		
	}
	public boolean isWon(String s) {
		boolean result = false;
		if(a[0][0].equals(s)) {
			if(a[0][1].equals(s)) {
				if(a[0][2].equals(s)) {
					result = true;
				}
			}
			if(a[1][1].equals(s)) {
				if(a[2][2].equals(s)) {
						result = true;
				}
			}
			if(a[1][0].equals(s)) {
				if(a[2][0].equals(s)) {
					result = true;
				}
			}
		}
		if(a[1][0].equals(s)){
			if(a[1][1].equals(s)) {
				if(a[1][2].equals(s)) {
					result = true;
				}
			}
		}
		if(a[2][0].equals(s)) {
			if(a[2][1].equals(s)) {
				if(a[2][2].equals(s)) {
					result = true;
				}
			}
			if(a[1][1].equals(s)) {
				if(a[0][2].equals(s)) {
					result = true;
				}
			}
		}
		if(a[0][1].equals(s)) {
			if(a[1][1].equals(s)) {
				if(a[2][1].equals(s)) {
					result = true;
				}
			}
		}
		if(a[0][2].equals(s)) {
			if(a[1][2].equals(s)) {
				if(a[2][2].equals(s)) {
					result =  true;
				}
			}
		}
		if(result) {
			for(int i = 0; i< 3;i++) {
				for(int j = 0; j<3;j++) {
					a[i][j] = "";
				}
			}
			return true;
		}
		return false;
	}
	public static boolean full() {
		for(int i =0; i <3;i++) {
			for(int j = 0; j<3;j++) {
				if(a[i][j].equals("")) {
					return false;
				}
			}
		}
		for(int i = 0; i< 3;i++) {
			for(int j = 0; j<3;j++) {
				a[i][j] = "";
			}
		}
		return true;
	}
	public void stats() {
		System.out.println("");
		System.out.println("RECORD");
		System.out.println(" X | O");
		System.out.println(" "+X+" | "+ O);
		System.out.println("");
	}
	public static void cpuTurn() {
		int r = (int)(Math.random()*3);
		int c = (int)(Math.random()*3);
		while(a[r][c]!="") {
			r = (int)(Math.random()*3);
			c = (int)(Math.random()*3);
		}
		if(r == 0 && c == 0) {
			btn1.setText("O");
			a[0][0] = "O";
		}
		else if(r == 0 && c == 1) {
			btn2.setText("O");
			a[0][1] = "O";
		}
		else if(r == 0 && c == 2) {
			btn3.setText("O");
			a[0][2] = "O";
		}
		else if(r == 1 && c == 0) {
			btn4.setText("O");
			a[1][0] = "O";
		}
		else if(r == 1 && c == 1) {
			btn5.setText("O");
			a[1][1] = "O";
		}
		else if(r == 1 && c == 2) {
			btn6.setText("O");
			a[1][2] = "O";
		}
		else if(r == 2 && c == 0) {
			btn7.setText("O");
			a[2][0] = "O";
		}
		else if(r == 2 && c == 1) {
			btn8.setText("O");
			a[2][1] = "O";
		}
		else if(r == 2 && c == 2) {
			btn9.setText("O");
			a[2][2] = "O";
		}
	}
	public static boolean champion() {
		if(X >= 3) {
			X = 0;
			frame.dispose();
			System.out.println("You won! Good Job User!");
			Timerr back = new Timerr(time);
			back.get().setVisible(true);
			frame.dispose();
			return true;
		}
		if(O == 3) {
			O = 0;
			frame.dispose();
			Timerr back = new Timerr();
			back.get().setVisible(true);
			System.out.println("You lost. Try again");
			return true;
		}
		return false;
	}
}
