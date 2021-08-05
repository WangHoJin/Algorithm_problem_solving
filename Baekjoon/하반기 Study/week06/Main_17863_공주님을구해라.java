import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17863_공주님을구해라 {
	static int N, M, T, ans;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static class Point {
		int y, x, gram;

		public Point(int y, int x, int gram) {
			super();
			this.y = y;
			this.x = x;
			this.gram = gram;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/06/공주님을구해라.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		int[][] map;
		boolean[][][] visited;
		map = new int[N][M];
		visited = new boolean[N][M][2];
		ans = -1;
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(map, visited);
		print(map);
		System.out.println(ans == -1 ? "Fail" : ans);
	}

	private static void bfs(int[][] map, boolean[][][] visited) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0));
		visited[0][0][0] = true;

		int time = 0;
		while (!q.isEmpty()) {
			if (time >= N * M)
				break;
			int size = q.size();
			time++;
			for (int i = 0; i < size; i++) {
				Point temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = temp.y + dy[d];
					int nx = temp.x + dx[d];
					int ng = temp.gram;
					if (!check(ny, nx) || (map[ny][nx] == 1 && ng == 0) || (visited[ny][nx][ng]))
						continue;
					if (ny == N - 1 && nx == M - 1) {
						ans = time;
						return;
					}
					if (map[ny][nx] == 2)
						ng = 1;
					q.add(new Point(ny, nx, ng));
					visited[ny][nx][ng] = true;

				}
			}
		}

	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < M)
			return true;
		return false;
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
