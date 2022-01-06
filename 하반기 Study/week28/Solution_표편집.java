package second.study.week28;

import java.io.IOException;
import java.util.*;

public class Solution_표편집 {

	public static void main(String[] args) throws IOException {
		int n = 8;
		int k = 2;
		String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
		System.out.println(solution(n, k, cmd));
	}

	static class Node {
		int pre, next, curr;

		public Node(int pre, int next, int curr) {
			super();
			this.pre = pre;
			this.next = next;
			this.curr = curr;
		}
	}

	public static String solution(int n, int k, String[] cmd) {
		String answer = "";
		int select = k;
		int[] pre = new int[n];
		int[] next = new int[n];
		Stack<Node> delete = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			pre[i] = i - 1;
			next[i] = i + 1;
			sb.append("O");
		}
		next[n - 1] = -1;
		for (int i = 0; i < cmd.length; i++) {
			StringTokenizer st = new StringTokenizer(cmd[i], " ");
			String c = st.nextToken();
			// 업 단축키
			if (c.equals("U")) {
				int cnt = Integer.parseInt(st.nextToken());
				while (cnt-- > 0) {
					k = pre[k];
				}
			}

			// 다운 단축키
			else if (c.equals("D")) {
				int cnt = Integer.parseInt(st.nextToken());
				while (cnt-- > 0) {
					k = next[k];
				}
			}

			// 삭제 단축키
			else if (c.equals("C")) {
				// delete 스택에 추가
				delete.push(new Node(pre[k], next[k], k));
				if (pre[k] != -1)
					next[pre[k]] = next[k];
				if (next[k] != -1)
					pre[next[k]] = pre[k];
				sb.setCharAt(k, 'X');

				if (next[k] != -1)
					k = next[k];
				else
					k = pre[k];
			}

			// 되돌리기 단축키
			else {
				Node re = delete.pop();
				if (re.pre != -1)
					next[re.pre] = re.curr;
				if (re.next != -1)
					pre[re.next] = re.curr;
				sb.setCharAt(re.curr, 'O');
			}
		}
		answer = sb.toString();
		return answer;
	}
}
