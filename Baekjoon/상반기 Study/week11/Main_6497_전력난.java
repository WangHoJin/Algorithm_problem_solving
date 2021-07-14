package ssafy.study.week11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6497_전력난 {
	static class Node implements Comparable<Node> {
		int from, to, weight;

		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

	static int[] parents, rank;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/전력난.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if (m == 0 && n == 0)
				break;
			Node[] nodeList = new Node[n];
			int ans = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				nodeList[i] = new Node(from, to, weight);
				ans += weight;
			}

			// 돈 오름차순 정렬
			Arrays.sort(nodeList);

			parents = new int[m];
			rank = new int[m];
			makeSet();
			union(0, 0);

			int cnt = 0;
			for (Node node : nodeList) {
				if (union(node.from, node.to)) { // 싸이클이 발생하지 않았다면
					ans -= node.weight;
					if (++cnt == m - 1)
						break;
				}
			}

			System.out.println(ans);
		}
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		if (rank[aRoot] > rank[bRoot]) {
			parents[bRoot] = aRoot;
		} else {
			parents[aRoot] = bRoot;
			if (rank[aRoot] == rank[bRoot])
				rank[bRoot]++;
		}
		return true;
	}

	private static int findSet(int a) {
		if (parents[a] == a)
			return parents[a];
		return parents[a] = findSet(parents[a]);
	}

	private static void makeSet() {
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}
}
