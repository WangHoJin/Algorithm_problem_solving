package ssafy.study.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int N, min,totalcnt;
	static int[][] stat;
	static int[] P;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		stat = new int[N][N]; // 능력치 배열
		min = Integer.MAX_VALUE; // 능력차이 최소값
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < N; x++) {
				stat[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		P = new int[N]; // N크기의 flag배열
		int R = N / 2;
		int cnt = 0;

		// 넥스트퍼뮤로 조합구현
		while (++cnt <= R)
			P[N - cnt] = 1;

		do {
			// 선택과 비선택을 동시에 저장하기 때문에 모든경우의 수의 반만 확인하면 된다
			// P배열의 0 인덱스가 1이 되면 반의 경우의 수를 확인한것이다!!
			// 그 뒤에 탐색은 불필요 -> 가지치기
			if (P[0] == 1) {
				break;
			}
			totalcnt++;
			ArrayList<Integer> sel = new ArrayList<>();
			ArrayList<Integer> nsel = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				// 선택한 팀과 비선택팀을 나눠서 리스트에 저장
				if (P[i] == 1) {
					sel.add(i);
				} else {
					nsel.add(i);
				}
			}

			int sum1 = 0; // 능력치 차이를 담을 변수
			// 선택팀 -> 스타트팀의 능력치
			for (int i = 0; i < N / 2; i++) {
				for (int j = i + 1; j < N / 2; j++) {
					int a = sel.get(i);
					int b = sel.get(j);
					sum1 += stat[a][b];
					sum1 += stat[b][a];
				}
			}

			// 비선택팀 -> 링크팀의 능력치
			for (int i = 0; i < N / 2; i++) {
				for (int j = i + 1; j < N / 2; j++) {
					int a = nsel.get(i);
					int b = nsel.get(j);
					sum1 -= stat[a][b];
					sum1 -= stat[b][a];
				}
			}

			min = Math.min(min, Math.abs(sum1));
		} while (np());

		System.out.println(totalcnt);
	}

	// 넥스트퍼뮤
	private static boolean np() {
		// STEP 1
		int i = N - 1;
		// 뒤에서부터 꺾이는지점을 찾는다
		while (i > 0 && P[i - 1] >= P[i])
			--i; // 꼭대기 지점

		// 더 이상 앞자리가 없는 상황 : 현 순열의 상태가 가장 큰 순열(마지막 순열)
		if (i == 0)
			return false;

		// STEP 2
		int j = N - 1;
		while (P[i - 1] >= P[j])
			--j;

		// STEP 3
		swap(i - 1, j);

		// STEP 4
		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	private static void swap(int i, int j) {
		int temp = P[i];
		P[i] = P[j];
		P[j] = temp;
	}
}
