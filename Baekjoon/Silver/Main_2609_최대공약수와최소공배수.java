package Silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int big = a;
		int small = b;
		// 유클리드호제
		while (small != 0) {
			// 큰수 작은수 구분
			if (b > a) {
				big = b;
				small = a;
			}
			// 나머지값이 0이 될때까지 나눠준다.
			int temp = small;
			small = big % small;
			big = temp;
		}
		int ans = gcd(a,b);
		System.out.println(ans);
		// 최소공배수 = 두 수의 곱 / 최대공약수
		System.out.println(a * b / ans);
	}

	private static int gcd(int a, int b) {
		if(b == 0) return a;
		else return gcd(b, a % b);		
	}
}
