package ssafy.study.week02;
import java.util.Arrays;
import java.util.Scanner;

public class Main_11399_ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] time = new int[N];
		int result = 0, sum = 0;
		for (int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
		}
		Arrays.sort(time);

		for (int i = 0; i < N; i++) {
			sum += time[i];
			result += sum;
		}
		System.out.println(result);
	}

}
