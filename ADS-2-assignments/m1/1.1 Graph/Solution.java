import java.util.Scanner;
/**
 * Interface for graph.
 */
interface Graph {
    /**
     * Vertices variable.
     *
     * @return     { description_of_the_return_value }
     */
     int vertices();
    /**
     * Edge variable.
     *
     * @return     { description_of_the_return_value }
     */
    int edges();
    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    void addEdge(int v, int w);
    /**
     * { iterable function }.
     *
     * @param      v     { parameter_description }
     *
     * @return     { adjacent vertices are returned }
     */
    Iterable<Integer> adj(int v);
    /**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
     boolean hasEdge(int v, int w);
}
/**
 * Class for graph form.
 */
class GraphForm implements Graph {
    /**
     * variable for vertices.
     */
    private int V;
    /**
     * variable for edges.
     */
    private int E;
    /**
     * for bag.
     */
    private Bag<Integer>[] adj;
    /**
     * this is a constructor.
     */
    protected GraphForm() {

    }
    /**
     * Constructs the object.
     *
     * @param      V1    The v 1
     */
    GraphForm(final int V1) {
        this.V = V1;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int vertices() {
        return V;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int edges() {
        return E;
    }
    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int v, final int w) {
        if (v == w) {
            return;
        }
        if (!hasEdge(v, w)) {
            E++;
        }
        adj[v].add(w);
        adj[w].add(v);
    }
    /**
     * { iterable function }.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
    /**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        for (int k : adj[v]) {
                if (k == w) {
                    return true;
                }
        }
        return false;
    }
    /**.
     * To display the list.
     *
     * @param      v2          { parameter_description }
     * @param      e2          { parameter_description }
     * @param      tokens     The tokens
     *
     * @throws     Exception  { exception_description }
     */
    public void listdisplay(final int v2, final int e2,
        final String[] tokens) throws Exception {
        if (e2 <= 1 && v2 <= 1) {
            System.out.println(vertices() + " vertices" + ", " + edges() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(vertices() + " vertices" + ", " + edges() + " edges");
            for (int i = 0; i < tokens.length; i++) {
            String type = "";
            type = tokens[i] + ": ";
            for (int k : adj(i)) {
                type = type + tokens[k] + " ";
            }
            System.out.println(type);
            }
        }
    }

    /**
     * to display the matrix.
     *
     * @param      v1          { parameter_description }
     * @param      e1          { parameter_description }
     *
     * @throws     Exception  { exception_description }
     */
    public void matrixdisplay(final int v1, final int e1) throws Exception {
        if (e1 <= 1 && v1 <= 1) {
            System.out.println(vertices() + " vertices" + ", " + edges() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(vertices() + " vertices" + ", " + edges() + " edges");
            int[][] disp = new int[V][V];
            for (int i = 0; i  < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (hasEdge(i, j)) {
                        disp[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    System.out.print(disp[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}


/**
 * Client class.
 */
public final class Solution {
    /**
     * this is a constructor.
     */
    protected Solution() {
        //unused constructor.
    }
    /**
     * Client function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        GraphForm graph = new GraphForm();
        String type = scan.nextLine();
        int vertices = Integer.parseInt(scan.nextLine());
        int edges = Integer.parseInt(scan.nextLine());
        String[] data = scan.nextLine().split(",");
        graph = new GraphForm(vertices);
        while (scan.hasNext()) {
            String name = scan.nextLine();
            String[] links = name.split(" ");
            graph.addEdge(Integer.parseInt(links[0]),
            Integer.parseInt(links[1]));
        }
        switch (type) {
            case "List":
            try {
                graph.listdisplay(vertices, edges, data);
            } catch (Exception a) {
                System.out.println(a.getMessage());
            }
            break;
            case "Matrix":
            try {
                graph.matrixdisplay(vertices, edges);
            } catch (Exception b) {
                System.out.println(b.getMessage());
            }
            break;
            default:
            break;
        }
    }
}



