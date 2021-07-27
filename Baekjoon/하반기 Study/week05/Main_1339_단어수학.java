import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1339_단어수학 {
	static int N, ans;
	static int[] alpha;
	static char[] word;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/05/단어수학.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		alpha = new int[26];
		for (int i = 0; i < N; i++) {
			word = in.readLine().toCharArray();
			int len = word.length;
			for (int j = len - 1, idx = 0; j >= 0; j--) {
				int value = (int) Math.pow(10, j);
				alpha[word[idx++] - 'A'] += value;
			}
//			print(word);
		}
		Arrays.sort(alpha);
		int a = 9;
		for (int i = 25; i >= 0; i--) {
			ans += alpha[i] * a--;
			if (alpha[i] == 0 || a == 0)
				break;
		}
		System.out.println(ans);
	}

	private static void print(char[] word) {
		for (char x : word) {
			System.out.print(x);
		}
		System.out.println();

	}

}
