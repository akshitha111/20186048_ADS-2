import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		String[] words = loadWords();
		//Your code goes here...
		TST<Integer> tst = new TST<Integer>();
		Scanner sc = new Scanner(System.in);
		String prefix = sc.nextLine();
		int j = 0;
		for (String word : words) {
			SuffixArray sa = new SuffixArray(word);
			for (int i = 0; i < word.length(); i++) {
				tst.put(sa.select(i), j++);
			}
		}for (String word : tst.keysWithPrefix(prefix)) {
			System.out.println(word);
		}
	}

	public static String[] loadWords() {
		In in = new In("/Files/dictionary-algs4.txt");
		//return in.readAllstrings();
		String[] words = in.readAllStrings();
		return words;
	}
}