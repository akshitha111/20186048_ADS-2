/**
 * { item_description }
 */
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
    // Don't modify this method.
    /**
     * { Client Program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String cases = scan.nextLine();

        switch (cases) {
        case "loadDictionary":
            // input000.txt and output000.txt
            BinarySearchST<String, Integer> hash
             = loadDictionary("/Files/t9.csv");
            while (scan.hasNextLine()) {
                String key = scan.nextLine();
                System.out.println(hash.get(key));
            }
            break;

        case "getAllPrefixes":
            // input001.txt and output001.txt
            T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
            while (scan.hasNextLine()) {
                String prefix = scan.nextLine();
                for (String each : t9.getAllWords(prefix)) {
                    System.out.println(each);
                }
            }
            break;

        case "potentialWords":
            // input002.txt and output002.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            int count = 0;
            while (scan.hasNextLine()) {
                String t9Signature = scan.nextLine();
                for (String each : t9.potentialWords(t9Signature)) {
                    count++;
                    System.out.println(each);
                }
            }
            if (count == 0) {
                System.out.println("No valid words found.");
            }
            break;

        case "topK":
            // input003.txt and output003.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            Bag<String> bag = new Bag<String>();
            int k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                bag.add(line);
            }
            for (String each : t9.getSuggestions(bag, k)) {
                System.out.println(each);
            }

            break;

        case "t9Signature":
            // input004.txt and output004.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            bag = new Bag<String>();
            k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for (String each : t9.t9(line, k)) {
                    System.out.println(each);
                }
            }
            break;

        default:
            break;

        }
    }

    // Don't modify this method.
    /**
     * { toReadfile method }.
     *
     * @param      file  The file
     *
     * @return     { description_of_the_return_value }
     */
    public static String[] toReadFile(final String file) {
        In in = new In(file);
        return in.readAllStrings();
    }
        /**
         * Loads a dictionary.
         *
         * @param      file  The file
         *
         * @return     { description_of_the_return_value }
         */
    public static BinarySearchST<String, Integer>
    loadDictionary(final String file) {
        BinarySearchST<String, Integer>  st
        = new BinarySearchST<String, Integer>();
        // your code goes here
        String[] dictionary = toReadFile(file);
        for (int i = 0; i < dictionary.length; i++) {
            String string = dictionary[i].toLowerCase();
            if (!(st.contains(string))) {
                st.put(string, 1);
            } else {
                st.put(string, st.get(string) + 1);
            }
        }
        return st;
    }

}


/**
 * Class for t 9.
 */
class T9 {

    /**
     * { tst variable }.
     */
    private TST<Integer> tst;
    /**
     * Constructs the object.
     *
     * @param      st    { parameter_description }
     */
    T9(BinarySearchST<String, Integer> st) {
        // your code goes here
        tst = new TST<Integer>();
        for (String word : st.keys()) {
            tst.put(word, st.get(word));
        }

    }

    // get all the prefixes that match with given prefix.
    public Iterable<String> getAllWords(String prefix) {
        // your code goes here
        return tst.keysWithPrefix(prefix);
    }

    public Iterable<String> potentialWords(String t9Signature) {
        // your code goes here
        //System.out.println(tst.keysThatMatch(t9Signature));
        return tst.keysThatMatch(t9Signature);
    }

    // return all possibilities(words), find top k with highest frequency.
    public Iterable<String> getSuggestions(Iterable<String> words, int k) {
        // your code goes here
        return null;
    }

    // final output
    // Don't modify this method.
    public Iterable<String> t9(String t9Signature, int k) {
        return getSuggestions(potentialWords(t9Signature), k);
    }
}
