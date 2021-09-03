package second.study.week10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_22935_이진딸기 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/10/이진딸기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(in.readLine());
			StringBuilder sb = new StringBuilder();
			int type = ((N - 1) / 14) % 2;

			if (type == 0) {
				N = (N - 1) % 14 + 1;
				String bs = String.format("%04d", Integer.parseInt(Integer.toBinaryString(N)));
				char[] bc = bs.toCharArray();
				for (char c : bc) {
					if (c == '1')
						sb.append("딸기");
					else
						sb.append("V");
				}
			} else {
				N = (N - 1) % 14;
				String bs = String.format("%04d", Integer.parseInt(Integer.toBinaryString(N)));
				char[] bc = bs.toCharArray();
				for (char c : bc) {
					if (c == '0')
						sb.append("딸기");
					else
						sb.append("V");
				}
			}
			System.out.println(sb.toString());
		}
	}
}
