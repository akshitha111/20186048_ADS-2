import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;
interface Graph  {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    public Iterable<Integer> adj(int v);
    public boolean hasEdge(int v, int w);
}

class AdjacentList {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public AdjacentList(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}









public final class Solution {
	private Solution() {

	}public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		if(edges == 0) {
			System.out.println("No edges");
		}
		String[] tokens = sc.nextLine().split(",");
		//System.out.println(Arrays.toString(tokens));
		/*switch (input) {
			case "List":
				AdjacentList al = new AdjacentList();
				for(int i = 0; i < vertices; i++) {
					String[] check = sc.nextLine().split(" ");
				}
				break;
			case "Matrix":
				MatrixList ml = new MatrixList();
				break;
		}*/
		for(int i = 0; i < vertices; i++) {
					String[] check = sc.nextLine().split(" ");
					//System.out.println(Arrays.toString(check));
				}
				
		
	}
}
