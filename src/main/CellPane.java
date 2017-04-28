package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import screen.GridScreen;

public class CellPane extends JPanel {
	private GridScreen grid;
	private Color defaultBackground;
	private int row, col;
	private Image imageBoatFrontUp;

	public CellPane(int tailleBateau, GridScreen pGrid) {
		grid = pGrid;
		setStatus(0);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// defaultBackground = getBackground();
				setBackground(new Color(59, 89, 182));
				if (grid != null)
					grid.handleMouseOver(row, col);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(defaultBackground);
				if (grid != null)
					grid.handleMouseOut(row, col);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (grid != null)
					grid.handleClick(row, col);
			}
		});
	}

	public void setStatus(int n) {
		if (n == 0) {
			defaultBackground = new Color(100, 100, 100);
		} else if (n == 1) {
//			defaultBackground = new Color(0, 153, 204);
			try {
				imageBoatFrontUp = ImageIO.read(getClass().getResource("../images/front_horiz.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (n == 2) {
			defaultBackground = new Color(0, 204, 255);
		} else if (n == -1) {
			defaultBackground = new Color(200, 0, 0);
		}
		setBackground(defaultBackground);
	}

	public void setPosition(int r, int c) {
		row = r;
		col = c;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(30, 30);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imageBoatFrontUp != null) {
			Image front_up = imageBoatFrontUp.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
			g.drawImage(front_up, 0, 0, null);
		}
	}
}