/**
 * Edge class (It represents Weighted Graph)
 *
 * @author Esra Eryılmaz
 * @since 2020-06-19
 */


public class Edge
{
	/**
	 * Source vertex for an edge
	 */
	private int source;

	/**
	 * Destination vertex for an edge
	 */

	private int destination;
	/**
	 * Weight of an edge
	 */

	private int weight;

	/**
	 * Construct an edge from source to destination with the weight
	 * @param source The source vertex
	 * @param destination The destination vertex
	 * @param weight The specified weight of the edge
	 */
	public Edge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	/**
	 * Getter for destination vertex
	 * @return The destination vertex of this edge
	 */
	public int getDest(){
		return this.destination;
	}

	/**
	 * Getter for source vertex
	 * @return The source vertex of this edge
	 */
	public int getSource(){
		return this.source;
	}

	/**
	 * Getter for the edge weight
	 * @return The weight of this edge
	 */
	public int getWeight(){
		return this.weight;
	}


	/**
	 * Compares two edges for equality. Edges are equal if their source and destination vertices are the same. 
	 * Weight is not considered.
	 * @param e The edge we are comparing to.
	 */
	public boolean equals(Edge e) {
		return (this.source == e.source && this.destination == e.destination);
	}

	/**
	 * String representation of edge
	 */
	public String toString() {
		return "Source: " + source + ", Destination: " + destination + ", Weight: " + weight;
	}
}
