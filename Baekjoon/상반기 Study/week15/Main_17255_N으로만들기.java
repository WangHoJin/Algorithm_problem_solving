package ssafy.study.week15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_17255_N으로만들기 {
	static int N;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/15/N으로만들기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

	}
}
