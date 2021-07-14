package ssafy.study.week04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	static int N, max, min;
	static int[] num, operator;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine()); // 숫자 수
		num = new int[N]; // 숫자 저장 배열
		operator = new int[4]; // 연산자 저장 배열
		min = Integer.MAX_VALUE; // 최소값
		max = Integer.MIN_VALUE; // 최대값
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		// 연산자 입력
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		// 연산자 순열
		permu(new int[N - 1], 0);

		System.out.println(max);
		System.out.println(min);
	}

	private static void permu(int[] sel, int cnt) {
		if (cnt == N - 1) {
//			System.out.println(Arrays.toString(sel));
			// 정수형으로 저장된 연산자를 변환해서 계산해주는 함수
			// 연산자 우선순위가 없으므로 한번에 꺼내서 계산 X
			// 재귀로 하나씩 꺼내서 계산
			Calculation(sel, num[0], 0);
			return;
		}
		for (int i = 0; i < 4; i++) {
			// 방문 체크를 0인지 아닌지로 판단
			if (operator[i] != 0) {
				operator[i]--;
				// 연산자를 정수형으로 저장
				// 0:덧셈(+), 1:뺄셈(-), 2:곱셈(*), 3:나눗셈(/)
				sel[cnt] = i;
				permu(sel, cnt + 1);
				operator[i]++;
			}
		}
	}

	private static void Calculation(int[] sel, int result, int idx) {
		if (idx == sel.length) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}
		int a = result;
		int b = num[idx + 1];
		switch (sel[idx]) {
		case 0:
			result = a + b;
			break;
		case 1:
			result = a - b;
			break;
		case 2:
			result = a * b;
			break;
		case 3:
			result = a / b;
			break;
		default:
			break;
		}
		Calculation(sel, result, idx + 1);
	}

}
