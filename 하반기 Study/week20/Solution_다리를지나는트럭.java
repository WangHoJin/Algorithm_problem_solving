package second.study.week20;

import java.io.IOException;
import java.util.*;

public class Solution_다리를지나는트럭 {

	public static void main(String[] args) throws IOException {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		solution(bridge_length, weight, truck_weights);
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> q = new LinkedList<>();
		// 초기값
		q.add(0);
		int idx = 0;
		int sum = 0;
		int time = 0;
		while (!q.isEmpty()) {
			if (idx == truck_weights.length)
				break;
			int size = q.size();
			if (size >= bridge_length) {
				sum -= q.poll();
			} else {
				int input = truck_weights[idx];
				if (sum + input > weight) {
					q.add(0);
					time++;
				} else {
					q.add(input);
					sum += input;
					idx++;
					time++;
				}
			}
		}
//		System.out.println(time + bridge_length);
		answer = time + bridge_length;
		return answer;
	}
}
