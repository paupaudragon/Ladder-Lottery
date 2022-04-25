package tingting;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.DepthFirstPaths;
import edu.princeton.cs.algs4.DijkstraUndirectedSP;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class Algorithms {
	private static int localPathLength = 0;
	public static Double playerPoints = 0.0;

	/**
	 * Implementing the BreadthFirstPaths Algs4 algorithm Returns the shortest path.
	 * Also updates the <code>localPathLength</code> for the length of the path.
	 * Updates the final score for the Coins and Bombs.
	 * 
	 * @param <code>ST<Integer,  Point></code> vertex
	 * @param <code>Graph</code> graph
	 * @param int                Starting Point
	 * @param int                Ending Point
	 * @return a list of <code>Iterable</code> points from the start to end
	 */
	public static Iterable<Point> BFSAlgorithm(ST<Integer, Point> vertex, Graph graph, int startingPoint,
			int goalPoint) {
		localPathLength = 0;
		playerPoints = 0.0;
		In weightedIn = new In("src/tingting/Resources/WeightedGraph.txt");
		EdgeWeightedGraph weightedGraph = new EdgeWeightedGraph(weightedIn);
		Iterable<Edge> e = weightedGraph.edges();

		Queue<Point> path = new Queue<>();
		List<Integer> pathPoints = new ArrayList<>();

		BreadthFirstPaths BFSsearch = new BreadthFirstPaths(graph, startingPoint);

		// for each storing each step in the path
		// and updating the pathLength variable
		if (BFSsearch.hasPathTo(goalPoint))
		{
			for (Integer i : BFSsearch.pathTo(goalPoint)) {
				path.enqueue(GameArea.vertices.get(i));
				pathPoints.add(i);
			}
			for (Edge edge : e) {
				int either = edge.either();
				int other = edge.other(either);

				if (pathPoints.contains(other)) {
					if (edge.weight() == 25.0)
						playerPoints += 5.0;

					else if (edge.weight() == 75.0)
						playerPoints -= 10.0;
				} else if (pathPoints.contains(either)) {
					if (edge.weight() == 25.0)
						playerPoints += 5.0;
					else if (edge.weight() == 75.0)
						playerPoints -= 10.0;
				}
			}
		}
		// stores the length of the path
		localPathLength = BFSsearch.distTo(goalPoint);// change later
		StdOut.println("Steps taken: " + localPathLength);
		StdOut.println("Coins collected: " + playerPoints);
		StdOut.println();

		return path;
	}

	/**
	 * Implementing the DepthFirstPaths Algs4 algorithm Returns the shortest path.
	 * Also updates the <code>localPathLength</code> for the length of the path.
	 * Updates the final score for the Coins and Bombs.
	 * 
	 * @param <code>ST<Integer,  Point></code> vertex
	 * @param <code>Graph</code> graph
	 * @param int                Starting Point
	 * @param int                Ending Point
	 * @return a list of <code>Iterable</code> points from the start to end
	 */
	public static Iterable<Point> DFSAlgorithm(ST<Integer, Point> vertex, Graph graph, int startingPoint,
			int goalPoint) {
		playerPoints = 0.0;

		In weightedIn = new In("src/tingting/Resources/WeightedGraph.txt");
		EdgeWeightedGraph weightedGraph = new EdgeWeightedGraph(weightedIn);
		Iterable<Edge> e = weightedGraph.edges();

		Queue<Point> path = new Queue<>();
		List<Integer> pathPoints = new ArrayList<>();
		localPathLength = 0;

		DepthFirstPaths DFSsearch = new DepthFirstPaths(graph, startingPoint);

		// for each storing each step in the path
		// and updating the pathLength variable
		if (DFSsearch.hasPathTo(goalPoint))
		{
			for (Integer i : DFSsearch.pathTo(goalPoint)) {
				path.enqueue(GameArea.vertices.get(i));
				pathPoints.add(i);
				localPathLength++;
			}
			for (Edge edge : e) {
				int either = edge.either();
				int other = edge.other(either);

				if (pathPoints.contains(other)) {
					if (edge.weight() == 25.0)
						playerPoints += 5.0;
					else if (edge.weight() == 75.0)
						playerPoints -= 10.0;
				} else if (pathPoints.contains(either)) {
					if (edge.weight() == 25.0)
						playerPoints += 5.0;
					else if (edge.weight() == 75.0)
						playerPoints -= 10.0;
				}
			}
		}

		StdOut.println("Steps taken: " + localPathLength);
		StdOut.println("Coins collected: " + playerPoints);
		StdOut.println();

		return path;
	}

	/**
	 * Implementing the DepthFirstPaths Algs4 algorithm Returns the shortest path
	 * based on edge weight. Also updates the <code>localPathLength</code> for the
	 * length of the path. Updates the final score for the Coins and Bombs.
	 * 
	 * @param <code>ST<Integer,              Point></code> vertex
	 * @param <code>EdgeWeightedGraph</code> graph
	 * @param int                            Starting Point
	 * @param int                            Ending Point
	 * @return a list of <code>Iterable</code> points from the start to end
	 */
	public static Iterable<Point> Dijkstra(ST<Integer, Point> vertex, EdgeWeightedGraph graph, int startingPoint,
			int goalPoint) {
		localPathLength = 0;
		playerPoints = 0.0;
		Queue<Point> path = new Queue<>();
		List<Integer> points = new ArrayList<>();

		DijkstraUndirectedSP Dijkstra = new DijkstraUndirectedSP(graph, startingPoint);

		if (Dijkstra.hasPathTo(goalPoint))
		{
			for (Edge i : Dijkstra.pathTo(goalPoint)) {
				int val = i.either();
				int val2 = i.other(val);
				if (!points.contains(val)) {
					points.add(val);
					path.enqueue(GameArea.vertices.get(val));
				}
				if (!points.contains(val2)) {
					points.add(val2);
					path.enqueue(GameArea.vertices.get(val2));
				}
				localPathLength++;

				if (i.weight() == 25.0)
					playerPoints += 5.0;
				else if (i.weight() == 75.0)
					playerPoints -= 10.0;
			}
		}
		StdOut.println("Steps taken: " + localPathLength);
		StdOut.println("Coins collected: " + playerPoints);
		path.enqueue(GameArea.vertices.get(goalPoint));
		StdOut.println();

		return path;
	}
	
	/**
	 * @return the localPathLength
	 */
	public static int getLocalPathLength() {
		return localPathLength;
	}

	/**
	 * @return the playerPoints
	 */
	public static Double getPlayerPoints() {
		return playerPoints;
	}
}