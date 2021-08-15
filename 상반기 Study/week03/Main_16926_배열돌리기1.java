package ssafy.study.week03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
	static int N, M, R, cnt;
	static int[][] matrix;
	static int[] dy = { 1, 0, -1, 0 }; // 하우상좌
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < M; x++) {
				matrix[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			rotation(0, 0, 0, 1, matrix[0][0]);
			cnt = 0;
		}
		print();
	}

	private static void rotation(int y, int x, int d, int idx, int value) {
		if (idx > N * M) {
			// 문제에서 N과M이 둘다 홀수인 경우는 없다고 했지만 혹시 있을경우를 대비해 예외처리
			if ((N * M) % 2 != 0)
				matrix[y][x] = value;
			return;
		}
		int ny = y + dy[d];
		int nx = x + dx[d];
		if (!check(ny, nx)) {
			d++;
			if (d > 3) {
				d = 0;
				y++;
				x++;
				cnt++;
				value = matrix[y][x];
			}
			ny = y + dy[d];
			nx = x + dx[d];
		}
		int temp = matrix[ny][nx];
		matrix[ny][nx] = value;
		rotation(ny, nx, d, idx + 1, temp);
	}

	private static boolean check(int y, int x) {
		if (y >= 0 + cnt && y < N - cnt && x >= 0 + cnt && x < M - cnt)
			return true;
		return false;
	}

	private static void print() throws IOException {
		StringBuilder sb = new StringBuilder();
		for (int[] y : matrix) {
			for (int x : y) {
				sb.append(x + " ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
