package screen;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import main.Button;

public class AlgorithmScreen extends JPanel {
	public AlgorithmScreen() {
		setBorder(BorderFactory.createTitledBorder("Algorithme"));
		setBackground(Color.ORANGE);
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		Button moderne = new Button("Aléatoire",10,18,10,18,gbc,0,0);
		Button renaissance = new Button("Croix",10,33,10,33,gbc,0,1);
	    
		add(moderne,moderne.getGBC());
		add(renaissance,renaissance.getGBC());
	}
}
