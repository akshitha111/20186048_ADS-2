import java.util.Set;
import java.util.TreeSet;
public class BoggleSolver {
	// Initializes the data structure using the given
	// array of strings as the dictionary.
	// (You can assume each word in the dictionary
	//  contains only the uppercase letters A through Z.)

	private TrieST<Integer> dictionaryTrie;
	private Set<String> validWords;
	private boolean[][] marked;
	public BoggleSolver(final String[] dictionary) {
		dictionaryTrie = new TrieST<Integer>();
		validWords = new TreeSet<String>();
		int[] points = {0, 0, 0, 1, 1, 2, 3, 5, 11};
		for (String word : dictionary) {
			if (word.length() >= 8) {
				dictionaryTrie.put(word, 11);
			} else {
				dictionaryTrie.put(word, points[word.length()]);
			}
		}
	}
	// Returns the set of all valid words in the given Boggle board, as an Iterable.
	public Iterable<String> getAllValidWords(final BoggleBoard board) {
		if (board == null) {
			throw new IllegalArgumentException("board is null");
		}
		marked = new boolean[board.rows()][board.cols()];
		for (int i = 0; i < board.rows(); i++) {
			for (int j = 0; j < board.cols(); j++) {
				String st = appendCharacter("", board.getLetter(i, j));
				dfs(board, marked, i, j, st);
			}
		}
		return validWords;
	}
	private String appendCharacter(String st, final char c) {
		if (c == 'Q') {
			st += "QU";
			return st;
		} else {
			st += c;
			return st;
		}
	}
	private boolean isValidWord(final String word) {
		if (word.length() < 3) {
			return false;
		}
		return dictionaryTrie.contains(word);
	}

	public void dfs(final BoggleBoard board, final boolean[][] marked,
	                final int rows, final int cols, final String word) {
		if (!dictionaryTrie.hasPrefix(word)) {
			return;
		}
		if (isValidWord(word)) {
			validWords.add(word);
		}
		marked[rows][cols] = true;
		for (int i = rows - 1; i <= rows + 1; i++) {
			for (int j = cols - 1; j <= cols + 1; j++) {
				if (isValidRowColumn(i, j, board) && !marked[i][j]) {
					String sequence = appendCharacter(word, board.getLetter(i, j));
					dfs(board, marked, i, j, sequence);
				}
			}
		}
		marked[rows][cols] = false;
	}

	private boolean isValidRowColumn(final int row, final int col, final BoggleBoard board) {
		return (row >= 0 && col >= 0 && row < board.rows() && col < board.cols());
	}

	// Returns the score of the given word
	// if it is in the dictionary, zero otherwise.
	// (You can assume the word contains
	// only the uppercase letters A through Z.)
	public int scoreOf(final String word) {
		if (word == null) return 0;
		if (dictionaryTrie.contains(word)) {
			return dictionaryTrie.get(word);
		}
		return 0;
	}
}


