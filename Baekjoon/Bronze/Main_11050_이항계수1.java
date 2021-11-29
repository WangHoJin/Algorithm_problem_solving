package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11050_이항계수1 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = 1;
		int r = 1;
		int nr = 1;
		int ans = 0;
		for (int i = a; i > 0; i--) {
			n *= i;
		}
		for (int i = b; i > 0; i--) {
			r *= i;
		}
		for (int i = a - b; i > 0; i--) {
			nr *= i;
		}
		ans = n / (r * nr);
		System.out.println(ans);
	}
}
