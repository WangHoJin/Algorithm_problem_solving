package second.study.week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Solution_메뉴리뉴얼 {
	public static void main(String[] args) {
		String[] orders = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course = { 2, 3, 5 };
		System.out.println(solution(orders, course).toString());
	}
	static HashMap<String, Integer> hm;
	public static ArrayList<String> solution(String[] orders, int[] course) {
		ArrayList<String> answer = new ArrayList<>();
		// 모든 알파벳 조합구해서 카운트하기
		for (int j = 0; j < course.length; j++) {
			int max = 0;
			hm = new HashMap<>();
			// 오름차순 문자 정렬
			for (int i = 0; i < orders.length; i++) {
				char[] arr = orders[i].toCharArray();
				Arrays.sort(arr);
				combi(arr, new char[course[j]], 0, 0);
			}
			// 저장된 알파벳 조합중 max값 찾기
			for (Entry<String, Integer> e : hm.entrySet()) {
				max = Math.max(max, e.getValue());
			}
			for (Entry<String, Integer> e : hm.entrySet()) {
				if (max >= 2 && e.getValue() == max) {
					answer.add(e.getKey());
				}
			}
		}
		Collections.sort(answer);
		return answer;
	}

	private static void combi(char[] str, char[] sel, int start, int cnt) {
		if (cnt == sel.length) {
			// 해쉬맵을 이용하여 중복값 카운트 => getOrDefault 함수 사용
			hm.put(String.valueOf(sel), hm.getOrDefault(String.valueOf(sel), 0) + 1);
//			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = start; i < str.length; i++) {
			sel[cnt] = str[i];
			combi(str, sel, i + 1, cnt + 1);
		}
	}
}
