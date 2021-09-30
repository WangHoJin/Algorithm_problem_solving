package second.study.week14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12852_1로만들기2 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/14/1로만들기2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] d = new int[N + 1];
		int[] road = new int[N + 1];
		d[1] = 0;
		for (int i = 2; i <= N; i++) {
			d[i] = d[i - 1] + 1;
			road[i] = i - 1;
			if (i % 2 == 0 && d[i / 2] + 1 < d[i]) {
				d[i] = d[i / 2] + 1;
				road[i] = i / 2;
			}
			if (i % 3 == 0 && d[i / 3] + 1 < d[i]) {
				d[i] = d[i / 3] + 1;
				road[i] = i / 3;
			}
		}
		System.out.println(d[N]);

		while (N != 0) {
			System.out.print(N + " ");
			N = road[N];
		}
	}
}
