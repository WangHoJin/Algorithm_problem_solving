package ssafy.study.week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringBuilder sb = new StringBuilder(str);
		int startIdx = 0; // 단어의 시작
		int endIdx = 0; // 단어의 끝
		boolean stack = true; // '<','>'를 체크
		boolean words = false; // 단어임을 체크

		// 문자열을 탐색하면서 '<'이 나오면 '>'가 나올때까지 패스
		// 문자가 나오면 startIdx로 시작부분 체크
		// 이 후 '<','>',' '이 나오면 endIdx로 체크 후
		// Idx구간 단어 뒤집기! -> 함수로 만들자
		for (int i = 0; i < sb.length(); i++) {
			if (stack && sb.charAt(i) == '<') {
				stack = false;
				if (words) {
					endIdx = i;
					Revers(sb, startIdx, endIdx);
					words = false;
				}
				continue;
			} else if (!stack && sb.charAt(i) == '>') {
				stack = true;
				continue;
			}
			if (!stack)
				continue;

			if (!words) {
				startIdx = i;
				words = true;
			}

			if (sb.charAt(i) == ' ') {
				endIdx = i;
				Revers(sb, startIdx, endIdx);
				words = false;
				continue;
			}
			if (i == sb.length() - 1) {
				endIdx = i + 1;
				Revers(sb, startIdx, endIdx);
			}
		}
		System.out.println(sb.toString());
	}

	private static void Revers(StringBuilder sb, int startIdx, int endIdx) {
		StringBuilder nsb = new StringBuilder();
		nsb.append(sb.substring(startIdx, endIdx));
		sb.replace(startIdx, endIdx, nsb.reverse().toString());
	}

}
