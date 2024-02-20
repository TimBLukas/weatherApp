package swingFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import swingPanels.SearchPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel mainPanel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {

		setTitle("Weather App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		setBackground(Color.black);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(sidePanel, BorderLayout.WEST);
		sidePanel.setLayout(new GridLayout(15, 1, 0, 5));
		sidePanel.setBackground(Color.black);
		
		JButton location1_button = new JButton("Location 1");
		location1_button.setBackground(Color.BLACK);
		location1_button.setForeground(Color.WHITE);
		location1_button.setFont(new Font("Arial Black", Font.PLAIN, 13));
		sidePanel.add(location1_button);
		
		JButton location2_button = new JButton("Location 2");
		location2_button.setBackground(Color.BLACK);
		location2_button.setForeground(Color.WHITE);
		location2_button.setFont(new Font("Arial Black", Font.PLAIN, 13));
		sidePanel.add(location2_button);
		
		JPanel headPanel = new JPanel();
		headPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(headPanel, BorderLayout.NORTH);
		headPanel.setBackground(Color.black);
		
		JLabel titleLabel = new JLabel("Weather App");
		titleLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		titleLabel.setForeground(Color.white);
		headPanel.add(titleLabel);
		
		try {
			mainPanel_1 = new SearchPanel();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		mainPanel_1.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(mainPanel_1, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_bottomPanel = new GridBagLayout();
		gbl_bottomPanel.columnWidths = new int[]{600, 150, 0};
		gbl_bottomPanel.rowHeights = new int[]{40, 0};
		gbl_bottomPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_bottomPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		bottomPanel.setLayout(gbl_bottomPanel);
		bottomPanel.setBackground(Color.black);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
		GridBagConstraints gbc_logoutButton = new GridBagConstraints();
		gbc_logoutButton.fill = GridBagConstraints.BOTH;
		gbc_logoutButton.gridx = 1;
		gbc_logoutButton.gridy = 0;
		bottomPanel.add(logoutButton, gbc_logoutButton);
		
		
	}
	
	private static JPanel createLocationPanel(String country, String city) {
		
		JPanel locationPanel = new JPanel();
		
		switch(country) {
			case "Deutschland":
				country = "DE";
				break;
			
		}
		
		return locationPanel;
	}

}
