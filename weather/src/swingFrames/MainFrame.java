package swingFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Objects.CommonConstants;
import swingPanels.SearchPanel;
import swingPanels.LocationPanel;
import weatherInformation.weatherInformation;

/**
 * Main Frame of the application
 * here the user can select a city he wants to have weather data for
 * 
 * @authot TBL
 * @version 1.0
 */
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
		ImageIcon logo = new ImageIcon(CommonConstants.LOGINBACKGROUND);
		setIconImage(logo.getImage());
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
		
		JButton startPage_button = new JButton("Start Page");
		startPage_button.setBackground(Color.BLACK);
		startPage_button.setForeground(Color.WHITE);
		startPage_button.setFont(new Font("Arial Black", Font.PLAIN, 13));
		
		startPage_button.addActionListener(e -> {
			
			contentPane.remove(mainPanel_1);
				
			try {
				
				mainPanel_1 = new SearchPanel();
				
				/*
				 * ActionListener für den SearchButton, dieser ActionListener soll bewirken, dass das mainPanel von einem SearchPanel zu
				 * einem LocationPanel,  für die in der Suchzeile eingegeben Stadt in dem mit der ComboBox gewähtlen Land, konvertiert wird
				 * 
				 */
				
				((SearchPanel) mainPanel_1).getSearchButton().addActionListener(event -> {
					
					// auslesen des mit der ComboBox gewähteln Landes
					String country = null;
					
					if(mainPanel_1 instanceof SearchPanel && (String) ((SearchPanel) mainPanel_1).getCountrySelector().getSelectedItem() != null) {
						country = (String) ((SearchPanel) mainPanel_1).getCountrySelector().getSelectedItem();
					}
					
					// auslesen der in der Suchleiste eingegebenen Stadt
					String city = null;
					
					if (mainPanel_1 instanceof SearchPanel) city = ((SearchPanel) mainPanel_1).getsearchBar_TF().getText();
					
					
					// erstellen des LocationPanel für die ausgelesene Stadt im ausgelesenen Land
					// verwenden der Methode createLocationPanel
					JPanel locationPanel = null;
					if(country != null && city != null) {
						
						locationPanel = createLocationPanel(country, city);
			
					}else {
						JOptionPane.showMessageDialog(null, "Bitte geben sie ein Land und eine Stadt ein", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
					if(locationPanel != null) {
						
						// Entfernt das vorhandene SearchPanel aus dem ContentPane
					    contentPane.remove(mainPanel_1);
						
						mainPanel_1 = locationPanel;
						
						 // Fügt das neue Panel dem ContentPane hinzu
					    contentPane.add(mainPanel_1, BorderLayout.CENTER);
					    
						// Aktualisiert die Anzeige des ContentPane
					    contentPane.revalidate();
					    contentPane.repaint();
					    
					}else {
						JOptionPane.showMessageDialog(null, "Fehler beim Laden", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				});
				
			} catch (IOException ioException) {
				
				ioException.printStackTrace();
				
			}
				
			// Fügt das neue Panel dem ContentPane hinzu
			contentPane.add(mainPanel_1, BorderLayout.CENTER);
			    
			// Aktualisiert die Anzeige des ContentPane
			contentPane.revalidate();
			contentPane.repaint();
			
		});
		
		sidePanel.add(startPage_button);
		
		// erstellen der Komponenten für das SidePanel (Buttons für den Zugriff auf die Favoriten und um auf die Startseite zurückzukehren)
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
		
		/*
		 * ActionListener für den SearchButton, dieser ActionListener soll bewirken, dass das mainPanel von einem SearchPanel zu
		 * einem LocationPanel,  für die in der Suchzeile eingegeben Stadt in dem mit der ComboBox gewähtlen Land, konvertiert wird
		 * 
		 */
		
		((SearchPanel) mainPanel_1).getSearchButton().addActionListener(e -> {
			
			// auslesen des mit der ComboBox gewähteln Landes
			String country = null;
			
			if(mainPanel_1 instanceof SearchPanel && (String) ((SearchPanel) mainPanel_1).getCountrySelector().getSelectedItem() != null) {
				country = (String) ((SearchPanel) mainPanel_1).getCountrySelector().getSelectedItem();
			}
			
			// auslesen der in der Suchleiste eingegebenen Stadt
			String city = null;
			
			if (mainPanel_1 instanceof SearchPanel) city = ((SearchPanel) mainPanel_1).getsearchBar_TF().getText();
			
			// erstellen des LocationPanel für die ausgelesene Stadt im ausgelesenen Land
			// verwenden der Methode createLocationPanel
			JPanel locationPanel = null;
			if(country != null && city != null) {
				
				locationPanel = createLocationPanel(country, city);
	
			}else {
				JOptionPane.showMessageDialog(null, "Bitte geben sie ein Land und eine Stadt ein", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			if(locationPanel != null) {
				// Entfernt das vorhandene SearchPanel aus dem ContentPane
			    contentPane.remove(mainPanel_1);
				
				mainPanel_1 = locationPanel;
				
				 // Fügt das neue Panel dem ContentPane hinzu
			    contentPane.add(mainPanel_1, BorderLayout.CENTER);
			    
				// Aktualisiert die Anzeige des ContentPane
			    contentPane.revalidate();
			    contentPane.repaint();
			    
			}else {
				JOptionPane.showMessageDialog(null, "Fehler beim Laden", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
		});
		
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
	
	/**
	 * Methode um ein LocationPanel für eine Stadt in einem Land zu erstellen
	 * 
	 * @param country Land in dem die Stadt liegt, für die das Panel generiert werden soll
	 * @param city Stadt für die das LocationPanel erstellt werden soll
	 * @return die Rückgabe ist ein LocationPanel für die angegebene Stadt in dem angegebenen Land
	 * {@link #convertCountry(String)} Methode die verwendet wird um das Eingegeben Land zu konvertieren
	 */
	private JPanel createLocationPanel(String country, String city) {
		
		JPanel locationPanel = null;
				
		country = convertCountry(country);
		
		Map<String, Object> weatherData= weatherInformation.getWeatherInformation(country, city);
		
		locationPanel = LocationPanel.generateLocationPanel(country, city, weatherData);
		
		return locationPanel;
	}
	
	/**
	 * Methode um ein Land in die für die API URL benötigt Form zu konvertieren
	 * 
	 * @param country Name des Landes in der Ausgangsform
	 * @return Abkürzung des Landes in der korrekten Form für die API URL
	 */
	private String convertCountry(String country) {
		String result;
		
		Map<String, String> countryPairs = new HashMap<>();
		
		countryPairs.put("Deutschland", "DE");
		countryPairs.put("USA", "US");
		countryPairs.put("England", "GB");
		countryPairs.put("China", "CN");
		countryPairs.put("Japan", "JP");
		countryPairs.put("Indien", "IN");
		countryPairs.put("Spanien", "ES");
		countryPairs.put("Portugal", "PT");

		return countryPairs.get(country);

		
	}

}
