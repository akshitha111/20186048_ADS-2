import java.util.Scanner;
class PageRank {
	private Digraph dg;
	private double pr;
	PageRank(Digraph digraph) {
		this.dg = digraph;
	}
	public double getPR(int v) {
		return dg.indegree(v);
	}
	public void computePR(int v) {
		 double compute =  dg.outdegree(v) / getPR(v);
		 System.out.println(v + " " +  "-" + " " + compute);
		
	}
}
	
class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// read the first line of the input to get the number of vertices
		int vertices = Integer.parseInt(sc.nextLine());
		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		Digraph dg = new Digraph(vertices);
		PageRank pr = new PageRank(dg);

		int count = 0;
		for (int i = 0; i < vertices; i++) {
			String[] tokens = sc.nextLine().split(" ");
			for (int j = 1; j < tokens.length; j++) {
				
				dg.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[j]));
			}count = i;
		}
		System.out.println(dg);
		for (int i = 0; i < vertices; i++) {
		pr.computePR(count); 
	}
		System.out.println();
		
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
