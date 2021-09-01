package level1;

import java.util.Arrays;

public class Solution_로또의최고순위와최저순위 {
	public static void main(String[] args) {
		Solution_로또의최고순위와최저순위 s = new Solution_로또의최고순위와최저순위();
		int[] lottos = { 44, 1, 0, 0, 31, 25 };
		int[] win_nums = { 31, 10, 45, 1, 6, 19 };

		System.out.println(Arrays.toString(s.solution(lottos, win_nums)));
	}

	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		int joker = 0;
		int cnt = 0;
		for (int i : lottos) {
			if (i == 0)
				joker++;
			for (int j : win_nums) {
				if (i == j)
					cnt++;
			}
		}

		answer[0] = getRank(cnt + joker);
		answer[1] = getRank(cnt);
		return answer;
	}

	public int getRank(int cnt) {
		int rank = 0;
		switch (cnt) {
		case 6:
			rank = 1;
			break;
		case 5:
			rank = 2;
			break;
		case 4:
			rank = 3;
			break;
		case 3:
			rank = 4;
			break;
		case 2:
			rank = 5;
			break;
		default:
			rank = 6;
			break;
		}
		return rank;
	}
}
