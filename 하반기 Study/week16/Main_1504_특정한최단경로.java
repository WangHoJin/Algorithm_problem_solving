package second.study.week16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504_특정한최단경로 {
	static int V, E;
	static ArrayList<Edge>[] adjList;

	static class Edge implements Comparable<Edge> {
		int from;
		int weight;

		public Edge(int from, int weight) {
			super();
			this.from = from;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/16/특정한최단경로.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[to].add(new Edge(from, weight));
			adjList[from].add(new Edge(to, weight));
		}
		st = new StringTokenizer(in.readLine(), " ");
		int wp1 = Integer.parseInt(st.nextToken());
		int wp2 = Integer.parseInt(st.nextToken());
		int[] start = new int[3];
		int[] end = new int[3];
		int[][] dis = new int[3][V + 1];

		start[0] = 1;
		start[1] = wp1;
		start[2] = wp2;
		for (int i = 0; i < 3; i++) {
			boolean[] visited = new boolean[V + 1];
			Arrays.fill(dis[i], Integer.MAX_VALUE);
			dis[i][start[i]] = 0; // 시작점에서 최단거리
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.add(new Edge(start[i], 0));

			while (!pq.isEmpty()) {
				Edge temp = pq.poll();
				int curr = temp.from;
				if (visited[curr])
					continue;
				visited[curr] = true;
				for (Edge next : adjList[curr]) {
					if (dis[i][next.from] > dis[i][curr] + next.weight) {
						dis[i][next.from] = dis[i][curr] + next.weight;
						pq.add(new Edge(next.from, dis[i][next.from]));
					}
				}
			}
		}
		// 두정점 wp1,wp2를 반드시 거치는 최단경로
		// 1. 1 -> wp1 -> wp2 -> V
		// 2. 1 -> wp2 -> wp1 -> V
		// 2가지 방법이 있는데 이 중 최단거리를 구하자.

		// 1. 1 -> wp1 -> wp2 -> V
		int ans1 = dis[0][wp1] + dis[1][wp2] + dis[2][V];
		// 2. 1 -> wp2 -> wp1 -> V
		int ans2 = dis[0][wp2] + dis[2][wp1] + dis[1][V];
		int min = ans1 < ans2 ? ans1 : ans2;
		if (min >= Integer.MAX_VALUE-2 || min < 0)
			System.out.println(-1);
		else
			System.out.println(min);

	}

}
