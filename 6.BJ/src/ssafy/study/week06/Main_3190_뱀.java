package ssafy.study.week06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190_뱀 {
	static int N, K, L, ans; // 보드의 크기, 사과의 개수, 방향 변환 횟수
	static int[][] map; // 맵
	static int[] dy = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int[] dx = { 1, 0, -1, 0 };
	static Queue<Point> TD; // 시간 방향 정보
	static Deque<Point> snake; // 뱀 저장 덱

	static class Point {
		int y, x, time, d;

		public Point(int y, int x, int time, int d) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/뱀.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		K = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			map[y][x] = 1;
		}
		L = Integer.parseInt(in.readLine());
		TD = new LinkedList<>();
		snake = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			TD.add(new Point(0, 0, Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
		}
		play(0, 0);
		System.out.println(ans);
	}

	private static void play(int y, int x) {
		snake.add(new Point(y, x, 0, 0));
		map[y][x] = 2;
		while (!snake.isEmpty()) {
			print();
			Point temp = snake.peek();
			int ny = temp.y + dy[temp.d];
			int nx = temp.x + dx[temp.d];
			int nt = temp.time + 1;
			int nd = temp.d;
			// 경계를 넘거나 자신의 몸을 만나면 종료
			if (!check(ny, nx) || map[ny][nx] == 2) {
				ans = nt;
				return;
			}
			// 해당 시간에 맞게 방향을 바꿔준다
			if (!TD.isEmpty() && nt == TD.peek().time) {
				// D라면 오른쪽으로 90도
				if (TD.peek().d == 'D') {
					nd++;
					nd = nd % 4;
				}
				// L이면 왼쪽으로 90도
				else {
					nd += 3;
					nd = nd % 4;
				}
				// 방향 바꿔주고 해당 정보 삭제
				TD.poll();
			}
			// 뱀의 머리를 덱의 젤 앞에 넣어준다
			snake.addFirst(new Point(ny, nx, nt, nd));
			// 0을 만나면 머리가 한칸 앞으로 갔으므로 꼬리를 한칸 줄여준다
			if (map[ny][nx] == 0) {
				// 마지막 뱀의 좌표를 삭제
				Point re = snake.pollLast();
				// 맵에서 0으로 만들어준다
				map[re.y][re.x] = 0;
			}
			// 머리가 이동한 위치에 2로 표시
			map[ny][nx] = 2;
		}
	}

	private static void print() {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < N)
			return true;
		return false;
	}
}
