package second.study.week25;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_4948_베르트랑공준 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/25/베르트랑공준.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n = Integer.parseInt(in.readLine());
			if (n == 0)
				break;
			int nn = 2 * n;
			int ans = 0;
			for (int i = n + 1; i <= nn; i++) {
				ans += isPrime(i);
			}
			System.out.println(ans);
		}
	}

	private static int isPrime(int number) {
		if (number < 2) {
			return 0;
		}
		if (number == 2) {
			return 1;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0)
				return 0;
		}
		return 1;
	}
}
