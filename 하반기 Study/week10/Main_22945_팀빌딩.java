package second.study.week10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_22945_팀빌딩 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/10/팀빌딩.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int ans = 0;
		// (개발자 A와 개발자 B 사이에 존재하는 다른 개발자 수) × min(개발자 A의 능력치, 개발자 B의 능력치)
		// 양쪽끝에서 작은값쪽을 땡겨보자
		int[] stat = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			stat[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = N - 1;
		while (left < right) {
			if (stat[left] < stat[right]) {
				ans = Math.max(ans, (right - left - 1) * stat[left]);
				++left;
			} else {
				ans = Math.max(ans, (right - left - 1) * stat[right]);
				--right;
			}
		}
		System.out.println(ans);
	}
}
