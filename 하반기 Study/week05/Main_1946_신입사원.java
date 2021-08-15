import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1946_신입사원 {
	static int T, N, ans;
	static ArrayList<Grade> list;

	static class Grade implements Comparable<Grade> {
		int a, b;

		public Grade(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Grade o) {
			return this.a - o.a;
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/05/신입사원.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			ans = 1; // 서류든 면접이든 1등은 무조건 있으므로
			N = Integer.parseInt(in.readLine());
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				list.add(new Grade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Collections.sort(list);
			int st = list.get(0).b;
			// 서류 성적이 낮은 사람부터 뒤에 사람과 비교하며 면접 성적까지 낮으면 break;
			for (int i = 1; i < N; i++) {
				if (st > list.get(i).b) {
					st = list.get(i).b;
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
}
