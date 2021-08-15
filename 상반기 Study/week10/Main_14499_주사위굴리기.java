package ssafy.study.week10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
	static int N, M, X, Y, K;
	static int[][] map;
	static int[][] dice;
	static int dice_bt;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/주사위굴리기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dice = new int[3][3];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < K; i++) {
			int d = Integer.parseInt(st.nextToken());
			Y = Y + dy[d];
			X = X + dx[d];
			if (!check(Y, X)) {
				Y = Y - dy[d];
				X = X - dx[d];
				continue;
			}
			play(Y, X, d);
			// 주사위 상단에 쓰여 있는 값 결과 값에 저장
			sb.append(dice[1][1]).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	static int[] dy = { 0, 0, 0, -1, 1 };
	static int[] dx = { 0, 1, -1, 0, 0 };

	private static void play(int y, int x, int d) {
		int num = map[Y][X]; // 이동칸에 쓰여 있는 수
		// 주사위를 굴린다 : 동서북남
		if (d == 1) {
			move1(d);
		} else if (d == 2) {
			move2(d);
		} else if (d == 3) {
			move3(d);
		} else {
			move4(d);
		}
		// 이동한 칸에 쓰여 있는 수가 0이면
		// 주사위의 바닥면에 쓰여있는 수가 칸에 복사!
		if (num == 0) {
			map[Y][X] = dice_bt;
		}
		// 0이 아닌 경우
		// 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사!
		else {
			dice_bt = num;
			map[Y][X] = 0;
		}
	}

	private static void move1(int d) {
		// 주사위는 3x3배열로 표현했고 굴리는 방향으로 배열이동
		// 바닥부분은 따로 변수로 저장함
		int temp = dice_bt;
		for (int x = dice.length - 1; x >= 0; x--) {
			int nx = x + dx[d];
			// 배열 범위 밖으로 나가면 해당 위치가 바닥부분이 됨 => dice_bt에 저장
			if (nx > 2) {
				dice_bt = dice[1][2];
				continue;
			}
			dice[1][nx] = dice[1][x];
		}
		dice[1][0] = temp;
	}

	private static void move2(int d) {
		int temp = dice_bt;
		for (int x = 0; x < dice.length; x++) {
			int nx = x + dx[d];
			if (nx < 0) {
				dice_bt = dice[1][0];
				continue;
			}
			dice[1][nx] = dice[1][x];
		}
		dice[1][2] = temp;
	}

	private static void move3(int d) {
		int temp = dice_bt;
		for (int y = 0; y < dice.length; y++) {
			int ny = y + dy[d];
			if (ny < 0) {
				dice_bt = dice[0][1];
				continue;
			}
			dice[ny][1] = dice[y][1];
		}
		dice[2][1] = temp;
	}

	private static void move4(int d) {
		int temp = dice_bt;
		for (int y = dice.length - 1; y >= 0; y--) {
			int ny = y + dy[d];
			if (ny > 2) {
				dice_bt = dice[2][1];
				continue;
			}
			dice[ny][1] = dice[y][1];
		}
		dice[0][1] = temp;
	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= N || nx < 0 || nx >= M)
			return false;
		return true;
	}

	private static void printDice() {
		System.out.println("주사위 바닥 : " + dice_bt);
		for (int[] y : dice) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	private static void print() {
		System.out.println("지도");
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

}
