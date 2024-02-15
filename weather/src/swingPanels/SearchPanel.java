package swingPanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import swingPanels.JPanelMitBackground;


public class SearchPanel {
	
	
	public static JPanel generateSearchPanel() {
		
		JPanel searchPanel = null;
		
		try {
			
			searchPanel = new JPanelMitBackground("C:/Studium/ProgrammierenProjekte/WeatherApp/Images/MainPanelBackground_MainFrame.jpg");
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		searchPanel.setLayout(gridBagLayout);
		
		JTextField searchBar_Tf = new JTextField();
		searchBar_Tf.setFont(new Font("Arial Black", Font.PLAIN, 12));
		GridBagConstraints gbc_searchBar_Tf = new GridBagConstraints();
		gbc_searchBar_Tf.gridwidth = 4;
		gbc_searchBar_Tf.insets = new Insets(0, 0, 5, 5);
		gbc_searchBar_Tf.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchBar_Tf.gridx = 4;
		gbc_searchBar_Tf.gridy = 3;
		searchPanel.add(searchBar_Tf, gbc_searchBar_Tf);
		searchBar_Tf.setColumns(10);
		
		JButton searchButton = new JButton("New button");
		searchButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		GridBagConstraints gbc_searchButton = new GridBagConstraints();
		gbc_searchButton.insets = new Insets(0, 0, 5, 5);
		gbc_searchButton.gridx = 9;
		gbc_searchButton.gridy = 3;
		searchPanel.add(searchButton, gbc_searchButton);
		
		JLabel subTitle_popularLoc_label = new JLabel("beliebte Standorte:");
		subTitle_popularLoc_label.setForeground(Color.white);
		subTitle_popularLoc_label.setFont(new Font("Arial Black", Font.PLAIN, 12));
		GridBagConstraints gbc_subTitle_popularLoc_label = new GridBagConstraints();
		gbc_subTitle_popularLoc_label.insets = new Insets(0, 0, 5, 5);
		gbc_subTitle_popularLoc_label.gridx = 5;
		gbc_subTitle_popularLoc_label.gridy = 6;
		searchPanel.add(subTitle_popularLoc_label, gbc_subTitle_popularLoc_label);
		
		JLabel LA_label = new JLabel("Los Angeles - USA");
		LA_label.setForeground(Color.white);
		LA_label.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_LA_label = new GridBagConstraints();
		gbc_LA_label.insets = new Insets(0, 0, 5, 5);
		gbc_LA_label.gridx = 5;
		gbc_LA_label.gridy = 7;
		searchPanel.add(LA_label, gbc_LA_label);
		
		JLabel london_label = new JLabel("London - UK");
		london_label.setForeground(Color.white);
		london_label.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_london_label = new GridBagConstraints();
		gbc_london_label.insets = new Insets(0, 0, 5, 5);
		gbc_london_label.gridx = 5;
		gbc_london_label.gridy = 8;
		searchPanel.add(london_label, gbc_london_label);
		
		JLabel stuttgart_label = new JLabel("Stuttgart - Germany");
		stuttgart_label.setForeground(Color.white);
		stuttgart_label.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_stuttgart_label = new GridBagConstraints();
		gbc_stuttgart_label.insets = new Insets(0, 0, 0, 5);
		gbc_stuttgart_label.gridx = 5;
		gbc_stuttgart_label.gridy = 9;
		searchPanel.add(stuttgart_label, gbc_stuttgart_label);
		
		
		
		return searchPanel;
	}
	

}