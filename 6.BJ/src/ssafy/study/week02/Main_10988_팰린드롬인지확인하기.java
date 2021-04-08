package ssafy.study.week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_10988_팰린드롬인지확인하기 {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		int len = str.length();
		int result = 1;
		for (int i = 0; i < len; i++) {
			if (sb.charAt(i) != sb.charAt(len - 1 - i)) {
				result = 0;
				break;
			}
		}
		System.out.println(result);
	}
}
