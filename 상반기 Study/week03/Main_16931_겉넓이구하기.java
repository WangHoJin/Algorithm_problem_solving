package ssafy.study.week03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16931_겉넓이구하기 {
	static int N, M, result;
	static int[][] map;

	// 둘레더하고 차이더하고 아래위더하고 끝
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		result = N * M * 2;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (y == 0)
					result += map[y][x];
				if (y == N - 1)
					result += map[y][x];
				if (x < M - 1)
					result += Math.abs(map[y][x] - map[y][x + 1]);
			}
		}

		for (int x = 0; x < M; x++) {
			for (int y = 0; y < N; y++) {
				if (x == 0)
					result += map[y][x];
				if (x == M - 1)
					result += map[y][x];
				if (y < N - 1)
					result += Math.abs(map[y][x] - map[y + 1][x]);
			}
		}

		System.out.println(result);
	}
}
