package second.study.week30;

import java.util.*;

public class Solution_가장큰수 {
	public static void main(String[] args) {
		int[] numbers = { 6, 10, 2 };
		System.out.println(solution(numbers));
	}

	static ArrayList<String> rs;

	public static String solution(int[] numbers) {
		String answer = "";
		int len = numbers.length;
		rs = new ArrayList<>();
		permu(0, new StringBuilder(), numbers, new boolean[len]);
		Collections.sort(rs);
		answer = rs.get(len - 1);
		return answer;
	}

	private static void permu(int cnt, StringBuilder sb, int[] numbers, boolean[] v) {
		if (cnt == numbers.length) {
			System.out.println(sb.toString());
			rs.add(sb.toString());
			sb.setLength(0);
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!v[i]) {
				sb.append(numbers[i]);
				v[i] = true;
				permu(cnt + 1, sb, numbers, v);
				v[i] = false;
			}
		}
	}
}