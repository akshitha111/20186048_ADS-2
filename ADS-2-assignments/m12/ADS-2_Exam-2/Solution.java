import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
        int vertices = Integer.parseInt(sc.nextLine());
        int edges = Integer.parseInt(sc.nextLine());
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(vertices);
        for (int i = 0; i < edges; i++) {
            String[] tokens = sc.nextLine().split(" ");
                int verOne = Integer.parseInt(tokens[0]);
                int edgeOne = Integer.parseInt(tokens[1]);
                Double weight = Double.parseDouble(tokens[2]);
                Edge edge = new Edge(verOne,edgeOne,weight);
                digraph.addEdge(edge);
                
        }
        
        String caseToGo =  sc.nextLine();		
		switch (caseToGo) {
		case "Graph":
		System.out.println(digraph);
			//Print the Graph Object.
		 

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			/*EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(edges);
			for (int i = 0; i < edges; i++) {
				String[] check = sc.nextLine().split(" ");
				DirectedEdge directedEdge = new DirectedEdge(Integer.parseInt(check[0]),
                Integer.parseInt(check[1]), Double.parseDouble(check[2]));
			}
			DijkstraSP dijkstra = new DijkstraSP(digraph, )
			break;*/
			
		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}