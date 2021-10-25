package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	private static void solution(int numOfOperation, Operation[] operations) {
		boolean[] number = new boolean[numOfOperation+1];
		int startNum = 2;
		number[1] = true;
		for (int i = 0; i < numOfOperation; i++) {
			if(operations[i].type == OperationType.branch) {
//				System.out.println("브랜치");
				int idx = startNum;
				for (int j = 2; j < number.length; j++) {
					if(!number[j]) {
						idx = j;
						break;
					}
				}
				number[idx] = true;
			}
			else {
				int idx = operations[i].value;
				number[idx] = false;
//				System.out.println("머지"+" "+idx);
			}
		}
		
		for (int i = 1; i < number.length; i++) {
			if(number[i])
				System.out.print(i+" ");
		}
	}
	
	private static class InputData{
		int numOfOperation;
		Operation[] operations;
	}
	private static class Operation{
		OperationType type;
		Integer value;
		public Operation(OperationType type, Integer value) {
			super();
			this.type = type;
			this.value = value;
		}
	}
	
	private static enum OperationType{
		branch,
		merge;
	}
	
	private static InputData processStdin() throws FileNotFoundException {
		System.setIn(new FileInputStream("input/test/1.txt"));
		InputData inputData = new InputData();
		
		try(Scanner scanner = new Scanner(System.in)){
			inputData.numOfOperation = Integer.parseInt(scanner.nextLine());
			inputData.operations = new Operation[inputData.numOfOperation];
			
			for (int i = 0; i < inputData.numOfOperation; i++) {
				String[] temp = scanner.nextLine().split(" ");
				
				Integer value = null;
				OperationType operationType = OperationType.valueOf(temp[0]);
				if(OperationType.merge == operationType) {
					value = Integer.valueOf(temp[1]);
				}
				inputData.operations[i] = new Operation(operationType, value);
			}
		} catch (Exception e) {
			throw e;
		}
		
		return inputData;
	}
	
	public static void main(String[] args) throws IOException {
		InputData inputData = processStdin();
		
		solution(inputData.numOfOperation, inputData.operations);
	}

	
}
