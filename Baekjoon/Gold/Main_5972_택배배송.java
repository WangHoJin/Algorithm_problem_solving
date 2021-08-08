package Gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_5972_택배배송 {
	static int N, M, ans;
	static ArrayList<Node>[] adjList;
	static int[] dis;
	static boolean[] visited;

	static class Node implements Comparable<Node> {
		int b, c;

		public Node(int b, int c) {
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
			return this.c - o.c;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/Gold/택배배송.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		dis = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			adjList[a].add(new Node(b, c));
			adjList[b].add(new Node(a, c));
		}
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[0] = 0;
		visited[0] = true;
//		for (int i = 1; i <= adjList[0].size(); i++) {
//			dis[adjList[0].get(i - 1).b] = adjList[0].get(i - 1).c;
//		}
//		System.out.println("초기 dis 상태");
//		System.out.println(Arrays.toString(dis));

		dijkstra();

//		print(adjList);
//		System.out.println(Arrays.toString(dis));
		System.out.println(dis[N - 1]);
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));

		while (!pq.isEmpty()) {
			Node temp = pq.poll();
			visited[temp.b] = true;
			// 최단거리 갱신
			for (int j = 0; j < adjList[temp.b].size(); j++) {
				Node node = adjList[temp.b].get(j);
				if (visited[node.b])
					continue;
				if (dis[node.b] > dis[temp.b] + node.c) {
					dis[node.b] = dis[temp.b] + node.c;
					pq.add(new Node(node.b, dis[node.b]));
				}
			}
			// 갱신된 dis 출력 => 확인 용도
//			System.out.println(temp.b+"점 경유 했을때");
//			System.out.println(Arrays.toString(dis));
		}
	}

	private static int minDis() {
		int min = Integer.MAX_VALUE;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if (!visited[i] && min > dis[i]) {
				min = dis[i];
				idx = i;
			}
		}
		return idx;
	}

	private static void print(ArrayList<Node>[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i].toString());
		}
	}
}
