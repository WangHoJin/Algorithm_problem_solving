package ssafy.study.week12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	static int N, M, red_y, red_x, blue_y, blue_x, end_y, end_x, ans;
	static char[][] map;
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static ArrayList<Point> list;

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/구슬탈출2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int y = 0; y < N; y++) {
			String str = in.readLine();
			for (int x = 0; x < M; x++) {
				map[y][x] = str.charAt(x);
				if (map[y][x] == 'R') {
					red_y = y;
					red_x = x;
				} else if (map[y][x] == 'B') {
					blue_y = y;
					blue_x = x;
				} else if (map[y][x] == 'O') {
					end_y = y;
					end_x = x;
				}
			}
		}

		bfs(new boolean[N][M]);
		System.out.println(ans);
//		print();

	}

	private static void bfs(boolean[][] v) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(red_y, red_x));
		q.add(new Point(blue_y, blue_x));
		int cnt = 1;
		while (cnt <= 10) {
			int size = q.size();
			for (int i = 0; i < size / 2; i++) {
				Point red = q.poll();
				Point blue = q.poll();
				for (int d = 0; d < 4; d++) {
					int ry = red.y + dy[d];
					int rx = red.x + dx[d];
					int by = blue.y + dy[d];
					int bx = blue.x + dx[d];

					while (true) {
						if (map[ry][rx] == '#') {
							ry -= dy[d];
							rx -= dx[d];
							break;
						}
						if (map[ry][rx] == 'O') {
							ans = cnt;
							break;
						}
						ry += dy[d];
						rx += dx[d];
					}

					while (true) {
						if (map[by][bx] == '#') {
							by -= dy[d];
							bx -= dx[d];
							break;
						}
						if (map[by][bx] == 'O') {
							ans = -1;
							break;
						}
						by += dy[d];
						bx += dx[d];
					}

					if (by == end_y && bx == end_x) {
						continue;
					}

					if (rx == bx && ry == by) {
						switch (d) {
						case 0:
							if (red.y > blue.y)
								ry++;
							else
								by++;
							break;
						case 1:
							if (red.y > blue.y)
								by--;
							else
								ry--;
							break;
						case 2:
							if (red.x > blue.x)
								rx++;
							else
								bx++;
							break;
						case 3:
							if (red.x > blue.x)
								bx--;
							else
								rx--;
							break;
						}

					}
//					if (v[ry][rx])
//						continue;

					if (ry == end_y && rx == end_x) {
						ans = cnt;
						return;
					}
//					v[ry][rx] = true;
					q.add(new Point(ry, rx));
					q.add(new Point(by, bx));
				}

			}
			cnt++;
		}
		ans = -1;
	}

	private static void move(int ry, int rx, int d) {
		// TODO Auto-generated method stub

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
