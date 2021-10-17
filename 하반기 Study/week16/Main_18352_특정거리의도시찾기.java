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

public class Main_18352_특정거리의도시찾기 {
	static int N, M, K, X;
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
		System.setIn(new FileInputStream("input/second/16/특정거리의도시찾기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 거리정보
		X = Integer.parseInt(st.nextToken()); // 출발 번호
		adjList = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int weight = 1;
			adjList[to].add(new Edge(from, weight));
		}

		int[] dis = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[X] = 0; // 시작점에서 최단거리
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(X, 0));

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
		boolean flag = false;
		for (int i = 1; i < dis.length; i++) {
			if (dis[i] == K) {
				flag = true;
				System.out.println(i);
			}
		}
		if (!flag)
			System.out.println(-1);

	}

}
