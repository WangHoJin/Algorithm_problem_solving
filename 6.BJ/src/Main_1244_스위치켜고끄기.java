import java.util.Scanner;

public class Main_1244_스위치켜고끄기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] sw = new int[N];
		for (int i = 0; i < N; i++) {
			sw[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int gen = sc.nextInt();
			int idx = sc.nextInt();

			int k = 1;
			if (gen == 1) {
				while (idx * k < N) {
					sw[idx * k - 1] = (sw[idx * k - 1] == 1) ? 0 : 1;
					k++;
				}
			} else {
				sw[idx - 1] = (sw[idx - 1] == 1) ? 0 : 1;

				while (true) {
					int left = idx - k - 1;
					int right = idx + k - 1;
					if (left < 0 || right >= N) {
						break;
					}
					if (sw[left] == sw[right]) {
						sw[left] = (sw[left] == 1) ? 0 : 1;
						sw[right] = (sw[right] == 1) ? 0 : 1;
						k++;
					}
				}
			}
		}
		for (int i : sw) {
			System.out.print(i + " ");
		}
	}
}
