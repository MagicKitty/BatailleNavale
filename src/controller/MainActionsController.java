package controller;

import javax.swing.JButton;

import main.GameStatus;
import main.GameWindow;

public class MainActionsController implements ButtonController {
	private GameWindow gamewindow;
	
	public MainActionsController(GameWindow gw) {
		gamewindow = gw;
	}

	@Override
	public void handleButton(Object s) {
		if(s instanceof JButton) {
			switch(((JButton) s).getText()) {
				case "Quitter": System.exit(-1); break;
				//case "Continue": gamewindow.setStatus(GameStatus.INGAME); break;
				case "Algorithme": gamewindow.setStatus(GameStatus.ALGORITHM); break;
				case "Sauvegarder": gamewindow.save(); break;
			}
		}
	}
}
