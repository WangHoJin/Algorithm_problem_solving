package ssafy.study.week09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브 {
	static int N, ans;
	static int[][] map;
	static ArrayList<Integer> dir;
	final static int SIZE = 100;

	static class Point {
		int y, x, d, g;

		public Point(int y, int x, int d, int g) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
			this.g = g;
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/드래곤커브.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[SIZE][SIZE];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			map[y][x] = 1; // 시작점
			dir = new ArrayList<>(); // 방향을 저장할 리스트
			dir.add(d); // 초기 방향 저장
			makeDir(d, g); // 세대에 따른 방향을 만드는 함수
			makeLine(y, x, 0); // 선을 그리는 함수
//			print();
		}
		findBox(); // 네 꼭짓점이 일치하는 영역 찾는 함수
		System.out.println(ans);

	}

	private static void makeDir(int d, int g) {
		// 마지막 지점으로부터 이동방향이 0->1->2->3->0.. 순으로 바뀌는 규칙
		Stack<Integer> stack = new Stack<>();
		// g세대까지 반복
		for (int cnt = 0; cnt < g; cnt++) {
			// 현재 방향을 stack에 push
			for (int i = 0; i < dir.size(); i++) {
				stack.push(dir.get(i));
			}
			// stack에서 꺼내면서 다음 방향을 dir에 저장
			// dir에는 최종 방향들의 순서가 저장되어있음
			while (!stack.isEmpty()) {
				Integer temp = stack.pop();
				int nd = (temp + 1) % 4;
				dir.add(nd);
			}
		}
	}

	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };

	private static void makeLine(int y, int x, int idx) {
		if (idx == dir.size()) {
//			print();
			return;
		}
		// 시작지점으로 부터 방향 정보를 하나씩 꺼내서 선을 그린다
		int d = dir.get(idx);
		int ny = y + dy[d];
		int nx = x + dx[d];
		map[ny][nx] = 1;
		makeLine(ny, nx, idx + 1);
	}

	private static void findBox() {
		int[] dy = { 0, 1, 1 };
		int[] dx = { 1, 1, 0 };
		// 3방(→↘↓) 탐색을 통해 해당영역 카운트
		for (int y = 0; y < SIZE - 1; y++) {
			for (int x = 0; x < SIZE - 1; x++) {
				if (map[y][x] != 1)
					continue;
				for (int d = 0; d < 3; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (map[ny][nx] != 1)
						break;
					if (d == 2)
						ans++;
				}
			}
		}
	}

	private static void print() {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		System.out.println("===================");
	}
}
