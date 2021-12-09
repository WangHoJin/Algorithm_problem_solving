package second.study.week24;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17503_맥주축제 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/Silver/맥주축제.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // N병
		int M = Integer.parseInt(st.nextToken()); // 채워야되는 선호도
		int K = Integer.parseInt(st.nextToken()); // 마실 수 있는 맥주 종류
		long ans = -1;
		long[][] v = new long[K][2];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			v[i][0] = Integer.parseInt(st.nextToken()); // 맥주 선호도
			v[i][1] = Integer.parseInt(st.nextToken()); // 맥주 도수
//			max = Math.max(max, v[i][1]);
		}

		Arrays.sort(v, new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {
				// TODO Auto-generated method stub
				return (int) (o1[1] - o2[1]);
			}
		});
		// 맥주의 도수가 간 레벨보다 높으면 X
		// 맥주 N개의 선호도 합이 M 이상
		int sum = 0;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < K; i++) {
			pq.add(v[i][0]);
			sum += v[i][0];
			// 이것땜에 틀렸는데 차이점을 알아보자
//			if (pq.size() > N) {
//				long min = pq.peek() == null ? 0 : pq.poll();
//				sum -= min;
//			}
			if (pq.size() == N) {
				if (sum >= M) {
					ans = v[i][1];
					break;
				} else {
					sum -= pq.poll();
				}
			}
		}
		System.out.println(ans);
	}
}
