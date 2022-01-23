package second.study.week30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_잃어버린괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), "-");
		int ans = Integer.MAX_VALUE;

		while (st.hasMoreTokens()) {
			int num = 0;
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

			while (st2.hasMoreTokens())
				num += Integer.parseInt(st2.nextToken());

			if (ans == Integer.MAX_VALUE)
				ans = num;
			else
				ans -= num;

		}
		System.out.println(ans);
	}
}
