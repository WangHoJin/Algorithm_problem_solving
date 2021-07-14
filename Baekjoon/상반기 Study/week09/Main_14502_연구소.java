package ssafy.study.week09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int N, M, wallCnt, ans;
	static int[][] map;
	static boolean[][] visited;

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/연구소.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		ans = 0; // 안전 영역
		wallCnt = 3; // 벽의 개수
		ArrayList<Point> virus = new ArrayList<>();
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < M; x++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 2) {
					virus.add(new Point(y, x)); // 바이러스 좌표 저장
				} else if (a == 1) {
					wallCnt++; // 벽의 개수 증가
				}
				map[y][x] = a;
			}
		}
		// 벽을 3개 세우는 함수
		buildWall(0, 0, new int[3], virus);
		System.out.println(ans);
	}

	private static void buildWall(int start, int cnt, int[] sel, ArrayList<Point> virus) {
		if (cnt == 3) {
			int y = 0;
			int x = 0;
			// 선택된 벽 위치에 벽 건설
			// 모듈 연산을 통해 x,y좌표 추출
			for (int i = 0; i < 3; i++) {
				y = sel[i] / M;
				x = sel[i] % M;
				map[y][x] = 1;
			}

			int max = 0;
			// 전체 영역에서 벽의 개수와 바이러스 영역을 빼주면 안전영역
			max = N * M - wallCnt - spreadVirus(virus, new boolean[N][M]);
			// 안전영역의 최대값 갱신
			ans = Math.max(ans, max);
			// 벽 초기화
			for (int i = 0; i < 3; i++) {
				y = sel[i] / M;
				x = sel[i] % M;
				map[y][x] = 0;
			}
			return;
		}

		// 벽을 3개 세우기
		// 2차원 좌표를 한줄로 나열해서 모듈연산을 사용하겠다
		for (int i = start; i < N * M; i++) {
			if (map[i / M][i % M] != 0)
				continue;
			sel[cnt] = i;
			buildWall(i + 1, cnt + 1, sel, virus);
		}
	}

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	// 바이러스 퍼지는 함수(bfs)
	private static int spreadVirus(ArrayList<Point> virus, boolean[][] v) {
		int virusCnt = 0;
		Queue<Point> q = new LinkedList<>();
		// 바이러스 좌표를 큐에 저장
		for (int i = 0; i < virus.size(); i++) {
			q.add(virus.get(i));
			virusCnt++; // 바이러스 수 증가
		}
		// bfs탐색
		while (!q.isEmpty()) {
			Point temp = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];
				// 범위를 벗어나거나 빈칸이 아니거나 방문했으면 continue
				if (!check(ny, nx) || map[ny][nx] != 0 || v[ny][nx])
					continue;
				q.add(new Point(ny, nx));
				v[ny][nx] = true;
				virusCnt++; // 바이러스의 개수 증가
			}
		}
		return virusCnt; // 바이러스 개수 리턴
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
		System.out.println("================");
	}
}
