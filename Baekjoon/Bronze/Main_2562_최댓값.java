package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2562_최댓값 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int idx = 0;
		for (int i = 1; i <= 9; i++) {
			int num = Integer.parseInt(in.readLine());
			if (max < num) {
				max = num;
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}
}
