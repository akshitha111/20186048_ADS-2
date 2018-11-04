/**
 * class for Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        String synsets = StdIn.readLine();
        String hypernyms = StdIn.readLine();
        String type = StdIn.readLine();
        switch (type) {
        case "Graph":
            try {
                WordNet wordnet = new WordNet(synsets, hypernyms);
                wordnet.display();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
        case "Queries":
            try {
                WordNet wordnet = new WordNet(synsets,
                                          hypernyms);
                while (StdIn.hasNextLine()) {
                    String line = StdIn.readLine();
                    String[] tokens = line.split(" ");
                    if (tokens[0].equals("null")) {
                        throw new IllegalArgumentException(
                            "IllegalArgumentException");
                    }
                    System.out.println(
                        "distance = " + wordnet.distance(tokens[0],
                                       tokens[1])
                                        + ", ancestor = "
                                         + wordnet.sap(tokens[0],
                                               tokens[1]));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
        default:
            break;
        }
    }
}

