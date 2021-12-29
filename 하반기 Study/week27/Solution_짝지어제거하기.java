package second.study.week27;

import java.io.IOException;
import java.util.*;

public class Solution_짝지어제거하기 {

	public static void main(String[] args) throws IOException {
		String s = "baabaa";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (stack.isEmpty()) {
				stack.push(c);
				continue;
			}
			if (c == stack.peek()) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		if (stack.isEmpty())
			answer = 1;
		return answer;
	}
}
