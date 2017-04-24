package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import main.Button;
import main.CellPane;

public class GridScreen extends JPanel {
	public GridScreen(int a,int b) {
		setBorder(BorderFactory.createTitledBorder("Placer bateaux"));
		setBackground(Color.ORANGE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < a; row++) {
            for (int col = 0; col < b; col++) {
                gbc.gridx = col;
                gbc.gridy = row;
                CellPane cellPane = new CellPane();
                cellPane.setBorder(new MatteBorder(1, 1, row < a-1 ? 0 : 1, col < b-1 ? 0 : 1, Color.GRAY));
                add(cellPane, gbc);
            }
        }
        
        // METTRE SUR UN AUTRE JPANEL
        Button but = new Button("OK", 0, 0, 0, 0, gbc,a/2,b);
        add(but,but.getGBC());
    }
}
