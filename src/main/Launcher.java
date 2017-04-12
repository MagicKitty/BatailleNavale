package main;

import javax.swing.JFrame;

import screen.GridScreen;

public class Launcher {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setTitle("Bataille Navale");
		window.setSize(500, 500);

		window.add(new GridScreen(10,10));

		window.setResizable(true);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
