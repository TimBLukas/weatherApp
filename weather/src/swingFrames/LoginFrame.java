package swingFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DbAccess.GetDataFromDB;
import Objects.CommonConstants;
import Objects.User;
import swingPanels.JPanelMitBackground;

/**
 * a class to create a frame to login as a user who has already been created
 * 
 * @author TBL
 * @version 1.0
 */
public class LoginFrame extends JFrame {

	/*
	 * Initializing all the variables that have to be accessed globally
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	static JPasswordField password_Pf;
	static JTextField username_Tf;
	static JLabel registrieren_Label;
	static JButton login_Button;
	private static JFrame frame;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	
	public LoginFrame() {
		
//		Set all the general designs for the frame
		setTitle("Login");
		ImageIcon logo = new ImageIcon(CommonConstants.LOGINBACKGROUND);
		setIconImage(logo.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 386);
		setResizable(false);
		
		
//		Initialize the contant Pane as a Panel with Background - Background Image Location defined in CommonConstants Class (Package: objects)
		try {
			
			contentPane = new JPanelMitBackground(CommonConstants.LOGINBACKGROUND);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
//		Initialize the MainPanel as a Panel with Background as well - Background Image Location defined in CommonConstants Class (Package: objects)
		JPanel MainPanel = null;
		
		try {
			
			MainPanel = new JPanelMitBackground(CommonConstants.LOGINBACKGROUND);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		contentPane.add(MainPanel, BorderLayout.CENTER);
		SpringLayout sl_MainPanel = new SpringLayout();
		MainPanel.setLayout(sl_MainPanel);
		
//		Textfield to enter the username when attempting to Log-in
		
		JTextField username_Tf = new JTextField();
		sl_MainPanel.putConstraint(SpringLayout.WEST, username_Tf, 55, SpringLayout.WEST, MainPanel);
		sl_MainPanel.putConstraint(SpringLayout.SOUTH, username_Tf, -219, SpringLayout.SOUTH, MainPanel);
		sl_MainPanel.putConstraint(SpringLayout.EAST, username_Tf, -85, SpringLayout.EAST, MainPanel);
		username_Tf.setFont(new Font("Arial Black", Font.PLAIN, 12));
		MainPanel.add(username_Tf);
		username_Tf.setColumns(10);
		
//		Button to execute the Log-In attempt
		
		login_Button = new JButton("Login");
		sl_MainPanel.putConstraint(SpringLayout.EAST, login_Button, 0, SpringLayout.EAST, username_Tf);
		login_Button.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		
		
		MainPanel.add(login_Button);
		
//		Label to switch to creating a new User
		
		registrieren_Label = new JLabel("Noch keinen Account? Hier registrieren!");
		sl_MainPanel.putConstraint(SpringLayout.WEST, registrieren_Label, 25, SpringLayout.WEST, MainPanel);
		sl_MainPanel.putConstraint(SpringLayout.SOUTH, registrieren_Label, -22, SpringLayout.SOUTH, MainPanel);
		registrieren_Label.setFont(new Font("Arial Black", Font.PLAIN, 10));
		
//		Giving the Label the ability to switch to the Registrieren Frame by using a MouseListener
		registrieren_Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				frame = new RegistrierenFrame();
				frame.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				registrieren_Label.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				registrieren_Label.setForeground(Color.BLACK);
			}
			
		});
			
		MainPanel.add(registrieren_Label);
		
//		Password Field to enter the password when attempting to Log-in
		
		JPasswordField password_Pf = new JPasswordField();
		sl_MainPanel.putConstraint(SpringLayout.NORTH, login_Button, 39, SpringLayout.SOUTH, password_Pf);
		sl_MainPanel.putConstraint(SpringLayout.WEST, password_Pf, 0, SpringLayout.WEST, username_Tf);
		sl_MainPanel.putConstraint(SpringLayout.NORTH, password_Pf, 33, SpringLayout.SOUTH, username_Tf);
		sl_MainPanel.putConstraint(SpringLayout.EAST, password_Pf, 0, SpringLayout.EAST, username_Tf);
		password_Pf.setFont(new Font("Arial Black", Font.PLAIN, 12));
		MainPanel.add(password_Pf);
		
		JPanel headPanel = null;
		try {
			headPanel = new JPanelMitBackground(CommonConstants.LOGINBACKGROUND);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		Give the Login Button the functionality to execute a Log-in
		
		login_Button.addActionListener(e -> {
			
			String password;
			String username;
			
//			check if all the necessary fields contain input
			
			if(password_Pf.getPassword().length != 0 && !username_Tf.getText().isEmpty()) {
				
//				get the Password Input and transpose the password array to a String
				password = "";
				for(char c : password_Pf.getPassword()) password += c;
				
//				get the username Input
				username = username_Tf.getText();
				
//				Get all Users from the Database with a fitting username
//				For this process the class GetDataFromDB is used
				
				List<User> usersWithCorrectUsername = GetDataFromDB.getUserByUsername(username);
				
//				check if one of the retrieved users has a matching password
				boolean userFound = false;
				for (User u : usersWithCorrectUsername) {
					if (u.getEncryptedPW().equals(password)) {
						
						userFound = true;
						
//						dispose the Frame and create a new mainFrame
						dispose();
						frame = new MainFrame();
						frame.setVisible(true);	
						
					}
				}
				
//				If no user is found mark the passwordField Border and the Username border red
//				This is to signalize that there has occurred an Error when attempting to match the username and the password
				
				if(!userFound) {
					
					password_Pf.setBorder(new LineBorder(Color.RED, 3));
					username_Tf.setBorder(new LineBorder(Color.RED, 3));
					
				}
				
//				If either the password Field or the username field does not contain anything mark them red to signalize they have to be filled out
				
			}else {
				
				password_Pf.setBorder(new LineBorder(Color.RED, 3));
				username_Tf.setBorder(new LineBorder(Color.RED, 3));
				
			}
		});
		
		contentPane.add(headPanel, BorderLayout.NORTH);
		
		JLabel titleLabel = new JLabel("Login");
		titleLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		headPanel.add(titleLabel);
	}

}
