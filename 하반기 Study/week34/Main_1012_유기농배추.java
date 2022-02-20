package second.study.week34;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {

	static int T, M, N, K, ans;
	static boolean[][] map, visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/34/유기농배추.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new boolean[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				map[n][m] = true;
			}
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (visited[y][x] || !map[y][x])
						continue;
					bfs(y, x);
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	private static void bfs(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(y, x));
		visited[y][x] = true;
		while (!q.isEmpty()) {
			Point temp = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				if (check(ny, nx) || visited[ny][nx] || !map[ny][nx])
					continue;
				q.add(new Point(ny, nx));
				visited[ny][nx] = true;
			}
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= N || nx < 0 || nx >= M)
			return true;
		return false;
	}
}
