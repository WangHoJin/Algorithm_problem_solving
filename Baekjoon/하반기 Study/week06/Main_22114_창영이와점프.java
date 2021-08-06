package second.study.week06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_22114_창영이와점프 {
	static int N, K, ans;
	static int[] L;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/06/창영이와점프.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		L = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i < N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[2][N]; // 점프 사용 유무
		for (int i = 0; i < 2; i++) {
			Arrays.fill(dp[i], 1);
		}
//		dp[n][] = n번째까지 연속해서 밟을 수 있는 블럭의 수
//		dp[n][0] = Max(dp[n-1][0], 

		for (int i = 1; i < N; i++) {
			if (L[i] <= K) {
				dp[0][i] += dp[0][i - 1];
				dp[1][i] += dp[1][i - 1];
			} else {
				dp[1][i] += dp[0][i - 1];
			}
			ans = Math.max(ans, Math.max(dp[0][i], dp[1][i]));
		}
		System.out.println(ans);
//		print(dp[0]);
//		print(dp[1]);
	}

	private static void print(int[] l) {
		for (int i : l) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
