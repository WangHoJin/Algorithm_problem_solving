package kakao2021.level1;

public class Solution_신규아이디추천 {
	public static void main(String[] args) {
		String new_id = "=.=";
		System.out.println(solution(new_id));

	}

	public static String solution(String new_id) {
		String answer = "";
		// 1. new_id의 모든 대문자를 대응되는 소문자로 치환
		answer = new_id.toLowerCase();

		// 2. new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
		answer = removeChar(answer);

		// 3. new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
		answer = findConti(answer);

		// 4. new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거
		answer = removeBothEnds(answer);

		// 5. new_id가 빈 문자열이라면, new_id에 "a"를 대입
		if (answer.length() == 0)
			answer = "a";

		// 6. new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
		// 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
		if (answer.length() >= 16) {
			answer = answer.substring(0, 15);
			if (answer.charAt(14) == 46)
				answer = answer.substring(0, 14);
		}

		// 7. new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙임
		answer = loopChar(answer);

		return answer;
	}

	public static String loopChar(String new_id) {
		StringBuilder sb = new StringBuilder(new_id);
		if (sb.length() <= 2) {
			char c = sb.charAt(sb.length() - 1);
			while (sb.length() < 3) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String removeBothEnds(String new_id) {
		StringBuilder sb = new StringBuilder(new_id);
		char start = sb.charAt(0);
		char end = sb.charAt(sb.length() - 1);
		if (start == 46)
			sb.deleteCharAt(0);
		if (end == 46 && sb.length() != 0)
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static String findConti(String new_id) {
		StringBuilder sb = new StringBuilder();
		boolean con = false;
		for (int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if (c == 46) {
				if (con)
					continue;
				con = true;
			} else
				con = false;
			sb.append(c);
		}
		return sb.toString();
	}

	public static String removeChar(String new_id) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if ((97 <= c && c <= 122) || (48 <= c && c <= 57) || c == 46 || c == 45 || c == 95) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
