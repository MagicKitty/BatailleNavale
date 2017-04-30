package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button extends JButton {
	private static final long serialVersionUID = 1L;
	private GridBagConstraints g = new GridBagConstraints();

	public Button(String title, int a,int b,int c,int d, GridBagConstraints gbc, int e,int f) {
		super(title);
		
		setBackground(new Color(59, 89, 182));
		setForeground(Color.WHITE);
		setFocusPainted(false);
		setBorder(BorderFactory.createEmptyBorder(a,b,c,d));
		setFont(new Font("Tahoma", Font.BOLD, 12));
		
		gbc.gridx = e;
		gbc.gridy = f;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(5,5,5,5);
		this.g = gbc;
	}
	public GridBagConstraints getGBC() {
		return g;
	}
}
