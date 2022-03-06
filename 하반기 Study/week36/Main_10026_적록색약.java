package second.study.week36;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_적록색약 {

	static int N, ans1, ans2;
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/36/적록색약.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];

		for (int y = 0; y < N; y++) {
			map[y] = in.readLine().toCharArray();
		}
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (visited[y][x])
					continue;
				bfs(y, x);
				ans1++;
			}
		}
		visited = new boolean[N][N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (visited[y][x])
					continue;
				bfs2(y, x);
				ans2++;
			}
		}

		System.out.println(ans1 + " " + ans2);
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	private static void bfs(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(y, x));
		visited[y][x] = true;
		while (!q.isEmpty()) {
			Point temp = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				if (!check(ny, nx) || map[temp.y][temp.x] != map[ny][nx] || visited[ny][nx])
					continue;
				q.add(new Point(ny, nx));
				visited[ny][nx] = true;
			}
		}

	}

	private static void bfs2(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(y, x));
		visited[y][x] = true;
		while (!q.isEmpty()) {
			Point temp = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				if (!check(ny, nx) || visited[ny][nx])
					continue;
				if (map[temp.y][temp.x] == 'B' && map[ny][nx] == 'B') {
					q.add(new Point(ny, nx));
					visited[ny][nx] = true;
				} else if (map[temp.y][temp.x] != 'B' && map[ny][nx] != 'B') {
					q.add(new Point(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}

	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < N)
			return true;
		return false;
	}

}
