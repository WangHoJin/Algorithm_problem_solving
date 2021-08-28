package Silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6236_용돈관리 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/Silver/용돈관리.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0;
		int[] day = new int[N];
		int left = 0;
		for (int i = 0; i < N; i++) {
			day[i] = Integer.parseInt(in.readLine());
			left = Math.max(day[i], left);
		}

		int right = 1000000000;
		while (left < right) {
			int mid = (left + right) / 2;
			int curr = mid;
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				if (day[i] <= curr) {
					curr -= day[i];
				} else {
					curr = mid - day[i];
					cnt++;
				}
			}

			if (cnt <= M) {
				right = mid;
				ans = mid;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
	}
}
