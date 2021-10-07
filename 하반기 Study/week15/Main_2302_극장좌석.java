package second.study.week15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2302_극장좌석 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/15/극장좌석.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());

		// d[n] : n개의 좌석에서 나오는 경우의 수
		int[] d = new int[N + 1];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		// d[n] = d[n-1] + d[n-2]
		for (int i = 2; i <= N; i++) {
			d[i] = d[i - 1] + d[i - 2];
		}
		int ans = 1;
		int preVip = 0;
		for (int i = 0; i < M; i++) {
			// VIP좌석을 제외한 좌석무리를 구한다.
			// 이동가능 좌석 무리 수 = (현재 vip 좌석-1) -이전 vip좌석
			int vip = Integer.parseInt(in.readLine());
			int cnt = (vip - 1) - preVip;
			// 전체 경우의 수 = 좌석무리 경우의 수들의 곱
			ans *= d[cnt];
			preVip = vip;
		}
		// 마지막 남은 좌석
		ans *= d[N - preVip];
		System.out.println(ans);
	}
}
