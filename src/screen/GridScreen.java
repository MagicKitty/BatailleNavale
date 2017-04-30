package screen;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import main.CellPane;

public class GridScreen extends JPanel {
	private static final long serialVersionUID = 1L;
	private LinkedList<CellPane> cells;
	
	public GridScreen(int a, int b, String title) {
		if(title != null) setBorder(BorderFactory.createTitledBorder(title));
		
		cells = new LinkedList<CellPane>();
		
		setBackground(Color.ORANGE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < a; row++) {
            for (int col = 0; col < b; col++) {
                gbc.gridx = col;
                gbc.gridy = row;
                
        		CellPane cellPane = new CellPane(1, this);
                cellPane.setBorder(new MatteBorder(1, 1, row < a-1 ? 0 : 1, col < b-1 ? 0 : 1, Color.GRAY));
                cellPane.setPosition(row,  col);
                cells.add(cellPane);
                add(cellPane, gbc);
            }
        }
    }
	
	public void handleMouseOver(int row, int col) {
		
	}
	
	public void handleMouseOut(int row, int col) {
			
	}
	
	public void handleClick(int row, int col) {
		
	}
	
	public void clearScreen() {
		for(CellPane c : cells) {
			c.setStatus(0);
		}
	}
	
	public void colorCell(int col, int row, int color) {
		for(CellPane c : cells) {
			if(c.getRow() == row && c.getCol() == col) {
				c.setStatus(color);
				break;
			}
		}
	}
}
