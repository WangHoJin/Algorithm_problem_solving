package ssafy.study.week05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2072_오목 {
	static int N, size = 19, ans;
	static int[][] board;
	static int[] dy = { -1, -1, 0, 1 }; // 상 상우 우 상하
	static int[] dx = { 0, 1, 1, 1 };
	static boolean flag;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/오목.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		board = new int[size][size]; // 바둑판 크기는 19x19로 고정
		ans = -1;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int y = Integer.parseInt(st.nextToken()) - 1; // 인덱스 맞춰주고
			int x = Integer.parseInt(st.nextToken()) - 1;

			// 정답이 나왔는지 판단
			// 정답이 나왔으면 입력만 계속하다가 끝
			if (ans != -1)
				continue;

			// 번갈아가면서 흑백 삽입
			int color = (i % 2) + 1; // 2:흑, 1:백
			board[y][x] = color;

			// 9턴 전까지는 승부가 안나니까 패스
			if (i <= 8) {
				continue;
			}

			// 오목인지 판단
			flag = false;
			// 오목판단 함수
			search(y, x, color);
			// 오목이라면 끝
			if (flag) {
				ans = i;
			}
		}
		System.out.println(ans);
	}

	private static void search(int y, int x, int color) {
		// 상 상우 우 하우 4방향과 반대편을 탐색
		for (int d = 0; d < 4; d++) {
			int l = 0, r = 0; // 기준 돌의 양옆에 같은 돌이 있는지 카운트
			boolean ls = true, rs = true; // 양옆으로 탐색을 더이상 해야될지 판단
			// 기준돌 제외 4칸까지 탐색
			for (int i = 1; i <= 4; i++) {
				// 우측 좌표
				int ny = y + dy[d] * i;
				int nx = x + dx[d] * i;
				// 좌측 좌표
				int ny2 = y - dy[d] * i;
				int nx2 = x - dx[d] * i;

				// 우측좌표에서 경계를 안넘고
				// 같은 색의 돌이 나왔다면 카운팅
				if (check(ny, nx) && rs && board[ny][nx] == color) {
					r++;
				}
				// 다른 색의 돌이거나 바둑판 밖이면 더이상 탐색 불가
				else {
					rs = false;
				}

				// 좌측 동일
				if (check(ny2, nx2) && ls && board[ny2][nx2] == color) {
					l++;
				} else {
					ls = false;
				}

			}
			// 카운트 합이 4이면 오목 -> 본인은 카운트를 안했기때문
			if (r + l == 4) {
				flag = true;
				return;
			}
		}

	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= size || nx < 0 || nx >= size)
			return false;
		return true;
	}
}
