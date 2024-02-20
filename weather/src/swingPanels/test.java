package swingPanels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import weatherInformation.weatherInformation;

import java.awt.Font;
import java.awt.Color;

public class test extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	public static void main(String []args) {
		
		Map<String, Object> weatherTest = weatherInformation.getWeatherInformation("DE","Bietigheim-Bissingen");
		
		System.out.println(weatherTest);
		
		for(String key : weatherTest.keySet()) {
			System.out.println(key + ": " + weatherTest.get(key));
		}
		
	}
	public test() {
		setForeground(Color.WHITE);
		
		JPanel weatherInformation_panel = new JPanel();
		weatherInformation_panel.setBackground(new Color(169, 169, 169));
		
		
		JLabel locationName_label = new JLabel("New label");
		locationName_label.setForeground(Color.WHITE);
		locationName_label.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		JLabel weatherImage_label = new JLabel("weatherImage");
		weatherImage_label.setForeground(Color.WHITE);
		weatherImage_label.setFont(new Font("Arial", Font.PLAIN, 11));
		
		GroupLayout groupLayout = new GroupLayout(this);
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
		setLayout(groupLayout);

	}
}
