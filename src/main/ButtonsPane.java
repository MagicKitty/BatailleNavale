package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class ButtonsPane extends JPanel {
	public ButtonsPane(int a, String ... args) {
		super();
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setBackground(Color.ORANGE);
		for (int i = 0; i < a; i++) {
			Button but = new Button(args[i], 5, 5, 5, 5, gbc, i, 0);
			add(but, but.getGBC());
		}
	}
}
