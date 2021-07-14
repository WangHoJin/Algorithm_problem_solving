package second.study.week02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14719_빗물 {
	static int H, W, ans;
	static int[] map;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/02/빗물.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[W];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < W; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		int min = 0;
//		시작과 마지막 열빼고 모든 열 탐색
		for (int i = 1; i < W - 1; i++) {
			int ltb = 0;
			int rtb = 0;
//			해당 열에서 왼쪽으로 가장 큰 불록, 오른쪽으로 가장 큰 불록 찾기
			for (int j = 0; j < i; j++) {
				ltb = Math.max(map[j], ltb);
			}
			for (int j = i + 1; j < W; j++) {
				rtb = Math.max(map[j], rtb);
			}
//			양쪽 블록 중 작은 불록과 해당 블로의 차이 => 고인 빗물
			if (map[i] < ltb && map[i] < rtb) {
				min = Math.min(ltb, rtb);
				ans += min - map[i];
			}
		}

		print(map);
		System.out.println(ans);
	}

	private static void print(int[] map) {
		for (int i : map) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
