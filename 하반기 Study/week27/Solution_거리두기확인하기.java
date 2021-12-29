package second.study.week27;

import java.io.IOException;
import java.util.*;

public class Solution_거리두기확인하기 {

	public static void main(String[] args) throws IOException {
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		System.out.println(Arrays.toString(solution(places)));
	}

	static int[] dy = { -1, 1, 0, 0, -2, 2, 0, 0, -1, -1, 1, 1 };
	static int[] dx = { 0, 0, -1, 1, 0, 0, -2, 2, -1, 1, -1, 1 };

	public static int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = 1;
		}
		for (int i = 0; i < places.length; i++) {
			char[][] map = new char[5][5];
			copyMap(places, map, i);
			checkMap(places, map, i, answer);
		}
		return answer;
	}

	private static void checkMap(String[][] places, char[][] map, int i, int[] answer) {
		for (int y = 0; y < map.length; y++) {
			// map[y] = places[i][y].toCharArray();
			for (int x = 0; x < map.length; x++) {
				char c = map[y][x];
				if (c == 'P') {
					// 상하좌우 1칸
					for (int d = 0; d < 4; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						if (!check(ny, nx))
							continue;
						if (map[ny][nx] == 'P') {
							answer[i] = 0;
							return;
						}
					}
					// 상하좌우 2칸
					for (int d = 4; d < 8; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						if (!check(ny, nx))
							continue;
						if (map[ny][nx] == 'P') {
							if (map[y + dy[d - 4]][x + dx[d - 4]] == 'X')
								continue;
							answer[i] = 0;
							return;
						}
					}
					// 대각선
					for (int d = 8; d < 12; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						if (!check(ny, nx))
							continue;
						if (map[ny][nx] == 'P') {
							if (map[y + dy[d]][x] == 'X' && map[y][x + dx[d]] == 'X')
								continue;
							answer[i] = 0;
							return;
						}
					}

				}
			}
		}

	}

	private static void copyMap(String[][] places, char[][] map, int i) {
		for (int y = 0; y < map.length; y++) {
			map[y] = places[i][y].toCharArray();
		}
	}

	private static boolean check(int ny, int nx) {
		if (0 <= ny && ny < 5 && 0 <= nx && nx < 5)
			return true;
		return false;
	}
}
