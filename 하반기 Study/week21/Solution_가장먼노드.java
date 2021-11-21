package second.study.week21;

import java.io.IOException;
import java.util.*;

import sun.misc.Perf;

public class Solution_가장먼노드 {

	public static void main(String[] args) throws IOException {
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}; 
		
		System.out.println(solution(n, edge));
	}

	public static int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[][] map = new boolean[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        for (int i = 0; i < edge.length; i++) {
			int a =edge[i][0];
			int b =edge[i][1];
			map[a][b] = true;
			map[b][a] = true;
		}
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        visited[1] = true;
        
        while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int temp = q.poll();
				for (int j = 1; j < map.length; j++) {
					if(visited[j] || !map[temp][j]) continue;
					visited[j] = true;
					q.add(j);
				}
			}
			answer = size;
		}
        return answer;
    }
}
