package ssafy.study.week10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1967_트리의지름 {
	static int ans;

	static class Node {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/트리의지름.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		ArrayList<Node>[] adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[start].add(new Node(end, weight));
			adj[end].add(new Node(start, weight));
		}

		for (int i = 1; i <= N; i++) {
			boolean[] v = new boolean[N + 1];
//			System.out.println(i+"가 루트");
			dfs(adj, i, v, 0);
//			System.out.println("=================");
		}
		System.out.println(ans);

	}

	private static void dfs(ArrayList<Node>[] adj, int n, boolean[] v, int sum) {
		v[n] = true;
//		System.out.print(n+" ");
		int size = adj[n].size();
		if (size == 1) {
//			System.out.println(sum);
			ans = Math.max(sum, ans);
		}
		for (int i = 0; i < size; i++) {
			Node temp = adj[n].get(i);
			if (!v[temp.vertex]) {
				dfs(adj, temp.vertex, v, sum + temp.weight);
			}
		}

	}

}
