package main;

import javax.swing.JFrame;

public class Launcher {

	public static void main(String[] args) {
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Bataille Navale");
		fenetre.setSize(400, 400);

		fenetre.add(new NewLoadChoix());

		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
}
