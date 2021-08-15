package ssafy.study.week04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2503_숫자야구 {
	static int N, Ans;
	static int[] strike, ball;
	static char[][] num;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine()); // 질문의 개수
		Ans = 0;
		num = new char[N][3];
		strike = new int[N];
		ball = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			num[i] = st.nextToken().toCharArray(); // 질문한 세자리수
			strike[i] = Integer.parseInt(st.nextToken()); // 해당 질문의 스트라이크 수
			ball[i] = Integer.parseInt(st.nextToken());// 해당 질문의 볼 수
		}

		// 1~9에서 3자리를 뽑는 모든 경우의 수 => 순열(순서 상관 있음)
		permu(new char[3], 0, new boolean[10]);

		System.out.println(Ans);
	}

	private static void permu(char[] sel, int cnt, boolean[] isSelect) {
		if (cnt == 3) {
			for (int n = 0; n < N; n++) {
				int s = 0; // 스트라이크
				int b = 0; // 볼
				// 모든 경우의 수와 해당 질문의 숫자를 비교
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						// 해당 위치와 값이 같으면 스트라이크!
						if (i == j && num[n][i] == sel[j])
							s++;
						// 위치는 달라도 값이 같은게 있으면 볼!
						else if (num[n][i] == sel[j])
							b++;
					}
				}
				// 질문의 스트라이크와 볼을 비교해서 다르면 패스
				if (s != strike[n] || b != ball[n]) {
					return;
				}
			}
			// 스트라이크와 볼이 모두 일치하면 
//			System.out.println(Arrays.toString(sel));
			Ans++;
			return;
		}

		// 1~9에서 3자리를 뽑는 모든 경우의 수
		// char형으로 형변환
		for (int i = 1; i <= 9; i++) {
			if (!isSelect[i]) {
				sel[cnt] = (char) (i + '0');
				isSelect[i] = true;
				permu(sel, cnt + 1, isSelect);
				isSelect[i] = false;
			}
		}
	}
}
