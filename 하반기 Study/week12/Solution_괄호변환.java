package second.study.week12;

public class Solution_괄호변환 {
	public static void main(String[] args) {
		String p = "(()())()";
		solution(p);
	}

	public static String solution(String p) {
		String answer = "";
		answer = separation(p);
		System.out.println(answer);
		return answer;
	}

	private static String separation(String p) {
		if (p.equals(""))
			return p;
		int len = p.length();
		int cnt = 0;
		String u = "", v = "";
		// u,v로 문자열 분리
		for (int i = 0; i < len; i++) {
			char c = p.charAt(i);
			if (c == '(')
				cnt++;
			else
				cnt--;

			if (cnt == 0) {
				u = p.substring(0, i + 1);
				v = p.substring(i + 1, len);
				break;
			}
		}
		// 문자열 u가 "올바른 괄호 문자열" 이라면
		if (isCorrect(u)) {
			StringBuilder sb = new StringBuilder();
			// 문자열 v에 대해 1단계부터 다시 수행합니다.
			// 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
			sb.append(u);
			sb.append(separation(v));
			return sb.toString();
		}
		// 문자열 u가 "올바른 괄호 문자열"이 아니라면
		else {
			StringBuilder sb = new StringBuilder();
			// 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
			sb.append("(");
			// 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
			sb.append(separation(v));
			// ')'를 다시 붙입니다.
			sb.append(")");
			// u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
			for (int i = 1; i < u.length() - 1; i++) {
				char c = u.charAt(i);
				sb.append(c == '(' ? ')' : '(');
			}
			// 생성된 문자열을 반환합니다.
			return sb.toString();
		}

	}

	private static boolean isCorrect(String str) {
		int cnt = 0;
		for (char c : str.toCharArray()) {
			if (c == '(')
				cnt++;
			else
				cnt--;

			// cnt가 0보다 작아지면 올바른 괄호 문자열 X
			if (cnt < 0)
				return false;
		}
		return true;
	}
}
