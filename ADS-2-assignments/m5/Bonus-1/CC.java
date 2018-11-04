/**
 * Class for cc.
 */
public class CC {
    /**
     * marked array of boolean type.
     */
    private boolean[] marked; // marked[v] = has vertex v been marked?
    /**
     * id array of integer type.
     */
    private int[] id; // id[v] = id of connected component containing v
    /**
     * size array.
     */
    private int[] size; // size[id] = number of vertices in given component
    /**
     * count variable.
     */
    private int count; // number of connected components
    /**
     * Computes the connected components of the undirected graph {@code G}.
     *
     * @param gp the undirected graph
     */
    public CC(final Graph gp) {
        marked = new boolean[gp.vertices()];
        id = new int[gp.vertices()];
        size = new int[gp.vertices()];
        for (int v = 0; v < gp.vertices(); v++) {
            if (!marked[v]) {
                dfs(gp, v);
                count++;
            }
        }
    }
    // depth-first search for a Graph
    /**
    * depth first search method.
    *
    * @param gp graph
    * @param v integer
    *
    **/
    private void dfs(final Graph gp, final int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : gp.adj(v)) {
            if (!marked[w]) {
                dfs(gp, w);
            }
        }
    }
    /**
     * Returns the component id of the connected
     * component containing vertex {@code v}.
     *
     * @param  v the vertex
     * @return the component id of the connected
     * component containing vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int id(final int v) {
        validateVertex(v);
        return id[v];
    }
    /**
     * Returns the number of vertices in the connected
     * component containing vertex {@code v}.
     *
     * @param  v the vertex
     * @return the number of vertices in the connected
     * component containing vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int size(final int v) {
        validateVertex(v);
        return size[id[v]];
    }
    /**
     * Returns the number of connected components in the graph {@code G}.
     *
     * @return the number of connected components in the graph {@code G}
     */
    public int count() {
        return count;
    }
    /**
     * Returns true if vertices {@code v} and {@code w} are in the same
     * connected component.
     *
     * @param  v one vertex
     * @param  w the other vertex
     * @return {@code true} if vertices {@code v} and {@code w} are in the same
     *         connected component; {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     * @throws IllegalArgumentException unless {@code 0 <= w < V}
     */
    public boolean connected(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }
    /**
     * Returns true if vertices {@code v} and {@code w} are in the same
     * connected component.
     *
     * @param  v one vertex
     * @param  w the other vertex
     * @return {@code true} if vertices {@code v} and {@code w} are in the same
     *         connected component; {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     * @throws IllegalArgumentException unless {@code 0 <= w < V}
     * @deprecated Replaced by {@link #connected(int, int)}.
     */
    @Deprecated
    public boolean areConnected(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }
    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    /**
    * validates vertex.
    * @param v integer
    *
    **/
    private void validateVertex(final int v) {
        int ml = marked.length;
        if (v < 0 || v >= ml) {
            throw new IllegalArgumentException("vertex " + v
                + " is not between 0 and " + (ml - 1));
        }
    }
    /**
     * returns id array.
     *
     * @return     integer array
     */
    public int[] idarray() {
        return id;
    }
}


