package swingPanels;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelMitBackground extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private Image backgroundImage;

	// Some code to initialize the background image.
	// Here, we use the constructor to load the image. This
	// can vary depending on the use case of the panel.
	public JPanelMitBackground (String fileName) throws IOException {
		backgroundImage = ImageIO.read(new File(fileName));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	// Draw the background image.
		g.drawImage(backgroundImage, 0, 0, this);
		
	}
}
