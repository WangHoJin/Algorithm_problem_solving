package second.study.week11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110_공유기설치 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/11/공유기설치.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int ans = 0;
		int[] pos = new int[N];
		for (int i = 0; i < N; i++) {
			pos[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(pos);
		int left = 1;
		int right = pos[N - 1];
		while (left <= right) {
			int mid = (left + right) / 2;
			int now = pos[0];
			int cnt = 1;
			for (int i = 1; i < N; i++) {
				int diff = pos[i] - now;
				// 간격에 맞는 집이 있다면
				if (diff >= mid) {
					cnt++;
					now = pos[i];
				}
			}
			if (cnt >= C) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
//		System.out.println(Arrays.toString(pos));
		System.out.println(ans);
	}
}
