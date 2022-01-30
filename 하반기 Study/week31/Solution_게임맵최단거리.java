package second.study.week31;

import java.util.*;

import sun.net.www.content.audio.basic;

public class Solution_게임맵최단거리 {
	public static void main(String[] args) {
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };
		System.out.println(solution(maps));
	}

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	public static int solution(int[][] maps) {
		int answer = -1;
		int ySize = maps.length;
		int xSize = maps[0].length;

		answer = bfs(ySize, xSize, maps);

		return answer;
	}

	private static int bfs(int ySize, int xSize, int[][] maps) {
		boolean[][] visited = new boolean[ySize][xSize];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		visited[0][0] = true;
		int time = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point temp = q.poll();
				if (temp.y == ySize - 1 && temp.x == xSize - 1)
					return time;
				for (int d = 0; d < 4; d++) {
					int ny = temp.y + dy[d];
					int nx = temp.x + dx[d];
					if (!check(ny, nx, ySize, xSize) || visited[ny][nx] || maps[ny][nx] == 0)
						continue;
					visited[ny][nx] = true;
					q.add(new Point(ny, nx));
				}
			}
			time++;
		}
		return -1;
	}

	private static boolean check(int ny, int nx, int ySize, int xSize) {
		if (ny >= 0 && ny < ySize && nx >= 0 && nx < xSize)
			return true;
		return false;
	}
}