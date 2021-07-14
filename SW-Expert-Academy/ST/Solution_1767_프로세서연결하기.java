package com.swea.ST;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {
	static int T, N;
	static int[][] map;
	static ArrayList<Point> core;

	static class Point implements Comparable<Point>{
		int y, x, conAble;

		public Point(int y, int x, int conAble) {
			super();
			this.y = y;
			this.x = x;
			this.conAble = conAble;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.conAble-o.conAble;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/프로세서.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			core = new ArrayList<>();
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int x = 0; x < N; x++) {
					int c = Integer.parseInt(st.nextToken());
					map[y][x] = c;
					if (c == 1 && x != 0 && x != N - 1 && y != 0 && y != N - 1)
						core.add(new Point(y, x,4));
				}
			}
			connectableCount();
			Collections.sort(core);
			for (int i = 0; i < core.size(); i++) {
				System.out.println(core.get(i).y+","+core.get(i).x+" : "+core.get(i).conAble);
			}
//			print();
		}
	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	private static void connectableCount() {
		int size = core.size();

		for (int i = 0; i < size; i++) {
			Point temp = core.remove(i);
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int k = 1;
				while (true) {
					int ny = temp.y + dy[d] * k;
					int nx = temp.x + dx[d] * k;
					if(map[ny][nx] != 1 && check(ny,nx)) {
						break;
					}
					if (map[ny][nx] == 1) {
						cnt++;
						break;
					}
					k++;
				}
			}
			core.add(new Point(temp.y, temp.x, 4-cnt));
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny == 0 || ny == N - 1 || nx == 0 || nx == N - 1)
			return true;
		return false;
	}

	private static void print() {
		for (int[] y : map) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}

	}
}
