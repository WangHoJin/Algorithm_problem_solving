package second.study.week03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import sun.misc.Cache;

public class Main_15988_123더하기3 {
	static int T, n;
	static long ans;
	static long[] d;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/03/123더하기3.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(in.readLine());
			d = new long[n+10];
			ans = dp(n);
			System.out.println(ans);
		}

	}

	// d[n] : n을 만들수 있는 경우의 수
	// 점화식 : d[n] = d[n-1] + d[n-2] + d[n-3]
	private static long dp(int n) {
		if (d[n] != 0) {
			return d[n] % 1000000009;
		} else {
			d[1] = 1;
			d[2] = 2;
			d[3] = 4;
			for (int i = 4; i <= n; i++) {
				d[i] = (d[i - 1] + d[i - 2] + d[i - 3]) % 1000000009;
			}
			return d[n] % 1000000009;
		}
	}

}
