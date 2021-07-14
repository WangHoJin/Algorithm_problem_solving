package ssafy.study.week16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2502_떡먹는호랑이 {
	static int D, K;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/16/떡먹는호랑이.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 어제 받은 떡의 개수와 그저께 받은 떡의 개수를 더한 만큼을 받아야 한다
		// x[n] = x[n-1]+x[n-2]
		// 1일, 2일에 받은 떡의 개수로 표현하면
		// dp[n][1] += dp[n-1][1]
		// dp[n][2] += dp[n-1][2]
		int[][] d = new int[D + 1][3];
		d[1][1] = 1; // 첫 날 떡의 개수
		d[2][2] = 1; // 둘째 날 떡의 개수
		// D째 날 1일, 2일에 받은 떡의 개수로 표현
		for (int i = 3; i <= D; i++) {
			d[i][1] = d[i - 2][1] + d[i - 1][1];
			d[i][2] = d[i - 2][2] + d[i - 1][2];
		}
//		System.out.println("1일 개수 : " + d[D][1] + ", 2일 개수 : " + d[D][2]);
		dp(d);
	}

	private static void dp(int[][] d) {
		int first = d[D][1];
		int second = d[D][2];
		int b = 1, result = 0; // 둘째 날 떡의 개수, 결과
		while (true) {
			// 둘째 날 떡의 개수를 늘려가면서 가능한 범위의 첫 날 떡의 개수를 찾으면서 계산
			for (int a = 1; a <= b; a++) {
				result = b * second + a * first;
				// D째 날 준 떡의 개수 K와 일치하면 결과 출력
				if (result == K) {
					System.out.println(a);
					System.out.println(b);
					return;
				}
				// K를 초과하면 break
				else if (result > K)
					break;
			}
			b++;
		}
	}
}
