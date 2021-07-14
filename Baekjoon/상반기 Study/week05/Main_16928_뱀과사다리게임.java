package ssafy.study.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928_뱀과사다리게임 {
	static int N, M, ans;
	static int[] s;
	static boolean[] check;

	static class Short {
		int start;
		int end;

		public Short(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		s = new int[101];
		check = new boolean[101];
//		Short[] s = new Short[N + M];
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
//			s[i] = new Short(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			s[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		// bfs로 길 탐색
		bfs(s);
		System.out.println(ans);
	}

	private static void bfs(int[] s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1); // 시작점 1을 넣고
		check[1] = true;
		while (!q.isEmpty()) {
			int size = q.size(); // 주사위 몇번 굴렸는지 알기위해 size 지정
			// size마다 반복돌리면 bfs단계를 나눌수있음
			for (int k = 0; k < size; k++) {
				int temp = q.poll(); // 현재 위치
				if (temp == 100) // 100되면 도착
					return;
				// 주사위로 나올수있는 1~6 모두 넣어준다
				for (int i = 1; i <= 6; i++) {
					int current = temp + i;
					if (current > 100)
						break;
					if (check[current])
						continue;
					// 사다리나 뱀위치와 같으면 이동한 위치를 q에 넣는다
					if (s[current] != 0) {
						q.add(s[current]);
						check[s[current]] = true;
					}
					// 아닐경우 주사위눈금만큼 q에 넣는다
					else {
						q.add(current);
						check[current] = true;

					}
				}
			}
			// 한 bfs가 끝나면 ans증가 -> 카운터 역할
			ans++;
		}

	}
}
