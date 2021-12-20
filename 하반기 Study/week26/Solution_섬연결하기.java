package second.study.week26;

import java.io.IOException;
import java.util.*;

public class Solution_섬연결하기 {

	public static void main(String[] args) throws IOException {
		int n = 5;
		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		System.out.println(solution(n, costs));
	}

	static int[] parents;

	public static int solution(int n, int[][] costs) {
		int answer = 0;
		parents = new int[n + 1];
		Arrays.sort(costs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		});
		makeSet(n);
		for (int i = 0; i < costs.length; i++) {
			int xRoot = findSet(costs[i][0]);
			int yRoot = findSet(costs[i][1]);
			if (xRoot == yRoot)
				continue;
			parents[yRoot] = xRoot;
			answer += costs[i][2];
		}
		return answer;
	}

	public static void makeSet(int n) {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	public static int findSet(int x) {
		if (parents[x] == x)
			return x;
//		return findSet(parents[x]);	// path compression 전
		return parents[x] = findSet(parents[x]); // path compression 후
	}
}
