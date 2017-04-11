package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class GridScreen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GridScreen(int a,int b) {
		setLayout(new BorderLayout());
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < a; row++) {
            for (int col = 0; col < b; col++) {
                gbc.gridx = col;
                gbc.gridy = row;
                CellPane cellPane = new CellPane();
                Border border = null;
                if (row < a-1) {
                    if (col < b-1) {
                        border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                    }
                } else {
                    if (col < b-1) {
                        border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    }
                }
                cellPane.setBorder(border);
                add(cellPane, gbc);
            }
        }
        // METTRE SUR UN AUTRE JPANEL
        Button but = new Button("OK", 0, 0, 0, 0, gbc,a/2,b);
        add(but,but.getGBC());
    }
}
