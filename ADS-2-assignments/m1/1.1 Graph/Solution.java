import java.util.Scanner;
import java.util.Arrays;
interface Graph  {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    public Iterable<Integer> adj(int v);
    public boolean hasEdge(int v, int w);
}


class Solution {
	private Solution() {

	}public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		String[] tokens = sc.nextLine().split(",");
		System.out.println(Arrays.toString(tokens));
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
				}
				//System.out.println(Arrays.toString(check));
		
	}
}
