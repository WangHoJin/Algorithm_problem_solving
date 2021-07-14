package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
	static int N, start, ans;
	static boolean[][] matrix;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			matrix = new boolean[101][101];
			ans = 0;
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				matrix[a][b] = true;
			}

			bfs(new boolean[101]);
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void bfs(boolean[] v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		v[start] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			ans = 0;
			for (int i = 0; i < size; i++) {
				int temp = q.poll();
				ans = Math.max(ans, temp);
				for (int n = 1; n < 101; n++) {
					if (v[n])
						continue;
					if (matrix[temp][n]) {
						q.add(n);
						v[n] = true;
					}
				}
			}
		}
	}

}
