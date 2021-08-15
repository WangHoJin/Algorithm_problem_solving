package study.week13;

import java.util.Arrays;
import java.util.Queue;

public class Solution_경주로건설 {
	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
//		int[][] board = {{0, 0, 1, 0, 1, 1, 0, 0, 0, 0},
//				{0, 0, 0, 0, 1, 0, 1, 1, 0, 1},
//				{1, 0, 0, 0, 0, 1, 1, 0, 1, 0},
//				{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
//				{0, 0, 0, 0, 1, 0, 1, 0, 1, 1},
//				{0, 0, 1, 0, 1, 1, 0, 1, 0, 1},
//				{0, 1, 0, 0, 1, 0, 0, 0, 1, 0},
//				{1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//				{0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
//				{1, 0, 0, 0, 0, 0, 0, 0, 1, 0}};

		System.out.println(solution.solution(board));
	}
}

class Solution3 {
	static int N;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static class Point {
		int y,x;
	}
	public int solution(int[][] map) {
		int answer = 0;
		bfs(map);
		return answer;
	}

	private void bfs(int[][] map) {
		
		
	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= N || nx < 0 || nx >= N)
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
	}
}