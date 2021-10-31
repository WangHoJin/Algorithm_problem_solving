package second.study.week18;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Solution_완주하지못한선수 {

	public static void main(String[] args) throws IOException {

	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < participant.length; i++) {
			String key = participant[i];
			int cnt = 1;
			if (hm.containsKey(key)) {
				cnt = hm.get(key);
				cnt++;
			}
			hm.put(key, cnt);
		}
		for (int i = 0; i < completion.length; i++) {
			String key = completion[i];
			int cnt = hm.get(key);
			if (hm.containsKey(key)) {
				cnt--;
			}
			hm.put(key, cnt);
		}
		Iterator<Entry<String, Integer>> iterator = hm.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			if (entry.getValue() != 0) {
				answer = entry.getKey();
				break;
			}
		}

		return answer;
	}
}
