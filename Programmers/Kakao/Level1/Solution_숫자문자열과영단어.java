package kakao.level1;

public class Solution_숫자문자열과영단어 {
	public static void main(String[] args) {
		String s = "one4seveneight";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = 0;
		int len = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			// 숫자일때는 그대로
			if (0 <= c - '0' && c - '0' <= 9)
				sb.append(c);
			// 영단어일때는 변환
			// t,f,s 일때만 예외처리 나머지 첫글자로 판단
			else {
				switch (c) {
				case 'z':
					sb.append(0);
					i += 3;
					break;
				case 'o':
					sb.append(1);
					i += 2;
					break;
				case 't':
					char next = s.charAt(i + 1);
					if (next == 'w') {
						sb.append(2);
						i += 2;
					} else {
						sb.append(3);
						i += 4;
					}
					break;
				case 'f':
					next = s.charAt(i + 1);
					if (next == 'o') {
						sb.append(4);
						i += 3;
					} else {
						sb.append(5);
						i += 3;
					}
					break;
				case 's':
					next = s.charAt(i + 1);
					if (next == 'i') {
						sb.append(6);
						i += 2;
					} else {
						sb.append(7);
						i += 4;
					}
					break;
				case 'e':
					sb.append(8);
					i += 4;
					break;
				case 'n':
					sb.append(9);
					i += 3;
					break;
				}
			}
		}
		answer = Integer.parseInt(sb.toString());
		return answer;
	}
}
