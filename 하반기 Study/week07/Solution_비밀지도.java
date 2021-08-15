package kakao2018.level1;

import java.util.Arrays;
import java.util.Stack;

public class Solution_비밀지도 {

	public static void main(String[] args) {
		int n = 1;
		int[] arr1 = { 46, 33, 33, 22, 31, 50 };
		int[] arr2 = { 27, 56, 19, 14, 14, 10 };

		String[] str = solution(n, arr1, arr2);
		for (String string : str) {
			System.out.println(string);
		}
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			// 이진수로 변환 => 문자열
			// 지도1 지도2 비트 or연산 => 지도 합쳐짐
			// 자리수가 안맞을 경우 n길이 만큼 0 채워주기 => 중요!!
			// int형을 벗어나기때문에 Long형으로 해줘야함 => 중요!@!@
			String bString = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i] | arr2[i])));
			System.out.println(bString);

			// 합쳐진 이진수를 지도형식으로 변환
			answer[i] = convertToMap(bString);
		}
		return answer;
	}

	private static String convertToMap(String bString) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bString.length(); i++) {
			if (bString.charAt(i) == '1')
				sb.append("#");
			else
				sb.append(" ");
		}
		return sb.toString();
	}
}
