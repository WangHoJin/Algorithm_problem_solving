package second.study.week19;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1874_스택수열 {
	static int N;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/19/스택수열.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
//		int[] num = new int[N];
		Stack<Integer> stack = new Stack<>();
		int now = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());

			if (now < num) {
				for (int j = now + 1; j <= num; j++) {
					stack.push(j);
					sb.append("+").append("\n");
				}
				now = num;
			} else if (stack.peek() != num) {
				System.out.println("NO");
				System.exit(0);;
			}
			stack.pop();
			sb.append("+").append("\n");
		}
		System.out.println(sb.toString());

	}
}
