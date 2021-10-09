package second.study.week15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단거리 {
	static int V, E, K;
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
		System.setIn(new FileInputStream("input/second/15/최단거리.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(in.readLine());
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
		}

		int[] dis = new int[V + 1];
		boolean[] visited = new boolean[V + 1];

		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[K] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(K, 0));

		while (!pq.isEmpty()) {
			Edge temp = pq.poll();
			int curr = temp.from;
			if (visited[curr])
				continue;
			visited[curr] = true;

			for (Edge next : adjList[curr]) {
				if (dis[next.from] > dis[curr] + next.weight) {
					dis[next.from] = dis[curr] + next.weight;
					pq.add(new Edge(next.from, dis[next.from]));
				}
			}
		}

		for (int i = 1; i < dis.length; i++) {
			System.out.println(dis[i] == Integer.MAX_VALUE ? "INF" : dis[i]);
		}
	}

}
