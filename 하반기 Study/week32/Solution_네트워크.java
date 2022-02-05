package second.study.week32;

import java.util.*;

public class Solution_네트워크 {
	public static void main(String[] args) {
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int n = 3;
		System.out.println(solution(n, computers));
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			dfs(n, computers, visited, i);
			answer++;
		}
		return answer;
	}

	public static void dfs(int n, int[][] computers, boolean[] visited, int i) {
		for (int j = 0; j < n; j++) {
			if (visited[j] || computers[i][j] == 0)
				continue;
			visited[j] = true;
			dfs(n, computers, visited, j);
		}
		return;
	}
}