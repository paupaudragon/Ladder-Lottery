package tingting;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.princeton.cs.algs4.StdDraw;
/**
 * Represents a pixel unit on the game board to build grid
 * 
 * @author Sam
 * @author Maddie
 * @author Tingting
 *
 */
public class GridPixel {

	private int x;
	private int y;
	private Point point;
	private Color color;
//	public static GameAreaMouseListener actionHandler = new GameAreaMouseListener();

	public GridPixel (int r, int c, Color color) {
		x = r*3 + 5;
		y = c*3 + 25;
//		x= r;
//		y= c;
		this.color = color;
		point = new Point(x,y);
		
		StdDraw.setPenRadius(.002);
		StdDraw.setPenColor(color);
		StdDraw.filledSquare(x, y, 1.5);
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @return the y
	 */
	public Point getPoint() {
		return new Point(x,y);
	}
	
	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "[" + getX() + ", " + getY() + "]";
	}

	public void addActionListener(ActionListener actionListener) {
	}

}
