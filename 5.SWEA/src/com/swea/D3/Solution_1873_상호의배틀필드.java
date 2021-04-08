package com.swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//	/**
//	 * 문자 의미
//	 * . 평지(전차가 들어갈 수 있다.) 
//	 * * 벽돌로 만들어진 벽
//	 * # 강철로 만들어진 벽 
//	 * - 물(전차는 들어갈 수 없다.) 
//	 * ^ 위쪽을 바라보는 전차(아래는 평지이다.) 
//	 * v 아래쪽을 바라보는 전차(아래는 평지이다.) 
//	 * < 왼쪽을 바라보는 전차(아래는 평지이다.) 
//	 * > 오른쪽을 바라보는 전차(아래는 평지이다.) 
//	 * 
//	 * 문자 동작 
//	 * U Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다. 
//	 * D Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다. 
//	 * L Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다. 
//	 * R Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다. 
//	 * S Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
//	 */

public class Solution_1873_상호의배틀필드 {
	static int T, H, W, N;
	static char[][] map;
	static char[] control;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static Point p;

	static class Point {
		int y;
		int x;
		char dir;

		public Point(int y, int x, char dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int y = 0; y < H; y++) {
				String str = in.readLine();
				for (int x = 0; x < W; x++) {
					char c = str.charAt(x);
					map[y][x] = c;
					if (c == '<' || c == '>' || c == '^' || c == 'v') {
						p = new Point(y, x, c);
					}
				}
			}
			N = Integer.parseInt(in.readLine());
			control = new char[N];
			String str = in.readLine();
			for (int i = 0; i < N; i++) {
				control[i] = str.charAt(i);
			}
			// 풀이
			for (int i = 0; i < N; i++) {
				switch (control[i]) {
				case 'U':
					p.dir = '^';
					map[p.y][p.x] = '^';
					move(0);
					break;
				case 'D':
					p.dir = 'v';
					map[p.y][p.x] = 'v';
					move(1);
					break;
				case 'L':
					p.dir = '<';
					map[p.y][p.x] = '<';
					move(2);
					break;
				case 'R':
					p.dir = '>';
					map[p.y][p.x] = '>';
					move(3);
					break;
				case 'S':
					int d = 0;
					if (p.dir == '^')
						d = 0;
					else if (p.dir == 'v')
						d = 1;
					else if (p.dir == '<')
						d = 2;
					else
						d = 3;
					shot(p.y, p.x, d);
					break;

				default:
					break;
				}
			}
			System.out.print("#" + t + " ");
			print();
		}
	}

	private static void print() {
		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				System.out.print(map[y][x]);
			}
			System.out.println();
		}
	}

	private static void shot(int y, int x, int d) {
		int ny = y + dy[d];
		int nx = x + dx[d];
		if (!check(ny, nx))
			return;
		if (map[ny][nx] == '*') {
			map[ny][nx] = '.';
			return;
		} else if (map[ny][nx] == '#') {
			return;
		}
		shot(ny, nx, d);
	}

	private static void move(int d) {
		int ny = p.y + dy[d];
		int nx = p.x + dx[d];
		if (!check(ny, nx))
			return;
		if (map[ny][nx] == '.') {
			map[ny][nx] = p.dir;
			map[p.y][p.x] = '.';
			p.y = ny;
			p.x = nx;
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < H && nx >= 0 && nx < W)
			return true;
		return false;
	}
}
