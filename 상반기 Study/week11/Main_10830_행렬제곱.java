package ssafy.study.week11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10830_행렬제곱 {
	static int N;
	static long B;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/행렬제곱.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		map = new int[N][N];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] rs = pow(B, map);
		System.out.println(print(rs).toString());

	}

	private static int[][] pow(long b, int[][] map) {
		if (b == 1) {
			return map;
		}
		if (b % 2 == 0) {
			int[][] map1 = pow(b / 2, map);
			return gob(map1, map1);
		} else {
			int[][] map2 = pow((b - 1), map);
			return gob(map, map2);
		}
	}

	private static int[][] gob(int[][] map1, int[][] map2) {
		int[][] rs = new int[N][N];
		for (int y = 0; y < N; y++) {
			for (int y2 = 0; y2 < N; y2++) {
				for (int x = 0; x < N; x++) {
					rs[y][y2] += (map1[y][x] * map2[x][y2])% 1000;
				}
				rs[y][y2] %= 1000;
			}
		}
		return rs;
	}

	private static StringBuilder print(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int[] y : map) {
			for (int x : y) {
				sb.append(x% 1000 + " ");
			}
			sb.append("\n");
		}
		return sb;
	}
}
