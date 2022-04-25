package tingting;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import edu.princeton.cs.algs4.StdDraw;

/**
 * 
 * Keeps track of different variables as well as holds the code for the
 * Introduction Screen and the End Game Screen.
 * 
 * @author Sam
 * @author Maddie
 * @author Tingting
 * 
 */
public class GameConfig {

	public static int[][] grid = new int[31][24];
	static List<GridPixel> PointOnPole = new ArrayList<GridPixel>();
	static List<GridPixel> points = new ArrayList<GridPixel>();
	
	public static void main(String[] args) {
		StdDraw.setCanvasSize(1000, 800);
		StdDraw.pause(2000);

		IntroScreen();

		while (true) {
			if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
				GameArea.main(args);
			}
		}
	}

	/**
	 * Screen shown at the beginning explaining the game, how to play, and the rules
	 * of the game. Game starts when Enter is pressed.
	 */
	public static void IntroScreen() {

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(50, 50, 450, 455);

		// Sets up the scale and the starter window area
		StdDraw.setScale(0, 100);
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.filledRectangle(49, 63, 40, 31);
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.filledRectangle(49, 63, 39, 30);

		// Write the instructions and how to play
		Font title = new Font("Sans Serif", Font.BOLD, 50);
		Font subTitle = new Font("Sans Serif", Font.BOLD, 20);
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.setFont(title);
		StdDraw.text(49, 83, "Welcome to Ladder Lottery!");
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.setFont(subTitle);
		StdDraw.text(49, 79, "Game Description:");
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.setFont();
		StdDraw.text(49, 76,
				"This is a game of luck with a twist. The objective is for each player to reach the goal at the");
		StdDraw.text(49, 74,
				"bottom of the playing field while collecting coins along the way. Each player chooses a way");
		StdDraw.text(49, 72, "to traverse the graph.");

		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.setFont(subTitle);
		StdDraw.text(49, 69, "How To Play:");
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.setFont();
		StdDraw.text(49, 66,
				"Each player has a starting position randomly selected before they choose how to traverse");
		StdDraw.text(49, 64,
				"the ladders. There are a few ways graph traversals to choose from: BFS, DFS or DijkstraSP.");
		StdDraw.text(49, 62, "Bombs and coins are hidden along the path that will effect your score each round.");
		StdDraw.text(49, 60, "You earn points when you cross a path with a coin and lose points when you hit a bomb.");
		StdDraw.text(49, 58, "At the end of each round, the player with the smallest number of moves wins a point and");
		StdDraw.text(49, 56, "the player with the most coins collected wins a point. At the end of 3 rounds,");
		StdDraw.text(49, 54, "the player with the most points wins the game.");

		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.setFont(subTitle);
		StdDraw.text(49, 51, "Rules:");
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.setFont();
		StdDraw.text(49, 48, "1. Players take turns selecting an algorithm each round");
		StdDraw.text(49, 46, "2. Algorithm selections can be repeated");
		StdDraw.text(49, 44, "3. Scores will be calculated at the end of each round");
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.setFont(subTitle);
		StdDraw.text(49, 41, "Press Enter to play.");
		StdDraw.text(49, 38, "Have Fun!");

		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.setFont();
		StdDraw.text(49, 35, "Created by: Samantha Tilo, Tingting Zhou, Maddie Konnick");

		StdDraw.show();

	}

	/**
	 * Draws ladders on the game board connecting neighboring poles.
	 */
	public static void generateLadders() {
		StdDraw.setPenColor(StdDraw.RED);
		// 0
		StdDraw.line(86, 87, 92, 85);// 86-92
		StdDraw.line(86, 55, 92, 52);
		// 1
		StdDraw.line(80, 48, 86, 48);// 80-86
		StdDraw.line(80, 60, 86, 68);
		// 2
		StdDraw.line(74, 60, 80, 54);// 74-80
		StdDraw.line(74, 75, 80, 68);
		// 3
		StdDraw.line(68, 35, 74, 42);// 68-74
		StdDraw.line(68, 83, 74, 73);
		// 4
		StdDraw.line(62, 68, 68, 78);// 62-68
		StdDraw.line(62, 62, 68, 53);
		// 5
		StdDraw.line(56, 56, 62, 60);// 56-62
		// 6
		StdDraw.line(50, 75, 56, 80);// 50-56
		StdDraw.line(50, 50, 56, 41);
		// 7
		StdDraw.line(44, 38, 50, 38);// 44-50
		StdDraw.line(44, 61, 50, 65);
		// 8
		StdDraw.line(38, 48, 44, 54);// 38-44
		StdDraw.line(38, 38, 44, 34);
		// 9
		StdDraw.line(32, 70, 38, 70);// 32-38
		StdDraw.line(32, 81, 38, 84);
		// 10
		StdDraw.line(26, 60, 32, 52);// 26-32
		StdDraw.line(26, 63, 32, 71);
		// 11
		StdDraw.line(20, 70, 26, 78);// 20-26
		StdDraw.line(20, 35, 26, 31);
		// 12
		StdDraw.line(14, 65, 20, 65);// 14-26
		StdDraw.line(14, 45, 20, 50);
		// 13
		StdDraw.line(8, 33, 14, 40);// 8-14
		StdDraw.line(8, 80, 14, 80);

	}

	/**
	 * Draws the canvas board for the game.
	 */
	public static void drawGameArea() {
		// setup of window and parameters
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
					points.add(pixel);
				} else if ((r + 1) % 2 == 0 && c == 1) { // draw potential goal positions
					GridPixel pixel = new GridPixel(r, c, StdDraw.GREEN);
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
			}

			drawStatsBoard();
			GameConfig.generateLadders();

			StdDraw.show();
		}
	}

	/**
	 * Creates labels to track the active round and current player scores
	 */
	public static void drawStatsBoard() {
		// Player labels
		updatePlayerLabel(15, 18, "Player1 Score: ", GameArea.player1.getScore(), Color.CYAN);
		updatePlayerLabel(40, 18, "Player2 Score: ", GameArea.player2.getScore(), Color.YELLOW);

		// Round #
		updateRound(GameArea.round);

		// = = = Algorithm choices = = =

		// BFS
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.filledRectangle(29, 8, 5.5, 3.5);
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledRectangle(29, 8, 5, 3);
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.text(29, 8, "BFS");

		// DFS
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.filledRectangle(49, 8, 5.5, 3.5);
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledRectangle(49, 8, 5, 3);
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.text(49, 8, "DFS");

		// Dijkstra
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.filledRectangle(69, 8, 5.5, 3.5);
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledRectangle(69, 8, 5, 3);
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.text(69, 8, "Dijkstra");
	}

	/**
	 * Updates the round label in the window
	 * 
	 * @param round
	 */
	public static void updateRound(int round) {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(69, 18, 7.5, 3.5);
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledRectangle(69, 18, 7, 3);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(69, 18, "Round " + round);
	}

	/**
	 * 
	 * Updates the player label with their current score at the end of each round
	 * 
	 * @param x
	 * @param y
	 * @param str
	 * @param score
	 * @param color
	 */
	public static void updatePlayerLabel(int x, int y, String str, int score, Color color) {
		StdDraw.setPenColor(color);
		StdDraw.filledRectangle(x, y, 11.5, 3.5);
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledRectangle(x, y, 11, 3);
		StdDraw.setPenColor(color);
		StdDraw.text(x, y, str + score);
	}

	/**
	 * End of Game screen is shown after all the rounds have been played. It will
	 * display the first and second place players with the number of rounds won.
	 * 
	 * @param players
	 */
	public static void EndGameScreen(Player p1, Player p2) {
		StdDraw.setScale(0, 100);
		StdDraw.enableDoubleBuffering();

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(50, 50, 450, 455);

		// sets up the base window
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledRectangle(49, 63, 29, 23);
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.filledRectangle(49, 63, 28, 22);

		// fonts
		Font title = new Font("Sans Serif", Font.BOLD, 50);
		Font subTitle = new Font("Sans Serif", Font.BOLD, 30);

		// GameOver
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setFont(title);
		StdDraw.text(49, 89, "GAME OVER");

		if (p1.getScore() > p2.getScore()) {
			// First Player
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.setFont(title);
			StdDraw.text(49, 80, "First Place:");
			StdDraw.setPenColor(StdDraw.PINK);
			StdDraw.setFont(subTitle);
			if (p1.getScore() == 1)
				StdDraw.text(49, 74, "Player 1: " + p1.getScore() + " win");
			else
				StdDraw.text(49, 74, "Player 1: " + p1.getScore() + " wins");

			// Second Player
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.setFont(title);
			StdDraw.text(49, 59, "Second Place:");
			StdDraw.setPenColor(StdDraw.PINK);
			StdDraw.setFont(subTitle);
			if (p2.getScore() == 1)
				StdDraw.text(49, 53, "Player 2: " + p2.getScore() + " win");
			else
				StdDraw.text(49, 53, "Player 2: " + p2.getScore() + " wins");
		} else if (p1.getScore() < p2.getScore()) {
			// First Player
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.setFont(title);
			StdDraw.text(49, 80, "First Place:");
			StdDraw.setPenColor(StdDraw.PINK);
			StdDraw.setFont(subTitle);
			if (p2.getScore() == 1)
				StdDraw.text(49, 74, "Player 2: " + p2.getScore() + " win");
			else
				StdDraw.text(49, 74, "Player 2: " + p2.getScore() + " wins");

			// Second Player
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.setFont(title);
			StdDraw.text(49, 59, "Second Place:");
			StdDraw.setPenColor(StdDraw.PINK);
			StdDraw.setFont(subTitle);
			if (p1.getScore() == 1)
				StdDraw.text(49, 53, "Player 1: " + p1.getScore() + " win");
			else
				StdDraw.text(49, 53, "Player 1: " + p1.getScore() + " wins");
		} else {
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.setFont(title);
			StdDraw.text(49, 74, "It's a tie!");
			StdDraw.setPenColor(StdDraw.PINK);
			StdDraw.setFont(subTitle);
			StdDraw.text(49, 53, "Congrats to both players!");

		}

		StdDraw.show();
	}

}