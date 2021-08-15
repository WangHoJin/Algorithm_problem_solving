package ssafy.study.week08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20056_마법사상어와파이어볼 {
	static int N, M, K, ans;
	static int[][] map;
	static Point[][] fire;
	static int[][] dMap;
	static int[][] sMap;
	static boolean[][] visited;
	static Queue<Point> fb;

	static class Point {
		int y, x, m, s, d, cnt;
		boolean eo;
		public Point(int y, int x, int m, int s, int d, int cnt, boolean eo) {
			super();
			this.y = y;
			this.x = x;
			this.m = m;
			this.s = s;
			this.d = d;
			this.cnt = cnt;
			this.eo = eo;
		}

		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + ", m=" + m + ", s=" + s + ", d=" + d + ", cnt=" + cnt + "]";
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
		fire = new Point[N][N];
		visited = new boolean[N][N];
		fb = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fb.add(new Point(r, c, m, s, d, 1,true));
			map[r][c] = 1;
		}

//		print();
		fbShot();
		countFire();
		System.out.println(ans);

//		printFire();
	}

	private static void countFire() {
		while (!fb.isEmpty()) {
			Point temp = fb.poll();
			ans += temp.m;
		}
	}

	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

	private static void fbShot() {
		int cnt = 0;
		while (!fb.isEmpty()) {
			if (cnt == K) {
//				System.out.println(fb.size());
				break;
			}
			int size = fb.size();
			for (int i = 0; i < size; i++) {
				Point temp = fb.poll();
				int ny = temp.y + dy[temp.d] * temp.s;
				int nx = temp.x + dx[temp.d] * temp.s;
				if (!check(ny, nx)) {
					ny = (N*1001 + ny) % N;
					nx = (N*1001 + nx) % N;
				}
				if (fire[ny][nx] == null) {
					fire[ny][nx] = new Point(ny, nx, 0, 0, 0, 0, true);
				}
				map[temp.y][temp.x] = 0;
				fire[ny][nx].m += temp.m;
				fire[ny][nx].s += temp.s;
				fire[ny][nx].d += temp.d;
				fire[ny][nx].cnt += temp.cnt;
				map[ny][nx] += temp.cnt; 
				if (fire[ny][nx].cnt >= 2) {
					if(fire[ny][nx].d %2 != 0) {
						fire[ny][nx].eo = false;
					}
					continue;
				}
				fb.add(new Point(ny, nx, temp.m, temp.s, temp.d, temp.cnt,true));
			}
			// 파이어볼 분해
			size = fb.size();
			for (int i = 0; i < size; i++) {
				Point temp = fb.poll();
				if (fire[temp.y][temp.x].cnt == 1) {
					fire[temp.y][temp.x].m = 0;
					fire[temp.y][temp.x].s = 0;
					fire[temp.y][temp.x].d = 0;
					fire[temp.y][temp.x].cnt = 0;
					fire[temp.y][temp.x].eo = true;
					fb.add(temp);
					continue;
				}
				int nm = fire[temp.y][temp.x].m / 5;
				int ns = fire[temp.y][temp.x].s / fire[temp.y][temp.x].cnt;
				boolean nd = fire[temp.y][temp.x].eo;
				if (nm == 0) {
					map[temp.y][temp.x] = nm;
					continue;
				}
				if (nd) {
					for (int d = 0; d < 8; d += 2) {
						fb.add(new Point(temp.y, temp.x, nm, ns, d, 1,true));
						map[temp.y][temp.x] += nm;
					}
				} else {
					for (int d = 1; d < 8; d += 2) {
						fb.add(new Point(temp.y, temp.x, nm, ns, d, 1,true));
						map[temp.y][temp.x] += nm;
					}
				}
				fire[temp.y][temp.x].m = 0;
				fire[temp.y][temp.x].s = 0;
				fire[temp.y][temp.x].d = 0;
				fire[temp.y][temp.x].cnt = 0;
				fire[temp.y][temp.x].eo = true;
			}
			cnt++;
			System.out.println(cnt + "초 후~~~~~~~~~~~~~~~~~~~~~~~");
			print();
		}
	}

	private static void printFire() {
		for (Point point : fb) {
			System.out.println(point);
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
