package tingting;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
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
	// initiate end and starting positions
	public static int endPoint;
	public static Point goal;
	public static Point start;

	// holds all vertices on the grid
	private static List<Point> ladderPoints = new ArrayList<Point>();
	static ST<Integer, Point> vertices = new ST<>();

	private static RectHV[] buttons = new RectHV[6];// 0:Next Round; 1: BFS; 2:DFS; 3:Dijkstra
	public static RectHV[] playerPositions = new RectHV[15]; // to redraw players

	// initialize both players
	public static Player player1 = new Player(Color.CYAN, "1");
	public static Player player2 = new Player(Color.YELLOW, "2");
	public static Player[] players = { player1, player2 };

	public static int round = 1;
	public static boolean countinueRound = true;
	private static JFrame frame;

	public static void main(String[] args) {
		// graph used for collecting vertices
		In in = new In("src/tingting/Resources/intLadderGraph.txt");
		Graph graph = new Graph(in);

		// clickable button areas
		buttons[0] = new RectHV(81, 15, 96, 21);// next round
		buttons[1] = new RectHV(22, 4, 35, 11);// BFS
		buttons[2] = new RectHV(43, 4, 54, 11);// DFS
		buttons[3] = new RectHV(63, 4, 74, 11);// Dijkstra

		playRound(graph);
	}

	/**
	 * Checks at the top of each round if the game is still active. If the current
	 * round is 1, 2, or 3, draws a new goal point and players will take turns
	 * traversing the graph
	 * 
	 * @param graph
	 */
	private static void playRound(Graph graph) {
		while (round < 4) {
			fillPoints(ladderPoints);
			fillST(ladderPoints);
			GameConfig.drawGameArea();

			goal = drawGoal();
			int goalIndex = ladderPoints.indexOf(goal);
			JOptionPane.showMessageDialog(frame, "Please choose an algorithm for Round" + round);

			// beginning of a round
			for (int i = 0; i < players.length; i++) {
				start = generateStart();
				int startIndex = ladderPoints.indexOf(start);

				Player.setCurrent(start);
				playerMovement(graph, startIndex, goalIndex, players[i]);
			}

			MatchWinner(player1, player2);
			StdDraw.pause(3000);
			round++;
			GameConfig.updateRound(round);
		}
		GameConfig.EndGameScreen(player1, player2);
	}

	/**
	 * 
	 * Assigns an algorithm to the provided player based on their selection in the
	 * Game Area button section
	 * 
	 * @param graph      Graph used to create the path taken
	 * @param startIndex starting position of the player
	 * @param goalIndex  goal position to be reached
	 * @param player     active Player
	 */
	public static void playerMovement(Graph graph, int startIndex, int goalIndex, Player player) {
		while (!Player.getCurrent().equals(goal)) {
			if (StdDraw.mousePressed()) {
				Point2D p = new Point2D(StdDraw.mouseX(), StdDraw.mouseY());
				if (buttons[1].contains(p)) {
					Iterable<Point> Algorithm1 = Algorithms.BFSAlgorithm(vertices, graph, startIndex, goalIndex);
					drawPath(Algorithm1, player);
					player.setPathLength(Algorithms.getLocalPathLength());
					player.setCoin(Algorithms.getPlayerPoints());

				} else if (buttons[2].contains(p)) {
					Iterable<Point> Algorithm2 = Algorithms.DFSAlgorithm(vertices, graph, startIndex, goalIndex);
					drawPath(Algorithm2, player);
					player.setPathLength(Algorithms.getLocalPathLength());
					player.setCoin(Algorithms.getPlayerPoints());

				} else if (buttons[3].contains(p)) {
					In weightedIn = new In("src/tingting/Resources/WeightedGraph.txt");
					EdgeWeightedGraph weightedGraph = new EdgeWeightedGraph(weightedIn);
					Iterable<Point> Algorithm3 = Algorithms.Dijkstra(vertices, weightedGraph, startIndex, goalIndex);
					drawPath(Algorithm3, player);
					player.setPathLength(Algorithms.getLocalPathLength());
					player.setCoin(Algorithms.getPlayerPoints());

				} else {
					continue;
				}
			}
		}
	}

	/**
	 * Determines the path taken by the player depending on the algorithm chosen and
	 * draws the path in the Game Area
	 * 
	 * @param algor  Algorithm chosen to guide the user to the goal point
	 * @param player Player who's path is being drawn
	 */
	public static void drawPath(Iterable<Point> algor, Player player) {
		for (Point path : algor) {
			StdDraw.pause(150);
			StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			StdDraw.filledCircle(path.getX(), path.getY(), 1.0);
			StdDraw.show();
			StdDraw.pause(100);
			StdDraw.setPenColor(player.getColor());
			StdDraw.filledCircle(path.getX(), path.getY(), 1.0);
			StdDraw.show();
		}
		Player.setCurrent(goal);
	}

	/**
	 * Randomly selects a new goal position each round
	 * 
	 * @return a Point to assign the goal
	 */
	public static Point drawGoal() {
		endPoint = StdRandom.uniform(15, 30);
		goal = vertices.get(endPoint);

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(goal.x, goal.y, 1.5, 1.5);
		StdDraw.show();

		return goal;
	}

	/**
	 * Generates a random starting position for each player at the top of the
	 * ladders
	 * 
	 * @return a gridPixel to place the player and assign as their start position
	 */
	public static Point generateStart() {
		int index = StdRandom.uniform(0, 14);
		start = vertices.get(index);
		return start;
	}

	/**
	 * Determines the winner of each round dependent on the length of their
	 * respective paths traveled
	 * 
	 * @param players Both Players to access path length
	 * 
	 * @return the number of the player who won the round, 0 if it is a tie
	 */
	public static void MatchWinner(Player p1, Player p2) {
		// calculate winner based on shortest path length
		if (p2.getPathLength() > p1.getPathLength()) {
			player1.setScore(player1.getScore() + 1);
		} else if (p2.getPathLength() < p1.getPathLength()) {
			player2.setScore(player2.getScore() + 1);
		} else {
			StdDraw.text(50, 60, "Tie!");
		}

		// calculate winner based on greatest number of coins
		if (p2.getCoin() < p1.getCoin()) {
			player1.setScore(player1.getScore() + 1);
		} else if (p1.getCoin() < p2.getCoin()) {
			player2.setScore(player2.getScore() + 1);
		} else {
			StdDraw.text(50, 60, "Tie!");
		}

		GameConfig.updatePlayerLabel(15, 18, player1.toString() + " Score: ", player1.getScore(), Color.CYAN);
		GameConfig.updatePlayerLabel(40, 18, player2.toString() + " Score: ", player2.getScore(), Color.YELLOW);
		StdDraw.show();
		StdDraw.pause(3000);
	}

	/**
	 * Takes all the vertices from LadderPoints and assigns each to a key
	 * 
	 * @param <code>List</code> points
	 */
	private static void fillST(List<Point> points) {
		for (int i = 0; i < ladderPoints.size(); i++) {
			vertices.put(i, ladderPoints.get(i));
		}
	}

	/**
	 * Generates all vertices to be drawn on the graph
	 * 
	 * @param points
	 */
	public static void fillPoints(List<Point> points) {
		// start points
		points.add(0, new Point(8, 91));
		points.add(1, new Point(14, 91));
		points.add(2, new Point(20, 91));
		points.add(3, new Point(26, 91));
		points.add(4, new Point(32, 91));
		points.add(5, new Point(38, 91));
		points.add(6, new Point(44, 91));
		points.add(7, new Point(50, 91));
		points.add(8, new Point(56, 91));
		points.add(9, new Point(62, 91));
		points.add(10, new Point(68, 91));
		points.add(11, new Point(74, 91));
		points.add(12, new Point(80, 91));
		points.add(13, new Point(86, 91));
		points.add(14, new Point(92, 91));
		// goal points
		points.add(15, new Point(8, 28));
		points.add(16, new Point(14, 28));
		points.add(17, new Point(20, 28));
		points.add(18, new Point(26, 28));
		points.add(19, new Point(32, 28));
		points.add(20, new Point(38, 28));
		points.add(21, new Point(44, 28));
		points.add(22, new Point(50, 28));
		points.add(23, new Point(56, 28));
		points.add(24, new Point(62, 28));
		points.add(25, new Point(68, 28));
		points.add(26, new Point(74, 28));
		points.add(27, new Point(80, 28));
		points.add(28, new Point(86, 28));
		points.add(29, new Point(92, 28));
		// 8
		points.add(30, new Point(8, 33));
		points.add(31, new Point(8, 60));
		points.add(32, new Point(8, 80));
		// 14
		points.add(33, new Point(14, 40));
		points.add(34, new Point(14, 45));
		points.add(35, new Point(14, 53));
		points.add(36, new Point(14, 65));
		points.add(37, new Point(14, 80));
		points.add(38, new Point(14, 89));
		// 20
		points.add(39, new Point(20, 46));
		points.add(40, new Point(20, 70));
		points.add(41, new Point(20, 35));
		points.add(42, new Point(20, 85));
		points.add(43, new Point(20, 50));
		points.add(44, new Point(20, 65));
		// 26
		points.add(45, new Point(26, 40));
		points.add(46, new Point(26, 60));
		points.add(47, new Point(26, 63));
		points.add(48, new Point(26, 85));
		points.add(49, new Point(26, 51));
		points.add(50, new Point(26, 78));
		points.add(51, new Point(26, 31));
		// 32
		points.add(52, new Point(32, 45));
		points.add(53, new Point(32, 70));
		points.add(54, new Point(32, 34));
		points.add(55, new Point(32, 40));
		points.add(56, new Point(32, 52));
		points.add(57, new Point(32, 71));
		points.add(58, new Point(32, 81));
		// 38
		points.add(59, new Point(38, 84));
		points.add(60, new Point(38, 48));
		points.add(61, new Point(38, 38));
		points.add(62, new Point(38, 75));
		points.add(63, new Point(38, 40));
		points.add(64, new Point(38, 70));
		points.add(65, new Point(38, 36));
		// 44
		points.add(66, new Point(44, 80));
		points.add(67, new Point(44, 50));
		points.add(68, new Point(44, 38));
		points.add(69, new Point(44, 61));
		points.add(70, new Point(44, 59));
		points.add(71, new Point(44, 54));
		points.add(72, new Point(44, 34));
		points.add(73, new Point(44, 75));
		// 50
		points.add(74, new Point(50, 70));
		points.add(75, new Point(50, 65));
		points.add(76, new Point(50, 50));
		points.add(77, new Point(50, 75));
		points.add(78, new Point(50, 45));
		points.add(79, new Point(50, 38));
		// 56
		points.add(80, new Point(56, 56));
		points.add(81, new Point(56, 36));
		points.add(82, new Point(56, 85));
		points.add(83, new Point(56, 41));
		points.add(84, new Point(56, 55));
		points.add(85, new Point(56, 70));
		points.add(86, new Point(56, 80));
		// 62
		points.add(87, new Point(62, 68));
		points.add(88, new Point(62, 62));
		points.add(89, new Point(62, 40));
		points.add(90, new Point(62, 75));
		points.add(91, new Point(62, 60));
		points.add(92, new Point(62, 36));
		// 68
		points.add(93, new Point(68, 35));
		points.add(94, new Point(68, 83));
		points.add(95, new Point(68, 63));
		points.add(96, new Point(68, 50));
		points.add(97, new Point(68, 78));
		points.add(98, new Point(68, 53));
		points.add(99, new Point(68, 47));
		// 74
		points.add(100, new Point(74, 75));
		points.add(101, new Point(74, 30));
		points.add(102, new Point(74, 60));
		points.add(103, new Point(74, 42));
		points.add(104, new Point(74, 73));
		points.add(105, new Point(74, 63));
		points.add(106, new Point(74, 54));
		// 80
		points.add(107, new Point(80, 48));
		points.add(108, new Point(80, 60));
		points.add(109, new Point(80, 37));
		points.add(110, new Point(80, 86));
		points.add(111, new Point(80, 68));
		points.add(112, new Point(80, 39));
		points.add(113, new Point(80, 54));
		// 86
		points.add(114, new Point(86, 87));
		points.add(115, new Point(86, 55));
		points.add(116, new Point(86, 62));
		points.add(117, new Point(86, 46));
		points.add(118, new Point(86, 48));
		points.add(119, new Point(86, 68));
		points.add(120, new Point(86, 40));
		points.add(121, new Point(86, 73));
		// 92
		points.add(122, new Point(92, 85));
		points.add(123, new Point(92, 52));
		points.add(124, new Point(92, 74));
		points.add(125, new Point(92, 39));
	}
}
