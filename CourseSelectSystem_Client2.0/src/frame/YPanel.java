package frame;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class YPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = new ImageIcon("12(3).jpg").getImage();
		g.drawImage(img, 0, 0, 614, 400, 0, 0, img.getWidth(this),
				img.getHeight(this), this);
	}
}