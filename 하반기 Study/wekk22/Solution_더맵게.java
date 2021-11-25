package second.study.week22;

import java.io.IOException;
import java.util.*;

import sun.misc.Perf;

public class Solution_더맵게 {

	public static void main(String[] args) throws IOException {
		int n = 5;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };

		System.out.println(solution(n, results));
	}

	public static int solution(int n, int[][] results) {
		int answer = 0;
		boolean[][] adj = new boolean[n][n];
		boolean[] visited = new boolean[n];
		for (int i = 0; i < results.length; i++) {
			int a = results[i][0] - 1;
			int b = results[i][1] - 1;
			adj[a][b] = true;
		}

		for (int k = 0; k < n; k++) {
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					if (adj[y][k] && adj[k][x]) {
//        				System.out.println((y+1)+"가 "+(k+1)+"를 이겼고 "+(k+1)+"가"+(x+1)+"를 이겼다");
						adj[y][x] = true;
					}
				}
			}
		}
		for (int y = 0; y < n; y++) {
			int cnt = 0;
			for (int x = 0; x < n; x++) {
				boolean a = adj[y][x];
				boolean b = adj[x][y];

				if (a || b) {
//					if (a) {
//						System.out.println((y + 1) + "가 " + (x + 1) + "를 이겼다 ");
//					}
//					if (b) {
//						System.out.print((x + 1) + "가 " + (y + 1) + "를 이겼다 ");
//					}

					cnt++;
				}
			}
			if (cnt == n - 1)
				answer++;

		}

		return answer;
	}
}
