package ssafy.study.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8911_거북이 {
	static int N, dir, row, col, min_row, max_row, min_col, max_col;
	static char[] move;
	static int[] dy = { -1, 0, 1, 0 }; // 상 좌 하 우
	static int[] dx = { 0, -1, 0, 1 }; // 상 좌 하 우

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			move = in.readLine().toCharArray();
			// 현재 행과열의 상태
			row = 0;
			col = 0;
			// 가장 작았을때와 컸을때 행과열
			min_row = 0;
			max_row = 0;
			min_col = 0;
			max_col = 0;

			// 동작
			for (int j = 0; j < move.length; j++) {
				// L과R일때는 방향을 바꿔주고
				// F와B일때는 전진 후진
				if (move[j] == 'L') {
					dir++;
				} else if (move[j] == 'R') {
					dir += 3;
				} else if (move[j] == 'F') {
					row += dy[dir];
					col += dx[dir];
				} else {
					row -= dy[dir];
					col -= dx[dir];
				}
				dir = dir % 4;

				// 최소,최대 값 갱신
				min_row = (min_row > row) ? row : min_row;
				max_row = (max_row < row) ? row : max_row;
				min_col = (min_col > col) ? col : min_col;
				max_col = (max_col < col) ? col : max_col;
			}
			// 넓이 구하면 끝
			int ans = (max_row - min_row) * (max_col - min_col);
			System.out.println(ans);
		}
	}

	private static void print() {
		for (char c : move) {
			System.out.print(c);
		}
		System.out.println();

	}

}
