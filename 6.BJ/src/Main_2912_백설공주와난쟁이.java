

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2912_백설공주와난쟁이 {
	static int N, C, M;
	static int[][] hat;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		hat = new int[N + 1][C + 1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int color = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= C; j++) {
				hat[i][j] = hat[i-1][j];
				if (color == j)
					hat[i][j]++;
			}
		}
		M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a =Integer.parseInt(st.nextToken()); 
			int b =Integer.parseInt(st.nextToken());
			
		}
		print();

	}

	private static void print() {
		for (int[] y : hat) {
			for (int x : y) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
		
	}

}
