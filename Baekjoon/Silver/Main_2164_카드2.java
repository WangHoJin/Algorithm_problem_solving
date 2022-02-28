package Silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2164_카드2 {
	static int N, ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/Silver/카드2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		// 2^(i-1) < N <= 2^i 사이에 해당하는 값을 찾는다.
		// ans = 2 * (N - 2^(i-1))
		int i = 0;
		while (N > Math.pow(2, i)) {

			i++;
		}
		ans = (int) (2 * (N - Math.pow(2, i - 1)));
		System.out.println(ans);
	}
}
