package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3052_나머지 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean[] num = new boolean[43];
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			int a = Integer.parseInt(in.readLine());
			if (!num[a % 42]) {
				num[a % 42] = true;
				ans++;
			}
		}
		System.out.println(ans);
	}
}
