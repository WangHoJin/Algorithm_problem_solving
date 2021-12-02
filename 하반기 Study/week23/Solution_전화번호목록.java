package second.study.week23;

import java.io.IOException;
import java.util.*;

public class Solution_전화번호목록 {

	public static void main(String[] args) throws IOException {
		String[] phone_book = { "119", "97674223", "1195524421" };
		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < phone_book.length; i++)
			hm.put(phone_book[i], 1);

		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 1; j < phone_book[i].length(); j++) {
				if (hm.containsKey(phone_book[i].substring(0, j))) {
					answer = false;
					return answer;
				}
			}
		}
		return answer;
	}
}
