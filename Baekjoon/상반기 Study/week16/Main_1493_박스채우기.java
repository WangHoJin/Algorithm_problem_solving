package ssafy.study.week16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1493_박스채우기 {
	static int ans;
	static int[] box;
	static int[] cube;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/16/박스채우기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		box = new int[3];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < 3; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(box);
		int n = Integer.parseInt(in.readLine());
		cube = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			cube[a] = b;
		}

		yap(n - 1, box[0], box[1], box[2]);
	}

	private static void yap(int n, int l, int w, int h) {
		int pow = (int) Math.pow(n, 2);
		if (pow > l) {
			yap(n - 1, l, w, h);
		} else {
			// 현재 큐브로 채울수 있는 칸 계산
			int ll = l / pow;
			int ww = w/ pow;
			int hh = h / pow;
			if(cube[n] < (h / pow)) {
				hh = cube[n];
			}
			ans += ll * ww * hh;
			// 큐브 개수 고려
			int lll = (l%pow==0)?l:l%pow;
			int www = (w%pow==0)?w:w%pow;
			int hhh = (h%pow==0)?h:h%pow;
			
		}

	}
}
