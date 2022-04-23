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
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class Algorithms
{
	private static int localPathLength = 0;

	/**
	 * Implementing the BreadthFirstPaths Algs4 algorithm
	 * Returns the shortest path. Also updates the
	 * <code>localPathLength</code> for the length of the path.
	 * 
	 * @param <code>ST<Integer, Point></code> vertex
	 * @param <code>Graph</code> graph
	 * @param int Starting Point
	 * @param int Ending Point
	 * @return a list of <code>Iterable</code> points from the start to end
	 */
	public static Iterable<Point> BFSAlgorithm(ST<Integer, Point> vertex, 
												Graph graph,
												int startingPoint, 
												int goalPoint)
	{
		localPathLength=0;
		/*
		 *the generateStart and End isn't working
		 *in place to use if we continue to use GridPixel
		*/
		//GridPixel currentVertex = start;
		//Point pointStart = vertices.get(currentVertex.getY());
		//Point pointEnd   = vertices.get(currentVertex.getY());
		
		Queue<Point> path = new Queue<>();
//		int startingTest = 0;
//		int EndingTest = 29;
		
		
		BreadthFirstPaths BFSsearch = new BreadthFirstPaths(graph, startingPoint);
		
		//for each storing each step in the path
		//and updating the pathLength variable
		if(BFSsearch.hasPathTo(goalPoint));
		{
			for(Integer i : BFSsearch.pathTo(goalPoint))
			{
				path.enqueue(GameArea.vertices.get(i));
			}
			
		}
		//stores the length of the path
		localPathLength = BFSsearch.distTo(goalPoint);//change later
		StdOut.println("number of hops: " + localPathLength);
		
		return path;
	}
	
	/**
	 * Implementing the DepthFirstPaths Algs4 algorithm
	 * Returns the shortest path. Also updates the
	 * <code>localPathLength</code> for the length of the path.
	 * 
	 * @param <code>ST<Integer, Point></code> vertex
	 * @param <code>Graph</code> graph
	 * @param int Starting Point
	 * @param int Ending Point
	 * @return a list of <code>Iterable</code> points from the start to end
	 */
	public static Iterable<Point> DFSAlgorithm(ST<Integer, Point> vertex, 
												Graph graph,
												int startingPoint, 
												int goalPoint)
	{
		localPathLength=0;
		/*
		 *the generateStart and End isn't working
		 *in place to use if we continue to use GridPixel
		*/
		//GridPixel currentVertex = start;
		//Point pointStart = vertices.get(currentVertex.getY());
		//Point pointEnd   = vertices.get(currentVertex.getY());
		
		Queue<Point> path = new Queue<>();
		localPathLength = 0;
		
		
		DepthFirstPaths DFSsearch = new DepthFirstPaths(graph, startingPoint);
		
		//for each storing each step in the path
		//and updating the pathLength variable
		if(DFSsearch.hasPathTo(goalPoint));
		{
			for(Integer i : DFSsearch.pathTo(goalPoint))
			{
				path.enqueue(GameArea.vertices.get(i));
				localPathLength++;
			}
		}
		StdOut.println("number of hops: " + localPathLength);
		return path;
	}
	
	/**
	 * @return the localPathLength
	 */
	public static int getLocalPathLength() {
		return localPathLength;
	}

	/**
	 *Implementing the DepthFirstPaths Algs4 algorithm
	 *Returns the shortest path based on edge weight. 
	 *Also updates the <code>localPathLength</code> for 
	 *the length of the path.
	 * 
	 * @param <code>ST<Integer, Point></code> vertex
	 * @param <code>EdgeWeightedGraph</code> graph
	 * @param int Starting Point
	 * @param int Ending Point
	 * @return a list of <code>Iterable</code> points from the start to end
	 */
	public static Iterable<Point> Dijkstra(ST<Integer, Point> vertex, 
												EdgeWeightedGraph graph,
												int startingPoint, 
												int goalPoint)
	{
		localPathLength=0;
		Queue<Point> path = new Queue<>();
		List<Integer> points = new ArrayList<>();
		
		DijkstraUndirectedSP Dijkstra = new DijkstraUndirectedSP(graph, startingPoint);
		
		//for each storing each step in the path
		//and updating the pathLength variable
		if(Dijkstra.hasPathTo(goalPoint));
		{
			for(Edge i : Dijkstra.pathTo(goalPoint))
			{
				int val = i.either();
				int val2 = i.other(val);
					if(!points.contains(val))
					{
						points.add(val);
						path.enqueue(GameArea.vertices.get(val));
					}
					if(!points.contains(val2))
					{
						points.add(val2);
						path.enqueue(GameArea.vertices.get(val2));
					}
				localPathLength++;	
			}
		}
		StdOut.println("number of hops: " + localPathLength);
		StdOut.println(points.toString());
//		for(Point i : path)
//		{
//			StdOut.println(i);
//		}
		path.enqueue(GameArea.vertices.get(goalPoint));
		return path;
	}

}
