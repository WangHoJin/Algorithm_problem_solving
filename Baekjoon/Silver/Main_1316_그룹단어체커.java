package Silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1316_그룹단어체커 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/Silver/그룹단어체커.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int ans = N;
		for (int i = 0; i < N; i++) {
			boolean[] alpha = new boolean[26];
			char[] word = in.readLine().toCharArray();
			char pre = 0;
			for (int j = 0; j < word.length; j++) {
				char now = word[j];
				int idx = now - 'a';
				if (pre != now) {
					if (alpha[idx]) {
						ans--;
						break;
					}
					pre = now;
					alpha[idx] = true;
				}
			}
		}
		System.out.println(ans);
	}
}
