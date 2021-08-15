package ssafy.study.week11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2011_암호코드 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		int len = str.length();
		int[] num = new int[len + 1];
		for (int i = 1; i <= len; i++) {
			num[i] = str.charAt(i - 1) - '0';
		}
		int[] dp = new int[len + 1];
		dp[0] = 1;
		for (int i = 1; i <= len; i++) {
			// 1~9일 경우
			if (1 <= num[i] && num[i] < 10)
				dp[i] = (dp[i - 1] + dp[i]) % 1000000;
			// 10~ 26일 경우
			int temp = num[i] + num[i - 1] * 10;
			if (10 <= temp && temp <= 26)
				dp[i] = (dp[i - 2] + dp[i]) % 1000000;
		}

		System.out.println(dp[len]);
	}

}
