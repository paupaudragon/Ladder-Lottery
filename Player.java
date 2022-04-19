package currentSource;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

public class Player {

//    private static StdDraw std = new StdDraw();

	int score = 0;
	List<GridPixel> path = new ArrayList<>();
	GridPixel currentPosition;
	Color color;
	
	/**
	 * Constructor to create a player using the user chosen starting
	 * position and a randomized color
	 * 
	 * @param position
	 * @param color
	 */
	public Player(GridPixel position, Color color) {
		currentPosition = position;
		this.color = color;
		this.path.add(position);
		System.out.println(currentPosition);
	}
	
}
