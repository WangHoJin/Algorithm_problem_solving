package second.study.week23;

import java.io.IOException;
import java.util.*;

public class Solution_이중우선순위큐 {

	public static void main(String[] args) throws IOException {
		String[] operations = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
		System.out.println(Arrays.toString(solution(operations)));
	}

	public static int[] solution(String[] operations) {
		int[] answer = new int[2];
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		for (int i = 0; i < operations.length; i++) {
			StringTokenizer st = new StringTokenizer(operations[i], " ");
			String type = st.nextToken();
			if (type.equals("I")) {
				int num = Integer.parseInt(st.nextToken());
				tm.put(num, tm.getOrDefault(num, 0) + 1);
			} else {
				if (tm.isEmpty())
					continue;
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					int max = tm.lastKey();
					if (tm.get(max) == 1)
						tm.remove(max);
					// 같은 숫자가 있을경우
					else {
						tm.put(max, tm.get(max) - 1);
					}
				} else {
					int min = tm.firstKey();
					if (tm.get(min) == 1)
						tm.remove(min);
					// 같은 숫자가 있을경우
					else {
						tm.put(min, tm.get(min) - 1);
					}
				}
			}

		}
		if (tm.isEmpty()) {
			answer[0] = 0;
			answer[1] = 0;
		} else {
			answer[0] = tm.lastKey();
			answer[1] = tm.firstKey();
		}
		return answer;
	}
}
