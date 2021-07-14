package ssafy.study.week12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import jdk.net.NetworkPermission;

public class Main_1445_일요일아침의데이트 {
	static int N, M, ans1, ans2;
	static char[][] map;
	static int[][] SG;
	static boolean[][] v;
	static PriorityQueue<Point> pq;
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	static class Point implements Comparable<Point> {
		int y, x, gar, sideGar;

		public Point(int y, int x, int gar, int sideGar) {
			super();
			this.y = y;
			this.x = x;
			this.gar = gar;
			this.sideGar = sideGar;
		}

		@Override
		public int compareTo(Point o) {
			if (this.gar == o.gar)
				return this.sideGar - o.sideGar;
			return this.gar - o.gar;
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/일요일아침의데이트.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		SG = new int[N][M];
		pq = new PriorityQueue<>();
		v = new boolean[N][M];
		int start_y = 0, start_x = 0;
		for (int y = 0; y < N; y++) {
			String str = in.readLine();
			for (int x = 0; x < M; x++) {
				char c = str.charAt(x);
				map[y][x] = c;
				if (c == 'S') {
					start_y = y;
					start_x = x;
				} else if (c == 'g') {
					for (int d = 0; d < 4; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						if (!check(ny, nx))
							continue;
						SG[ny][nx]=1;
					}
				}
			}
		}
		bfs(start_y, start_x);
//		print();
		System.out.println(ans1 + " " + ans2);
	}

	private static void bfs(int y, int x) {
		pq.add(new Point(y, x, 0, 0));
		v[y][x] = true;
		while (!pq.isEmpty()) {
			Point temp = pq.poll();
			for (int d = 0; d < 4; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				if (!check(ny, nx) || v[ny][nx])
					continue;
				if (map[ny][nx] == 'F') {
					ans1 = temp.gar;
					ans2 = temp.sideGar;
					return;
				}
				if (map[ny][nx] == 'g') {
					pq.add(new Point(ny, nx, temp.gar + 1, temp.sideGar));
				} else
					pq.add(new Point(ny, nx, temp.gar, temp.sideGar + SG[ny][nx]));
				v[ny][nx] = true;
			}

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
	}
}
