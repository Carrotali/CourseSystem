package frame;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class MyPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = new ImageIcon("ะฃปี4.jpg").getImage();
		g.drawImage(img, 0, 0, 80, 80, 0, 0, img.getWidth(this),
				img.getHeight(this), this);
	}
}