package second.study.week03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import sun.misc.Cache;

public class Main_11404_플로이드 {
	static int n, m, ans;
	static int[][] dis;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/03/플로이드.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		m = Integer.parseInt(in.readLine());
		dis = new int[n][n];
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (x == y)
					dis[y][x] = 0;
				else
					dis[y][x] = 10000001;
			}
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			if (dis[a][b] != Integer.MAX_VALUE) {
				dis[a][b] = Math.min(dis[a][b], c);
			} else
				dis[a][b] = c;
		}

		// 플로이드와샬
		// 경유지를 거친 값과 바로가는 값 중 작은 값이 최단거리
		for (int k = 0; k < n; k++) { // 경유지
			for (int y = 0; y < n; y++) { // 시작 도시
				for (int x = 0; x < n; x++) { // 도착 도시
					if (dis[y][k] + dis[k][x] < dis[y][x])
						dis[y][x] = dis[y][k] + dis[k][x];
				}
			}
		}
		print(dis);
	}

	private static void print(int[][] dis) {
		for (int[] y : dis) {
			for (int x : y) {
				if (x == 10000001)
					System.out.print(0 + " ");
				else
					System.out.print(x + " ");
			}
			System.out.println();
		}
	}
}
