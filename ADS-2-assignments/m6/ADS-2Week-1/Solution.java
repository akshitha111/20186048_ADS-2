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
		 double compute = getPR(v) / dg.outdegree(v);
		 System.out.println(v + ":" + compute);
		 //compute;
	}
}
	/*private Digraph dg;
	private double pr;
	PageRank(Digraph digraph) {
		this.dg = digraph;
	}
*/
	/*double getPR(int v) {
		pr = 0;
		for (int i = 0; i < 1000; i++) {
		for (Integer j : dg.adj(v)){
			pr += getPR(i) / dg.outdegree(v);
		}
	}

		return pr;
	}*/
	/*public String toString() {
        StringBuilder s = new StringBuilder();
        //s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < digraph.V(); v++) {
            s.append(String.format("%d: - ", v));
            //for (int w : adj[v]) {
              //  s.append(String.format("%d ", w));
            //}
            s.append(String.format("%d: ", getPR(v)));
            s.append("\n");
        }
        return s.toString();
    }*/


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
		//for (int i = 0; i < vertices; i++) {
		//	StdIn.readLine();
		//}	
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
		pr.computePR(count);
		System.out.println();
		// Create page rank object and pass the graph object to the constructor
		
		/*for (int i = 0; i < vertices; i++) {
			String[] tokens = sc.nextLine().split(" ");
			for (int j = 1; j < tokens.length; j++) {
				pr.computePR(j);
			}
		}*/
		
		// print the page rank object
		//pr.calc(vertices);
		//pr.computePR(vertices);
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
