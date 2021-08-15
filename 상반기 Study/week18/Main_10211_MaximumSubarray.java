package ssafy.study.week18;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10211_MaximumSubarray {
	static int T, N, ans;
	static int[] num;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/18/MaximumSubarray.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			ans = Integer.MIN_VALUE;
			N = Integer.parseInt(in.readLine());
			num = new int[N + 1];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				num[i] = Integer.parseInt(st.nextToken());

			}
			prefixSum();
			System.out.println(ans);
		}

	}

	// prefixSum[n] = n번째 인덱스까지 구간합중 최대값
	// prefixSum[n] = Max(num[n],num[n]+prefixSum[n-1]) => 전 구간까지의 최대값과 자기자신을 더한 값 중 더 큰값으로 갱신
	// -2 1 -2 3 -5
	// -2 1 -1 3 -2
	private static void prefixSum() {
		int[] prefixSum = new int[N + 1];
		// 안쓰는 인덱스 0
		prefixSum[0] = 0;

		int sum = 0;
		for (int i = 1; i <= N; i++) {
			prefixSum[i] = Math.max(num[i], num[i] + prefixSum[i - 1]);
			ans = Math.max(ans, prefixSum[i]);
		}
	}
}
