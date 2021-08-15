package ssafy.study.week10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3079_입국심사 {
	static int N;
	static long M;
	static long[] T;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/입국심사.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = new long[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			T[i] = Integer.parseInt(in.readLine());
			max = (int) Math.max(max, T[i]);
		}
		// 입국심사 소요시간 오름차순 정렬
		Arrays.sort(T);
		// 이분탐색 => 1시간부터 최대 걸리는 시간까지 이분탐색을 통해 최소시간을 찾아낸다
		long start = 1;
		long end = max * M; // 최대 걸리는 시간 = (인원수 * 심사대 중 최대시간)
//		long m = Long.MAX_VALUE;
		long result = max * M;
		while (start < end) {
			long mid = (start + end) / 2; // 탐색의 중간값
			long cnt = 0; // 심사 가능 인원 수
			// 중간값으로 심사 가능 인원 수
			for (int i = 0; i < N; i++) {
				cnt += mid / T[i];
			}
			// 심사 가능 인원 수가 총 인원 수보다 작으면 현재 중간시간보다 작게 탐색이 불가능
			// 중간시간부터 최대 시간까지 탐색
			if (cnt < M) {
				start = mid + 1;
			}
			// 심사 가능 인원 수가 총 인원 수보다 크면 현재 mid시간보다 작게 탐색이 가능
			// 중간시간을 마지막으로 두고 탐색
			// 최솟값 갱신
			else {
				result = Math.min(result, mid);
				end = mid - 1;
			}
		}
		System.out.println(result);

	}
}
