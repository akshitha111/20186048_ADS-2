import java.util.Scanner;
import java.util.Arrays;
public final class Solution {
	private Solution() {

	}public static void main(String[] args) {
		LSD lsd = new LSD();
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] tokens = new String[n];
		for (int i = 0; i < n; i++) {
			tokens[i] = sc.nextLine();
			//int w = tokens[i].length();
			
		}lsd.sort(tokens, 6);
		System.out.println(Arrays.toString(tokens));
	}
}