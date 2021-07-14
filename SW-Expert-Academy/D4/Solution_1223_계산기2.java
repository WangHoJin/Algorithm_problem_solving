package com.swea.D4;

import java.util.Scanner;
import java.util.Stack;

public class Solution_1223_계산기2 {
	static int N, idx;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			idx=0;
			N = sc.nextInt();
			Stack<Character> stack = new Stack<>();
			Stack<Integer> stack2 = new Stack<>();
			char[] cal = sc.next().toCharArray();
			char[] result = new char[N];
			for (int i = 0; i < N; i++) {
				if (0 <= cal[i] - '0' && cal[i] - '0' <= 57) {
					result[idx++] = cal[i];
				} else {
					if (stack.isEmpty())
						stack.push(cal[i]);
					else if (stack.peek() > cal[i]) {
						stack.push(cal[i]);
					} else {
						result[idx++] = stack.pop();
						stack.push(cal[i]);
					}
				}
			}
			while (!stack.isEmpty()) {
				result[idx++] = stack.pop();
			}

			for (int i = 0; i < idx; i++) {
				if (0 <= result[i] - '0' && result[i] - '0' <= 57) {
					stack2.push(result[i] - '0');
				} else {
					int a = stack2.pop();
					int b = stack2.pop();
					int c = 0;
					switch (result[i]) {
					case '+':
						c = b + a;
						break;

					default:
						c = b * a;
						break;
					}
					stack2.push(c);
				}
			}
			System.out.println("#" + t + " " + stack2.pop());
		}
	}
}
