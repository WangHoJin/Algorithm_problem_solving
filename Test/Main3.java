package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main3 {
	static int ans;
	static ArrayList<String> list;
	private static void solution(int numOfConflict, int[][] conflicts) {
		ans = 0;
		list = new ArrayList<>();
		for (int i = 0; i < conflicts.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < conflicts[i].length; j++) {
				sb.append(conflicts[i][j]);
			}
			list.add(sb.toString());
			list.add(sb.reverse().toString());
		}
		
		permu(0,  new StringBuilder(), new boolean[9], conflicts);
		System.out.println(ans);
	}
	
	private static void permu(int cnt, StringBuilder sb, boolean[] v, int[][] conflicts) {
		if (cnt == 8) {
			String str = sb.toString();
			for (int i = 0; i < list.size(); i++) {
				if(str.contains(list.get(i)))
					return;				
			}
			ans++;
			return;
		}

		for (int i = 1; i <= 8; i++) {
			if (!v[i]) {
				sb.append(i);
				v[i] = true;
				permu(cnt + 1, sb, v, conflicts);
				v[i] = false;
				sb.setLength(sb.length()-1);
			}
		}
	}
	
	private static class InputData {
		int numOfConflict;
		int[][] conflicts;
	}

	private static InputData processStdin() throws FileNotFoundException {
		System.setIn(new FileInputStream("input/test/3.txt"));
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfConflict = Integer.parseInt(scanner.nextLine());
			inputData.conflicts = new int[inputData.numOfConflict][2];
			for (int i = 0; i < inputData.numOfConflict; i++) {
				String[] temp = scanner.nextLine().split(" ");
				inputData.conflicts[i][0] = Integer.parseInt(temp[0]);
				inputData.conflicts[i][1] = Integer.parseInt(temp[1]);
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws IOException {
		InputData inputData = processStdin();

		solution(inputData.numOfConflict, inputData.conflicts);
	}

}
