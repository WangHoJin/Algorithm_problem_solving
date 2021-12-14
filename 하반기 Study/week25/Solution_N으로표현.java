package second.study.week25;

import java.io.IOException;
import java.util.*;

public class Solution_N으로표현 {

	public static void main(String[] args) throws IOException {
		int N = 5;
		int number = 12;
		System.out.println(solution(N, number));
	}

	static int answer = -1;

	public static int solution(int N, int number) {
		dfs(N, number, 0, 0);
		return answer;
	}

	public static void dfs(int N, int number, int cnt, int ans) {
		if (cnt > 8)
			return;
		if (number == ans) {
			if (answer == -1)
				answer = cnt;
			else
				answer = Math.min(answer, cnt);
		}
		int temp = N;
		for (int i = 0; i < 8 - cnt; i++) {
			int idx = cnt + i + 1;
			dfs(N, number, idx, ans + temp);
			dfs(N, number, idx, ans - temp);
			dfs(N, number, idx, ans * temp);
			dfs(N, number, idx, ans / temp);
			temp = temp * 10 + N;
		}
	}
}
