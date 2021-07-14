package ssafy.study.week14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3020_개똥벌레 {
	static int N, H, ans;
	static int[] up, down;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/14/개똥벌레.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		up = new int[H + 1];
		down = new int[H + 1];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N / 2; i++) {
			int u = Integer.parseInt(in.readLine());
			int d = Integer.parseInt(in.readLine());
			up[u]++;
			down[d]++;
		}
//		System.out.println("석순");
//		for (int i = 1; i <= H; i++) {
//			System.out.println("높이 "+i+" "+up[i]);
//		}
//		System.out.println("종유석");
//		for (int i = 1; i <= H; i++) {
//			System.out.println("높이 "+i+" "+down[i]);
//		}

		int[] uSum = new int[H + 1];
		int[] dSum = new int[H + 1];
		// 누적합
		for (int i = 1; i <= H; i++) {
			uSum[i] = uSum[i - 1] + up[i];
			dSum[i] = dSum[i - 1] + down[i];
		}

		int cnt = 1;
		for (int i = 1; i <= H; i++) {
			int sum = uSum[H] - uSum[i - 1] + dSum[H] - dSum[H-i];
//			System.out.println(sum);
			if (sum < ans) {
				ans = sum;
				cnt = 1;
			} else if (sum == ans)
				cnt++;
		}

		System.out.println(ans + " " + cnt);
	}
}
