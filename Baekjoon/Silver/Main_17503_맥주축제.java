package Silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_17503_맥주축제 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/Silver/맥주축제.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // N병
		int M = Integer.parseInt(st.nextToken()); // 채워야되는 선호도
		int K = Integer.parseInt(st.nextToken()); // 마실 수 있는 맥주 종류
		long ans = Integer.MAX_VALUE;
		long[][] v = new long[K][2];
		long max = 0;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			v[i][0] = Integer.parseInt(st.nextToken()); // 맥주 선호도
			v[i][1] = Integer.parseInt(st.nextToken()); // 맥주 도수
//			max = Math.max(max, v[i][1]);
		}

		long left = 1;
		long right = (long) Math.pow(2, 31);
//		long right = max;
		Arrays.sort(v, new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {
				// TODO Auto-generated method stub
				return (int) (o1[1] - o2[1]);
			}
		});
		// 맥주의 도수가 간 레벨보다 높으면 X
		// 맥주 N개의 선호도 합이 M 이상
		while (left <= right) {
			long mid = (left + right) / 2;
			if (check(mid, v, N, M, K)) {
				ans = Math.min(ans, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	private static boolean check(long mid, long[][] v, int N, int M, int K) {
		int sum = 0;
		ArrayList<Long> temp = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			if (v[i][1] <= mid)
				temp.add(v[i][0]);
			else
				break;
		}
		if (temp.size() < N)
			return false;

		Collections.sort(temp, Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			sum += temp.get(i);
		}
		return (sum >= M);
	}
}
