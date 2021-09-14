package level1;

import java.util.Arrays;

public class Solution_소수만들기 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };

		solution(nums);
	}

	public static int solution(int[] nums) {
		int answer = -1;
		combi(0, 0, nums, 0);
		answer = ans;
		return answer;
	}

	static int ans = 0;

	private static void combi(int start, int cnt, int[] nums, int sum) {
		if (cnt == 3) {
			System.out.println(sum);
			if (isPrimeCnt(sum))
				ans++;
			return;
		}

		for (int i = start; i < nums.length; i++) {
			sum += nums[i];
			combi(i + 1, cnt + 1, nums, sum);
			sum -= nums[i];
		}

	}

	public static boolean isPrimeCnt(int num) {
		boolean ip = true;
		if (num == 0 || num == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				ip = false;
				break;
			}
		}
		if (ip)
			return true;
		return false;
	}
}
