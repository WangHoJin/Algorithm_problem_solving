package second.study.week33;

import java.util.*;

public class Solution_단어변환 {
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));
	}

	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		visited = new boolean[words.length];
		ans = Integer.MAX_VALUE;
		dfs(begin, target, words, 0, 0);
		return answer;
	}

	static boolean[] visited;
	static int ans;

	public static void dfs(String begin, String target, String[] words, int idx, int depth) {
		if (begin.equals(target)) {
			ans = Math.min(ans, depth);
			return;
		}
		for (int i = 0; i < words.length; i++) {
			int same = 0;
			if (visited[i])
				continue;
			for (int j = 0; j < words[i].length(); j++) {
				if (begin.charAt(j) == words[i].charAt(j))
					same++;
			}
			if (same == begin.length() - 1) {
				visited[i] = true;
				dfs(words[i], target, words, i, depth + 1);
				visited[i] = false;
			}
		}
		return;
	}
}