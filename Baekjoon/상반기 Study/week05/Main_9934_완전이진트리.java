package ssafy.study.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9934_완전이진트리 {
	static int K, size;
	static int[] Btree;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		K = Integer.parseInt(in.readLine());
		size = (int) Math.pow(2, K) - 1;
		Btree = new int[size];
		st = new StringTokenizer(in.readLine(), " ");
		search(0);
		int cnt = 1;
		for (int i = 0; i < size; i++) {
			if ((i + 1) % Math.pow(2, cnt) == 0) {
				System.out.println();
				cnt++;
			}
			System.out.print(Btree[i] + " ");
		}
	}

	private static void search(int idx) {
		if (idx > size - 1)
			return;

		search(idx * 2 + 1);
		Btree[idx] = Integer.parseInt(st.nextToken());
//		System.out.println(Btree[idx]);
		search(idx * 2 + 2);
	}
}
