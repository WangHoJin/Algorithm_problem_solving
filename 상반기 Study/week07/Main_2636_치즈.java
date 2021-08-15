package ssafy.study.week07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> edge;
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

	// 외부공기를 2로 표시
	// 
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/치즈.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M]; // 방문체크배열
		edge = new LinkedList<>(); // 가장자리 치즈의 좌표 저장 큐
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
//		print();
		int time = 0; // 다 녹는데 걸리는 시간
		int size = 0; // 다 녹기전 남아있던 치즈의 수
		// 가장자리 치즈가 없을 때까지 반복
		while (true) {
			visited = new boolean[N][M]; // 방문배열 초기화
			findEdge(0, 0); // 가장자리 치즈 찾는 함수
			// 다 녹기전 치즈의 수 저장
			if (edge.size() != 0)
				size = edge.size();
			// 다 녹았으면 반복문 종료
			else if (edge.size() == 0)
				break;
			// 치즈 녹이는 함수
			meltCheese();
			// 시간 증가
			time++;
		}
		System.out.println(time);
		System.out.println(size);
	}

	private static void meltCheese() {
		while (!edge.isEmpty()) {
			Point temp = edge.poll();
			map[temp.y][temp.x] = 0;
		}
	}

	// 외부공기를 기준으로 4방 탐색을해서 공기인부분을 bfs탐색
	// 치즈를 만나면 패스하기때문에 내부공기와 구분 가능
	private static void findEdge(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		// 시작점 (0,0) -> 항상 공기이기 때문
		q.add(new Point(y, x));
		visited[y][x] = true;
		while (!q.isEmpty()) {
			Point temp = q.poll();
			// 공기 주변 4방 탐색을 통해 치즈를 만나면 가장자리 저장
			for (int d = 0; d < 4; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				// 범위를 넘어가거나 방문했으면 패스
				if (!check(ny, nx) || visited[ny][nx])
					continue;
				// 치즈이면 가장자리이므로 저장
				if (map[ny][nx] == 1) {
					visited[ny][nx] = true;
					edge.add(new Point(ny, nx));
					continue;
				}
				// 치즈가 아니면 외부공기이므로 방문체크하고 계속 탐색
				visited[ny][nx] = true;
				q.add(new Point(ny, nx));
			}
		}

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
