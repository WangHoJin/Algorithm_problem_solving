package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2475_검증수 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int ans = 0;
		for (int i = 0; i < 5; i++) {
			ans += Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		System.out.println(ans % 10);
	}
}
