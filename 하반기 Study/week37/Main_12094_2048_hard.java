package second.study.week37;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12094_2048_hard {

	static int N, ans;
	static int[][] map;
	static int[] dir;
	static final int size = 10;

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/37/2048_easy.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		dir = new int[size];

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < N; x++) {
				int num = Integer.parseInt(st.nextToken());
				map[y][x] = num;
			}
		}
		go(0);
		System.out.println(ans);
//		print(map);
	}

	private static void go(int depth) {
		int curMax = findMaxVal();

		ans = ans >= curMax ? ans : curMax;
		if (depth == size || ans >= curMax * Math.pow(2, size - depth)) {
			return;
		}

		int[][] clone = new int[N][N];
		copyMap(map, clone);

		left();
		if (ifSameMap(clone)) {
			go(depth + 1);
			copyMap(clone, map);
		}

		up();
		if (ifSameMap(clone)) {
			go(depth + 1);
			copyMap(clone, map);
		}

		right();
		if (ifSameMap(clone)) {
			go(depth + 1);
			copyMap(clone, map);
		}

		down();
		if (ifSameMap(clone)) {
			go(depth + 1);
			copyMap(clone, map);
		}
	}

	private static int findMaxVal() {
		int num = 0;
		for (int[] m : map) {
			for (int val : m) {
				num = num > val ? num : val;
			}
		}
		return num;
	}

	private static boolean ifSameMap(int[][] clone) {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] != clone[y][x])
					return true;
			}
		}
		return false;
	}

	private static void copyMap(int[][] map, int[][] clone) {
		for (int i = 0; i < clone.length; i++) {
			System.arraycopy(map[i], 0, clone[i], 0, N);
		}
	}

	private static void left() {
		Queue<Integer> list = new LinkedList<>();
		// 왼쪽 이동
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] == 0)
					continue;
				list.add(map[y][x]);
				map[y][x] = 0;
			}
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int a = list.poll();
				if (!list.isEmpty() && a == list.peek()) {
					int sum = a + list.poll();
					map[y][i] = sum;
					size--;
				} else
					map[y][i] = a;
			}
		}
	}

	private static void right() {
		Queue<Integer> list = new LinkedList<>();
		// 오른쪽 이동
		for (int y = 0; y < N; y++) {
			for (int x = N - 1; x >= 0; x--) {
				if (map[y][x] == 0)
					continue;
				list.add(map[y][x]);
				map[y][x] = 0;
			}
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int a = list.poll();
				if (!list.isEmpty() && a == list.peek()) {
					int sum = a + list.poll();
					map[y][N - 1 - i] = sum;
					size--;
				} else
					map[y][N - 1 - i] = a;
			}
		}
	}

	private static void up() {
		Queue<Integer> list = new LinkedList<>();
		// 위로 이동
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (map[y][x] == 0)
					continue;
				list.add(map[y][x]);
				map[y][x] = 0;
			}
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int a = list.poll();
				if (!list.isEmpty() && a == list.peek()) {
					int sum = a + list.poll();
					map[i][x] = sum;
					size--;
				} else
					map[i][x] = a;
			}
		}
	}

	private static void down() {
		Queue<Integer> list = new LinkedList<>();
		// 아래 이동
		for (int x = 0; x < N; x++) {
			for (int y = N - 1; y >= 0; y--) {
				if (map[y][x] == 0)
					continue;
				list.add(map[y][x]);
				map[y][x] = 0;
			}
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int a = list.poll();
				if (!list.isEmpty() && a == list.peek()) {
					int sum = a + list.poll();
					map[N - 1 - i][x] = sum;
					size--;
				} else
					map[N - 1 - i][x] = a;
			}
		}
	}

	private static void print(int[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int[] y : map) {
			for (int x : y) {
				sb.append(x + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
