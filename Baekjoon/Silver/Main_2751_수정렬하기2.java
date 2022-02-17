package Silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 문제> 
 * 	수 정렬하기1과 다르게 Arrays.sort()를 사용하면 시간초과가 뜬다. => 최악의 경우 O(N^2)이기 때문에
 *  Collections.sort()는 Tim Sort로 구현한 것으로
 *  Tim Sort란 머지 정렬의 최악 O(nlogn)과 삽입 정렬의 최선O(n)을 합친 정렬방식
 */
public class Main_2751_수정렬하기2 {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(in.readLine()));
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (int i : list) {
			sb.append(i).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
