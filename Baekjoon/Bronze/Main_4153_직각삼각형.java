package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_4153_직각삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int[] num = new int[3];
			num[0] = Integer.parseInt(st.nextToken());
			num[1] = Integer.parseInt(st.nextToken());
			num[2] = Integer.parseInt(st.nextToken());
			if (num[0] == 0 && num[1] == 0 && num[2] == 0)
				return;
			Arrays.sort(num);
			if (Math.pow(num[0], 2) + Math.pow(num[1], 2) == Math.pow(num[2], 2))
				System.out.println("right");
			else
				System.out.println("wrong");
		}
	}
}
