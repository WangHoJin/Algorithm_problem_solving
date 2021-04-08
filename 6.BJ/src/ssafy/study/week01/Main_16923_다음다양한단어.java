package ssafy.study.week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16923_다음다양한단어 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String str = in.readLine(); // 입력 문자열
		int[] alpha = new int[26]; // 알파벳 사용유무

		// 사용된 알파벳 체크
		for (int i = 0; i < str.length(); i++)
			alpha[str.charAt(i) - 'a']++;

		int min = Integer.MAX_VALUE;
		// 문자열 길이가 26보다 크면
		if (str.length() >= 26) {
			// 예외처리
			if (str.equals("zyxwvutsrqponmlkjihgfedcba")) {
				str = "-1";
			} else {
				// 문자열 뒤에서부터 탐색
				for (int i = str.length() - 1; i >= 0; i--) {
					int now = (int) str.charAt(i) - 'a'; // 현재 문자의 알파벳값
					int pre = (int) str.charAt(i - 1) - 'a'; // 이전 문자의 알파벳값
					// 이전 문자보다 현재 문자가 더 큰 경우
					// 현재 문자를 기준으로 탐색
					if (pre < now) {
						for (int j = i; j < 26; j++) {
							int temp = str.charAt(j) - 'a';
							// 이전 문자의 값보다 크면서 젤 작은값을 저장
							if (pre < temp)
								min = (min > temp) ? temp : min;
						}
						// 필요없는 부분 짜르고 min값 이어붙이기
						str = str.substring(0, i - 1);
						str += (char) (min + 'a');
						break;
					}
				}
			}
		}
		// 문자열 길이가 26보다 작으면
		// 아직 사용하지 않은 가장 빠른 알파벳을 이어 붙인다.
		else {
			for (int i = 0; i < 26; i++) {
				if (alpha[i] == 0) {
					str += (char) (i + 'a');
					break;
				}
			}
		}
		System.out.print(str);
	}
}
