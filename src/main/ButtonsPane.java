package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class ButtonsPane extends JPanel {
	public ButtonsPane() {
		super();
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setBackground(Color.ORANGE);
        Button but = new Button("Continuer", 5, 5, 5, 5, gbc,0,0);
        add(but,but.getGBC());
	}
}
