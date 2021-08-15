package ssafy.study.week15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17825_주사위윷놀이 {
	static int ans;
	// 10:5번째 20:10번재 30:15번째
	static int[] dice;
	static int[] b1 = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0 };
	static int[] b2 = { 0, 0, 0, 0, 0, 00, 00, 00, 00, 00, 00, 00, 00, 10, 13, 16, 19, 25, 30, 35, 40, 0 };
	static int[] b3 = { 0, 0, 0, 0, 0, 00, 00, 00, 00, 00, 00, 00, 00, 00, 20, 22, 24, 25, 30, 35, 40, 0 };
	static int[] b4 = { 0, 0, 0, 0, 0, 00, 00, 00, 00, 00, 00, 00, 00, 30, 28, 27, 26, 25, 30, 35, 40, 0 };

	static int[] visited;


	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/15/주사위윷놀이.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		dice = new int[10];
		visited = new int[4];

		for (int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(b1.length);
		dfs(0, new int[4], 0, visited);
		System.out.println(ans);

	}

	private static void dfs(int cnt, int[] idx, int sum, int[] v) {
		if (cnt == 3) {
			ans = Math.max(ans, sum);
			return;
		}
		for (int i = 0; i < 3; i++) {
			idx[i] += dice[cnt];
			if (idx[i] > 21)
				idx[i] = 21;
			if (v[i] == idx[i])
				continue;
			v[i] = idx[i];
			if (idx[i] == 5) {
				idx[i] = 13;
				dfs(cnt + 1, idx, sum + b2[idx[i]], v);

			} else if (idx[i] == 10) {
				idx[i] = 14;
				dfs(cnt + 1, idx, sum + b3[idx[i]], v);

			} else if (idx[i] == 15) {
				idx[i] = 13;
				dfs(cnt + 1, idx, sum + b4[idx[i]], v);

			} else {
				dfs(cnt + 1, idx, sum + b1[idx[i]], v);

			}
			idx[i] -= dice[cnt];
		}

	}

	private static void print(int[][] map) {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
}
