import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_21922_학부연구생민상 {
	static int N, M, ans;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/00/학부연구생민상.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map;
		boolean[][] visited;
		map = new int[N][M];
		visited = new boolean[N][M];
		ArrayList<Integer> sy = new ArrayList<>();
		ArrayList<Integer> sx = new ArrayList<>();
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 9) {
					sy.add(y);
					sx.add(x);
					visited[y][x] = true;
				}
			}
		}
		play(map, visited, sy, sx);
		print(map, visited);
		countMap(visited);
		System.out.println(ans);
	}

	private static void countMap(boolean[][] visited) {
		for (boolean[] bs : visited) {
			for (boolean b : bs) {
				if (b)
					ans++;
			}
		}
	}

	private static void play(int[][] map, boolean[][] visited, ArrayList<Integer> sy, ArrayList<Integer> sx) {
		for (int i = 0; i < sy.size(); i++) {
			for (int d = 0; d < 4; d++) {
				int ny = sy.get(i);
				int nx = sx.get(i);
				int nd = d;
				while (true) {
					ny += dy[nd];
					nx += dx[nd];
					if (!check(ny, nx) || map[ny][nx] == 9)
						break;
					if (map[ny][nx] != 0) {
						int temp = thing(map[ny][nx], nd);
						if (temp == -1) {
							visited[ny][nx] = true;
							break;
						} else
							nd = temp;
					}
					visited[ny][nx] = true;
				}
			}
		}
	}

	private static int thing(int sel, int dir) {
		if (sel == 1) {
			if (dir == 2 || dir == 3) {
				return -1;
			}
		} else if (sel == 2) {
			if (dir == 0 || dir == 1) {
				return -1;
			}
		} else if (sel == 3) {
			return Math.abs(dir - 3);
		} else {
			return (dir + 2) % 4;
		}
		return dir;
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < M)
			return true;
		return false;
	}

	private static void print(int[][] map, boolean[][] visited) {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
}
