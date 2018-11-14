import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    	//unused constructor.
    }
    /**
     * { Client Program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        String[] words = loadWords();
        Scanner scan = new Scanner(System.in);
        TST<Integer> tst = new TST<Integer>();
        String prefix = scan.nextLine();
        int j = 0;
        for (String word : words) {
            SuffixArray sa = new SuffixArray(word);
            for (int i = 0; i < word.length(); i++) {
                tst.put(sa.select(i), j++);
            }
        }
        for (String word : tst.keysWithPrefix(prefix)) {
            System.out.println(word);
        }
        //Your code goes here...
    }
    /**
     * load words function.
     *
     * @return     { words are returned }.
     */
    public static String[] loadWords() {
        In in = new In("/Files/dictionary-algs4.txt");
        String[] words = in.readAllStrings();
        return words;
    }
}
