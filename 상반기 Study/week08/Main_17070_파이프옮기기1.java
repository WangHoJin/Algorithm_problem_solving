package ssafy.study.week08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	static int N, ans;
	static int[][] map;
	static int[] dy = { 0, 1, 1 };
	static int[] dx = { 1, 1, 0 };

	static class Point {
		int y, x, dir;

		public Point(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/파이프옮기기1.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		map[0][0] = 1;
		map[0][1] = 1;
		dfs(0, 1, 0);
		System.out.println(ans);
//		print();
	}

	private static void dfs(int y, int x, int dir) {
		if (y == N - 1 && x == N - 1) {
			ans++;
			return;
		}

		if (dir == 0) {
			for (int d = 0; d < 2; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (!check(ny, nx) || map[ny][nx] == 1)
					continue;
				if (d == 1 && (map[y][x + 1] == 1 || map[y + 1][x] == 1))
					continue;
				dfs(ny, nx, d);
			}
		} else if (dir == 2) {
			for (int d = 1; d < 3; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (!check(ny, nx) || map[ny][nx] == 1)
					continue;
				if (d == 1 && (map[y][x + 1] == 1 || map[y + 1][x] == 1))
					continue;
				dfs(ny, nx, d);
			}
		} else {
			for (int d = 0; d < 3; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (!check(ny, nx) || map[ny][nx] == 1)
					continue;
				if (d == 1 && (map[y][x + 1] == 1 || map[y + 1][x] == 1))
					continue;
				dfs(ny, nx, d);
			}
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= N || nx < 0 || nx >= N)
			return false;
		return true;
	}

	private static void print() {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		System.out.println("============================");
	}
}
