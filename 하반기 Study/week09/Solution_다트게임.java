package kakao.level1;

import java.util.ArrayList;

public class Solution_다트게임 {
	public static void main(String[] args) {
		String dartResult = "1S2D*3T";
		System.out.println(solution(dartResult));

	}

	public static int solution(String dartResult) {
		int answer = 0;
		int len = dartResult.length();
		ArrayList<Integer> score = new ArrayList<>();
		int num = 0;
		for (int i = 0; i < len; i++) {
			char c = dartResult.charAt(i);
			// 점수부분 뽑기
			if (0 <= c - '0' && c - '0' <= 9) {
				// 10은 예외처리
				if (c - '0' == 1 && dartResult.charAt(i + 1) - '0' == 0) {
					num = 10;
					i++;
				} else
					num = c - '0';
			}
			// 보너스 처리
			else if (c == 'S' || c == 'D' || c == 'T') {
				int bonus = 0;
				if (c == 'S')
					bonus = (int) Math.pow(num, 1);
				else if (c == 'D')
					bonus = (int) Math.pow(num, 2);
				else
					bonus = (int) Math.pow(num, 3);
				score.add(bonus);
			}
			// 옵션 처리
			else {
				int idx = score.size() - 1;
				if (c == '*') {
					if (idx != 0) {
						int now = score.get(idx);
						int pre = score.get(idx - 1);
						score.set(idx, now * 2);
						score.set(idx - 1, pre * 2);
					} else {
						int now = score.get(idx);
						score.set(idx, now * 2);
					}
				} else {
					int now = score.get(idx);
					score.set(idx, now * (-1));
				}
			}
		}
		for (Integer i : score) {
			answer += i;
		}
		return answer;
	}
}
