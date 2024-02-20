package swingFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import swingPanels.JPanelMitBackground;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 386);
		
		try {
			
			contentPane = new JPanelMitBackground("E:/Coding_Projects/WeatherApp/Images/LoginBackground.jpg");
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel MainPanel = null;
		
		try {
			
			MainPanel = new JPanelMitBackground("E:/Coding_Projects/WeatherApp/Images/LoginBackground.jpg");
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		
		contentPane.add(MainPanel, BorderLayout.CENTER);
		SpringLayout sl_MainPanel = new SpringLayout();
		MainPanel.setLayout(sl_MainPanel);
		
		JTextField username_Tf = new JTextField();
		sl_MainPanel.putConstraint(SpringLayout.WEST, username_Tf, 55, SpringLayout.WEST, MainPanel);
		sl_MainPanel.putConstraint(SpringLayout.SOUTH, username_Tf, -219, SpringLayout.SOUTH, MainPanel);
		sl_MainPanel.putConstraint(SpringLayout.EAST, username_Tf, -85, SpringLayout.EAST, MainPanel);
		username_Tf.setFont(new Font("Arial Black", Font.PLAIN, 12));
		MainPanel.add(username_Tf);
		username_Tf.setColumns(10);
		
		JButton registrieren_Button = new JButton("Registrieren");
		sl_MainPanel.putConstraint(SpringLayout.EAST, registrieren_Button, 0, SpringLayout.EAST, username_Tf);
		registrieren_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		registrieren_Button.setFont(new Font("Arial Black", Font.PLAIN, 12));
		MainPanel.add(registrieren_Button);
		
		JLabel registrieren_Label = new JLabel("Noch keinen Account? Hier registrieren!");
		sl_MainPanel.putConstraint(SpringLayout.WEST, registrieren_Label, 25, SpringLayout.WEST, MainPanel);
		sl_MainPanel.putConstraint(SpringLayout.SOUTH, registrieren_Label, -22, SpringLayout.SOUTH, MainPanel);
		registrieren_Label.setFont(new Font("Arial Black", Font.PLAIN, 10));
		MainPanel.add(registrieren_Label);
		
		JPasswordField password_Pf = new JPasswordField();
		sl_MainPanel.putConstraint(SpringLayout.NORTH, registrieren_Button, 39, SpringLayout.SOUTH, password_Pf);
		sl_MainPanel.putConstraint(SpringLayout.WEST, password_Pf, 0, SpringLayout.WEST, username_Tf);
		sl_MainPanel.putConstraint(SpringLayout.NORTH, password_Pf, 33, SpringLayout.SOUTH, username_Tf);
		sl_MainPanel.putConstraint(SpringLayout.EAST, password_Pf, 0, SpringLayout.EAST, username_Tf);
		password_Pf.setFont(new Font("Arial Black", Font.PLAIN, 12));
		MainPanel.add(password_Pf);
		
		JPanel headPanel = null;
		try {
			headPanel = new JPanelMitBackground("E:/Coding_Projects/WeatherApp/Images/LoginBackground.jpg");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		contentPane.add(headPanel, BorderLayout.NORTH);
		
		JLabel titleLabel = new JLabel("Login");
		titleLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		headPanel.add(titleLabel);
	}

}
