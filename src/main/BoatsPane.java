package main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoatsPane extends JPanel {
	public BoatsPane(JPanel screen) {
		super();
		this.setLayout(new FlowLayout());
		this.setBackground(Color.ORANGE);
		for (int i = 0; i < 5; i++) {
			this.add(createComponent(i));
		}
	}

	private JButton createComponent(int i) {
		JButton component = new JButton(""+i);
		try {
			Image img = ImageIO.read(getClass().getResource("../images/ship.bmp"));
			component.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		component.setSize(100, 80);
		component.setFocusPainted(false);
		component.setBackground(Color.DARK_GRAY);
		return component;
	}
}
