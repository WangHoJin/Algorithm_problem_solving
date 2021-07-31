package wang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] rs = new int[K];
		long left = 1;
		long right = 0;
		for (int i = 0; i < K; i++) {
			rs[i] = Integer.parseInt(in.readLine());
			right = Math.max(right, rs[i]);
		}
		long ans = 0;
		long mid = 0;
		while (left <= right) {
			int result = 0;
			mid = (left + right) / 2;
			for (int i = 0; i < rs.length; i++) {
				result += rs[i] / mid;
			}
			if (result < N) {
				right = mid - 1;
			} else if (result >= N) {
				left = mid + 1;
				ans = mid;
			}
		}
		System.out.println(ans);
	}
}
