package com.swea.D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가로,세로,대각선을 탐색하면서 해당 인덱스부터 4방으로 뻗어나가면서 다른색 돌이면 돌 바꿔주고 같은 돌을 만나면 중단
 *
 */
public class Solution_4615_재미있는오셀로게임 {
	static int T, N, M;
	static int[][] board;
	static int py, px, color;
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int w, b;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			board[N / 2 - 1][N / 2 - 1] = 2;
			board[N / 2 - 1][N / 2] = 1;
			board[N / 2][N / 2 - 1] = 1;
			board[N / 2][N / 2] = 2;
			w = 0;
			b = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				px = Integer.parseInt(st.nextToken()) - 1;
				py = Integer.parseInt(st.nextToken()) - 1;
				color = Integer.parseInt(st.nextToken());
				board[py][px] = color;
				play();
//				System.out.println("===================================");
//				print();
			}
			count();
			System.out.println("#" + t + " " + b + " " + w);
		}

	}

	private static void count() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (board[y][x] == 1)
					b++;
				else if (board[y][x] == 2)
					w++;
			}
		}
	}

	private static void go(int d) {
		int i = 1;
		while (true) {
			int cy = py + dy[d] * i;
			int cx = px + dx[d] * i;
			if (isCheck(cy, cx) && board[cy][cx] == color)
				break;
			else if (!isCheck(cy, cx) || board[cy][cx] == 0)
				return;
			i++;
		}
		i = 1;
		while (true) {
			int ny = py + dy[d] * i;
			int nx = px + dx[d] * i;
			if (board[ny][nx] == color)
				break;
			board[ny][nx] = color;
			i++;
		}
	}

	private static void play() {
		for (int d = 0; d < 8; d++) {
			int ny = py + dy[d];
			int nx = px + dx[d];
			if (!isCheck(ny, nx) || board[ny][nx] == 0 || board[ny][nx] == color)
				continue;
			go(d);
		}
	}

	private static boolean isCheck(int ny, int nx) {
		if (0 <= ny && ny < N && 0 <= nx && nx < N)
			return true;
		return false;
	}

	private static void print() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				System.out.print(board[y][x] + " ");
			}
			System.out.println();
		}
	}
}
