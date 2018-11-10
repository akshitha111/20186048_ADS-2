import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * { Client Program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
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
                Edge edge = new Edge(verOne, edgeOne, weight);
                digraph.addEdge(edge);
        }
        String caseToGo =  sc.nextLine();
        switch (caseToGo) {
        case "Graph":
        System.out.println(digraph);
            //Print the Graph Object.
            break;
        case "DirectedPaths":
            // Handle the case of DirectedPaths, where two integers are given.
            // First is the source and second is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            //
            String[] check = sc.nextLine().split(" ");
            int source = Integer.parseInt(check[0]);
            int destination = Integer.parseInt(check[1]);
            DijkstraUndirectedSP dijik = new
            DijkstraUndirectedSP(digraph, source);
            if (!dijik.hasPathTo(destination)) {
                System.out.println("No Path Found.");
            } else {
                System.out.println(dijik.distTo[destination]);
            }
            break;
        case "ViaPaths":
            String[] values = sc.nextLine().split(" ");
            int sourceOne = Integer.parseInt(values[0]);
            int via = Integer.parseInt(values[1]);
            int destinationOne = Integer.parseInt(values[2]);
            DijkstraUndirectedSP dusp1 = new
            DijkstraUndirectedSP(digraph, sourceOne);
            /*DijkstraUndirectedSP dusp2 = new
            DijkstraUndirectedSP(digraph, destinationOne);*/
            if (!dusp1.hasPathTo(destinationOne)) {
                System.out.println("No Path Found.");
            } else {
                System.out.println(dusp1.distTo[via]);
                //System.out.println(dusp2.pathTo[destinationOne]);
            }
            // Handle the case of ViaPaths, where three integers are given.
            // First is the source and second is
            // the via is the one where path should pass throuh.
            // third is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            break;

        default:
            break;
        }

    }
}




















