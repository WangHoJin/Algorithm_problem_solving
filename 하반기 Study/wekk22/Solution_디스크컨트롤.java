package second.study.week22;

import java.io.IOException;
import java.util.*;

import sun.misc.Perf;

public class Solution_디스크컨트롤 {

	public static void main(String[] args) throws IOException {
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };

		System.out.println(solution(jobs));
	}

	static class Point implements Comparable<Point> {
		int start, time, rest;

		public Point(int start, int time) {
			super();
			this.start = start;
			this.time = time;
		}

		public Point(int start, int time, int rest) {
			super();
			this.start = start;
			this.time = time;
			this.rest = rest;
		}

		@Override
		public int compareTo(Point o) {
			return this.time - o.time;
		}
	}

	public static int solution(int[][] jobs) {
		int answer = 0;
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		PriorityQueue<Point> pq = new PriorityQueue<>();
		int idx = 0;
		int end = 0;
		for (int i = 0; i < jobs.length;) {
			while (idx < jobs.length && jobs[idx][0] <= end) {
				pq.add(new Point(jobs[idx][0], jobs[idx][1]));
				idx++;
			}

			if (!pq.isEmpty()) {
				Point temp = pq.poll();
				end += temp.time;
				answer += end - temp.start;
				i++;
			} else {
				end = jobs[idx][0];
			}
		}

		answer /= jobs.length;
		return answer;
	}
}
