import java.util.Scanner;

public final class Solution {

        Solution() {

        }

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = Integer.parseInt(sc.nextLine());
        int E = Integer.parseInt(sc.nextLine());
        DigraphGenerator digraphGenerator = new DigraphGenerator();

        StdOut.println("complete graph");
        Digraph a = digraphGenerator.complete(V);
        KosarajuSharirSCC scc = new KosarajuSharirSCC(a);
        int m = scc.count();
        StdOut.println(m + " strong components");
        //StdOut.println(digraphGenerator.complete(V));
        StdOut.println();

        StdOut.println("simple");
        Digraph b = digraphGenerator.simple(V, E);
        KosarajuSharirSCC sccSimple = new KosarajuSharirSCC(b);
        int n = sccSimple.count();
        StdOut.println(n + " strong components");
        //StdOut.println(digraphGenerator.simple(V, E));
        StdOut.println();

        StdOut.println("path");
        Digraph c = digraphGenerator.path(V);
        KosarajuSharirSCC sccPath = new KosarajuSharirSCC(c);
        int o = sccPath.count();
        StdOut.println(o + " strong components");
        //StdOut.println(digraphGenerator.path(V));
        StdOut.println();

        StdOut.println("cycle");
        Digraph d = digraphGenerator.cycle(V);
        KosarajuSharirSCC sccCycle = new KosarajuSharirSCC(d);
        int p = sccCycle.count();
        StdOut.println(p + " strong components");
        //StdOut.println(digraphGenerator.cycle(V));
        StdOut.println();

        StdOut.println("Eulierian path");
        Digraph e = digraphGenerator.eulerianPath(V, E);
        KosarajuSharirSCC sccEulerPath = new KosarajuSharirSCC(e);
        int q = sccEulerPath.count();
        StdOut.println(q + " strong components");
        //StdOut.println(digraphGenerator.eulerianPath(V, E));
        StdOut.println();

        StdOut.println("Eulierian cycle");
        Digraph f = digraphGenerator.eulerianCycle(V, E);
        KosarajuSharirSCC sccEulerCycle = new KosarajuSharirSCC(f);
        int r = sccEulerCycle.count();
        StdOut.println(r + " strong components");
        //StdOut.println(digraphGenerator.eulerianCycle(V, E));
        StdOut.println();

        StdOut.println("binary tree");
        Digraph g = digraphGenerator.binaryTree(V);
        KosarajuSharirSCC binary = new KosarajuSharirSCC(g);
        int s = binary.count();
        StdOut.println(s + " strong components");
        //StdOut.println(digraphGenerator.binaryTree(V));
        StdOut.println();

        StdOut.println("tournament");
        Digraph h = digraphGenerator.tournament(V);
        KosarajuSharirSCC tour = new KosarajuSharirSCC(h);
        int t = tour.count();
        StdOut.println(t + " strong components");
        //StdOut.println(digraphGenerator.tournament(V));
        StdOut.println();

        StdOut.println("DAG");
        Digraph i = digraphGenerator.dag(V, E);
        KosarajuSharirSCC dag = new KosarajuSharirSCC(i);
        int u = dag.count();
        StdOut.println(u + " strong components");
        //StdOut.println(digraphGenerator.dag(V, E));
        StdOut.println();

        StdOut.println("rooted-in DAG");
        Digraph j = digraphGenerator.rootedInDAG(V, E);
        KosarajuSharirSCC root = new KosarajuSharirSCC(j);
        int v = root.count();
        StdOut.println(v + " strong components");
        //StdOut.println(digraphGenerator.rootedInDAG(V, E));
        StdOut.println();

        StdOut.println("rooted-out DAG");
        Digraph k = digraphGenerator.rootedOutDAG(V, E);
        KosarajuSharirSCC rootOut = new KosarajuSharirSCC(k);
        int w = rootOut.count();
        StdOut.println(w + " strong components");
        //StdOut.println(digraphGenerator.rootedOutDAG(V, E));
        StdOut.println();

        StdOut.println("rooted-in tree");
        Digraph l = digraphGenerator.rootedInTree(V);
        KosarajuSharirSCC rootTree = new KosarajuSharirSCC(l);
        int x = rootTree.count();
        StdOut.println(x + " strong components");
        //StdOut.println(digraphGenerator.rootedInTree(V));
        StdOut.println();
        
        StdOut.println("rooted-out Tree");
        Digraph di = digraphGenerator.rootedOutTree(V);
        KosarajuSharirSCC rootOutDag = new KosarajuSharirSCC(di);
        int y = rootOutDag.count();
        StdOut.println(y + " strong components");
        //StdOut.println(digraphGenerator.rootedOutTree(V));
        StdOut.println();
        }

}


