package second.study.week18;

import java.io.IOException;
import java.util.ArrayList;

public class Solution_모의고사 {

	public static void main(String[] args) throws IOException {

	}

	public static int[] solution(int[] answers) {
		int[][] std = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
		int[] mod = { 5, 8, 10 };
		int[] score = new int[3];
		int max = 0;

		for (int i = 0; i < std.length; i++) {
			int sum = 0;
			for (int j = 0; j < answers.length; j++) {
				if (answers[j] == (std[i][j] % mod[i]))
					sum++;
			}
			max = Math.max(max, sum);
			score[i] = sum;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (max == score[i])
				list.add(i);
		}
		int[] answer = new int[list.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i) + 1;
		}
		return answer;
	}
}
