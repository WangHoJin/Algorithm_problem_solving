package ssafy.study.week10;

public class Solution_자물쇠와열쇠_programmers {

	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		System.out.println(solution(key, lock));
	}

	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = true;
		// 자물쇠의 범위를 열쇠크기만큼 늘리자
		int ex_size = key.length - 1;	// 확장될 길이
		int ori_size = lock.length;	// 자물쇠 길이
		int[][] exLock = new int[ori_size + ex_size * 2][ori_size + ex_size * 2];	// 확장된 자물쇠
		int holeCnt = expandLock(ex_size, ori_size, lock, exLock);	// 자물쇠의 홈의 개수
//		print(exLock);

		// 열쇠의 4가지 회전 모양을 자물쇠의 모든 범위에 탐색
		// 나중에 함수로 만들어서 return..
		L: for (int i = 0; i < 4; i++) {
			// 일치하는 경우를 찾자 => 일단 완탐돌려~
			for (int y = 0; y < exLock.length - ex_size; y++) {
				for (int x = 0; x < exLock.length - ex_size; x++) {
					// 자물쇠와 일치하는 키가 있는지 판단하는 함수
					answer = mathKey(y, x, exLock, key, holeCnt, ex_size, ori_size);
					if (answer)
						break L;
				}
			}

//			print(key);
			key = rotationKey(key);
		}
		return answer;
	}

	private static boolean mathKey(int start_y, int start_x, int[][] exLock, int[][] key, int holeCnt, int ex_size,
			int ori_size) {
		for (int y = 0; y < key.length; y++) {
			for (int x = 0; x < key.length; x++) {
				// 자물쇠의 돌기와 키의 돌기가 만나면 X
				if (exLock[start_y + y][start_x + x] == 1 && key[y][x] == 1)
					return false;

				// 자물쇠 홈과 키의 돌기가 만날때
				if (exLock[start_y + y][start_x + x] == 0 && key[y][x] == 1) {
					// 자물쇠 범위내일때 자물쇠 홈의 개수 감소
					if (check(start_y + y, start_x + x, ex_size, ori_size))
						holeCnt--;
				}
			}
		}
		// 홈의 개수가 0이 되면 키로 자물쇠를 열수있음
		return (holeCnt == 0) ? true : false;
	}

	private static boolean check(int y, int x, int ex_size, int ori_size) {
		// 자물쇠 범위 내인가
		if (y >= ex_size && y < ex_size + ori_size && x >= ex_size && x < ex_size + ori_size)
			return true;
		return false;
	}

	private static int[][] rotationKey(int[][] key) {
		int size = key.length;
		int[][] copy = new int[size][size];
		// \대칭 후 y대칭을 하면 90도 회전
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				copy[y][size - 1 - x] = key[x][y];
			}
		}
		return copy;
	}

	private static int expandLock(int ex_size, int ori_size, int[][] lock, int[][] exLock) {
		int cnt = 0; // 홈 부분
		for (int y = 0; y < ori_size; y++) {
			for (int x = 0; x < ori_size; x++) {
				int a = lock[y][x];
				exLock[y + ex_size][x + ex_size] = a;
				// 홈의 개수 카운트
				if (a == 0)
					cnt++;
			}
		}
		return cnt;
	}

	private static void print(int[][] map) {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		System.out.println("=======================");
	}

}
