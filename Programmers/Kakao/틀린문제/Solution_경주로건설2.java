package study.week13;

import java.util.Arrays;

public class Solution_경주로건설2 {
	public static void main(String[] args) {
		Solution4 solution = new Solution4();
		int[][] board = { { 0, 0, 1, 0, 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 1, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 1, 0, 1, 1 },
				{ 0, 0, 1, 0, 1, 1, 0, 1, 0, 1 }, { 0, 1, 0, 0, 1, 0, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 } };

		System.out.println(solution.solution(board));
	}
}

class Solution4 {
	static int N;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public int solution(int[][] map) {
		int answer = 0;
		N = map.length;
		int[][] distance = new int[N][N];
		int[][] dir = new int[N][N]; // 0:초기 1:수평 2:수직
		boolean[][] visited = new boolean[N][N];

		// 거리 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}

		// 초기 길 설정
		distance[0][0] = 0;
		visited[0][0] = true;
		dir[0][0] = 4;
		dir[0][1] = 0;
		distance[0][1] = 100;
		dir[1][0] = 3;
		distance[1][0] = 100;

		// 모든점 검사
		for (int i = 0; i < N * N; i++) {
			int min = Integer.MAX_VALUE;
			int current_y = 0;
			int current_x = 0;

			// 방문하지않고 연결된 비용이 가장 작은 도로 찾기 => 이것도 말이안댐
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (map[y][x] == 1)
						continue;
					if (!visited[y][x] && distance[y][x] != Integer.MAX_VALUE && min > distance[y][x]) {
						min = distance[y][x];
						current_y = y;
						current_x = x;
					}
				}
			}

			visited[current_y][current_x] = true;
			
			if (current_y == N - 1 && current_x == N - 1)
				break;

			for (int d = 0; d < 4; d++) {
				int ny = current_y + dy[d];
				int nx = current_x + dx[d];
				int weight = 0;
				if (!check(ny, nx) || map[ny][nx] == 1 || visited[ny][nx])
					continue;
				// 직선도로일 경우에는 비용이 100
				if ((dir[current_y][current_x] < 2 && d < 2) || (dir[current_y][current_x] >= 2 && d >= 2)
						|| dir[current_y][current_x] == 4) {
					weight = 100;
				} else {	// 코너는 비용이 100+500 = 600
					weight = 600;
				}
				// 현재 도로에서 직선이냐 코너이냐에 따른 비용을 더한 최소값과 방향을 갱신
				if (distance[ny][nx] >= distance[current_y][current_x] + weight) {
					// 직선이나 코너 둘다 같은 비용일땐 둘 다 가능 : 4로 표시
					if (distance[ny][nx] == distance[current_y][current_x] + weight) {
						dir[ny][nx] = 4;
					} else
						dir[ny][nx] = d;
					distance[ny][nx] = distance[current_y][current_x] + weight;
				}
			}
		}
		return answer = distance[N - 1][N - 1];
	}

	private static boolean check(int ny, int nx) {
		if (ny < 0 || ny >= N || nx < 0 || nx >= N)
			return false;
		return true;
	}

	private static void print(int[][] map) {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
}