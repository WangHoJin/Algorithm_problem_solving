package ssafy.study.week02;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_8320_직사각형을만드는방법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int y = 1; y <= N; y++) {
			for (int x = y; x * y <= N; x++) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
