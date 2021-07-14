package ssafy.study.week04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
	static int K, Ans;
	static char[][] wheelState;
	static boolean[] check;
	static int[] index;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		wheelState = new char[4][8];
		check = new boolean[4];
		index = new int[4];
		for (int i = 0; i < 4; i++) {
			wheelState[i] = in.readLine().toCharArray();
		}
		K = Integer.parseInt(in.readLine());
		for (int i = 0; i < K; i++) {
			check = new boolean[4];
			index = new int[4];
			st = new StringTokenizer(in.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken()) - 1; // 문제와 인덱스 맞춤
			int dir = Integer.parseInt(st.nextToken()); // 1:시계 -1:반시계

			// 회전하는 함수
			Rotation(idx, dir);

		}
		for (int i = 0; i < 4; i++) {
			// 12시 방향이 N극이면 패스
			if (wheelState[i][0] == '0')
				continue;
			// 아닐경우 2^i 더하기
			Ans += Math.pow(2, i);
		}
		System.out.println(Ans);
	}

	private static void Rotation(int idx, int dir) {
		// 시작 톱니바퀴 체크
		int d = dir;
		check[idx] = true;
		index[idx] = dir;
		// 왼쪽
		for (int i = 1; i <= idx; i++) {
			// 인덱스가 넘어가지않고
			// 시작 톱니바퀴의 9시와 3시가 다른 극이면
			if (idx - i >= 0 && wheelState[idx - i + 1][6] != wheelState[idx - i][2]) {
				check[idx - i] = true;
				index[idx - i] = -d;
				d *= -1;
			} else
				break;
		}
		d = dir;
		// 오른쪽
		for (int i = 1; i < 4 - idx; i++) {
			// 시작 톱니바퀴의 3시와 오른쪽 톱니바퀴의 9시가 다른 극이면
			if (idx + i < 4 && wheelState[idx + i - 1][2] != wheelState[idx + i][6]) {
				check[idx + i] = true;
				index[idx + i] = -d;
				d *= -1;
			} else
				break;
		}
		// 한번에 톱니바퀴 돌리기
		for (int i = 0; i < 4; i++) {
			if (check[i]) {
				// 그냥 배열 스왑
				swap(i, index[i]);
			}
		}
	}

	private static void swap(int idx, int dir) {
		if (dir == -1) {
			char temp = wheelState[idx][0];
			for (int i = 1; i < 8; i++) {
				wheelState[idx][i - 1] = wheelState[idx][i];

			}
			wheelState[idx][7] = temp;
		} else if (dir == 1) {
			char temp = wheelState[idx][7];
			for (int i = 7; i > 0; i--) {
				wheelState[idx][i] = wheelState[idx][i - 1];
			}
			wheelState[idx][0] = temp;
		}
	}
}
