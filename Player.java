package tingting;

import java.awt.Color;
import java.awt.Point;

import currentSource.GameArea;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;


public class Player {
	private int score = 0;// Each player starts with zero point.
	private int coin = 0;// Each player starts with zero coin.
	private int bomb = 0;// Each player starts with zero bomb.
	private int pathLength = 0;//path default value is null;
	private String name;
	
	// need these value to construct a player
	private Color color;
	private static Point current;

	/**
	 * Constructs a Plaayer by using position and color. We can assign coin and
	 * score explicitly to the play if it changes.
	 * 
	 * @param position cordinate position
	 * @param color    color if the player
	 */
	public Player(Point start, Color color, String name) {
		this.current = start;
		this.color = color;
		this.name = name;
	}
	

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @return the pathLength
	 */
	public int getPathLength() {
		return pathLength;
	}

	/**
	 * @return the coin
	 */
	public int getCoin() {
		return coin;
	}

	/**
	 * @return the bomb
	 */
	public int getBomb() {
		return bomb;
	}

	/**
	 * @return the current
	 */
	public static Point getCurrent() {
		return current;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @param coin the coin to set
	 */
	public void setCoin(int coin) {
		this.coin = coin;
	}

	/**
	 * @param bomb the bomb to set
	 */
	public void setBomb(int bomb) {
		this.bomb = bomb;
	}

	/**
	 * @param algorithm1 the path to set
	 */
	public void setPathLength(int path) {
		this.pathLength = path;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @param current the current to set
	 */
	public static void setCurrent(Point currentPosition) {
		current = currentPosition;
	}


	@Override
	public String toString() {
		return "Player" + name;
	}
	
//	public static void selectStart() {
//		int i = 0;
//		while (true && i == 0) {
//			if (StdDraw.mousePressed()) {
//				Point p = new Point((int)StdDraw.mouseX(), (int) StdDraw.mouseY());
//				Point2D p2D = new Point2D(StdDraw.mouseX(), StdDraw.mouseY());
//				StdDraw.pause(200);
//				for(RectHV r: GameArea.playerPositions) {
//					if (r.contains(p2D)) {
//						StdDraw.setPenColor(StdDraw.BLACK);
//						StdDraw.filledRectangle(r.xmin() + 1.5, r.ymin() + 1.5, 1.5, 1.5);
//						StdDraw.show();
//						setCurrent(new Point((int)(r.xmin() + 1.5), (int)(r.ymin() + 1.5)));
////						currentX = (int)(r.xmin() + 1.5);
////						currentY = (int)(r.ymin() + 1.5);
////						StdOut.println(currentX + ", " + currentY);
//						//Player player = new Player(r.xmin() + 1.5, r.ymin() + 1.5);
//					}
//					StdOut.println("start position: " + getCurrent()); // test
//				}
//				StdDraw.pause(200);
//				i++;
//			}
//	}}
	
}
