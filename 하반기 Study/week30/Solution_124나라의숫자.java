package second.study.week30;

import java.util.*;

public class Solution_124나라의숫자 {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(solution(n));
	}

	static StringBuilder sb;

	public static String solution(int n) {
		String answer = "";
		sb = new StringBuilder();
		dfs(n);
		answer = sb.toString();
		return answer;
	}

	private static void dfs(int n) {
		if (n <= 0) {
			return;
		}
		int a = n / 3;
		int b = n % 3;
		if (b == 1) {
			String s = sb.toString();
			sb.setLength(0);
			sb.append("1" + s);
			dfs(a);
		} else if (b == 2) {
			String s = sb.toString();
			sb.setLength(0);
			sb.append("2" + s);
			dfs(a);
		} else if (b == 0) {
			String s = sb.toString();
			sb.setLength(0);
			sb.append("4" + s);
			a--;
			dfs(a);
		}
	}
}