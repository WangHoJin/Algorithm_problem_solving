package ssafy.study.week11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16929_TwoDots {
	static int N, M, sy, sx;
	static char[][] map;
	static boolean ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/TwoDots.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int y = 0; y < N; y++) {
			map[y] = in.readLine().toCharArray();
		}
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				sy = y;
				sx = x;
				dfs(y, x, 1, new boolean[N][M]);
			}
		}
		System.out.println(ans ? "Yes" : "No");
//		print();
	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	private static void dfs(int y, int x, int cnt, boolean[][] v) {
		v[y][x] = true;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (cnt >= 4 && sy == ny && sx == nx) {
				ans = true;
				return;
			}
			if (!check(ny, nx) || map[ny][nx] != map[y][x] || v[ny][nx])
				continue;
			if (ans)
				return;
			v[ny][nx] = true;
			dfs(ny, nx, cnt + 1, v);
			v[ny][nx] = false;
		}

	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= N || nx < 0 || nx >= M)
			return false;
		return true;
	}

	private static void print() {
		for (char[] y : map) {
			for (char x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}
}
