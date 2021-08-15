package ssafy.study.week18;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14494_다이나믹이뭐예요 {
	static int N, M;
	static long[][] D;
	static final long MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/18/다이나믹이뭐예요.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		D = new long[N + 1][M + 1];
		dp();
		long ans = D[N][M];
		System.out.println(ans);

	}

	private static void dp() {
		D[0][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				D[i][j] = (D[i - 1][j] % MOD + D[i][j - 1] % MOD + D[i - 1][j - 1] % MOD) % MOD;
			}
		}

	}

}
