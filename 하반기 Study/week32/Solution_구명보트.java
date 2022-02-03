package second.study.week32;

import java.util.*;

public class Solution_구명보트 {
	public static void main(String[] args) {
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;
		System.out.println(solution(people, limit));
	}

	public static int solution(int[] people, int limit) {
		int answer = 0;
		// 내림차순 정렬
		Integer[] arr = Arrays.stream(people).boxed().toArray(Integer[]::new);
		Arrays.sort(arr, Collections.reverseOrder());

		int len = people.length;

		// 가장 작은 값
		int max = 0;
		int min = len - 1;

		while (max <= min) {

			if (arr[max] + arr[min] <= limit) {
				max++;
				min--;
				answer++;
			} else {
				max++;
				answer++;
			}
		}
		return answer;
	}
}