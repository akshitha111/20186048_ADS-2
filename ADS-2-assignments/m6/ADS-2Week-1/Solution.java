import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Class for page rank.
 */
class PageRank {
	/**
	 * { var_description }
	 */
	private Digraph digraph;
	/**
	 * { var_description }
	 */
	private Digraph revgraph;
	/**
	 * { var_description }
	 */
	private Double[] pgRank;
	/**
	 * Constructs the object.
	 *
	 * @param      gr    The graphics
	 */
	PageRank(Digraph gr) {
		this.digraph = gr;
		this.revgraph = digraph.reverse();
		pgRank = new Double[digraph.V()];
		//int vertex = digraph.V();
		for (int i = 0; i < digraph.V(); i++) {
			pgRank[i] = 1.000000d / digraph.V();
		}
		calcPageRank();
	}
	/**
	 * Calculates the page rank.
	 */
	public void calcPageRank() {
		for (int i = 0; i < digraph.V(); i++) {
			if (digraph.outdegree(i) == 0) {
				for (int j = 0; j < digraph.V() ; j++) {
					if (i != j) {
						digraph.addEdge(i, j);
					}
				}
			}
		}
		int count = 0;
		for (int k = 1; k <= 1000; k++) {			
			Double[] tempPR = new Double[digraph.V()];
			for (int i = 0; i < digraph.V(); i++) {
				Double sum = 0.00000000000000000000d;
				for (int each : digraph.reverse().adj(i)) {
					sum = sum + pgRank[each] / digraph.outdegree(each);
				}
				tempPR[i] = sum;
			}
			
			pgRank = tempPR;
		}
	}
	/**
	 * Gets the page rank.
	 *
	 * @param      v     { parameter_description }
	 *
	 * @return     The page rank.
	 */
	public double getPageRank(int v){
		return pgRank[v];
	}
	/**
	 * { function_description }
	 */
	public void display(){
		for(int i =0 ; i< digraph.V(); i++){
			System.out.println(i + " - "+ pgRank[i]);
		}
	}
}
/**
 * Class for web search.
 */
class WebSearch {

}

/**
 * Class for solution.
 */
public class Solution {
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// read the first line of the input to get the number of vertices
		int vertices = Integer.parseInt(sc.nextLine());
		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		Digraph dg = new Digraph(vertices);
		//

		//int count = 0;
		for (int i = 0; i < vertices; i++) {
			String[] tokens = sc.nextLine().split(" ");
			for (int j = 1; j < tokens.length; j++) {
				
				dg.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[j]));
			}
		}
		System.out.println(dg);
		PageRank pageRank = new PageRank(dg);


		// Create page rank object and pass the graph object to the constructor
		pageRank.display();

		// print the page rank object

		// This part is only for the final test case

		// File path to the web content
		String file = "WebContent.txt";

		// instantiate web search object
		// and pass the page rank object and the file path to the constructor

		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky

	}
}
