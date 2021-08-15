package ssafy.study.week14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 어디로 낙하해야 가장 많은 아이템을 얻을 수 있는지 알기 위해서
 * 모든 정점을 기준으로 최단 경로를 구하는 플로이드 와샬을 사용
 *
 */
public class Main_14938_서강그라운드 {
	static int N, M, R, ans;
	static int[] num;
	static int[][] dis;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input/14/서강그라운드.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		num = new int[N + 1];
		dis = new int[N + 1][N + 1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(dis[i], 16);
		}
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			// 수색범위보다 작으면 길 연결 X
			if (l > M)
				continue;
			dis[a][b] = l;
			dis[b][a] = l;
		}
		// 모든 정점에서 각각 정점까지 최대 아이템 개수 찾기
		for (int k = 1; k <= N; k++) {	// 경유지
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j)
						continue;
					// 길 연결이 되어있고 수색범위보다 작거나 같으면 갱신
					if (dis[i][k] != 16 && dis[k][j] != 16) {
						if (dis[i][k] + dis[k][j] <= M) {
							dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
						}
					}
				}
			}
		}
		
		// 모든 낙하지점을 대상으로 아이템 최대 개수 찾기
		for (int i = 1; i <= N; i++) {
			int sum = num[i];
			for (int j = 1; j <= N; j++) {
				if (dis[i][j] <= M)
					sum += num[j];
			}
			ans = Math.max(ans, sum);
		}
		System.out.println(ans);
	}
}
