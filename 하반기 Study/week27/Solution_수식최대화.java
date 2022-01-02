package second.study.week27;

import java.io.IOException;
import java.util.*;

public class Solution_수식최대화 {

	public static void main(String[] args) throws IOException {
		String expression = "100-200*300-500+20";
		System.out.println(solution(expression));
	}

	static ArrayList<Long> numList = new ArrayList<Long>();
	static ArrayList<Character> operList = new ArrayList<Character>();
	static char[] operator = { '*', '+', '-' };
	static boolean[] visited = new boolean[3];
	static long answer = 0;

	public static long solution(String expression) {
		String num = "";
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				operList.add(c);
				numList.add(Long.parseLong(num));
				num = "";
			} else {
				num += c;
			}
		}
		// 마지막 숫자
		numList.add(Long.parseLong(num));

		permutation(0, new char[operator.length]);

		return answer;
	}

	private static void permutation(int cnt, char[] sel) {
		if (cnt == operator.length) {
//			for (int i = 0; i < sel.length; i++) {
//				System.out.print(sel[i]);
//			}
//			System.out.println();
			ArrayList<Long> cNum = new ArrayList<>(numList);
			ArrayList<Character> cOper = new ArrayList<Character>(operList);

			for (int i = 0; i < sel.length; i++) {
				for (int j = 0; j < cOper.size(); j++) {
					if (sel[i] == cOper.get(j)) {
						long result = calc(cNum.remove(j), cNum.remove(j), sel[i]);
						cNum.add(j, result);
						cOper.remove(j);
						j--;
					}
				}
			}
			answer = Math.max(answer, Math.abs(cNum.get(0)));

			return;
		}
		for (int i = 0; i < operator.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[cnt] = operator[i];
				permutation(cnt + 1, sel);
				visited[i] = false;
			}
		}

	}

	private static long calc(Long num1, Long num2, char oper) {
		long res = 0;
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num1 - num2;
			break;
		case '*':
			res = num1 * num2;
			break;
		}
		return res;
	}
}
