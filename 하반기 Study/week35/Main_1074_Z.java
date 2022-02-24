package second.study.week35;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1074_Z {

	static int N, r, c, cnt, ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/35/Z.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, n);
		cnt = 0;
		find(N, 0, 0);
		System.out.println(ans);
	}

	private static void find(int size, int y, int x) {
		if (y == r && x == c) {
			ans = cnt;
			return;
		} else {
			// 분할로 안하면 시간초과
			if (y <= r && r < y + size / 2 && x <= c && c < x + size / 2) {
				find(size / 2, y, x);
			} else if (y <= r && r < y + size / 2 && x + size / 2 <= c && c < x + size) {
				cnt += size * size / 4;
				find(size / 2, y, x + size / 2);
			} else if (y + size / 2 <= r && r < y + size && x <= c && c < x + size / 2) {
				cnt += size * size / 4 * 2;
				find(size / 2, y + size / 2, x);
			} else if (y + size / 2 <= r && r < y + size && x + size / 2 <= c && c < x + size) {
				cnt += size * size / 4 * 3;
				find(size / 2, y + size / 2, x + size / 2);
			}
		}

		return;
	}

}
