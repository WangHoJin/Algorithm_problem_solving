package ssafy.study.week15;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_17255_N으로만들기3 {
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		Integer.parseInt(in.readLine());
		Integer.parseInt(st.nextToken());
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		out.flush();
		out.close();
		
		// 스캐너
		Scanner sc = new Scanner(System.in);
		
		// 파일
		
	}
	
	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= N || nx < 0 || nx >= M)
			return false;
		return true;
	}
	
	private static void print(int[][] map) {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
}
