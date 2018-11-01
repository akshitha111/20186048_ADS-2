import java.util.Arrays;
/**
 * Class for word net.
 */
public class WordNet {
    /**
     * Constructs the object.
     *
     * @param      synsets    The synsets
     * @param      hypernyms  The hypernyms
     */
    public WordNet(String synsets, String hypernyms) {
        readMySynsetFile(synsets, hypernyms);
    }
    
    /**
     * readMySynsetFile.
     *
     * @param      filename  The filename
     */
    void readMySynsetFile(String filename, String hypernyms) {
        int id = 0;
        int numOfVertices = 0;
        try {
            In inObj = new In(filename);
            while (!inObj.isEmpty()) {
                numOfVertices++;
                String[] fileArray = inObj.readString().split(",");
                id = Integer.parseInt(fileArray[0]);
                String[] nounsArray = fileArray[1].split(" ");
            }
            Digraph digraphObj = new Digraph(numOfVertices);
            readMyHypernymsFile(hypernyms, digraphObj);
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }


    void readMyHypernymsFile(String hypernyms, Digraph tempObj) {
        try {
            In inObj = new In(hypernyms);
            while (!inObj.isEmpty()) {
                String[] fileArray = inObj.readString().split(",");
                int v = Integer.parseInt(fileArray[0]);
                int w = Integer.parseInt(fileArray[1]);
                tempObj.addEdge(v, w);
            }
            System.out.println(tempObj);

        } catch (Exception e) {

        }
        DirectedCycle dc = new DirectedCycle(tempObj);
            if (dc.hasCycle()) {
            System.out.println("Cycle exists.");
        } else {
            System.out.println("Cycle doesn't exists.");
        }

    }

    // // returns all WordNet nouns
    // public Iterable<String> nouns()

    // // is the word a WordNet noun?
    // public boolean isNoun(String word)

    // // distance between nounA and nounB (defined below)
    // public int distance(String nounA, String nounB)

    // // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // // in a shortest ancestral path (defined below)
    // public String sap(String nounA, String nounB)

    // // do unit testing of this class
    // public static void main(String[] args)
}
