package ssafy.study.week13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17951_흩날리는시험지 {
	static int N, K, ans;
	static int[] score;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/13/시험지.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		score = new int[N];
		int start = 0;
		int end = 0;
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			end += score[i];
		}

		while (start <= end) {
			int mid = (start + end) / 2;
			int ms = 0, diff = Integer.MAX_VALUE, cnt = 1;
			boolean flag = false;

			for (int i = 0; i < N; i++) {
				ms += score[i];
				if (ms >= mid) {
					diff = Math.min(diff, ms);
					ms = 0;
					cnt++;
					if (cnt > K) {
						ans = Math.max(ans, diff);
						flag = true;
						break;
					}
				}
			}

			if (flag) {
				start = mid + 1;
				ans = Math.max(ans, diff);
			} else
				end = mid - 1;
		}
		
		System.out.println(ans);
	}
}
