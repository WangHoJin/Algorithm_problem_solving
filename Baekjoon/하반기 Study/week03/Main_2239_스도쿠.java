import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2239_스도쿠 {
	static int[][] map;
	static final int SIZE = 9;
	static ArrayList<Point> arr;

	static class Point {
		int y, x;
		ArrayList<Integer> number = new ArrayList<>();
		boolean[] check;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/스도쿠.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new int[SIZE][SIZE];
		arr = new ArrayList<>();
		for (int y = 0; y < SIZE; y++) {
			String str = in.readLine();
			for (int x = 0; x < SIZE; x++) {
				map[y][x] = str.charAt(x) - '0';
				if (map[y][x] == 0) {
					arr.add(new Point(y, x));
				}
			}
		}

		// 해당 위치에 없는 숫자 검사
		findNum(0);
	}

	private static void findNum(int idx) {
		// 모든 빈칸을 다 채우면 종료
		if (idx == arr.size()) {
			print();
			System.exit(0);
		}
		// 모든 빈칸에 1~9까지 숫자를 넣어본다
		Point temp = arr.get(idx);
		for (int i = 1; i <= SIZE; i++) {
			// 1~9중에 가능한 숫자만 삽입
			if (possibleNum(temp.y, temp.x, i)) {
				map[temp.y][temp.x] = i;
				findNum(idx + 1);
			}
		}
		map[temp.y][temp.x] = 0;

	}

	private static boolean possibleNum(int ny, int nx, int num) {
		// 상하좌우 검사 내부 3x3검사
		if (outside(ny, nx, num) && inside(ny, nx, num))
			return true;
		return false;
	}

	private static boolean inside(int ny, int nx, int num) {
		int i = (ny / 3) * 3;
		int j = (nx / 3) * 3;
		for (int y = i; y < i + 3; y++) {
			for (int x = j; x < j + 3; x++) {
				if (map[y][x] == num)
					return false;
			}
		}
		return true;
	}

	private static boolean outside(int ny, int nx, int num) {
		for (int y = 0; y < SIZE; y++) {
			if (map[y][nx] == num)
				return false;
		}
		for (int x = 0; x < SIZE; x++) {
			if (map[ny][x] == num)
				return false;
		}
		return true;
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int[] y : map) {
			for (int x : y) {
				sb.append(x);
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
