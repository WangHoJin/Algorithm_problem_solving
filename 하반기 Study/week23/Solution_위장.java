package second.study.week23;

import java.io.IOException;
import java.util.*;

public class Solution_위장 {

	public static void main(String[] args) throws IOException {
		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(solution(clothes));
	}

	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < clothes.length; i++)
			hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
		Iterator<Integer> it = hm.values().iterator();

		while (it.hasNext()) {
			// 아무것도 선택하지 않을 경우 +1 추가
			answer *= it.next().intValue() + 1;
		}

		// 아무것도 입지않은 경우 제외 -1
		return answer - 1;
	}
}
