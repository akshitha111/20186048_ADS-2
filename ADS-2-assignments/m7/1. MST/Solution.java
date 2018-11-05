import java.util.Scanner;
class Solution {
	private Solution() {

	}public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(vertices);
		
		for (int i = 0; i < vertices; i++) {
			String[] tokens = sc.nextLine().split(" ");
			Edge edge = new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
			edgeWeightedGraph.addEdge(edge);
		}
		KruskalMST kruskal = new KruskalMST(edgeWeightedGraph);
		System.out.printf("%.5f\n",  kruskal.weight());

	}
}