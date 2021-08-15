package ssafy.study.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_단지번호붙이기 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static ArrayList<Integer> sort;
//	static StringBuilder sb;

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		sort = new ArrayList<>();
//		sb = new StringBuilder();
		for (int y = 0; y < N; y++) {
			map[y] = in.readLine().toCharArray();
		}
		int count = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] == '1' && !visited[y][x]) {
					bfs(y, x);
					count++;
				}
			}
		}
		System.out.println(count);
		Collections.sort(sort);
		for (int i = 0; i < sort.size(); i++) {
			System.out.println(sort.get(i));
		}
//		sb.append(count+"\n");
//		sb.setLength(sb.length() - 1);
//		print();
	}

	private static void bfs(int y, int x) {
		int cnt = 1;
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(y, x));
		visited[y][x] = true;
		while (!q.isEmpty()) {
			Point temp = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				if (!check(ny, nx) || visited[ny][nx] || map[ny][nx] != '1')
					continue;
				visited[ny][nx] = true;
				q.add(new Point(ny, nx));
				cnt++;
			}
		}
		sort.add(cnt);
//		sb.append(cnt + "\n");
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < N)
			return true;
		return false;
	}

	private static void print() {
		for (char[] y : map) {
			for (char x : y) {
				System.out.print(x);
			}
			System.out.println();
		}

	}
}
