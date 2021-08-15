package second.study.week04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5014_스타트링크 {
	static int F, S, G, U, D, ans;
	static int[] floor;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/04/스타트링크.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		F = Integer.parseInt(st.nextToken()); // 총 F층
		S = Integer.parseInt(st.nextToken()); // 현재 위치
		G = Integer.parseInt(st.nextToken()); // 목적지
		U = Integer.parseInt(st.nextToken()); // 위로 U층 이동
		D = Integer.parseInt(st.nextToken()); // 아래로 D층 이동
		floor = new int[F + 1]; // 방문 여부

		ans = bfs();
//		print(map);
		System.out.println(ans == -1 ? "use the stairs" : ans);
	}

	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		floor[S] = 1;

		while (!q.isEmpty()) {
			int temp = q.poll();
			// 목적지에 도착하면
			if (temp == G) {
				return floor[temp] - 1;
			}
			// 위로 갈수 있고 간적이 없다면
			if (temp + U <= F && floor[temp + U] == 0) {
				floor[temp + U] = floor[temp] + 1;
				q.add(temp + U);
			}
			// 아래로 갈 수 있고 간적이 없다면
			if (temp - D > 0 && floor[temp - D] == 0) {
				floor[temp - D] = floor[temp] + 1;
				q.add(temp - D);
			}
		}
		return -1;
	}

	private static void print(int[][] map) {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
}