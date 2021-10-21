package Gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_빗물 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/Gold/빗물.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] height = new int[W];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for (int i = 1; i < W - 1; i++) {
			int start = 0;
			int end = 0;
			for (int j = 0; j < i; j++) {
				start = Integer.max(height[j], start);
			}
			for (int j = i + 1; j < W; j++) {
				end = Integer.max(height[j], end);
			}
			if (height[i] < start && height[i] < end) {
				int min = Integer.min(start, end);
				ans += min - height[i];
			}
		}
		System.out.println(ans);
	}
}
