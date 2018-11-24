import java.util.HashMap;
import java.util.Arrays;
/**
 * Class for burrows wheeler.
 */
public class BurrowsWheeler {
    private static final int lgR  = 8;
    public static void transform() {
        String str = BinaryStdIn.readString();
        CircularSuffixArray csa = new CircularSuffixArray(str);
        for (int i = 0; i < csa.length(); ++i) {
            if (csa.index(i) == 0) {
                BinaryStdOut.write(i);
                break;
            }
        }

        for (int i = 0; i < csa.length(); ++i) {
            int index = csa.index(i);
            if (index == 0) {
                BinaryStdOut.write(str.charAt(str.length() - 1), lgR);
            }
            else {
                BinaryStdOut.write(str.charAt(index - 1), lgR);
            }
        }
        BinaryStdOut.close();
    }
    /**
     * inverse transform function.
     */
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        String s = BinaryStdIn.readString();
        char[] c = s.toCharArray();
        HashMap<Character, Queue<Integer>> table
        = new HashMap<Character, Queue<Integer>>();
        for (int i = 0; i < c.length; ++i) {
            if (!table.containsKey(c[i])) {
                table.put(c[i], new Queue<Integer>());
            }
            table.get(c[i]).enqueue(i);
        }

        Arrays.sort(c);
        int[] next = new int[c.length];
        for (int i = 0; i < next.length; ++i) {
            next[i] = table.get(c[i]).dequeue();
        }

        for (int i = 0; i < next.length; ++i) {
            BinaryStdOut.write(c[first], 8);
            first = next[first];
        }
        BinaryStdOut.close();
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Illegal command line argument");
        }
        if (args[0].equals("-")) {
            transform();
        }
        else if (args[0].equals("+")) {
            inverseTransform();
        }
        else {
            throw new IllegalArgumentException("Illegal command line argument");
        }

    }
}



