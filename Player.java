package tingting;

import java.awt.Color;
import java.awt.Point;

/**
 * Creates a Player object that tracks each player's current position, overall
 * score, path taken each round and color
 * 
 * @author Sam
 * @author Maddie
 * @author Tingting
 *
 */
public class Player {
	private int score = 0;// Each player starts with zero point.
	private Double coin = 0.0;// Each player starts with zero coin.
	private int pathLength = 0;// path default value is null;
	private String name;

	// need these value to construct a player
	private Color color;
	private static Point current;

	/**
	 * Constructs a Player by using position and color. We can assign coin and score
	 * explicitly to the play if it changes.
	 * 
	 * @param position coordinate position
	 * @param color    color if the player
	 */
	public Player(Color color, String name) {
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
	public Double getCoin() {
		return coin;
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
	 * @param double1 the coin to set
	 */
	public void setCoin(Double double1) {
		this.coin = double1;
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
}
