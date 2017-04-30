package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controller.ButtonController;

public class ButtonsPane extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private ButtonController controller;
	
	public ButtonsPane(ButtonController controller, String ... args) {
		super();
		
		if(controller != null) {
			this.controller = controller;
		}
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setBackground(Color.ORANGE);
		for (int i = 0; i < args.length; i++) {
			Button but = new Button(args[i], 5, 5, 5, 5, gbc, i, 0);
			but.addActionListener(this);
			add(but, but.getGBC());
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(controller != null) {
			controller.handleButton(e.getSource());
		}
	}
}
