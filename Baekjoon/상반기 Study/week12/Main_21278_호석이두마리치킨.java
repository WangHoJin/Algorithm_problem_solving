package ssafy.study.week12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_21278_호석이두마리치킨 {
	static int N, M, ans;
	static int[][] adj;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/호석이두마리치킨.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			// Integer.MAX_VALUE로 초기화
			// 연결 되지 않는 정점은 무한
			Arrays.fill(adj[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1;
			adj[b][a] = 1;
		}

		// 건물 사이 거리 계산 => 플로이드와샬
		for (int k = 1; k <= N; k++) { // 경유지
			for (int i = 1; i <= N; i++) { // 출발
				for (int j = 1; j <= N; j++) { // 도착
					if (i == j) // 자기 자신은 0
						adj[i][j] = 0;
					// 연결이 되어있는 정보만 비교
					if (adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE)
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}

		// 모든 건물에서 가장 가까운 치킨집 2개 선택
		ans = Integer.MAX_VALUE;
		int a = 0;
		int b = 0;
		// 건물 번호를 1~N사이에 2개를 뽑는다 => 조합
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				int sum = sumDis(i, j); // 선택된 2개의 치킨집과 모든 건물 사이 거리를 구하는 함수
				// 2개의 치킨집과 모든 건물 사이의 최단 거리와 치킨집 건물 번호를 구한다
				if (ans > sum) {
					ans = sum;
					a = i;
					b = j;
				}
			}
		}
		System.out.println(a + " " + b + " " + ans);
//		print(adj);
	}

	private static int sumDis(int i, int j) {
		int sum = 0;
		// 모든 건물과 2개의 치킨집 중 더 가까운 거리 더하기
		for (int k = 1; k <= N; k++) {
			sum += Math.min(adj[i][k], adj[j][k]);
		}
		return sum * 2; // 왕복거리라서 곱하기 2
	}

	private static void print(int[][] map) {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
}
