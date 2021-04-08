package ssafy.study.week10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/문자열폭발.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		String words = in.readLine();
		char[] result = new char[str.length()];
		int wl = words.length();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			// 현재 검사 문자와 폭발 문자열의 마지막 문자가 같으면
			// 폭발 문자열과 일치하는지 검사
			if (str.charAt(i) == words.charAt(wl - 1)) {
				boolean flag = true;
				for (int j = 1; j < wl; j++) {
					if (cnt < wl - 1 || result[cnt - j] != words.charAt(wl - 1 - j)) {
						flag = false;
						break;
					}
				}
				// 일치하면 폭발 문자열 길이만큼 인덱스 감소
				if (flag) {
					cnt -= (wl - 1);
				}
				// 일치하지않으면 그대로 결과 문자열 삽입
				else {
					result[cnt] = str.charAt(i);
					cnt++;
				}
			}
			// 현재 검사 문자와 폭발 문자열의 마지막 문자가 다르면
			// 결과 문자열 삽입
			else {
				result[cnt] = str.charAt(i);
				cnt++;
			}
		}
		StringBuilder sb = new StringBuilder();
		if (cnt <= 0)
			sb.append("FRULA");
		else {
			for (int i = 0; i < cnt; i++) {
				sb.append(result[i]);
			}
		}
		System.out.println(sb);

	}
}
