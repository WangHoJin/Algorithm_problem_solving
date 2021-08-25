package Gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_21941_문자열제거 {
	static int M, ans;
	static char[] S;
	static int[] dp;
	static ArrayList<SS> list;

	static class SS {
		String word;
		int score;

		public SS(String str, int score) {
			super();
			this.word = str;
			this.score = score;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/Gold/문자열제거.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		S = in.readLine().toCharArray();
		M = Integer.parseInt(in.readLine());
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			list.add(new SS(st.nextToken(), Integer.parseInt(st.nextToken())));
		}
		// 마지막 문자부터 하나씩 늘려가면서 해당 인덱스까지 최대 점수 저장
		// dp[n] = n~젤 끝 인덱스까지 최대 점수
		dp = new int[S.length];
		ans = go(0);
		System.out.println(ans);
	}

	private static int go(int idx) {
		if (idx >= S.length)
			return 0;
		if (dp[idx] != 0)
			return dp[idx];

		dp[idx] = go(idx + 1) + 1;

		for (SS temp : list) {
			String word = temp.word;
			int score = temp.score;
			// 원본 문자열에서 제거 문자열의 길이만큼 문자열을 만들어서 비교
			String nWord = cutString(S, idx, word.length());
//			System.out.println(nWord);
			if (word.equals(nWord)) {
				dp[idx] = Math.max(dp[idx], go(idx + word.length()) + score);
			}
		}

		return dp[idx];
	}

	private static String cutString(char[] S, int curr, int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = curr; i < curr + len; i++) {
			if (i >= S.length)
				continue;
			sb.append(S[i]);
		}
		return sb.toString();
	}

	private static void print(ArrayList<SS> list) {
		for (SS ss : list) {
			System.out.println(ss);
		}
	}
}
