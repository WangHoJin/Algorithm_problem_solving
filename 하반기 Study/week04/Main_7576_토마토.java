package second.study.week04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	static int M, N, ans;
	static int[][] map;
	static ArrayList<Point> list;

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	// 방향 탐색
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/04/토마토.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		ans = -1;
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		// 익은 토마토 찾기
		findTomato(map);

		// 익은 토마토 bfs
		bfs();

		// 남은 안익은 토마토가 있으면 -1출력
		ans = lastTomato();

//		print(map);
		System.out.println(ans);
	}

	private static int lastTomato() {
		for (int[] y : map) {
			for (int x : y) {
				if (x == 0)
					return -1;
			}
		}
		return ans;
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			q.add(list.get(i));
		}
		while (!q.isEmpty()) {
			ans++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = temp.y + dy[d];
					int nx = temp.x + dx[d];
					if (!check(ny, nx) || map[ny][nx] != 0)
						continue;
					q.add(new Point(ny, nx));
					map[ny][nx] = 1;
				}
			}
		}

	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < M)
			return true;
		return false;
	}

	private static void findTomato(int[][] map) {
		boolean flag = false;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (map[y][x] == 1) {
					list.add(new Point(y, x));
				}
//            if(!flag)
//            else if(map[y][x] == 0) {
//               flag = true;
//            }
			}
		}

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