package level2;

import java.util.*;

public class Solution_소수찾기 {
	public static HashSet<Integer> hs;

	public static void main(String[] args) {
		String numbers = "17";
		System.out.println(solution(numbers));
	}

	public static int solution(String numbers) {
		int answer = 0;
		hs = new HashSet<>();
		for (int i = 1; i <= numbers.length(); i++) {
			permutation(0, numbers.toCharArray(), new char[i], new boolean[numbers.length()], i);
		}
		return isPrimeCnt();
	}

	public static void permutation(int cnt, char[] arr, char[] sel, boolean[] v, int size) {
		if (cnt == sel.length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < cnt; i++) {
				sb.append(sel[i]);
			}
			hs.add(Integer.parseInt(sb.toString()));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!v[i]) {
				sel[cnt] = arr[i];
				v[i] = true;
				permutation(cnt + 1, arr, sel, v, size);
				v[i] = false;
			}
		}
	}

	public static int isPrimeCnt() {
		int cnt = 0;
		Iterator<Integer> it = hs.iterator();
		while (it.hasNext()) {
			boolean ip = true;
			int num = it.next();
			it.remove();
			if (num == 0 || num == 1)
				continue;
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					ip = false;
					break;
				}
			}
			if (ip)
				cnt++;
		}
		return cnt;
	}
}
