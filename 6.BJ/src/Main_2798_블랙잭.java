import java.util.Scanner;

public class Main_2798_블랙잭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					sum = num[i] + num[j] + num[k];
					if (sum <= M)
						max = Math.max(sum, max);
				}
			}
		}

		System.out.println(max);
	}
}
