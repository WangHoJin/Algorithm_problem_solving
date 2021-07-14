package ssafy.study.week11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {
	static int N;
	static int[][] map, dis;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/젤다.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = 0;
		while (true) {
			++T;
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			dis = new int[N][N];
			if (N == 0)
				break;
			for (int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int x = 0; x < N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
					dis[y][x] = Integer.MAX_VALUE;
				}
			}

			Queue<Point> q = new LinkedList<>();
			q.add(new Point(0, 0));
			dis[0][0] = map[0][0];
			while (!q.isEmpty()) {
				Point temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = temp.y + dy[d];
					int nx = temp.x + dx[d];
					if (!check(ny, nx) || dis[ny][nx] <= dis[temp.y][temp.x] + map[ny][nx])
						continue;
					dis[ny][nx] = dis[temp.y][temp.x] + map[ny][nx];
					q.add(new Point(ny, nx));
				}

			}
			System.out.println("Problem " + T + ": " + dis[N - 1][N - 1]);
//		print();
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
	}

}
