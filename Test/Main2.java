package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {
	private static void solution(int numOfRegion, int numOfAttackableFrequency, int[][] frequencies) {
		Frequency[] totalFre = new Frequency[21];
		for (int i = 0; i < totalFre.length; i++) {
			totalFre[i] = new Frequency(i, 0);
		}
		for (int i = 0; i < numOfRegion; i++) {
			int len = frequencies[i].length;
			for (int j = 0; j < len; j++) {
				int idx = frequencies[i][j];
				totalFre[idx].cnt++;
			}
		}
		Arrays.sort(totalFre);
		int ans = 0;
		for (int i = 0; i < numOfAttackableFrequency ; i++) {
			ans += totalFre[i].cnt;
		}
		System.out.print(ans);
	}
	private static class Frequency implements Comparable<Frequency>{
		int idx;
		int cnt;
		public Frequency(int idx, int cnt) {
			super();
			this.idx = idx;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Frequency o) {
			return o.cnt-this.cnt;
		}
		
	}
	private static class InputData {
		int numOfRegion;
		int numOfAttackableFrequency;
		int[][] frequencies;
	}

	private static InputData processStdin() throws FileNotFoundException {
		System.setIn(new FileInputStream("input/test/2.txt"));
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			String[] temp = scanner.nextLine().split(" ");
			inputData.numOfRegion = Integer.parseInt(temp[0]);
			inputData.numOfAttackableFrequency = Integer.parseInt(temp[1]);
			inputData.frequencies = new int[inputData.numOfRegion][];
			for (int i = 0; i < inputData.numOfRegion; i++) {
				temp = scanner.nextLine().split(" ");
				int numOfFrequency = Integer.parseInt(temp[0]);
				inputData.frequencies[i] = new int[numOfFrequency];
				for (int j = 0; j < numOfFrequency; j++) {
					inputData.frequencies[i][j] = Integer.parseInt(temp[j + 1]);
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws IOException {
		InputData inputData = processStdin();

		solution(inputData.numOfRegion, inputData.numOfAttackableFrequency, inputData.frequencies);
	}

}
