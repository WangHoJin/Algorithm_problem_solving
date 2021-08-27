package second.study.week09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5710_전기요금 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/09/전기요금.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			long ans = 0;
			if (A == 0 && B == 0)
				break; // 입력 종료조건

			// A를 이용하여 사용량을 계산한다.
			long usage = getUsage(A);
//			System.out.println("총사용량 : " + usage);
			System.out.println("총사용량 : " + getFare(A));
			// 사용량을 바탕으로 이분탐색을 한다.
			long left = 0;
			long right = usage;
			while (left <= right) {
				long mid = (left + right) / 2; // 현재 내가 사용한 전기량
				long neighbor = usage - mid; // 이웃이 사용한 전기량
				long myFare = getFare(mid); // 나의 전기요금
				long neFare = getFare(neighbor); // 이웃 전기요금
				long diff = neFare - myFare; // 요금차이
				if (diff == B) {
					ans = myFare;
					break;
				}
				else if (diff > B) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			System.out.println(ans);
//			System.out.println("★내 사용 요금 : " + ans);
		}
	}

	private static long getFare(long use) {
		long result = 0;
		if (use > 100) {
			use -= 100;
			result += 200;
			if (use > 9900) {
				use -= 9900;
				result += 3 * 9900;
				if (use > 990000) {
					use -= 990000;
					result += 5 * 990000;
					result += use * 7;
				} else
					result += use * 5;
			} else
				result += use * 3;
		} else {
			result = use * 2;
		}
		return result;
	}

	private static long getUsage(long A) {
		long result = 0;
		if (A > 200) {
			A -= 200;
			result += 100;
			if (A > 29900) {
				A -= 3 * 9900;
				result += 9900;
				if (A > 4979900) {
					A -= 5 * 990000;
					result += 990000;
					result += A / 7;
				} else
					result += A / 5;
			} else
				result += A / 3;
		} else {
			result = A / 2;
		}
		return result;
	}

}
