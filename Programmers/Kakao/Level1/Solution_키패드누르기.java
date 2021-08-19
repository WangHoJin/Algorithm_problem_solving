package kakao2020.level1;

public class Solution_키패드누르기 {
	public static void main(String[] args) {
		int[] numbers = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
		String hand = "left";
		System.out.println(solution(numbers, hand));

	}

	public static String solution(int[] numbers, String hand) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		// 현재 손가락이 있는 위치
		int left = 9, right = 11;

		// 키패드 숫자에 따른 왼쪽 손가락, 오른쪽 손가락 구분
		for (int i = 0; i < numbers.length; i++) {
			int keypad = numbers[i] - 1;
			// 키패드 숫자가 1,4,7,* 이면 왼쪽 손가락
			if (keypad % 3 == 0) {
				sb.append("L");
				left = keypad;
			}
			// 키패드 숫자가 3,6,9,# 이면 오른쪽 손가락
			else if (keypad % 3 == 2) {
				sb.append("R");
				right = keypad;
			}
			// 키패드 숫자가 2,5,8,0 이면
			else {
				if (keypad == -1)
					keypad = 10;
				// 거리구하기
				int lDiff = distance(keypad,left);
				int rDiff = distance(keypad,right);
				// 왼쪽 손가락이 더 가깝다면
				if (lDiff < rDiff) {
					left = keypad;
					sb.append("L");
				}
				// 오른쪽 손가락이 더 가깝다면
				else if (lDiff > rDiff) {
					right = keypad;
					sb.append("R");
				}
				// 거리가 같다면
				else {
					if (hand.equals("left")) {
						left = keypad;
						sb.append("L");
					} else {
						right = keypad;
						sb.append("R");
					}
				}
			}
		}
		answer = sb.toString();
		return answer;
	}

	private static int distance(int keypad, int now) {
		int ky = keypad / 3;
		int kx = keypad % 3;
		int ny = now / 3;
		int nx = now % 3;
		int diff =  Math.abs(ky-ny)+Math.abs(kx-nx);
		return diff;
	}
}
