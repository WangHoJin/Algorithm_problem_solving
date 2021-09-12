package second.study.week11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17179_케이크자르기 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/11/케이크자르기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] cut = new int[M + 1];

		for (int i = 0; i < M; i++)
			cut[i] = Integer.parseInt(in.readLine());
		cut[M] = L;
		for (int i = 0; i < N; i++) {
			int ans = 0;
			int cutCnt = Integer.parseInt(in.readLine());

			int left = 0;
			int right = L;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (cakeCut(mid, cut, cutCnt)) {
					left = mid + 1;
					ans = Math.max(ans, mid);
				} else {
					right = mid - 1;
				}
			}
			System.out.println(ans);
		}

	}

	private static boolean cakeCut(int mid, int[] cut, int cutCnt) {
		int pre = 0;
		for (int i = 0; i < cut.length; i++) {
			if (cut[i] - pre >= mid) {
				--cutCnt;
				pre = cut[i];
			}
		}
		return cutCnt < 0 ? true : false;
	}
}
