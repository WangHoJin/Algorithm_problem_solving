package com.swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_농장물수확하기2 {
	static int T, N, result;
	static char[][] farm;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			farm = new char[N][N];
			result = 0;
			for (int y = 0; y < N; y++) {
				farm[y] = in.readLine().toCharArray();
			}

			// 풀이
			// 다이아몬드 모양으로 탐색하면서 해당값 더해주면 끝
			int cnt = 0;
			// y축 반복
			for (int y = 0; y < N; y++) {
				// x축은 홀수니까 중간값을 기준으로 cnt값을 양옆에 더하고 빼준다.
				for (int x = N / 2 - cnt; x <= N / 2 + cnt; x++) {
					result += farm[y][x] - '0';
				}
				// y축 기준으로 절반 cnt++
				if (y < N / 2)
					cnt++;
				// y축 기준으로 절반이 넘어가면 반대로 cnt--
				else if (y >= N / 2) {
					cnt--;
				}
			}

			// 출력
			System.out.println("#" + t + " " + result);
		}
	}
}
