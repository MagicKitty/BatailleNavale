package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ButtonsPane extends JPanel implements ActionListener {
	public ButtonsPane(int a, String ... args) {
		super();
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setBackground(Color.ORANGE);
		for (int i = 0; i < a; i++) {
			Button but = new Button(args[i], 5, 5, 5, 5, gbc, i, 0);
			but.addActionListener(this);
			add(but, but.getGBC());
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		System.out.println(e.getSource().toString());
//		if (source == newGame) {
//			window.setStatus(GameStatus.PERIOD);
//		} else if (source == loadGame) {
//			System.out.println("newGame");
//			fc = new JFileChooser();
//			fc.addChoosableFileFilter(new Filter());
//			fc.setAcceptAllFileFilterUsed(false);
//			int returnVal = fc.showOpenDialog(NewLoadScreen.this);
//            if (returnVal == JFileChooser.APPROVE_OPTION) {
//                File file = fc.getSelectedFile();
//                System.out.println("Opening: "+file.getName() + System.lineSeparator());
//            } else {
//            	System.out.println("Open command cancelled by user"+ System.lineSeparator());
//            }
//		}
	}
}
