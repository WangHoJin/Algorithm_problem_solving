package second.study.week26;

import java.io.IOException;
import java.util.*;

public class Solution_타겟넘버 {

	public static void main(String[] args) throws IOException {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		System.out.println(solution(numbers, target));
	}

	static int cnt = 0;

	public static int solution(int[] numbers, int target) {
		dfs(numbers, target, 0, 0);
		int answer = cnt;
		return answer;
	}

	private static void dfs(int[] numbers, int target, int num, int i) {
		if (i == numbers.length) {
			if (num == target)
				cnt++;
			return;
		}
		dfs(numbers, target, num + numbers[i], i + 1);
		dfs(numbers, target, num - numbers[i], i + 1);

	}
}
