package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2292_벌집 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int size = 1;
		int ans = 1;
		while (size < N) {
			size += 6 * ans;
			ans++;
		}
		System.out.println(ans);
	}
}