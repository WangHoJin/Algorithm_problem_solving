package ssafy.study.week09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2933_미네랄 {
	static int R, C, N, mCnt, mCnt2;
	static char[][] map;

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/미네랄.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int y = 0; y < R; y++) {
			String str = in.readLine();
			for (int x = 0; x < C; x++) {
				char a = str.charAt(x);
				map[y][x] = a;
				if (a == 'x')
					mCnt++; // 미네랄의 갯수
			}
		}
		N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int height = R - Integer.parseInt(st.nextToken());
			// 막대기를 던진다
			// 왼쪽에서 던진다
			if (i % 2 != 0) {
				// 미네랄이 있으면 부서진다
				for (int x = 0; x < C; x++) {
					if (map[height][x] == 'x') {
						map[height][x] = '.';
						mCnt--;
						break;
					}
				}
			}
			// 오른쪽에서 던진다
			else {
				for (int x = C - 1; x >= 0; x--) {
					if (map[height][x] == 'x') {
						map[height][x] = '.';
						mCnt--;
						break;
					}
				}
			}

			// 미네랄 파악
			mCnt2 = 0;
			boolean[][] v = new boolean[R][C];
			findCluster(v); // 바닥에 붙은 미네랄 덩어리 파악
			// 바닥에 붙은 미네랄과 미네랄 총 갯수가 같다면 내려올 미네랄 X
			// 다르다면 내려올 미네랄 O
			if (mCnt != mCnt2) {
//				System.out.println("내려와야댐");
				fallMineral(v);
			}
		}
		print();
	}

	private static void fallMineral(boolean[][] v) {
		int min = Integer.MAX_VALUE;
		for (int x = 0; x < C; x++) {
			int bottom = R; // 아래 미네랄 y좌표
			int top = 0; // 공중 미네랄 y좌표
			for (int y = R - 1; y >= 0; y--) {
				if (map[y][x] == 'x' && v[y][x]) {
					bottom = y;
				} else if (map[y][x] == 'x') {
					top = y + 1;
					// 미네랄 사이 최소 거리 파악
					min = Math.min(min, bottom - top);
					break;
				}
			}
		}

		// 최소거리만큼 미네랄을 내린다
		for (int x = 0; x < C; x++) {
			for (int y = R - 1; y >= 0; y--) {
				if (map[y][x] == 'x' && !v[y][x]) {
					map[y + min][x] = 'x';
					map[y][x] = '.';
				}
			}
		}

	}

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	private static void findCluster(boolean[][] v) {
		Queue<Point> q = new LinkedList<>();
		// 가장 밑바닥 미네랄 찾아서 탐색
		for (int x = 0; x < C; x++) {
			if (map[R - 1][x] == 'x') {
				q.add(new Point(R - 1, x));
				v[R - 1][x] = true;
				mCnt2++;
			}
		}

		// bfs
		while (!q.isEmpty()) {
			Point temp = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				if (!check(ny, nx) || map[ny][nx] == '.' || v[ny][nx])
					continue;
				q.add(new Point(ny, nx));
				v[ny][nx] = true;
				mCnt2++; // 밑바닥에 연결된 미네랄 갯수
			}
		}

	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= R || nx < 0 || nx >= C)
			return false;
		return true;
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (char[] y : map) {
			for (char x : y) {
				sb.append(x);
			}
			sb.append("\n");
		}
//		sb.append("==============");
		System.out.println(sb);
	}
}
