package level1;

import java.util.*;

public class Solution_K번째수 {
	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		System.out.println(Arrays.toString(solution(array, commands)));
	}

	public static int[] solution(int[] array, int[][] commands) {
		int len = commands.length;
		int[] answer = new int[len];
		for (int i = 0; i < len; i++) {
			int start = commands[i][0];
			int end = commands[i][1];
			int idx = commands[i][2];
			int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			Arrays.sort(temp);
			answer[i] = temp[idx - 1];
		}
		return answer;
	}
}
