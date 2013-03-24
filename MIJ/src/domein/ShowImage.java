package domein;

import java.awt.*;
import javax.swing.*;

// DIT IS EEN TEST FILE - DELETEN VOOR HET LEVEREN!
public class ShowImage extends JPanel {

	private static final long serialVersionUID = 1L;
	Image img;

	public ShowImage() {
		super();
		img = Toolkit.getDefaultToolkit().getImage("java_duke.png");
	}

	public void paintComponent(Graphics g) {
		// Teken image
		g.drawImage(img, 50, 10, 200, 200, this); // locatie (50, 10) en breedte x hoogte (200 x 200)
	}

	public static void main(String arg[]) {
		JFrame frame = new JFrame("ShowImage");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);

		ShowImage panel = new ShowImage();
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
}