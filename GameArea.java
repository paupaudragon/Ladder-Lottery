package currentSource;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Represents the game board, which holds player tokens, ladders, and the grids
 * each player traverses down.
 * 
 * @author Sam
 * @author Maddie
 * @author Tingting
 *
 */
public class GameArea {

	public static GridPixel goal;
	public static int[][] grid = new int[31][24];
//	private static double mouseX;
//	private static double mouseY;

	private static List<GridPixel> points = new ArrayList<GridPixel>();
	private static List<GridPixel> goalPositions = new ArrayList<GridPixel>();
	private static List<GridPixel> startPositions = new ArrayList<GridPixel>();
	/**********************************************************************************/
	private static List<GridPixel> PointOnPole = new ArrayList<GridPixel>();
	private static ST<Integer, GridPixel> vertices = new ST<>();

	/**********************************************************************************/
	// pole x-values 8, 14, 20, 26, 32, 38, 44, 50, 56, 62, 68, 74, 80,8 6, 92

	// 1 3 5 7 9 11 13 15 17 19 21 23 25 27 29

	public static void main(String[] args) {

		drawGameArea();
		
		drawGoal(goalPositions);
		
	}

	/**
	 * Generates a random starting point for player at the top of the ladder.
	 * 
	 * @return a gridPixel
	 */
	public static GridPixel generateStart() {

		int index = StdRandom.uniform(0, startPositions.size());
		GridPixel start = startPositions.get(index);
		return start;
	}

	/**
	 * Draws the canvas board for the game.
	 */
	public static void drawGameArea() {
		// setup of window and parameters
		StdDraw.setCanvasSize(1000, 800);
		StdDraw.setScale(0, 100);
		StdDraw.enableDoubleBuffering();
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(50, 50, 450, 455);
		
		Font subTitle = new Font("Sans Serif", Font.BOLD, 20);
		
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setFont(subTitle);
		StdDraw.text(49, 97, "Ladder Lottery");
		
		// grid
		for (int r = 0; r < grid.length; r++) {
			// draw grid system
			for (int c = 0; c < grid[0].length; c++) {
				if ((r + 1) % 2 == 0 && c == 22) { // draw potential starting positions
					GridPixel pixel = new GridPixel(r, c, StdDraw.MAGENTA);
					startPositions.add(pixel);
					points.add(pixel);
				} else if ((r + 1) % 2 == 0 && c == 1) { // draw potential goal positions
					GridPixel pixel = new GridPixel(r, c, StdDraw.GREEN);
					goalPositions.add(pixel);
					points.add(pixel);
				} else {
					GridPixel pixel = new GridPixel(r, c, StdDraw.DARK_GRAY);
					points.add(pixel);
					if ((r + 1) % 2 == 0) {
						PointOnPole.remove(pixel);
					}
				}
			}

			// draw starting poles
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.setPenRadius(.005);
			if ((r + 1) % 2 == 0) {
				StdDraw.line(r * 3 + 5, 91, r * 3 + 5, 30); // vertical pole
				// StdDraw.line(r*3 + 4, 91, r*3 + 6, 91); //horizontal starting position
			}

			//*********************** BUTTONS & LABELS ***************************
			
			//Player 1
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.filledRectangle(15, 18, 11.5, 3.5);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledRectangle(15, 18, 11, 3);
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.text(15, 18, "Player1 Score: " + "Score");
			
			//Player2
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.filledRectangle(40, 18, 11.5, 3.5);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledRectangle(40, 18, 11, 3);
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.text(40, 18, "Player2 Score: " + "Score");
			
			//Round #
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(69, 18, 7.5, 3.5);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledRectangle(69, 18, 7, 3);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(69, 18, "Round #");
			
			//Next Round
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledRectangle(89, 18, 7.5, 3.5);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledRectangle(89, 18, 7, 3);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(89, 18, "Next Round");
			
			//Algorithm choices
			
			//BFS
			StdDraw.setPenColor(StdDraw.PINK);	
			StdDraw.filledRectangle(29, 8, 5.5, 3.5);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledRectangle(29, 8, 5, 3);
			StdDraw.setPenColor(StdDraw.PINK);
			StdDraw.text(29, 8, "BFS");
			
			//DFS
			StdDraw.setPenColor(StdDraw.PINK);	
			StdDraw.filledRectangle(49, 8, 5.5, 3.5);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledRectangle(49, 8, 5, 3);
			StdDraw.setPenColor(StdDraw.PINK);
			StdDraw.text(49, 8, "DFS");
			
			//Dijkstra
			StdDraw.setPenColor(StdDraw.PINK);	
			StdDraw.filledRectangle(69, 8, 5.5, 3.5);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledRectangle(69, 8, 5, 3);
			StdDraw.setPenColor(StdDraw.PINK);
			StdDraw.text(69, 8, "Dijkstra");
			
			//*********************** BUTTONS & LABELS ***************************

			
			generateLadders();

			StdDraw.show();
		}
	}

	/**
	 * Selects a random index from goalPositions array and marks the goal in this
	 * pixel box
	 */
	public static GridPixel drawGoal(List<GridPixel> goalPositions) {
		int index = StdRandom.uniform(0, goalPositions.size());
		goal = goalPositions.get(index);

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(goal.getX(), goal.getY(), 1.5, 1.5);
		StdDraw.show();
		
		StdOut.println("goal position: " + goal);  //test
		return goal;
	}

	/**
	 * Draws ladders on the board connecting neighboring poles.
	 */
	public static void generateLadders() {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.line(8, 70, 14, 65); // test
		StdDraw.line(8, 45, 14, 50); // test
		StdDraw.line(8, 40, 14, 35); // test

		StdDraw.line(14, 84, 20, 79); // test
		StdDraw.line(14, 62, 20, 67); // test
		
		StdDraw.line(20, 46, 26, 51); // test
		StdDraw.line(20, 56, 26, 61); // test
		
		StdDraw.line(26, 67, 32, 72); // test
		StdDraw.line(26, 84, 32, 84); // test
		StdDraw.line(26, 39, 32, 44); // test
		
		StdDraw.line(32, 55, 38, 50); // test
		StdDraw.line(32, 78, 38, 72); // test
		
		StdDraw.line(38, 80, 44, 85); // test
		StdDraw.line(38, 65, 44, 59); // test
		
		StdDraw.line(44, 35, 50, 30); // test
		StdDraw.line(44, 80, 50, 75); // test
		StdDraw.line(44, 55, 50, 60); // test
		
		StdDraw.line(50, 79, 56, 84); // test
		StdDraw.line(50, 48, 56, 43); // test
		
		StdDraw.line(56, 65, 62, 60); // test
		StdDraw.line(56, 70, 62, 70); // test
		StdDraw.line(56, 32, 62, 37); // test
		
		StdDraw.line(62, 82, 68, 87); // test
		StdDraw.line(62, 42, 68, 50); // test
	
		StdDraw.line(68, 34, 74, 39); // test
		StdDraw.line(68, 70, 74, 75); // test
		
		StdDraw.line(74, 60, 80, 54); // test
		StdDraw.line(74, 48, 80, 43); // test
		
		StdDraw.line(80, 77, 86, 77); // test
		StdDraw.line(80, 45, 86, 50); // test
		StdDraw.line(80, 60, 86, 65); // test
		
		StdDraw.line(86, 86, 92, 81); // test
		StdDraw.line(86, 46, 92, 39); // test

		
		// Construct abstact graph.
//		Graph graph = new Graph(20);//there are always 20 vertices in the graph.
//		//Connect Points on the poles to the graph. 
//		//Starting point and gaolPoint into this graph. 
//		vertices.put(0,drawGoal());
//		vertices.put(1, generateStart());
//		//Put random points on the pole into symbol table. 
//		for(int i = 2;i< graph.V();i++) {
//			int index = StdRandom.uniform(0, PointOnPole.size());
//			vertices.put(i,PointOnPole.get(index));

		// find all vertices (x, y)
	}
	
	/**
	 * Moving the players down the ladders
	 * 
	 * @param activeRound
	 * @param totalRound
	 * @param Coin
	 * @param players
	 */
	public void PlayerMovement(int activeRound, int totalRound, boolean Coin/*, Player[] players*/) {
		// TODO
	}

}