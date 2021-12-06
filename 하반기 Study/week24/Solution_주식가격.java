package second.study.week24;

import java.io.IOException;
import java.util.*;

public class Solution_주식가격 {

	public static void main(String[] args) throws IOException {
		int[] prices = { 1, 2, 3, 2, 3 };
		System.out.println(Arrays.toString(solution(prices)));
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < prices.length; i++) {
			int n = prices[i];
			while (!stack.isEmpty() && n < prices[stack.peek()]) {
				answer[stack.peek()] = i - stack.pop();
			}
			stack.add(i);
		}
		while (!stack.isEmpty()) {
			answer[stack.peek()] = prices.length - stack.pop() - 1;
		}

		return answer;
	}
}
