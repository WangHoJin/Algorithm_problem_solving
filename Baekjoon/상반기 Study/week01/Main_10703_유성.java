package ssafy.study.week01;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제> 
 * 수직으로 낙하하는 유성이 땅에 떨어진 후 사진을 복구하라!
 * 
 * 조건>
 * X : 유성
 * # : 땅
 * . : 공기
 * R,S : 세로, 가로 	3 <= R,S <= 3000
 * 
 * 주의사항>
 * 1. 유성과 땅 사이에는 한 줄 이상의 공기가 존재!
 * 2. 유성은 수직으로 낙하
 * 3. 유성이 없을때 거리 구하는 부분을 주의하자!
 *
 * 풀이>
 * 1. 운석과 땅의 y좌표를 통해 최소거리를 구하고 그 거리만큼 수직으로 하강
 * 2. 기존에 운석의 좌표는 .(공기)으로 변경
 * 3. 유성이 없는 땅은 계산 X
 * 
 */
public class Main_10703_유성 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 입력
		st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][S];
		int[] meteor = new int[S]; // 유성의 y좌표
		int[] land = new int[S]; // 땅의 y좌표
		int min = Integer.MAX_VALUE; // 최소 거리 변수
		int dis;	// 거리차이
		
//		long beforeTime = System.currentTimeMillis();
		
		for (int y = 0; y < R; y++) {
			String s = in.readLine();
			for (int x = 0; x < S; x++) {
				map[y][x] = s.charAt(x);
				// X이면 meteor배열에 y좌표를 저장 
				if (map[y][x] == 'X')
					meteor[x] = y + 1;
				// #이고 같은 열에 유성이 있으면 land배열에 y좌표 저장
				if (map[y][x] == '#' && meteor[x] != 0) {
					land[x] = y;
					dis = land[x] - meteor[x];	// 유성과 땅의 거리차이
					min = (min > dis) ? dis : min;	// 최소값 갱신
				}
			}
		}

		for (int x = 0; x < S; x++) {
			for (int y = R - 1; y >= 0; y--) {
				// 유성을 만나면 min값만큼 하락 후 이전 좌표는 .으로 변경
				if (map[y][x] == 'X') {
					map[y + min][x] = 'X';
					map[y][x] = '.';
				}
			}
		}
		// 출력
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int y = 0; y < R; y++) {
			out.write(map[y]);
			out.newLine();
		}
//		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
//		long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
//		out.write("시간차이(m) : "+secDiffTime);
		out.close();
	}
}
