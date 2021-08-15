import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_21738_얼음깨기펭귄 {
	static int N, S, P, total, ans;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/00/얼음깨기펭귄.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		ans = N - 1;
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		visited = new boolean[N + 1];
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		bfs();
		System.out.println(ans);
//		print();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(P);
		visited[P] = true;
		int cnt = 0;
		int depth = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int temp = q.poll();
				if (temp <= S) {
					++cnt;
					ans -= depth;
					if (cnt == 2)
						return;
				}
				for (int ice : list.get(temp)) {
					if (visited[ice])
						continue;
					q.add(ice);
					visited[ice] = true;
				}

			}
			depth++;
		}

	}

	private static void print() {
		for (int i = 1; i < list.size(); i++) {
			System.out.print("정점 " + i + "의 인접리스트");

			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(" -> " + list.get(i).get(j));
			}
			System.out.println();
		}
	}
}
