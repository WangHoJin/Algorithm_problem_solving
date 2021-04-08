package ssafy.study.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057_마법사상어와토네이도 {
	static int N, ans, cy, cx;
	static int[][] map;
	static int[][] ratio = { { 0, 0, 2, 0, 0 }, { 0, 10, 7, 1, 0 }, { 5, 100, 0, 0, 0 }, { 0, 10, 7, 1, 0 },
			{ 0, 0, 2, 0, 0 } };
//	static ArrayList<Integer> dir;
	static int[] dir = { 0, 1, 2, 2, 3, 3, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 0, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/마법사상어와토네이도.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		// 방향 배열 만들기
		makeDir();
		// 가운데 좌표
		cy = N / 2;
		cx = N / 2;

		tornado();

		print();
	}

	private static void tornado() {
		int ny = cy;
		int nx = cx;
		for (int d = 0; d < dir.length; d++) {
			int py = ny;
			int px = nx;
			ny = ny + dy[d];
			nx = nx + dx[d];
			applyRatio(ny, nx, py, px);
			print();
		}
	}

	private static void applyRatio(int next_y, int next_x, int curr_y, int curr_x) {
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				int ny = next_y - 2 + y;
				int nx = next_x - 2 + x;
				int value = (int) (map[next_y][next_x] * (ratio[y][x] / 100.0));
				if(!check(ny, nx)) continue;
				map[ny][nx] += value;
			}
		}
	}

	private static void makeDir() {

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
