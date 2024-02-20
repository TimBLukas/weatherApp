package swingPanels;

import java.awt.Font;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LocationPanel {

	private static final long serialVersionUID = 1L;
	
	public static JPanel locationPanel;
	
	public LocationPanel(String country, String city) 
	{
		locationPanel = generateLocationPanel(country, city);
	}
	
	
	private JPanel generateLocationPanel(String country, String city) {
		
		JPanel locationPanel = null;
		
		try {
			locationPanel = new JPanelMitBackground("! Path missing");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel weatherInformation_panel = new JPanel();
		
		JLabel locationName_label = new JLabel("New label");
		locationName_label.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		JLabel weatherImage_label = new JLabel("weatherImage");
		weatherImage_label.setFont(new Font("Arial", Font.PLAIN, 11));
		GroupLayout groupLayout = new GroupLayout(locationPanel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(273, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(weatherInformation_panel, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
							.addGap(74))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(locationName_label, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addGap(202))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(weatherImage_label)
					.addContainerGap(603, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(locationName_label)
					.addGap(63)
					.addComponent(weatherImage_label)
					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
					.addComponent(weatherInformation_panel, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addGap(75))
		);
		locationPanel.setLayout(groupLayout);
		
		
		return locationPanel;
		
	}
	
	
	

}
