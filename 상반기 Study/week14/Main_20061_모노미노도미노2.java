package ssafy.study.week14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_20061_모노미노도미노2 {
	static int N, R = 10, C = 4, ans, cnt;
	static int[][] green, blue;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/14/모노미노도미노2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		green = new int[R][C];
		blue = new int[R][C];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int t = Integer.parseInt(st.nextToken()); // 1:1x1, 2:1x2, 3:2x1
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			// 1 1 => 1 2
			// 3 0 3 1 => 0 0 1 0
			int by = x;
			int bx = 3 - y;
			int bt = (t == 1) ? 1 : 3;
			if (t == 3) {
				by = x;
				bx = 3 - y - 1;
				bt = 2;
			}
			// 타입별로 블록을 구분 후 설치
			blockType(green, t, y, x);
			blockType(blue, bt, by, bx);
			// 블록이 내려온다
			blockMove(green, t, y, x);
			blockMove(blue, bt, by, bx);
			// 가득찬 줄이 있는지 확인
			// 가득찬 줄의 개수만큼 내린다
			blockDown(green, findFull(green));
			blockDown(blue, findFull(blue));
			// 연한 칸에 블록이 있는 경우 처리 => 연한 칸에 있는 줄 만큼 맨 밑을 없애고 내린다
			blockDown(green, findLight(green));
			blockDown(blue, findLight(blue));
//			print(green);
		}
		// 남은 타일의 개수
		print(green);
		print(blue);
		blockCount(green);
		blockCount(blue);
		System.out.println(ans);
		System.out.println(cnt);
	}

	private static void blockCount(int[][] map) {
		for (int y = 6; y < R; y++) {
			for (int x = 0; x < C; x++) {
				if (map[y][x] == 1)
					cnt++;
			}
		}
	}

	private static ArrayList<Integer> findLight(int[][] map) {
		ArrayList<Integer> list = new ArrayList<>();
		int idx = R - 1;
		for (int y = 4; y <= 5; y++) {
			boolean full = false;
			for (int x = 0; x < C; x++) {
				if (map[y][x] == 1) {
					full = true;
					break;
				}
			}
			if (full) {
				list.add(idx);
			}
		}
		return list;
	}

	private static void blockDown(int[][] map, ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			int ny = list.get(i);
			// 가득찬 줄 지우기
			for (int x = 0; x < C; x++) {
				map[ny][x] = 0;
			}
			// 해당 줄 위로 한칸 씩 내리기
			for (int y = ny; y >= 5; y--) {
				for (int x = 0; x < C; x++) {
					map[y][x] = map[y - 1][x];
					map[y - 1][x] = 0;
				}
			}
		}
	}

	private static ArrayList<Integer> findFull(int[][] map) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int y = 6; y < R; y++) {
			boolean full = true;
			for (int x = 0; x < C; x++) {
				if (map[y][x] == 0) {
					full = false;
					break;
				}
			}
			if (full) {
				list.add(y);
				ans++;
			}
		}
		return list;
	}

	private static void blockMove(int[][] map, int t, int y, int x) {
		// 1x1
		if (t == 1) {
			map[y][x] = 0;
			for (int ny = y + 1; ny <= R; ny++) {
				// 막혀있거나 범위를 벗어나면 설치
				if (!check(ny, x) || map[ny][x] != 0) {
					map[ny - 1][x] = 1;
					return;
				}
			}
		}
		// 1x2
		else if (t == 2) {
			boolean flag = false;
			map[y][x] = 0;
			map[y][x + 1] = 0;
			for (int ny = y + 1; ny <= R; ny++) {
				for (int i = 0; i <= 1; i++) {
					// 막혀있거나 범위를 벗어나면 설치
					if (!check(ny, x) || map[ny][x + i] != 0) {
						flag = true;
						break;
					}
				}
				if (flag) {
					map[ny - 1][x] = 1;
					map[ny - 1][x + 1] = 1;
					return;
				}
			}
		}
		// 2x1
		else {
			map[y][x] = 0;
			map[y + 1][x] = 0;
			for (int ny = y + 2; ny <= R; ny++) {
				// 막혀있거나 범위를 벗어나면 설치
				if (!check(ny, x) || map[ny][x] != 0) {
					map[ny - 1][x] = 1;
					map[ny - 2][x] = 1;
					return;
				}
			}
		}

	}

	private static void blockType(int[][] map, int t, int y, int x) {
		switch (t) {
		case 1:
			map[y][x] = 1;
			break;
		case 2:
			map[y][x] = 1;
			map[y][x + 1] = 1;
			break;
		default:
			map[y][x] = 1;
			map[y + 1][x] = 1;
			break;
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= R || nx < 0 || nx >= C)
			return false;
		return true;
	}

	private static void print(int[][] map) {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		System.out.println("============");
	}
}
