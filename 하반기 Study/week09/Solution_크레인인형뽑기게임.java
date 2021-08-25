package kakao.level1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_크레인인형뽑기게임 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		int n = board.length;
		Queue<Integer>[] q = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			q[i] = new LinkedList<>();
		}
		// 각 열마다 큐에 넣어서 원할때 poll할 수 있게한다.
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (board[y][x] == 0)
					continue;
				q[x].add(board[y][x]);
			}
		}
		// 바구니 스택에 같은 모양이 들어오면 터진다
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < moves.length; i++) {
			int idx = moves[i] - 1;
			// 인형을 못집었거나 바구니가 비어있을때
			if (q[idx].size() == 0)
				continue;
			if (stack.size() == 0) {
				int curr = q[idx].poll();
				stack.push(curr);
			} else {
				int curr = q[idx].poll();
				int store = stack.peek();
				if (curr == store) {
					stack.pop();
					answer += 2;
				} else
					stack.push(curr);
			}
		}
		return answer;
	}
}
