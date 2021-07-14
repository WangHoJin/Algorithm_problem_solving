package ssafy.study.week07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1986_체스 {
	static int N, M, ans;
	static int[][] map;
	static int[] ky = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] kx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/체스.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Queue<Point> Queen = new LinkedList<>(); // 퀸 저장할 큐
		Queue<Point> Knight = new LinkedList<>(); // 나이트 저장할 큐
		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				if (i == 1) {
					Queen.add(new Point(y, x)); // 퀸을 큐에 저장
					map[y][x] = i; // 퀸은 1로 표시
				} else if (i == 2) {
					Knight.add(new Point(y, x)); // 나이트를 큐에 저장
					map[y][x] = i; // 나이트는 2로 표시
				} else
					map[y][x] = i; // 폰은 3으로 표시
			}
		}
//		print();
		// 풀이
		// 퀸 이동 가능한 위치 찾는 함수
		queen(Queen);
		// 나이트 이동 가능한 위치 찾는 함수
		kight(Knight);
		// 안전한곳 카운트 함수
//		print();
		count();
		System.out.println(ans);
	}

	private static void kight(Queue<Point> Knight) {
		while (!Knight.isEmpty()) {
			Point temp = Knight.poll();
			// 나이트 범위에 해당하는 곳을 -1로 표시
			for (int d = 0; d < 8; d++) {
				int ny = temp.y + ky[d];
				int nx = temp.x + kx[d];
				if (!check(ny, nx))
					continue;
				map[ny][nx] = -1;
			}
		}
	}

	private static void queen(Queue<Point> Queen) {
		while (!Queen.isEmpty()) {
			Point temp = Queen.poll();
			// 퀸 범위에 해당하는 곳을 -1로 표시
			for (int d = 0; d < 8; d++) {
				int idx = 1;
				while (true) {
					int ny = temp.y + dy[d] * idx;
					int nx = temp.x + dx[d] * idx;
					// 움직일려는 곳에 장애물이 있으면 break
					if (!check(ny, nx) || map[ny][nx] > 0)
						break;
					map[ny][nx] = -1;
					idx++;
				}
			}
		}
	}

	private static void count() {
		for (int[] y : map) {
			for (int x : y) {
				// 0으로 표시된곳은 안전한곳
				if (x == 0)
					ans++;
			}
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= N || nx < 0 || nx >= M)
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
		System.out.println("=============================");
	}
}
