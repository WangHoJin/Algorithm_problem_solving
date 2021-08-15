package ssafy.study.week06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_11559_PuyoPuyo {
	static int N = 12, M = 6, ans; // 가로, 세로 ,결과
	static char[][] map; // 맵 배열
	static boolean[][] visited; // 방문 배열
	static int[] dy = { -1, 0, 1, 0 }; // 상우하좌 방향 배열
	static int[] dx = { 0, 1, 0, -1 };
	static Queue<Point> puyo; // 뿌요 저장 큐
	static boolean flag; // 연쇄 판단

	static class Point {
		int y, x;
		char color;

		public Point(int y, int x, char color) {
			super();
			this.y = y;
			this.x = x;
			this.color = color;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/puyopuyo.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new char[N][M];
		visited = new boolean[N][M];
		puyo = new LinkedList<>();
		for (int y = 0; y < N; y++) {
			map[y] = in.readLine().toCharArray();
		}
//		print();
		// 연쇄가 없을때까지 무한반복
		while (true) {
			flag = false;
			visited = new boolean[N][M];
			findPuyo(); // 뿌요의 위치를 저장
			// 뿌요들을 4방탐색하여 4개이상 연결되어있으면 터짐
			while (!puyo.isEmpty()) {
				bomb(puyo.poll());
			}
			// 연쇄가 안일어났으면 종료
			if (!flag)
				break;
			// 중력으로 뿌요가 내려옴
			gravity();
//			print();
			// 연쇄 횟수
			ans++;
		}
		System.out.println(ans);
	}

	private static void gravity() {
		Queue<Character> temp = new LinkedList<>();
		for (int x = 0; x < M; x++) {
			for (int y = N - 1; y >= 0; y--) {
				// 방문하지않고 .인 부분을 만나면 열 검사 종료
				if (!visited[y][x] && map[y][x] == '.')
					break;
				// 폭발로 인해 .이된 부분은 패스
				if (map[y][x] == '.')
					continue;
				// 남아 있는 뿌요 저장
				temp.add(map[y][x]);
				// 원래 뿌요 위치를 .으로 변경 -> 같은 map배열을 사용할거기 때문에 기존 위치를 초기화해준다
				map[y][x] = '.';
			}
			// 같은 열에 있던 모든 뿌요들을 밑에서부터 채워준다
			int size = temp.size();
			for (int y = 0; y < size; y++) {
				map[N - 1 - y][x] = temp.poll();
			}
		}
	}

	private static void bomb(Point p) {
		// 이미 앞에서 방문했는데 터지지않은 뿌요는 다시 검사할 필요 없음
		if (visited[p.y][p.x])
			return;
		Queue<Point> q = new LinkedList<>(); // 뿌요 담을 큐
		Queue<Point> b = new LinkedList<>(); // 터질 뿌요 담을 큐
		int puyoCnt = 1; // 연결된 뿌요 수
		q.add(p); // 탐색할 뿌요를 저장할 큐
		b.add(p); // 터질 뿌요를 저장할 큐
		visited[p.y][p.x] = true;
		while (!q.isEmpty()) {
			Point temp = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				if (!check(ny, nx) || map[ny][nx] != temp.color || visited[ny][nx])
					continue;
				q.add(new Point(ny, nx, temp.color));
				b.add(new Point(ny, nx, temp.color));
				visited[ny][nx] = true;
				puyoCnt++; // 연결된 뿌요 갯수
			}
		}
		// 연결된 뿌요가 4개 이상이면 터짐
		if (puyoCnt >= 4) {
			flag = true;
			// 터질 뿌요가 들어있는 큐에서 하나씩 꺼내면서 .으로 바꿔줌
			while (!b.isEmpty()) {
				Point temp = b.poll();
				map[temp.y][temp.x] = '.';
			}
		}
	}

	// 경계선 체크 함수
	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < M)
			return true;
		return false;
	}

	private static void findPuyo() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				// .이 아니면 뿌요
				if (map[y][x] != '.')
					puyo.add(new Point(y, x, map[y][x]));
			}
		}
	}

	private static void print() {
		for (char[] y : map) {
			for (char x : y) {
				System.out.print(x);
			}
			System.out.println();
		}
		System.out.println("====================================");
	}
}
