package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][M];

		for (int y = 0; y < H; y++) {
			String s = in.readLine();
			for (int x = 0; x < M; x++) {
				char c = s.charAt(x);
				map[y][x] = c;
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < H - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				int b_cnt = 0; // 왼쪽 위가 B인 경우
				int w_cnt = 0; // 왼쪽 위가 W인 경우

				for (int y = i; y < i + 8; y++) {
					for (int x = j; x < j + 8; x++) {
						char c = map[y][x];
						if ((y + x) % 2 == 0) {
							if (c == 'B')
								w_cnt++;
							else
								b_cnt++;

						} else {
							if (c == 'W')
								w_cnt++;
							else
								b_cnt++;
						}
					}
				}
				int min = (w_cnt < b_cnt ? w_cnt : b_cnt);
				ans = ans <  min ? ans : min;
			}
		}
		System.out.println(ans);
	}
}
