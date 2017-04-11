package main;

import javax.swing.JFrame;

public class Launcher {

	public static void main(String[] args) {
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Bataille Navale");
		fenetre.setSize(500, 500);

		fenetre.add(new GridScreen(10,10));

		fenetre.setResizable(true);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
}
