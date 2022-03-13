package second.study.week37;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638_치즈 {

	static int N, M, ans;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> list;

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/37/치즈.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new LinkedList<>();

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < M; x++) {
				int num = Integer.parseInt(st.nextToken());
				map[y][x] = num;
			}
		}

		while (true) {
			visited = new boolean[N][M];
			// 외부공기와 내부공기 나누기
			findOutAir();
			if (list.size() == 0)
				break;
			// 치즈 삭제
			deleteCheese();
			ans++;
		}

		System.out.println(ans);
//		print(map);
	}

	private static void deleteCheese() {
		while (!list.isEmpty()) {
			Point temp = list.poll();
			map[temp.y][temp.x] = 0;
		}
	}

	private static void findOutAir() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (map[y][x] == 0 || !visited[y][x]) {
					bfs(y, x);
					return;
				}
			}
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
				if (!check(ny, nx) || (visited[ny][nx] && map[ny][nx] == 0))
					continue;
				if (map[ny][nx] >= 1) {
					if (!visited[ny][nx])
						map[ny][nx] = 1;
					map[ny][nx]++;
					visited[ny][nx] = true;
					if (map[ny][nx] > 2)
						list.add(new Point(ny, nx));
					continue;
				}
				q.add(new Point(ny, nx));
				visited[ny][nx] = true;
			}
		}

	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < M)
			return true;
		return false;
	}

	private static void print(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int[] y : map) {
			for (int x : y) {
				sb.append(x + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
