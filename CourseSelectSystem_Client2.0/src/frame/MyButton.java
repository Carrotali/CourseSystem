package frame;

import java.awt.Color;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyButton extends JButton{
	public MyButton() {
		super();
		this.setBackground(new Color(199,0,133));
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setForeground(Color.WHITE);
	}
	
	public MyButton(String s) {
		super(s);
		this.setBackground(new Color(199,0,133));
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setForeground(Color.WHITE);
	}
}
