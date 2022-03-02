package second.study.week36;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {

	static int N, M, ans;
	static int[][] adj;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/36/연결요소의개수.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new int[N + 1][N + 1];
		check = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1;
			adj[b][a] = 1;
		}

		for (int i = 1; i <= N; i++) {
			if (check[i])
				continue;
			bfs(i);
			ans++;
		}
		System.out.println(ans);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		check[start] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 1; i <= N; i++) {
				if (check[i] || adj[temp][i] != 1)
					continue;
				q.add(i);
				check[i] = true;
			}
		}

	}

}
