package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPane extends JPanel {
	public ButtonsPane() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.ORANGE);
		this.setLayout(null);
		this.add(new JButton("hello"),BorderLayout.SOUTH);
	}
}
