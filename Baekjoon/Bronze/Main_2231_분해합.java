package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2231_분해합 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int start = 0;
		int end = N - 1;

		int num = N;
		int a = 0;
		int size = 0;
		while (num != 0) {
			a = num % 10;
			num = num / 10;
			size++;
		}

		start = N - (a + (size - 1) * 9);
		int ans = 0;
		for (int i = start; i <= end; i++) {
			int sum = i;
			int n = i;
			while (n != 0) {
				a = n % 10;
				n = n / 10;
				sum += a;
			}
			if (sum == N) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}
