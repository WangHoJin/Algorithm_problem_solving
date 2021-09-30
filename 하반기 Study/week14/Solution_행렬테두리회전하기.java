package second.study.week14;

public class Solution_행렬테두리회전하기 {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] map = new int[rows][columns];
		int num = 1;
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < columns; x++) {
				map[y][x] = num++;
			}
		}
		for (int i = 0; i < queries.length; i++) {
			int min = rows * columns;
			int y1 = queries[i][0] - 1;
			int x1 = queries[i][1] - 1;
			int y2 = queries[i][2] - 1;
			int x2 = queries[i][3] - 1;

			int temp = map[y1][x1];
			int next = temp;
			min = Math.min(min, next);
			// left
			for (int y = y1; y < y2; y++) {
				next = map[y + 1][x1];
				map[y][x1] = next;
				min = Math.min(min, next);
			}
			// bottom
			for (int x = x1; x < x2; x++) {
				next = map[y2][x + 1];
				map[y2][x] = next;
				min = Math.min(min, next);
			}
			// right
			for (int y = y2; y > y1; y--) {
				next = map[y - 1][x2];
				map[y][x2] = next;
				min = Math.min(min, next);
			}
			// top
			for (int x = x2; x > x1; x--) {
				next = map[y1][x - 1];
				map[y1][x] = next;
				min = Math.min(min, next);
			}
			answer[i] = min;
			map[y1][x1 + 1] = temp;
		}
		// for(int y = 0; y < rows; y++){
		// for(int x = 0; x < columns; x++){
		// System.out.print(map[y][x]+" ");
		// }
		// System.out.println();
		// }
		return answer;
	}
}
