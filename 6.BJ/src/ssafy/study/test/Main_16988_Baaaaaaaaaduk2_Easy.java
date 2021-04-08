package ssafy.study.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16988_Baaaaaaaaaduk2_Easy {
	static int N, M, killCnt, ans;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Point> white;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/baduk2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		white = new ArrayList<>(); // 편의상 상대방 돌(2)=>흰색, 내 돌(1)=>흑돌 정의
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < M; x++) {
				int a = Integer.parseInt(st.nextToken());
				map[y][x] = a;
				if (a == 2)
					white.add(new Point(y, x)); // 상대방 돌 좌표를 미리 저장
			}
		}

		// 풀이
		// 상대돌(2) 주변의 빈칸 좌표 저장
		ArrayList<Point> blank = new ArrayList<>();
		findBlank(white, blank, new boolean[N][M]);
//		for (int i = 0; i < blank.size(); i++) {
//			System.out.println(blank.get(i).y+", "+blank.get(i).x);
//		}	
		// 빈칸 좌표들로 조합
		// 빈칸 2곳에 흑돌 두기
		setBlack(0, 0, new int[2], blank);
		System.out.println(ans);
//		print();
	}

	private static void findBlank(ArrayList<Point> white, ArrayList<Point> blank, boolean[][] v) {
		int size = white.size();
		for (int i = 0; i < size; i++) {
			Point temp = white.get(i);
			for (int d = 0; d < 4; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				if (!check(ny, nx) || map[ny][nx] != 0 || v[ny][nx])
					continue;
				v[ny][nx] = true;
				blank.add(new Point(ny, nx));
			}
		}
	}

	private static void setBlack(int start, int cnt, int[] sel, ArrayList<Point> blank) {
		// 빈칸 좌표 2개를 뽑았으면
		if (cnt == 2) {
			// 빈칸 2곳에 흑돌 두기
//			System.out.println("=========");
			int iy = 0;
			int ix = 0;
			for (int i = 0; i < sel.length; i++) {
				iy = blank.get(sel[i]).y;
				ix = blank.get(sel[i]).x;
				map[iy][ix] = 1;
//				System.out.println(iy+", "+ix);
			}
			// 죽일수 있는 백돌 개수 세기(bfs)
			killCnt = 0;
			countWhite(new boolean[N][M]);
			ans = Math.max(ans, killCnt);
			for (int i = 0; i < sel.length; i++) {
				iy = blank.get(sel[i]).y;
				ix = blank.get(sel[i]).x;
				map[iy][ix] = 0;
			}
			return;
		}
		if (start == blank.size())
			return;

		sel[cnt] = start;
		setBlack(start + 1, cnt + 1, sel, blank);
		setBlack(start + 1, cnt, sel, blank);
	}

	private static void countWhite(boolean[][] v) {
		int size = white.size();
		for (int i = 0; i < size; i++) {
			if (v[white.get(i).y][white.get(i).x])
				continue;
			killCnt += bfs(i, v);
		}
	}

	private static int bfs(int i, boolean[][] v) {
		int count = 1;
		Queue<Point> q = new LinkedList<>();
		q.add(white.get(i));
		v[white.get(i).y][white.get(i).x] = true;
		boolean flag = false;
		while (!q.isEmpty()) {
			Point temp = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				if (!check(ny, nx) || map[ny][nx] == 1 || v[ny][nx])
					continue;
				if (map[ny][nx] == 0) {
					flag = true;
					continue;
				}
				v[ny][nx] = true;
				q.add(new Point(ny, nx));
				count++;
			}
		}
		if (flag) {
			return 0;
		} else
			return count;
	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= N || nx < 0 || nx >= M)
			return false;
		return true;
	}

	private static void print() {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
}
