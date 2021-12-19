package second.study.week25;

import java.io.IOException;
import java.util.*;

public class Solution_단속카메라 {

	public static void main(String[] args) throws IOException {
		int[][] routes = { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		System.out.println(solution(routes));
	}

	public static int solution(int[][] routes) {
		int answer = 0;
		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[1] - o2[1];
			}
		});
		int now = -30001;
		for (int[] r : routes) {
			if (now < r[0]) {
				now = r[1];
				answer++;
			}
		}
		return answer;
	}
}
