package ssafy.study.week13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_20615_인내의도미노장인호석 {
	static int N, M, R, ans;
	static int[][] map;
	static char[][] result;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/13/도미노.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		result = new char[N][M];
		// 도미노 입력
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				result[y][x] = 'S';
			}
		}

		// 공수 입력
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			// 공격할 위치
			int ay = Integer.parseInt(st.nextToken()) - 1;
			int ax = Integer.parseInt(st.nextToken()) - 1;
			// 넘어뜨릴 방향
			int dir = dirToint(st.nextToken());

			// 초기 도미노의 상태와 점수
			result[ay][ax] = 'F';
			ans++;

			attack(ay, ax, dir); // 공격 함수
//			System.out.println(ans); // 중간 확인

			st = new StringTokenizer(in.readLine(), " ");
			// 수비할 위치
			int dy = Integer.parseInt(st.nextToken()) - 1;
			int dx = Integer.parseInt(st.nextToken()) - 1;

			defence(dy, dx); // 수비 함수
		}

		System.out.println(ans);
		System.out.println(print().toString());
	}

	private static void attack(int ay, int ax, int d) {
		int K = map[ay][ax]; // 도미노 길이
		// 길이가 1이거나 범위를 벗어나면 연쇄가 일어나지 않음
		if (K == 1 || !check(ay, ax))
			return;
		// K-1개의 도미노중에 넘어질 도미노 탐색
		for (int i = 1; i < K; i++) {
			int ny = ay + dy[d] * i;
			int nx = ax + dx[d] * i;
			// 범위를 벗어나면 해당 도미노는 탐색 중지
			if (!check(ny, nx))
				break;
			// 쓰러져 있으면 아무일 일어나지않음
			if (result[ny][nx] == 'F')
				continue;

			result[ny][nx] = 'F'; // 해당 도미노는 쓰러짐
			ans++; // 공격 점수 획득
			// 연쇄작용 => 재귀
			attack(ny, nx, d);
		}

	}

	private static void defence(int dy, int dx) {
		result[dy][dx] = 'S';
	}

	private static int dirToint(String dir) {
		int result = 0;
		switch (dir) {
		case "E":
			result = 0;
			break;
		case "W":
			result = 1;
			break;
		case "S":
			result = 2;
			break;
		case "N":
			result = 3;
			break;
		default:
			break;
		}
		return result;
	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= N || nx < 0 || nx >= M)
			return false;
		return true;
	}

	private static StringBuilder print() {
		StringBuilder sb = new StringBuilder();
		for (char[] y : result) {
			for (char x : y) {
				sb.append(x).append(" ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		return sb;
	}
}
