package kakao.level2;

import java.util.ArrayList;

public class Solution_n진수 {
	public static void main(String[] args) {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 1;
		System.out.println(solution(n, t, m, p));
	}

	public static String solution(int n, int t, int m, int p) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		// 10진수를 n진수로 변환 시, 필요한 숫자의 길이이 만큼 n진수를 변환해서 합쳐준다.
		// 필요한 숫자의 길이 = t x m
		int num = 1;
		int len = t * m;
		sb.append(0);
		while (len > sb.length()) {
			// n진수로 변환 함수
			sb.append(conversion(n, num));
			++num;
		}
		// n진수 숫자 중 본인 순서일 때 말해야되는 숫자 선택
		for (int i = p - 1; i < len; i += m) {
			answer += sb.charAt(i);
		}

		return answer;
	}

	// n : 진법, num : 10진수
	public static String conversion(int n, int number) {
		StringBuilder sb = new StringBuilder();
		int curr = number;
		// 현재 숫자가 0보다 클때
		while (curr > 0) {
			// 현재 숫자의 나머지
			int res = curr % n;
			// 나머지가 10보다 작으면 그대로 저장
			if (res < 10)
				sb.append(res);
			// 나머지가 10보다 큰 경우는 10부터 A~F까지로 저장
			else {
				sb.append((char)(res - 10 + 'A'));
			}
			// 현재 숫자를 몫으로 갱신
			curr /= n;
		}
		return sb.reverse().toString();
	}
}
