package ssafy.study.week07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16918_봄버맨 {
	static int R, C, N;
	static char[][] map;
	static char[][] fillMap;
	static char[][] map3;
	static char[][] map4;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static Queue<Point> bomb;

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/봄버맨.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		bomb = new LinkedList<>(); // 폭탄을 담을 큐
		for (int y = 0; y < R; y++) {
			String s = in.readLine();
			for (int x = 0; x < C; x++) {
				char c = s.charAt(x);
				map[y][x] = c; // 초기상태를 입력
				if (c == 'O') {
					bomb.add(new Point(y, x)); // 폭탄 좌표 저장
				}
			}
		}
		int time = N % 4;
		// 시간에 따른 결과 배열을 출력
		// 1초 후 : map(초기상태)
		// 3초 후 : map(폭탄이 터진 후 상태)
		// 2초,4초 후 : map(모두 폭탄으로 채워져있는 상태)
		// 5초 후 : map(폭탄이 터진 후 상태)
		while (true) {
			// 초기상태는 예외처리
			if (N == 1) {
				print(map);
				break;
			}

			fillBomb(map);
			if (time == 0 || time == 2) {
				print(map);
				break;
			}
			playBomb(map);
			if (time == 3) {
				print(map);
				break;
			}
			findBomb(map);
			fillBomb(map);
			playBomb(map);
			if (time == 1) {
				print(map);
				break;
			}
		}
	}

	private static void fillBomb(char[][] map) {
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				if (map[y][x] == '.')
					map[y][x] = 'O';
			}
		}
	}

	private static void playBomb(char[][] map) {
		while (!bomb.isEmpty()) {
			Point temp = bomb.poll();
			map[temp.y][temp.x] = '.';
			for (int d = 0; d < 4; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				if (!check(ny, nx) || map[ny][nx] == '.')
					continue;
				map[ny][nx] = '.';
			}
		}
	}

	private static void findBomb(char[][] map) {
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				if (map[y][x] == 'O')
					bomb.add(new Point(y, x));
			}
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= R || nx < 0 || nx >= C)
			return false;
		return true;
	}

	private static void print(char[][] map) {
		StringBuilder sb = new StringBuilder();
		for (char[] y : map) {
			for (char x : y) {
				sb.append(x);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
