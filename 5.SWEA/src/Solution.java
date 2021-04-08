import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n, m, ans;
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] arr = new int[n + 1][m + 1];

		ans = n * m; // 위에서 투시한 겉넓이

		for (int i = 1; i <= n; i++) { // 오른쪽에서 투시한 겉넓이
			int sum = 0;
			for (int j = 1; j <= m; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] > arr[i][j - 1])
					sum += arr[i][j] - arr[i][j - 1]; // 이전 블록보다 높이가 높을 경우에 겉넓이 증가
			}
			ans += sum;
		}

		for (int j = 1; j <= m; j++) { // 앞에서 투시한 겉넓이
			int sum = 0;
			for (int i = 1; i <= n; i++)
				if (arr[i][j] > arr[i - 1][j]) {
					int a = arr[i][j];
					int b = arr[i - 1][j];
					sum += arr[i][j] - arr[i - 1][j];
				}
			ans += sum;
		}

		System.out.printf("%d", ans * 2);
	}
}
