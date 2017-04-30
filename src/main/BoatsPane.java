package main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.PlaceShipsController;

public class BoatsPane extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton carrier, cruiser, destroyer, submarine, battleship;
	private PlaceShipsController psc;
	
	public BoatsPane(PlaceShipsController controller) {
		super();
		
		psc = controller;
		
		this.setLayout(new FlowLayout());
		this.setBackground(Color.ORANGE);
		
		add(carrier = createButton("Porte avion"));
		add(cruiser = createButton("Croiseur"));
		add(battleship = createButton("Torpilleur"));
		add(destroyer = createButton("Contre-torpilleur"));
		add(submarine = createButton("Sous marin"));
		
		carrier.addActionListener(this);
		cruiser.addActionListener(this);
		battleship.addActionListener(this);
		destroyer.addActionListener(this);
		submarine.addActionListener(this);
	}

	private JButton createButton(String name) {
		JButton component = new JButton(name);
		try {
			Image img = ImageIO.read(getClass().getResource("../images/ship.bmp"));
			component.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		component.setSize(200, 80);
		component.setFocusPainted(false);
		component.setBackground(Color.DARK_GRAY);
		return component;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == carrier) {
			psc.chooseCarrier();
		} else if(e.getSource() == cruiser) {
			psc.chooseCruiser();
		} else if(e.getSource() == battleship) {
			psc.chooseBattleship();
		} else if(e.getSource() == destroyer) {
			psc.chooseDestroyer();
		} else if(e.getSource() == submarine) {
			psc.chooseSubmarine();
		}
	}
}
