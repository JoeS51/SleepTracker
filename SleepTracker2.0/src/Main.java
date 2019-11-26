import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		
		Login oldUser = new Login();
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
}
