

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static int R, C, cnt;
	static char[][] map;
	static boolean[][] check;
	static int[] dy = { -1, 0, 1 };
	static int[] dx = { 1, 1, 1 };
	static boolean flag;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/식당.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		check = new boolean[R][C];
		for (int y = 0; y < R; y++) {
			map[y] = in.readLine().toCharArray();
		}
		for (int y = 0; y < R; y++) {
			flag = false;
			dfs(y, 0);
		}
		System.out.println(cnt);
//		print();
	}

	private static void dfs(int y, int x) {
		if (flag || check[y][x]) {
			return;
		}
		if (x == C - 1) {
			cnt++;
			flag = true;
			return;
		}
		check[y][x] = true;
		for (int d = 0; d < 3; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (!isCheck(ny, nx) || check[ny][nx] || map[ny][nx] == 'x')
				continue;
			dfs(ny, nx);
		}
	}

	private static boolean isCheck(int y, int x) {
		if (y >= 0 && y < R && x >= 0 && x < C)
			return true;
		return false;
	}

	private static void print() {
		for (char[] cs : map) {
			for (char c : cs) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
