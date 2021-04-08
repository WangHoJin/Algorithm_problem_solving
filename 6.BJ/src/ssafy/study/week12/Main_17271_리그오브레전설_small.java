package ssafy.study.week12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17271_리그오브레전설_small {
	static int N, M, ans;
	static final long mod = 1000000007;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/리그오브레전설_small.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 싸움 시간
		M = Integer.parseInt(st.nextToken()); // B 스킬 시전 시간
		long[] dp = new long[N + 1];

		// dp[k] = dp[k-1] + dp[k-M]
		Arrays.fill(dp, -1);

		ans = (int) (skill(dp, N) % mod);
		System.out.println(ans);

	}

	private static long skill(long[] dp, int idx) {
		if (idx == 0 || idx == 1)
			return 1;
		if (idx < 0)
			return 0;
		if (dp[idx] != -1)
			return dp[idx] % mod;

		return dp[idx] = (skill(dp, idx - 1) + skill(dp, idx - M)) % mod;

	}
}
