/**
 * Class for bipartite.
 */
public class Bipartite {
    /**
     * { isBipartite variable }.
     */
    private boolean isBipartite;
    /**
     * { color variable }.
     */
    private boolean[] color;
    /**
     * { marked variable }.
     */
    private boolean[] marked;
    /**
     * { edgeTo variable }.
     */
    private int[] edgeTo;
    /**
     * { cycle variable }.
     */
    private Stack<Integer> cycle;
    /**
     * Constructs the object.
     *
     * @param      graph    { parameter_description }
     */
    public Bipartite(Graph graph) {
        isBipartite = true;
        color  = new boolean[graph.vertex()];
        marked = new boolean[graph.vertex()];
        edgeTo = new int[graph.vertex()];

        for (int v = 0; v < graph.vertex(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }
    /**
     * { function_description }
     *
     * @param      G     { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(Graph g, int v) { 
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (cycle != null) return;
            if (!marked[w]) {
                edgeTo[w] = v;
                color[w] = !color[v];
                dfs(g, w);
            } 
            else if (color[w] == color[v]) {
                isBipartite = false;
                cycle = new Stack<Integer>();
                cycle.push(w);
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
            }
        }
    }

    /**
     * Returns true if the graph is bipartite.
     *
     * @return {@code true} if the graph is bipartite; {@code false} otherwise
     */
    public boolean isBipartite() {
        return isBipartite;
    }
 
    /**
     * Returns the side of the bipartite that vertex {@code v} is on.
     *
     * @param  v the vertex
     * @return the side of the bipartition that vertex {@code v} is on; two vertices
     *         are in the same side of the bipartition if and only if they have the
     *         same color
     * @throws IllegalArgumentException unless {@code 0 <= v < V} 
     * @throws UnsupportedOperationException if this method is called when the graph
     *         is not bipartite
     */
    public boolean color(int v) {
        if (!isBipartite)
            throw new UnsupportedOperationException("graph is not bipartite");
        return color[v];
    }

    /**
     * Returns an odd-length cycle if the graph is not bipartite, and
     * {@code null} otherwise.
     *
     * @return an odd-length cycle if the graph is not bipartite
     *         (and hence has an odd-length cycle), and {@code null}
     *         otherwise
     */
    public Iterable<Integer> oddCycle() {
        return cycle; 
    }

    private boolean check(Graph G) {
        if (isBipartite) {
            for (int v = 0; v < G.vertex(); v++) {
                for (int w : G.adj(v)) {
                    if (color[v] == color[w]) {
                        System.err.printf("edge %d-%d with %d and %d in same side of bipartition\n", v, w, v, w);
                        return false;
                    }
                }
            }
        }
        else {
            int first = -1, last = -1;
            for (int v : oddCycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }

        return true;
    }
}
