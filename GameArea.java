package ladderLottery;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class GameArea extends JFrame implements MouseListener {
	JLabel label;
	JLabel[] labels = new JLabel[100];
	int labelSize = 100;

	GameArea() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(null);
		for (int i = 0; i < 100; i++) {
			labels[i] = new JLabel();
			labels[i].setSize(1, 1);
			Border border = BorderFactory.createLineBorder(Color.gray, 5);
			labels[i].setBorder(border);
			labels[i].setBackground(Color.cyan);
			labels[i].setOpaque(true);
			labels[i].addMouseListener(this);
			this.add(labels[i]);

		}
		this.setLayout(new GridLayout(10, 10));
		this.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Invoked when a mouse nutton has been clicked(pressed and released) on a component.
		System.out.println("you clicked the mouse");
		
		// checkLadder()
		//place player on label
		// crossLadder()
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Ivoked when a mouse button has been pressed on a component.

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Invoked when a mouse button has been relaesed on a component.

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Invoked when a mouse enters a component.
		
		//change label color
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Invoked when a mouse exits a component.

	}

	public static void main(String[] args) {
		GameArea game = new GameArea();
	}
}
