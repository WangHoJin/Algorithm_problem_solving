package ssafy.study.week01;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

///**
// * 문제> 수직으로 낙하하는 유성이 땅에 떨어진 후 사진을 복구하라!
// * 
// * 조건> X : 유성 # : 땅 . : 공기 R,S : 세로, 가로 3 <= R,S <= 3000
// * 
// * 주의사항> 
// * 1. 유성과 땅 사이에는 한 줄 이상의 공기가 존재! 
// * 2. 유성은 수직으로 낙하 
// * 3. 유성이 없을때 거리 구하는 부분을 주의하자!
// *
// * 풀이> 
// * 1. 모든 유성의 좌표를 저장한 후 
// * 2. 땅에 닿을때까지 한칸씩 하강 반복
// * 3. 땅에 닿으면 반복 종료 후 반복횟수만큼 내려준다.
// */

public class Main_10703_유성2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 입력
		st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][S];
		int meteCnt = 0;
		for (int y = 0; y < R; y++) {
			String s = in.readLine();
			for (int x = 0; x < S; x++) {
				map[y][x] = s.charAt(x);
				// X이면 meteor배열에 좌표를 저장
				if (map[y][x] == 'X') {
					meteCnt++; // 유성의 갯수 파악
				}
			}
		}

		int[][] meteor = new int[meteCnt][2]; // 유성의 좌표 배열 0:y좌표, 1:x좌표
		meteCnt = 0;
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < S; x++) {
				// X이면 유성의 좌표를 입력
				if (map[y][x] == 'X') {
					meteor[meteCnt][0] = y;
					meteor[meteCnt++][1] = x;
				}
			}
		}

		int cnt = 0; // 반복횟수
		boolean flag = true; // 땅 만남 여부 판단
		// 유성을 한칸씩 내리면서 땅을 만날때까지 반복
		while (flag) {
			for (int i = meteCnt - 1; i >= 0; i--) {
				int ny = meteor[i][0] + cnt + 1;
				int nx = meteor[i][1];
				// 땅을 만났으면 반복문 종료
				if (map[ny][nx] == '#') {
					flag = false;
					cnt--;
					break;
				}
			}
			cnt++;
		}

		// 모든 유성을 반복횟수만큼 내려준다
		for (int i = meteCnt - 1; i >= 0; i--) {
			int py = meteor[i][0];
			int ny = meteor[i][0] + cnt;
			int nx = meteor[i][1];
			map[ny][nx] = 'X';
			map[py][nx] = '.';
		}

		// 출력
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int y = 0; y < R; y++) {
			out.write(map[y]);
			out.newLine();
		}
		out.close();
	}
}