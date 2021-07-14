package ssafy.study.week16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7795_먹을것인가먹힐것인가_binary {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/16/먹먹.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			int[] B = new int[M];
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			// 배열 A,B 오름차순 정렬
			Arrays.sort(A);
			Arrays.sort(B);

			// A의 수가 B의 수보다 클때 카운트
			for (int i : A) {
				for (int j : B) {
					if (i <= j) // A의 수가 B의 수보다 작으면 break
						break;
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
}
