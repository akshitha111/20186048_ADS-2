/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//eval purpose constructor.
	}
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		In sc = new In();
		String synset = sc.readString();
		String hypernym = sc.readString();
		String type = sc.readString();
		if (type.equals("Graph")) {
			WordNet wordNet = new WordNet(synset, hypernym);
		} else {

		}
	}
}