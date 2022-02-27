package second.study.week35;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1057_토너먼트 {

	static int N, A, B, ans;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/35/토너먼트.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		while(A != B) {
			A = A - A/2;
			B = B - B/2;
			ans++;
		}
		System.out.println(ans);
	}
}
