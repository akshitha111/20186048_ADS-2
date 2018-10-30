import java.util.Scanner;
class Graph {
	private int[][] matrix;
	private int vertices;
	private int edges;
	Graph(final int vertices) {
		matrix = new int[vertices][vertices];
	}
	int vertices() {
		return vertices;
	}
	public void addEdge(final int vertexOne, final int vertexTwo) {
		if(vertexOne != vertexTwo) {
			if(!hasEdge(vertexOne, vertexTwo)) {
				matrix[vertexOne][vertexTwo] = 1;
				edges++;
			}
		}
	}
	public boolean hasEdge(final int vertexOne, final int vertexTwo) {
		if(matrix[vertexOne][vertexTwo] == 1) {
			return true;
		}
		return false;
	}
	public int[] adj(final int v) {
		return matrix[v];
	}
}

class ConnectedComponents {
	private boolean[] marked;
	private int[] id;
	private int count;
	ConnectedComponents(Graph g, int s) {
		marked = new boolean[g.vertices()];
		id = new int[g.vertices()];
		for(int i = 0; i < g.vertices(); i++) {
			marked[i] = false;
			if(!marked[i]) {
				dfs(g, i);
				count++;
			}
		}
}

public int count() {
        return count;
    }
    public int id(int v) {
        return id[v];
    }
    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int each : g.adj(v)) {
            if (!marked[each]) {
                dfs(g, each);
            }
        }
    }
    public boolean percolates() {
        if (count > 1) {
            return false;
        } else {
            return true;
        }
    }
}

class Solution {

	Solution() {
	}

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int size = Integer.parseInt(sc.nextLine());
	Graph gh = new Graph(size);
	while(sc.hasNext()) {		
		String[] tokens = sc.nextLine().split(" ");
		gh.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
	    //System.out.println(gh.hasEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
 	}
 	ConnectedComponents cc = new ConnectedComponents(gh, size);
 	System.out.println(cc.percolates());
}
}