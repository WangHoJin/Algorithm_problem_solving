package ssafy.study.week08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20056_마법사상어와파이어볼2 {
	static int N, M, K, ans;
	static int[][] map;
	static Queue<Point> fb[][];

	static class Point {
		int y, x, m, s, d;

		public Point(int y, int x, int m, int s, int d) {
			super();
			this.y = y;
			this.x = x;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/마법사상어와파이어볼.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		fb = new LinkedList[N + 1][N + 1];
		fb[N][N] = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fb[N][N].add(new Point(r, c, m, s, d));
			map[r][c] = 1;
		}
		print();
		fbShot();
		countFire();
		System.out.println(ans);

//		printFire();
	}

	private static void countFire() {
		while (!fb[N][N].isEmpty()) {
			Point temp = fb[N][N].poll();
			ans += temp.m;
		}
	}

	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

	private static void fbShot() {
		int cnt = 0;
		while (!fb[N][N].isEmpty()) {
			if (cnt == K) {
//				System.out.println(fb.size());
				break;
			}
			int size = fb[N][N].size();
			for (int i = 0; i < size; i++) {
				Point temp = fb[N][N].poll();
				int ny = temp.y + dy[temp.d] * temp.s;
				int nx = temp.x + dx[temp.d] * temp.s;
				int nm = temp.m;
				int ns = temp.s;
				int nd = temp.d;
				if (!check(ny, nx)) {
					ny = (N * 1001 + ny) % N;
					nx = (N * 1001 + nx) % N;
				}
				if (fb[ny][nx] == null) {
					fb[ny][nx] = new LinkedList<>();
				}
				map[temp.y][temp.x] = 0;
				if (fb[ny][nx].size() == 0) {
					fb[ny][nx].add(new Point(ny, nx, nm, ns, nd));
					fb[N][N].add(new Point(ny, nx, nm, ns, nd));
					map[ny][nx] = 1;
					continue;
				}
				fb[ny][nx].add(new Point(ny, nx, nm, ns, nd));
//				fb[N][N].add(new Point(ny, nx, nm, ns, nd));
				map[ny][nx]++;
			}
			// 파이어볼 분해
			size = fb[N][N].size();
			for (int i = 0; i < size; i++) {
				Point temp = fb[N][N].poll();
				int ny = temp.y;
				int nx = temp.x;
				int nm = temp.m;
				int ns = temp.s;
				int nd = temp.d;
				if (fb[ny][nx].size() == 1) {
					fb[N][N].add(fb[ny][nx].poll());
					continue;
				}
				// 겹쳐지면
				int nnm = 0;
				int nns = 0;
				int nnd = 0;
				boolean flag = true;
				int fbsize = fb[ny][nx].size();
				while (!fb[ny][nx].isEmpty()) {
					Point p = fb[ny][nx].poll();
					nnm += p.m;
					nnd += p.d;
					if (nns != 0 && nnd % 2 != 0)
						flag = false;
					nns += p.s;
				}
				nnm = nnm / 5;
				nns = nns / fbsize;
				if (nnm == 0) {
					continue;
				}
				if (flag) {
					for (int d = 0; d < 8; d += 2) {
						fb[N][N].add(new Point(ny, nx, nnm, nns, d));
					}
				} else {
					for (int d = 1; d < 8; d += 2) {
						fb[N][N].add(new Point(ny, nx, nnm, nns, d));
					}
				}

			}
			cnt++;
			System.out.println(cnt + "초 후~~~~~~~~~~~~~~~~~~~~~~~");
			print();
		}
	}

	private static void print() {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		System.out.println("==================");
	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= N || nx < 0 || nx >= N)
			return false;
		return true;
	}

}
