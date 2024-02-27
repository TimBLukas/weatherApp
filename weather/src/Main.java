import java.awt.EventQueue;

import javax.swing.JFrame;

import swingFrames.LoginFrame;

public class Main {

	private static JFrame frame;
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new LoginFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

}
