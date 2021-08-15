package ssafy.study.week11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1944_복제로봇 {
	static int N, M;
	static int[][] map;
	static Point[] nodeList;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {	// 가중치(로봇이 움직인 횟수)를 오름차순
			return Integer.compare(this.weight, o.weight);
		}
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/복제로봇.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		nodeList = new Point[M + 1]; // S,K를 저장할 리스트
		int i = 0; // 노드 인덱스
		for (int y = 0; y < N; y++) {
			String str = in.readLine();
			for (int x = 0; x < N; x++) {
				char a = str.charAt(x);
				// S나K이면 노드리스트에 저장
				if (a == 'S' || a == 'K') {
					nodeList[i] = new Point(y, x);
					map[y][x] = i; // 노드마다 인덱스 부여
					i++;
				} else
					map[y][x] = (a - '0') - 2; // 노드의 인덱스가 0부터 시작되기때문에 벽과 길은 음수로 바꿔놓음
			}
		}
		
		edgeList = new ArrayList<>();	// 간선 리스트
		
		// 풀이
		// 1. 모든 노드사이의 간선을 찾는다
		for (int j = 0; j < nodeList.length; j++) {
			bfs(nodeList[j], new boolean[N][N]);
		}
		
		// 2. 모든 간선정보들이 저장됐으면 크루스칼
		if (ans != -1) {
			Kruskal();
		}
		System.out.println(ans);
//		print();
	}

	private static void Kruskal() {
		V = M + 1;	// 정점의 개수 (S+K의 개수)
//		E = (M + 1) * M; 
		parents = new int[V];
		Collections.sort(edgeList);	// 오름차순 정렬
		make();
		int count = 0; // 선택한 간선수
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) { // 싸이클이 발생하지 않았다면
				ans += edge.weight;
				if (++count == V - 1)	// 선택한 간선=정점수-1이면 종료
					break;
			}
		}
	}

	static int V, E, ans;
	static int[] parents;
	static ArrayList<Edge> edgeList;
	static int edgeCnt;

	private static void bfs(Point start, boolean[][] v) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		v[start.y][start.x] = true;
		int cnt = 1;	// 로봇 움직인 횟수
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = temp.y + dy[d];
					int nx = temp.x + dx[d];
					if (map[ny][nx] == -1 || v[ny][nx])
						continue;
					// 노드가 노드를 만나면
					if (map[ny][nx] >= 0) {
						// 시작점,끝점,로봇움직임횟수 -> 간선리스트에 저장
						edgeList.add(new Edge(map[start.y][start.x], map[ny][nx], cnt));
					}
					v[ny][nx] = true;
					q.add(new Point(ny, nx));
				}
			}
			cnt++;	// 움직임 증가
		}
		// 모든 노드들이 연결되어 있는지 확인
		for (int i = 0; i < nodeList.length; i++) {
			// 연결 안된 노드가 있다면 모든 열쇠 찾기 불가능
			if (!v[nodeList[i].y][nodeList[i].x]) {
				ans = -1;
				break;
			}
		}
	}

	static void make() { 
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
