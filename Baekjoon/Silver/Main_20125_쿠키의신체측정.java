import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, hy, hx, wy, wx;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("input/Silver/쿠키의신체측정.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		char[][] map = new char[N][N];
		boolean head = false;
		for (int y = 0; y < N; y++) {
			String str = in.readLine();
			for (int x = 0; x < N; x++) {
				map[y][x] = str.charAt(x);
				if (!head && map[y][x] == '*') {
					// 심장 좌표 = 머리 바로 아래
					hy = y + 1;
					hx = x;
					head = true;
				}
			}
		}
		// 왼쪽팔
//		print(map);
//		System.out.println("왼팔 길이 : " + leftArm(map, hy, hx));
//		System.out.println("오른팔 길이 : " + rightArm(map, hy, hx));
//		System.out.println("허리 길이 : " + waist(map, hy, hx));
//		System.out.println("왼다리 길이 : " + leftLeg(map, wy, wx - 1));
//		System.out.println("오른다리 팔길이 : " + rightLeg(map, wy, wx + 1));

		System.out.println((hy + 1) + " " + (hx + 1));
		System.out.println(leftArm(map, hy, hx) + " " + rightArm(map, hy, hx) + " " + waist(map, hy, hx) + " "
				+ leftLeg(map, wy, wx - 1) + " " + rightLeg(map, wy, wx + 1));

	}

	private static int rightLeg(char[][] map, int wy, int wx) {
		int len = 0;
		for (int i = wy; i < N; i++) {
			if (map[i][wx] == '*') {
				len++;
			}
		}
		return len;
	}

	private static int leftLeg(char[][] map, int wy, int wx) {
		int len = 0;
		for (int i = wy; i < N; i++) {
			if (map[i][wx] == '*') {
				len++;
			}
		}
		return len;
	}

	private static int waist(char[][] map, int hy, int hx) {
		int len = 0;
		for (int i = hy + 1; i < N; i++) {
			if (map[i][hx] == '*') {
				len++;
			} else {
				wy = i;
				wx = hx;
				break;
			}
		}
		return len;
	}

	private static int rightArm(char[][] map, int hy, int hx) {
		int len = 0;
		for (int i = hx + 1; i < N; i++) {
			if (map[hy][i] == '*')
				len++;
		}
		return len;
	}

	private static int leftArm(char[][] map, int hy, int hx) {
		int len = 0;
		for (int i = hx - 1; i >= 0; i--) {
			if (map[hy][i] == '*')
				len++;
		}
		return len;
	}

	private static void print(char[][] map) {
		for (char[] y : map) {
			for (char x : y) {
				System.out.print(x);
			}
			System.out.println();
		}
	}
}
