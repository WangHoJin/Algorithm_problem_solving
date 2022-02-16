package second.study.week34;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1929_소수구하기 {

	static int M, N;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/34/소수구하기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		// 방법 1
//		for (int i = M; i <= N; i++) {
//			if (getPrimeNum(i)) {
//				System.out.println(i);
//			}
//		}

		check = new boolean[N + 1];
		// 방법 2 : 에라토스테네스의 체
		findPrimeNum(N);
		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (!check[i]) {
				sb.append(i);
				sb.append("\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb.toString());
	}

	private static void findPrimeNum(int num) {
		// 0과 1은 소수 아님
		check[0] = check[1] = true;

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (check[i])
				continue;

			for (int j = i * i; j <= N; j += i) {
				check[j] = true;
			}
		}

	}

	private static boolean getPrimeNum(int num) {
		if (num == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
