package second.study.week34;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

///**
// * 문제>
// * 	땅고르기 최소시간과 땅의 높이를 출력하시오.
// * 	
// * 조건>
// * 	1.좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다.
// * 	2.인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다.
// * 
// * 	1번 작업 -> 2초
// * 	2번 작업 -> 1초
// * 
// */
public class Main_18111_마인크래프트 {

	static int N, M, B, min, max, height, time;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/34/마인크래프트.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		max = 0;
		min = Integer.MAX_VALUE;
		time = Integer.MAX_VALUE;
		height = 0;
		map = new int[N][M];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < M; x++) {
				int num = Integer.parseInt(st.nextToken());
				map[y][x] = num;
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
		}

		for (int i = min; i <= max; i++) {
			int inven = B;
			int cnt = 0;
			W: for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					int diff = map[y][x] - i;
					int absDiff = Math.abs(diff);
					// 제거해야 되는 경우 -> 2초
					if (diff > 0) {
						inven += absDiff;
						cnt += absDiff * 2;
					}
					// 쌓아야 되는 경우 - > 1초
					else if (diff < 0) {
						if (inven < 0)
							break W;
						inven -= absDiff;
						cnt += absDiff;
					}
				}
			}
			if (inven < 0)
				continue;
			if (cnt <= time) {
				time = cnt;
				height = i;
			}
		}
		System.out.println(time + " " + height);
//		print(map);
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
