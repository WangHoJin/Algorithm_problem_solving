package second.study.week29;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class Solution_순위검색 {
	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		System.out.println(Arrays.toString(solution(info, query)));
	}

	static HashMap<String, ArrayList<Integer>> hm;
	static ArrayList<Integer> scoreList;

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		hm = new HashMap<>();
		scoreList = new ArrayList<>();
		// 1. info로 주어지는 데이터의 모든 경우의 수 -> 공백 '-' 포함
		for (int i = 0; i < info.length; i++) {
			combi("", 0, info[i].split(" "));

		}
		// 2. 점수 기준으로 정렬
		ArrayList<String> list = new ArrayList<>(hm.keySet());
		for (int i = 0; i < list.size(); i++) {
			ArrayList<Integer> score = hm.get(list.get(i));
			Collections.sort(score);
		}
		// 3. 이분탐색
		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] qData = query[i].split(" ");
			int qScore = Integer.parseInt(qData[1]);
			answer[i] = bSearch(qData[0], qScore);
		}
		return answer;
	}

	private static int bSearch(String qData, int qScore) {
		if (!hm.containsKey(qData))
			return 0;

		ArrayList<Integer> score = hm.get(qData);
		int start = 0;
		int end = score.size() - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (score.get(mid) < qScore) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return score.size() - start;
	}

	private static void combi(String str, int cnt, String[] data) {
		if (cnt == 4) {
			System.out.println(str);
			// 해당 조건이 없는 경우 => 새로운 점수 리스트 추가
			if (!hm.containsKey(str)) {
				scoreList = new ArrayList<>();
				scoreList.add(Integer.parseInt(data[4]));
				hm.put(str, scoreList);
			}
			// 해당 조건이 있는 경우 => 기존 점수 리스트에 점수 추가
			else {
				hm.get(str).add(Integer.parseInt(data[4]));
			}
			return;
		}
		combi(str + "-", cnt + 1, data);
		combi(str + data[cnt], cnt + 1, data);
	}
}