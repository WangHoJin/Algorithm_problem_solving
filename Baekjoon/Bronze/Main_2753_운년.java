package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2753_운년 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		if ((N % 4 == 0 && N % 100 != 0) || N % 400 == 0)
			System.out.println("1");
		else
			System.out.println("0");

	}
}
