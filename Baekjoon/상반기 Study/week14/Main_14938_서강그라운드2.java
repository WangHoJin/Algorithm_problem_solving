package ssafy.study.week14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14938_서강그라운드2 {
	static int N, M, R, ans;
	static int[] num;
	static int[][][] dis;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/14/서강그라운드.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		num = new int[N + 1];
		dis = new int[N + 1][N + 1][2]; // 0:아이템, 1:거리
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int w = num[a] + num[b];
			// 수색범위보다 작으면 길 연결 X
			if (l > M)
				continue;
			dis[a][b][0] = w;
			dis[b][a][0] = w;
			dis[a][b][1] = l;
			dis[b][a][1] = l;
		}

		// 모든 정점에서 각각 정점까지 최대 아이템 개수 찾기
		for (int i = 1; i <= N; i++) {
			
		
		}
	}

}
