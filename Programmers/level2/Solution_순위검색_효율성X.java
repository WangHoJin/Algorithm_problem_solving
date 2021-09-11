package second.study.week11;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_순위검색 {
	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		solution(info, query);
	}

	static class Info {
		String[] str = new String[4];
		int s;

		public Info(String s1, String s2, String s3, String s4, int s) {
			super();
			this.str[0] = s1;
			this.str[1] = s2;
			this.str[2] = s3;
			this.str[3] = s4;
			this.s = s;
		}
	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		int size = info.length;
		Info[] list = new Info[size];
		for (int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(info[i], " ");
			list[i] = new Info(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(),
					Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < query.length; i++) {
			String[] split = query[i].split(" and ");
			StringTokenizer st = new StringTokenizer(split[3], " ");
			split[3] = st.nextToken();
			int s = Integer.parseInt(st.nextToken());
			for (int j = 0; j < info.length; j++) {
				boolean flag = true;
				if(s > list[j].s) continue;
				for (int k = 0; k < 4; k++) {
					if(!split[k].equals(list[j].str[k]) && !split[k].equals("-")) {
						flag = false;
						break;
					}
				}
				if(flag)
					answer[i]++;
			}
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
