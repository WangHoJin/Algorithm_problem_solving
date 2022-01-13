package second.study.week29;

import java.util.*;

public class Solution_합승택시요금_플로이드와샬 {
	public static void main(String[] args) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
				{ 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };
		System.out.println(solution(n, s, a, b, fares));
	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = Integer.MAX_VALUE;
		int[][] matrix = new int[n + 1][n + 1];
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (i == j)
					continue;
				matrix[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < fares.length; i++) {
			int p1 = fares[i][0];
			int p2 = fares[i][1];
			int w = fares[i][2];
			matrix[p1][p2] = w;
			matrix[p2][p1] = w;
		}
		for (int k = 1; k < matrix.length; k++) {
			for (int i = 1; i < matrix.length; i++) {
				for (int j = 1; j < matrix.length; j++) {
					if (i == j || matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE)
						continue;
					if (matrix[i][k] + matrix[k][j] < matrix[i][j])
						matrix[i][j] = matrix[i][k] + matrix[k][j];
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			answer = Math.min(answer, matrix[s][i] + matrix[i][a] + matrix[i][b]);
		}
		return answer;
	}

}