package second.study.week17;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1662_압축 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/17/압축.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] s = in.readLine().toCharArray();
		int[] idx = new int[51];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '(')
				stack.push(i);
			if (s[i] == ')')
				idx[stack.pop()] = i;
		}
		int ans = getLength(s, idx, 0, s.length);
		System.out.println(ans);

	}

	private static int getLength(char[] s, int[] idx, int start, int end) {
		int len = 0;
		for (int i = start; i < end; i++) {
			if (s[i] == '(') {
				// 반복숫자는 사용하고 사라지니까 -1을 해준다!
				len += (s[i - 1] - '0') * getLength(s, idx, i + 1, idx[i]) - 1;
				i = idx[i];
			} else {
				len++;
			}
		}
		return len;
	}
}
