package ssafy.study.week13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16437_양구출작전 {
	static int N;
	static long ans;
	static ArrayList<Island>[] adjList;

	static class Island {
		char type;
		long cnt;
		int idx;

		public Island(char type, long cnt, int idx) {
			super();
			this.type = type;
			this.cnt = cnt;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/13/양구출작전.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 2; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			char type = st.nextToken().charAt(0);
			long cnt = Integer.parseInt(st.nextToken());
			int parent = Integer.parseInt(st.nextToken());
			adjList[parent].add(new Island(type, cnt, i));
		}

		ans = dfs(1, ' ', 0);

		System.out.println(ans); // 정답 범위가 int를 넘어가므로 long형으로!
	}

	private static long dfs(int currIdx, char currType, long currCnt) {
		long sheepCnt = 0;
		for (Island currIsland : adjList[currIdx]) {
			sheepCnt += dfs(currIsland.idx, currIsland.type, currIsland.cnt);
		}
		// 양 땅일 때 양 수을 더해준다
		if (currType == 'S') {
			sheepCnt += currCnt;
			return sheepCnt;
		}
		// 늑대 땅일 때 늑대의 수를 빼준다
		else {
			// 현재 양의 수보다 늑대 수가 많으면 양의 수 0마리
			long diff = sheepCnt - currCnt;
			if (diff < 0)
				diff = 0;
			return diff;
		}
	}

}
