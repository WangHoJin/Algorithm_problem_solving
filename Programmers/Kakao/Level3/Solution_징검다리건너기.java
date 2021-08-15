package study.week13;

public class Solution_징검다리건너기 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		System.out.println(solution.solution(stones, k));
	}
}

class Solution {
	public int solution(int[] stones, int k) {
		int answer = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; i < stones.length; i++) {
			end = Math.max(end, stones[i]);
		}
		
		while (start <= end) {
			int mid = (start + end)/2;
			int cnt = 0;
			for (int i = 0; i < stones.length; i++) {
				if(stones[i] < mid) {
					cnt++;
					if(cnt >= k) break;
					continue;
				}
				cnt = 0;
			}
			if(cnt >= k) end = mid - 1;
			else {
				answer = Math.max(answer, mid);
				start = mid +1;
			}
		}
		return answer;
	}
}