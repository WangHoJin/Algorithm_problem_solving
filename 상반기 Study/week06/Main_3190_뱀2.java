package ssafy.study.week06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190_뱀2 {
	static int N, K, L, ans; // 보드의 크기, 사과의 개수, 방향 변환 횟수
	static int[][] map; // 맵
	static int[] dy = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int[] dx = { 1, 0, -1, 0 };
	static Queue<Point> TD;
	static Queue<Point> snake;

	static class Point {
		int y, x, time, d;

		public Point(int y, int x, int time, int d) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/뱀.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		K = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			map[y][x] = 1;
		}
		L = Integer.parseInt(in.readLine());
		TD = new LinkedList<>();
		snake = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			TD.add(new Point(0, 0, Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
		}
		play(0, 0, 0, 0);
		snake.add(new Point(0, 0, 0, 0));
		System.out.println(ans);
//		print();
	}

	private static void play(int y, int x, int time,int dir) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		int size = snake.size();
		for (int i = 0; i < size; i++) {
			
				snake.add(new Point(ny, nx, time+1, dir));

		}
		map[ny][nx] = 2;
		play(ny, nx, dir, time+1);
	

	}

	private static void print() {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------");
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < N)
			return true;
		return false;
	}
}
