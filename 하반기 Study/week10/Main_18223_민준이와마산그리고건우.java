package second.study.week10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_18223_민준이와마산그리고건우 {
	static int V, E, P;
	static int[] dis;
	static boolean[] visited;

	static class Edge implements Comparable<Edge> {
		int from, weight;

		public Edge(int from, int weight) {
			super();
			this.from = from;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/10/민준이와마산그리고건우.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		ArrayList[] adjList = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++)
			adjList[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[to].add(new Edge(from, weight));
			adjList[from].add(new Edge(to, weight));
		}

		int a = dijkstra(adjList, 1, V);
		int b = dijkstra(adjList, 1, P) + dijkstra(adjList, P, V);
		System.out.println(a >= b ? "SAVE HIM" : "GOOD BYE");
	}

	private static int dijkstra(ArrayList[] adjList, int start, int end) {
		int des = 0;
		dis = new int[V + 1];
		visited = new boolean[V + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;
		visited[start] = true;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			visited[curr.from] = true;
			// 목적지 도착하면 리턴
			if (curr.from == end) {
				des = dis[end];
				break;
			}
			// 최단거리 갱신
			for (int j = 0; j < adjList[curr.from].size(); j++) {
				Edge next = (Edge) adjList[curr.from].get(j);
				if (visited[next.from])
					continue;
				if (dis[next.from] > dis[curr.from] + next.weight) {
					dis[next.from] = dis[curr.from] + next.weight;
					pq.add(new Edge(next.from, dis[next.from]));
				}
			}
		}
		return des;
	}
}
