package ssafy.study.week15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2263_트리의순회 {
	static int N;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/15/트리의순회.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine(), " ");
		
		go(0,N-1);

		System.out.println("성공");
	}

	private static void go(int start, int end) {
		
		
	}
}
