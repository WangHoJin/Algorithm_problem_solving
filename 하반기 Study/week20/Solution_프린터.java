package second.study.week20;

import java.io.IOException;
import java.util.*;

public class Solution_프린터 {

	public static void main(String[] args) throws IOException {

	}

	static class Point {
		int val;
		int idx;

		public Point(int val, int idx) {
			super();
			this.val = val;
			this.idx = idx;
		}

//		@Override
//		public int compareTo(Point o) {
//			// TODO Auto-generated method stub
//			if (this.val == o.val)
//				return this.idx - o.idx;
//			return o.val - this.val;
//		}

	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Point> pq = new LinkedList<>();
		for (int i = 0; i < priorities.length; i++) {
			pq.add(new Point(priorities[i], i));
		}
		int time = 0;
		while (!pq.isEmpty()) {
			Point temp = pq.poll();
			boolean flag = false;
			for (Point p : pq) {
				if (p.val > temp.val)
					flag = true;
			}
			if (flag) {
				pq.add(temp);
			} else {
				time++;
				if (temp.idx == location) {
					answer = time;
					break;

				}
			}
		}
		return answer;
	}
}
