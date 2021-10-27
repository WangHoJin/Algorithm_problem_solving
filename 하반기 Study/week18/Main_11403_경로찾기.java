package second.study.week18;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_11403_경로찾기 {
	static int N;
	static int[][] adj;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/18/경로찾기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		adj = new int[N][N];
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
//			Arrays.fill(adj[y], Integer.MAX_VALUE);
			for (int x = 0; x < N; x++) {
				int a = Integer.parseInt(st.nextToken());
				if (a != 0)
					adj[y][x] = a;
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (adj[i][k] + adj[k][j] > 1)
						adj[i][j] = 1;
				}
			}
		}
		print(adj);
	}

	private static void print(int[][] adj) {
		for (int[] y : adj) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
}
