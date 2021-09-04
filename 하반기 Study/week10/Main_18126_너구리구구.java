package second.study.week10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18126_너구리구구 {
	static long ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/10/너구리구구.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long[][] map = new long[N][N];
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			long c = Long.parseLong(st.nextToken());
			map[a][b] = c;
			map[b][a] = c;
		}

		dfs(0, map, new boolean[N], 0);
		System.out.println(ans);
	}

	private static void dfs(int idx, long[][] map, boolean[] visited, long val) {
		visited[idx] = true;
		for (int i = 0; i < map.length; i++) {
			if (map[idx][i] != 0 && !visited[i])
				dfs(i, map, visited, val + map[idx][i]);
		}
		ans = Math.max(ans, val);
	}
}
