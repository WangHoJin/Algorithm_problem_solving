package com.swea.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	static int T, N;
	static int[][] point;
	static int disMin;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine()) + 2;
			point = new int[N][2];
			disMin = Integer.MAX_VALUE;
			st = new StringTokenizer(in.readLine(), " ");
			point[0][0] = Integer.parseInt(st.nextToken());
			point[0][1] = Integer.parseInt(st.nextToken());
			point[N - 1][0] = Integer.parseInt(st.nextToken());
			point[N - 1][1] = Integer.parseInt(st.nextToken());
			for (int i = 1; i < N - 1; i++) {
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
			}
			permutation(1, new int[N][2], new boolean[N]);
			System.out.println("#" + t + " " + disMin);
		}
	}

	private static void permutation(int k, int[][] sel, boolean[] visited) {
		if (k == N - 1) {
			int dis = 0;
			for (int i = 1; i < N; i++) {
				dis += Math.abs(sel[i - 1][0] - sel[i][0]) + Math.abs(sel[i - 1][1] - sel[i][1]);
			}
			disMin = (disMin > dis) ? dis : disMin;
			return;
		}
		sel[0][0] = point[0][0];
		sel[0][1] = point[0][1];
		sel[N - 1][0] = point[N - 1][0];
		sel[N - 1][1] = point[N - 1][1];
		for (int i = 1; i < N - 1; i++) {
			if (!visited[i]) {
				sel[k][0] = point[i][0];
				sel[k][1] = point[i][1];
				visited[i] = true;
				permutation(k + 1, sel, visited);
				visited[i] = false;
			}
		}
	}
}
