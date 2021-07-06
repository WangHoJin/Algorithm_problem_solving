import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21772_가희의고구마먹방 {
	static int R, C, T, sy, sx, cnt, ans;
	static char[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input/00/가희의고구마먹방.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int y = 0; y < R; y++) {
			String s = in.readLine();
			for (int x = 0; x < C; x++) {
				char c = s.charAt(x);
				map[y][x] = c;
				if (c == 'G') {
					sy = y;
					sx = x;
				}
			}
		}
		// print();
		dfs(sy, sx, 0, new boolean[R][C]);
		System.out.println(ans);
	}

	private static void dfs(int y, int x, int time, boolean[][] visited) {
		if (time == T) {
//		4.최대 고구마
			ans = Math.max(ans, cnt);
			return;
		}
//		1.가희는 1초마다 상하좌우 방향 중 한 방향으로 1번 이동하거나, 이동하지 않고 그 자리에 머무를 수 있습니다.
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (!check(ny, nx) || map[ny][nx] == '#')
				continue;
//		2.가희가 이동한 지점에 고구마가 있는 경우에는, 고구마를 먹습니다. 고구마를 먹는 데 걸리는 시간은 없다고 가정합니다.
			if (map[ny][nx] == 'S') {
//		3.가희가 고구마를 먹으면, 고구마가 다시 그 자리에 생기지 않습니다.
				cnt++;
				map[ny][nx] = '.';
//				visited[ny][nx] = true;
				dfs(ny, nx, time + 1, visited);
//				visited[ny][nx] = false;
				map[ny][nx] = 'S';
				cnt--;
			} else {
//				visited[ny][nx] = true;				
				dfs(ny, nx, time + 1, visited);
//				visited[ny][nx] = false;
			}
		}

	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < R && nx >= 0 && nx < C)
			return true;
		return false;
	}

	private static void print() {
		for (char[] y : map) {
			for (char x : y) {
				System.out.print(x);
			}
			System.out.println();
		}
	}
}
