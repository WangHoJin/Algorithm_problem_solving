package ssafy.study.week03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17204_죽음의게임 {
	static int N, K, cnt;
	static int[] select;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		select = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			select[i] = Integer.parseInt(in.readLine());
		}
		cnt = 1;
		game(select[0]);
		System.out.println(cnt);
	}

	private static void game(int idx) {
		if (idx == K) {
			return;
		}
		if (visited[idx]) {
			cnt = -1;
			return;
		}
		cnt++;
		visited[idx] = true;
		game(select[idx]);

	}

}
