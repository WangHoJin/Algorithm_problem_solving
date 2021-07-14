import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1828_냉장고 {
	static int N;

	static class Ref implements Comparable<Ref> {
		int low;
		int high;

		public Ref(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Ref o) {

			return this.high - o.high;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		Ref[] r = new Ref[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			r[i] = new Ref(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int cnt = 1;
		Arrays.sort(r); // 냉장고 최고보관온도 오름차순 정렬
		Ref temp = r[0]; // 첫 냉장고 정보 삽입

		for (int i = 1; i < N; i++) {
			// 현재 냉장고 최고온도보다 다른 냉장고 최저온도가 크면
			// 냉장고가 하나 더 필요함
			if (temp.high < r[i].low) {
				temp = r[i]; // 현재냉장고정보 변경
				cnt++; // 냉장고 수 ++
			}
		}
		System.out.println(cnt);
	}
}
