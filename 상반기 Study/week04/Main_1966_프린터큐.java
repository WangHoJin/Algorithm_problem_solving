package ssafy.study.week04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {
	static int T, N, M, result;

	static class Doc {
		int impor;
		int idx;

		public Doc(int impor, int idx) {
			super();
			this.impor = impor;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			// 입력
			result = 0;
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine(), " ");
			Queue<Doc> q = new LinkedList<>();
			ArrayList<Integer> sort = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				int n = Integer.parseInt(st.nextToken());
				q.offer(new Doc(n, i));
				sort.add(n);
			}

			// 풀이
			// 중요도를 내림차순으로 정렬
			Collections.sort(sort, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}

			});

			while (!q.isEmpty()) {
				Doc tmp = q.poll();
				if (tmp.impor < sort.get(0)) {
					q.offer(tmp);

				} else {
					sort.remove(0);
					result++;
					if (tmp.idx == M) {
						System.out.println(result);
					}
				}
			}
		}
	}
}
