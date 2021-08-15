package com.kakao2018;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_프렌즈4블록 {
	static class Point {
		int y, x;
		char name;

		public Point(int y, int x, char name) {
			super();
			this.y = y;
			this.x = x;
			this.name = name;
		}
	}

	static int[] dy = { 0, 0, 1, 1 }; // 상우하좌 방향 배열
	static int[] dx = { 0, 1, 1, 0 };
	static boolean flag;

	// 라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)
	public static int solution(int m, int n, String[] b) {
		int answer = 0;
		char[][] board = new char[m][n];	// 게임판
		boolean[][] check = new boolean[m][n];	// 터질 블록 체크
		Queue<Point> frz = new LinkedList<>();
		for (int y = 0; y < m; y++) {
			board[y] = b[y].toCharArray();
		}

		while (true) {
			flag = false;	
			check = new boolean[m][n];
			// 모든 프렌즈를 검사
			for (int y = 0; y < m - 1; y++) {
				for (int x = 0; x < n - 1; x++) {
					if (board[y][x] != '.')
						bomb(y, x, board[y][x], board, check, frz, m, n);
				}
			}
			// print(board);
			// 더 이상 터질게 남았는지 확인
			if (!flag)
				break;
			// System.out.println(frz.size());
			// 터지고 중력으로 내리기
			gravity(m, n, board, check);
			// print(board);
		}
		answer = frz.size();	// 터질 프렌즈 크기
		//System.out.println(answer);
		return answer;
	}

	private static void gravity(int m, int n, char[][] board, boolean[][] check) {
		Queue<Character> temp = new LinkedList<>();
		for (int x = 0; x < n; x++) {
			for (int y = m - 1; y >= 0; y--) {
				// 터지는 부분 .으로 변경
				if (check[y][x]) {
					board[y][x] = '.';
					continue;
				}
				// 남아 있는 프렌즈들 저장
				temp.add(board[y][x]);
				// 원래 프렌즈 위치를 .으로 변경 -> 같은 map배열을 사용할거기 때문에 기존 위치를 초기화해준다
				board[y][x] = '.';
			}
			// 같은 열에 있던 모든 프렌즈들을 밑에서부터 채워준다
			int size = temp.size();
			for (int y = 0; y < size; y++) {
				board[m - 1 - y][x] = temp.poll();
			}
		}
	}

	private static void bomb(int y, int x, char name, char[][] board, boolean[][] check, Queue<Point> frz, int m,
			int n) {

		int frzCnt = 1; // 연결된 프렌즈 수
		// 우 우하 하 3방을 탐색
		for (int d = 1; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			// 다른 프렌즈가 있으면 break
			if (board[y][x] != board[ny][nx])
				break;
			frzCnt++;	// 연결된 프렌즈 수
		}
		// 2x2로 연결되어 있다면
		if (frzCnt == 4) {
			flag = true;	// 터질 프렌즈가 있다고 표시
			// 본인포함 터질 프렌즈를 frz큐에 저장
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (!check[ny][nx]) {
					frz.add(new Point(ny, nx, board[ny][nx]));
					check[ny][nx] = true;	// 터질부분 체크
				}
			}
		}
	}

	private static void print(char[][] board) {
		for (char[] y : board) {
			for (char x : y) {
				System.out.print(x);
			}
			System.out.println();
		}
		System.out.println("====================================");
	}
}
