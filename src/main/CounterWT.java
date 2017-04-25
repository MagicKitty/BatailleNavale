package main;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CounterWT extends JPanel {
	public CounterWT(int a, int b) {
		super();
		setLayout(new FlowLayout());
		JLabel lab1 = new JLabel("Eau : "+a, JLabel.CENTER);
		add(lab1);
		
		JLabel lab2 = new JLabel("Touché : "+b, JLabel.CENTER);
		add(lab2);
	}
}
