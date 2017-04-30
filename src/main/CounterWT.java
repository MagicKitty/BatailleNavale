package main;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CounterWT extends JPanel {
	private static final long serialVersionUID = 1L;
	{
        setOpaque(false);
    }
	public CounterWT(int a, int b) {
		super();
		setLayout(new BorderLayout());
		JLabel lab1 = new JLabel("Eau : "+a,JLabel.CENTER);
		add(lab1,BorderLayout.NORTH);
		JLabel lab2 = new JLabel("Touché : "+b,JLabel.CENTER);
		add(lab2,BorderLayout.CENTER);
	}
}
