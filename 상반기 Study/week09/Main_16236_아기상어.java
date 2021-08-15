package ssafy.study.week09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	static int N, eatCnt, ans;
	static int[][] map;
	static Queue<Point> shark;
	static Point start;
	static boolean momFlag;

	static class Point {
		int y, x, size;

		public Point(int y, int x, int size) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/아기상어.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		shark = new LinkedList<>();

		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < N; x++) {
				int a = Integer.parseInt(st.nextToken());
				map[y][x] = a;
				if (a == 9) {
					start = new Point(y, x, 2);
					map[y][x] = 0;
				}
			}
		}
		while (!momFlag) {
			momFlag = true;
			play(new boolean[N][N]);
//			System.out.println(start.size + ", 이동 거리 : " + ans);
//			print();
		}
		System.out.println(ans);
	}

	static int[] dy = { -1, 0, 0, 1 }; // 상좌우하
	static int[] dx = { 0, -1, 1, 0 };

	private static void play(boolean[][] v) {
		shark.add(start);
		v[start.y][start.x] = true;
		int cnt = 0;
		while (!shark.isEmpty()) {
			int qSize = shark.size();
			ArrayList<Point> fish = new ArrayList<>();
			cnt++;
			for (int i = 0; i < qSize; i++) {
				Point temp = shark.poll();
				for (int d = 0; d < 4; d++) {
					int ny = temp.y + dy[d];
					int nx = temp.x + dx[d];
					int ns = temp.size;
					if (!check(ny, nx) || ns < map[ny][nx] || v[ny][nx])
						continue;
					if (map[ny][nx] != 0 && ns > map[ny][nx]) {
						fish.add(new Point(ny, nx, ns));
						momFlag = false;
						continue;
					}
					shark.add(new Point(ny, nx, ns));
					v[ny][nx] = true;
				}
			}
			// 먹이 우선순위 위->왼
			if (!momFlag) {
				int ey = Integer.MAX_VALUE;
				int ex = Integer.MAX_VALUE;
				int es = fish.get(0).size;
				for (int i = 0; i < fish.size(); i++) {
					if (ey >= fish.get(i).y) {
						if (ey == fish.get(i).y) {
							if (ex > fish.get(i).x) {
								ey = fish.get(i).y;
								ex = fish.get(i).x;
							}
						} else {
							ey = fish.get(i).y;
							ex = fish.get(i).x;
						}
					}
				}
				eatCnt++;
//				System.out.print("잡아먹은 물고기 위치 : " + ey + "," + ex + " 상어 크기 변화 : " + es + " => ");
				if (eatCnt == es) {
					es++;
					eatCnt = 0;
				}
				map[ey][ex] = 0;
				start = new Point(ey, ex, es);
				ans += cnt;
				shark.clear();
				return;
			}

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
		System.out.println("===================");
	}
}
