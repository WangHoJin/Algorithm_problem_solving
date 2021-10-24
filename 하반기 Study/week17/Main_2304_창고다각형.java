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

public class Main_2304_창고다각형 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/17/창고다각형.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] height = new int[1001];
		int left = 1002;
		int right = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			height[idx] = h;
			right = Math.max(idx, right);
			left = Math.min(idx, left);
		}
		int ans = 0;
		for (int i = left; i <= right; i++) {
			int start = 0;
			int end = 0;
			int now = height[i];
			// 좌
			for (int j = left; j <= i; j++) {
				start = Math.max(start, height[j]);
			}
			// 우
			for (int j = i; j <= right; j++) {
				end = Math.max(end, height[j]);
			}

			if (now >= start && now >= end)
				ans += now;
			else
				ans += Math.min(start, end);

		}
		System.out.println(ans);
	}
}
