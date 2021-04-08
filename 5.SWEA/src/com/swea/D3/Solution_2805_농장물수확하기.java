package com.swea.D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;

public class Solution_2805_농장물수확하기 {
	static int T, N, result;
	static char[][] farm;
	static boolean[][] checkFarm;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			farm = new char[N][N];
			checkFarm = new boolean[N][N];
			result = 0;
			for (int y = 0; y < N; y++) {
				farm[y] = in.readLine().toCharArray();
			}
			int sy = N / 2;
			int sx = N / 2;

			harvest(sy, sx);

		}

	}

	private static void harvest(int sy, int sx) {
		if (sy == 0 || sy == N - 1 || sx == 0 || sx == N - 1) {
			checkFarm[sy][sx] = true;
			result += farm[sy][sx];
			return;
		}
		for (int d = 0; d < 4; d++) {
			int ny = sy + dy[d];
			int nx = sx + dx[d];
			if (isCheck(ny, nx) && !checkFarm[ny][nx]) {
				checkFarm[ny][nx] = true;
				result += farm[ny][nx];
				harvest(ny, nx);
			}
		}

	}

	private static boolean isCheck(int ny, int nx) {
		if (0 <= ny && ny < N && 0 <= nx && nx < N)
			return true;
		return false;
	}

}
