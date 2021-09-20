package second.study.week13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1660_캡틴이다솜 {
	static int N;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/13/캡틴이다솜.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		// cnt[n] => n사이즈일때 대포알 개수
		int[] cnt = new int[121]; // 넉넉히 150사이즈
		// dp[n] => n개의 대포알을 가지고 있을때 만들 수 있는 사면체의 최소 개수
		int[] dp = new int[300010];

		// 대포알 개수 구하기
		for (int i = 1; i < 121; i++) {
			int currCnt = (i * (i + 1)) / 2;
			cnt[i] = cnt[i - 1] + currCnt;
		}
		System.out.println(cnt[120]);
		int ans = go(N, cnt, dp);
		System.out.println(ans);
	}

	private static int go(int n, int[] cnt, int[] dp) {
		if (n == 0)
			return 0;
		int ans = dp[n];
		if (ans != 0)
			return ans;

		int idx;
		for (idx = 120; idx > 1; idx--) {
			// n이 i사이즈 대포알보다 작으면 못만들기 때문에 패스
			if (n >= cnt[idx])
				break;
		}
		ans = go(n - cnt[idx], cnt, dp) + 1;
		for (int i = 1; i < idx; i++) {
			ans = Math.min(ans, go(n - cnt[i], cnt, dp) + 1);
		}
		return ans;
	}

}
