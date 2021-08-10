package second.study.week07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17396_백도어 {
	static int N, M, ans;
	static ArrayList<Node>[] adjList;
	static int[] vs, dis;
	static boolean[] visited;

	static class Node implements Comparable<Node> {
		int b;
		long c;

		public Node(int b, long c) {
			super();
			this.b = b;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [b=" + b + ", c=" + c + "]";
		}

		@Override
		public int compareTo(Node o) {
			return (int) (this.c - o.c);
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/07/백도어.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] vs = new int[N];
		long[] dis = new long[N];
		boolean[] visited = new boolean[N];
		ArrayList<Node>[] adjList = new ArrayList[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
			vs[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList[a].add(new Node(b, c));
			adjList[b].add(new Node(a, c));
		}

		dijkstra(adjList, dis, vs, visited);

//		print(adjList);
		System.out.println(dis[N - 1] == Long.MAX_VALUE ? -1 : dis[N - 1]);
	}

	private static void dijkstra(ArrayList<Node>[] adjList, long[] dis, int[] vs, boolean[] visited) {
		Arrays.fill(dis, Long.MAX_VALUE);
		dis[0] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visited[curr.b])
				continue;
			visited[curr.b] = true;
			for (Node next : adjList[curr.b]) {
				// 방문한 노드는 패스
				if (vs[next.b] == 1 && next.b != N - 1)
					continue;
				// 거리 갱신
				if (dis[next.b] > dis[curr.b] + next.c) {
					dis[next.b] = dis[curr.b] + next.c;
					pq.add(new Node(next.b, dis[next.b]));
				}
			}
		}
	}

	private static void print(ArrayList<Node>[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i].toString());
		}
	}
}
