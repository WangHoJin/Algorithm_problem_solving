package second.study.week04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {
	static int N, M;
	static long ans;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/04/나무자르기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		long left = 0, right = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			right = Math.max(tree[i], right);
			left = Math.min(tree[i], left);
		}

		// 이진 탐색
		ans = bs(left, right);

//		print(tree);
		System.out.println(ans);
	}

	private static long bs(long left, long right) {
		long mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			long result = getTree(mid);
			if (result == M)
				return mid;
			else if (result > M)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return right;
	}

	private static long getTree(long mid) {
		long sum = 0;
		for (int i : tree) {
			if (i > mid)
				sum += (i - mid);
		}
		return sum;
	}

	private static void print(int[] tree) {
		for (int x : tree) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}