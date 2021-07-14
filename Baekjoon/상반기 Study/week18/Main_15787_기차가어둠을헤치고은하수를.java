package ssafy.study.week18;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15787_기차가어둠을헤치고은하수를 {
	static int N, M, ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/18/기차가어둠을헤치고은하수를.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] train = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int command = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			int x = 0;
			switch (command) {
			case 1:
				x = Integer.parseInt(st.nextToken());
				train[idx] |= 1 << x;
				break;
			case 2:
				x = Integer.parseInt(st.nextToken());
				train[idx] &= ~(1 << x);
				break;
			case 3:
				train[idx] = train[idx] << 1;
				train[idx] = train[idx] & ((1 << 21) - 1);
				break;

			default:
				train[idx] = train[idx] >> 1;
				train[idx] = train[idx] & ~1;
				break;
			}
		}
		boolean[] same = new boolean[1 << 21];
		for (int i = 1; i <= N; i++) {
			if (same[train[i]])
				continue;
			ans++;
			same[train[i]] = true;
		}
		System.out.println(ans);

	}

}
