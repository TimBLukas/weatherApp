package swingFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DbAccess.InsertDataToDB;
import Objects.CommonConstants;
import swingPanels.JPanelMitBackground;

/**
 * a class to create a Frame where a new user can be created
 * 
 * @author TBL
 * @version 1.0
 */
public class RegistrierenFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField userName_Tf;
	static JPasswordField password_Pf;
	static JPasswordField confirmation_Pf;
	static JLabel login_Label;
	static JButton registrieren_Button;
	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new RegistrierenFrame();
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
	public RegistrierenFrame() {

		setTitle("Registrieren");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 386);
		
		try {
			contentPane = new JPanelMitBackground(CommonConstants.LOGINBACKGROUND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel headPanel = null;
		try {
			headPanel = new JPanelMitBackground(CommonConstants.LOGINBACKGROUND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contentPane.add(headPanel, BorderLayout.NORTH);
		
		JLabel titleLabel = new JLabel("Registrieren");
		titleLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		headPanel.add(titleLabel);
		
		JPanel mainPanel = null;
		try {
			mainPanel = new JPanelMitBackground(CommonConstants.LOGINBACKGROUND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contentPane.add(mainPanel, BorderLayout.CENTER);
		SpringLayout sl_mainPanel = new SpringLayout();
		mainPanel.setLayout(sl_mainPanel);
		
		userName_Tf = new JTextField();
		sl_mainPanel.putConstraint(SpringLayout.WEST, userName_Tf, 51, SpringLayout.WEST, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.EAST, userName_Tf, -90, SpringLayout.EAST, mainPanel);
		userName_Tf.setFont(new Font("Arial Black", Font.PLAIN, 12));
		mainPanel.add(userName_Tf);
		userName_Tf.setColumns(10);
		
		password_Pf = new JPasswordField();
		sl_mainPanel.putConstraint(SpringLayout.SOUTH, userName_Tf, -29, SpringLayout.NORTH, password_Pf);
		sl_mainPanel.putConstraint(SpringLayout.EAST, password_Pf, -90, SpringLayout.EAST, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.NORTH, password_Pf, 98, SpringLayout.NORTH, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.WEST, password_Pf, 51, SpringLayout.WEST, mainPanel);
		password_Pf.setFont(new Font("Arial Black", Font.PLAIN, 12));
		mainPanel.add(password_Pf);
		
		JPasswordField confirmation_Pf = new JPasswordField();
		sl_mainPanel.putConstraint(SpringLayout.WEST, confirmation_Pf, 51, SpringLayout.WEST, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.EAST, confirmation_Pf, 0, SpringLayout.EAST, userName_Tf);
		confirmation_Pf.setFont(new Font("Arial Black", Font.PLAIN, 12));
		mainPanel.add(confirmation_Pf);
		
		registrieren_Button = new JButton("Registrieren");
		sl_mainPanel.putConstraint(SpringLayout.EAST, registrieren_Button, -90, SpringLayout.EAST, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.SOUTH, confirmation_Pf, -27, SpringLayout.NORTH, registrieren_Button);
		sl_mainPanel.putConstraint(SpringLayout.NORTH, registrieren_Button, 206, SpringLayout.NORTH, mainPanel);
		registrieren_Button.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		registrieren_Button.addActionListener(e -> {
			
			String username;
			String password = "";
			String confirmationPw = "";

			if(!userName_Tf.getText().isEmpty() && password_Pf.getPassword() != null && confirmation_Pf.getPassword().length != 0) {
				
				username = userName_Tf.getText();
				
				for (char c : password_Pf.getPassword()) password += c;
				
				for (char c : confirmation_Pf.getPassword()) confirmationPw += c;
				
				if(password.equals(confirmationPw)) {
					
					try {
						
						InsertDataToDB.createUser(username, password);
						
					}catch (Exception exception) {
						
						System.out.println(exception.getMessage());
						
					}
					
				}else {
					
					password_Pf.setBorder(new LineBorder(Color.RED, 3));
					confirmation_Pf.setBorder(new LineBorder(Color.RED, 3));
					
				}
				
			} else {
				
				userName_Tf.setBorder(new LineBorder(Color.RED, 3));
				password_Pf.setBorder(new LineBorder(Color.RED, 3));
				confirmation_Pf.setBorder(new LineBorder(Color.RED, 3));
				
			}
						
			
			
			frame.dispose();
			frame = new LoginFrame();
			frame.setVisible(true);
			
		});
		
		mainPanel.add(registrieren_Button);
		
		login_Label = new JLabel("Bereits einen Account? Hier einloggen");
		sl_mainPanel.putConstraint(SpringLayout.SOUTH, login_Label, -10, SpringLayout.SOUTH, mainPanel);
		sl_mainPanel.putConstraint(SpringLayout.EAST, login_Label, -22, SpringLayout.EAST, mainPanel);
		login_Label.setFont(new Font("Arial Black", Font.PLAIN, 10));
		
		login_Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				frame = new LoginFrame();
				frame.setVisible(true);	
				
			}

			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				login_Label.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				login_Label.setForeground(Color.BLACK);
			}
		});
		
		mainPanel.add(login_Label);
		
		
	}

}
