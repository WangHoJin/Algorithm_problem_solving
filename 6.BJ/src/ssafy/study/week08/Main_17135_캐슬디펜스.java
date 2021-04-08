package ssafy.study.week08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	static int N, M, D, ans, max;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] visited2;
	static int[] dy = { 0, -1, 0 };
	static int[] dx = { -1, 0, 1 };
	static Queue<Point> enemy;
	static Queue<Point> enemy2;
	static Queue<Point> archer;

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/캐슬디펜스.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		visited = new boolean[N][M];
		visited2 = new boolean[N][M];
		archer = new LinkedList<>();
		enemy = new LinkedList<>();
		enemy2 = new LinkedList<>();
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

//		defence(0, 3, new int[3]);
		defence(0, 0, new int[3]);
		System.out.println(max);

	}

	private static void defence(int start, int cnt, int[] sel) {
//		sel[0] = 1;
//		sel[1] = 3;
//		sel[2] = 4;

		// 궁수를 배치한다
		if (cnt == 3) {
//			System.out.println(Arrays.toString(sel));
			ans = 0;
			int archerY = N;
			visited = new boolean[N][M];
			visited2 = new boolean[N][M];
			while (true) {
				if (archerY == 0)
					break;
				// 적을 제거한다.
				attack(sel, archerY);
				delete();
//				print();
				visited2 = new boolean[N][M];
				max = Math.max(ans, max);
				archerY--;
			}
			revive();
//			System.out.println(ans);
			return;
		}
		if (start == M) {
			return;
		}

		sel[cnt] = start;
		defence(start + 1, cnt + 1, sel);

		defence(start + 1, cnt, sel);

	}

	private static void revive() {
		while (!enemy2.isEmpty()) {
			Point temp = enemy2.poll();
			map[temp.y][temp.x] = 1;

		}

	}

	private static void delete() {
		while (!enemy.isEmpty()) {
			Point temp = enemy.poll();
			map[temp.y][temp.x] = 0;
			enemy2.add(new Point(temp.y, temp.x));
		}
	}

	private static void attack(int[] sel, int size) {
		Queue<Point> q = new LinkedList<>();
		for (int s = 0; s < sel.length; s++) {
			int sy = size;
			int sx = sel[s];
			q.add(new Point(sy, sx));
			visited2 = new boolean[N][M];
			int dis = 0; // 공격 사거리
			L: while (!q.isEmpty()) {
				// 공격 사거리만큼만 탐색
				if (dis == D) {
					while (!q.isEmpty()) {
						Point qq = q.poll();
						if (check(qq.y, qq.x))
							visited2[qq.y][qq.x] = false;
					}
					break;
				}
				int qSize = q.size();
				for (int i = 0; i < qSize; i++) {
					Point temp = q.poll();
					for (int d = 0; d < 3; d++) {
						int ny = temp.y + dy[d];
						int nx = temp.x + dx[d];
						// 범위를 벗어나거나 적(1)이 아닌데 방문을 했으면 continue
						if (!check(ny, nx) || ny == size || visited2[ny][nx])
							continue;
						// 적(1)을 발견하면 적의 좌표를 저장하고 방문체크
						if (map[ny][nx] == 1) {
							if (!visited[ny][nx]) {
								enemy.add(new Point(ny, nx));
//								System.out.println(size + "단계 => 적 좌표 y:" + ny + ", x:" + nx);
								ans++;
								visited[ny][nx] = true;
							}
							while (!q.isEmpty()) {
								Point qq = q.poll();
								if (check(qq.y, qq.x))
									visited2[qq.y][qq.x] = false;
							}
							break L;
						}
						// 빈칸(0)이면 계속 탐색
						q.add(new Point(ny, nx));
						visited2[ny][nx] = true;
					}
				}
				dis++;
			}
//		print();
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
		System.out.println("====================");
	}
}
