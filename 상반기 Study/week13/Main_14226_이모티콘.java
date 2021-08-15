package ssafy.study.week13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14226_이모티콘 {
	static int S;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/13/이모티콘.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(in.readLine());
		dp = new int[S + 1];

		System.out.println(emo(S));
	}

	private static int emo(int n) {
		if (n == 0 || n == 1)
			return n;
		int min = Math.min((emo(n / 2) + 2), emo(n - 1) + 1);
		return min;
	}
}
