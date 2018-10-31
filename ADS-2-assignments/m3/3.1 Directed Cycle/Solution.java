import java.util.Scanner;
class Solution {
	private Solution() {

	}public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		Digraph dg = new Digraph(vertices);
		for(int i = 0; i < edges; i++) {
			String[] tokens = sc.nextLine().split(" ");
			dg.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
		DirectedCycle dc = new DirectedCycle(dg);
		if(dc.hasCycle()) {
			System.out.println("Cycle exists.");
		} else {
			System.out.println("Cycle doesn't exists.");
		}
	}
}