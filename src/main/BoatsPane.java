package main;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class BoatsPane extends JPanel {
	public BoatsPane(JPanel screen) {
		super();
		this.setLayout(null);
		this.setBackground(Color.ORANGE);
		ComponentMove listener = new ComponentMove(this);
        for(int i=0; i<10; i++) {
        	this.add(createComponent());
        }
        addMouseListener(listener);
        addMouseMotionListener(listener);
	}
	
	private JComponent createComponent() {
        JPanel component=new JPanel();
        component.setLocation((int)(Math.random()*100), (int)(Math.random()*100));
        component.setSize(50,50);
        component.setBackground(Color.DARK_GRAY);
        component.setEnabled(false); // les composants ne doivent pas intercepter la souris
        return component;
    }
}
