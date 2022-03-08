package second.study.week37;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12100_2048_easy2 {

	static int N, ans;
	static int[][] oriMap;
	static int[] dir;
	static final int size = 5;

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
		oriMap = new int[N][N];
		dir = new int[size];

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < N; x++) {
				int num = Integer.parseInt(st.nextToken());
				oriMap[y][x] = num;
			}
		}
		go(0);
		System.out.println(ans);
//		print(map);
	}

	private static void go(int depth) {
		if (depth == size) {
			int[][] copyMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				System.arraycopy(oriMap[i], 0, copyMap[i], 0, N);
			}
			for (int i = 0; i < size; i++) {
				switch (dir[i]) {
				case 0:
					left(copyMap);
					break;
				case 1:
					right(copyMap);
					break;
				case 2:
					up(copyMap);
					break;
				case 3:
					down(copyMap);
					break;
				}
			}
			// max값 찾기
			for (int[] map : copyMap) {
				for (int val : map) {
					ans = ans > val ? ans : val;
				}
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			dir[depth] = i;
			go(depth + 1);
		}
	}

	private static void left(int[][] copyMap) {
		Queue<Integer> list = new LinkedList<>();
		// 왼쪽 이동
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (copyMap[y][x] == 0)
					continue;
				list.add(copyMap[y][x]);
				copyMap[y][x] = 0;
			}
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int a = list.poll();
				if (!list.isEmpty() && a == list.peek()) {
					int sum = a + list.poll();
					copyMap[y][i] = sum;
					size--;
				} else
					copyMap[y][i] = a;
			}
		}
	}

	private static void right(int[][] copyMap) {
		Queue<Integer> list = new LinkedList<>();
		// 오른쪽 이동
		for (int y = 0; y < N; y++) {
			for (int x = N - 1; x >= 0; x--) {
				if (copyMap[y][x] == 0)
					continue;
				list.add(copyMap[y][x]);
				copyMap[y][x] = 0;
			}
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int a = list.poll();
				if (!list.isEmpty() && a == list.peek()) {
					int sum = a + list.poll();
					copyMap[y][N - 1 - i] = sum;
					size--;
				} else
					copyMap[y][N - 1 - i] = a;
			}
		}
	}

	private static void up(int[][] copyMap) {
		Queue<Integer> list = new LinkedList<>();
		// 위로 이동
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (copyMap[y][x] == 0)
					continue;
				list.add(copyMap[y][x]);
				copyMap[y][x] = 0;
			}
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int a = list.poll();
				if (!list.isEmpty() && a == list.peek()) {
					int sum = a + list.poll();
					copyMap[i][x] = sum;
					size--;
				} else
					copyMap[i][x] = a;
			}
		}
	}

	private static void down(int[][] copyMap) {
		Queue<Integer> list = new LinkedList<>();
		// 아래 이동
		for (int x = 0; x < N; x++) {
			for (int y = N - 1; y >= 0; y--) {
				if (copyMap[y][x] == 0)
					continue;
				list.add(copyMap[y][x]);
				copyMap[y][x] = 0;
			}
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int a = list.poll();
				if (!list.isEmpty() && a == list.peek()) {
					int sum = a + list.poll();
					copyMap[N - 1 - i][x] = sum;
					size--;
				} else
					copyMap[N - 1 - i][x] = a;
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
