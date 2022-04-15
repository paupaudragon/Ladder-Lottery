package ladderLottery;

import java.awt.Color;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Point2D;

public class Player {
	int score = 0;// Each player starts with zero point.
	int coin = 0;// Each player starts with zero coin.
	Point2D oldPosition = null;
	Point2D position;
	Color color;

	/**
	 * Constructs a Plaayer by using position and color. We can assign coin and
	 * score explicitly to the play if it changes.
	 * 
	 * @param position cordinate position
	 * @param color    color if the player
	 */
	public Player(Point2D position, Color color) {
		this.position = position;
		this.color = color;
	}
	
	/**
	 * Checks is the chose positin is valid.
	 * @param current
	 * @param chosen
	 */
	public boolean checkLadder(Point2D newPosition) {
		if((position.y()-newPosition.y())>=0)
			return true;
		else return false;
	}
	/**
	 * Updates the player's position.
	 * 
	 * @param p a Point2D
	 * @return P a Point2D
	 */
	public Point2D DrawPlayer(Point2D newPosition) { // get a position from input and update player's position
		if(checkLadder(newPosition))
			oldPosition = position;
			position = newPosition;
		return position;
	}

	/**
	 * Updates player's path.
	 * @param current
	 * @param destination
	 * @return
	 */
	public Digraph DrawLadder(Point2D oldPosition, Point2D position) {
		if(oldPosition == null||position == null) {
			throw new NullPointerException();
		}
		return  null;
	} 
	
	public void CoinDrawLadder(Point2D win) {
		//TODO
	}
	
	
}
