package second.study.week30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_약수지우기게임1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(in.readLine());

		// 만약 1을 제외한 나머지 숫자를 가지고 게임을 진행했을때,
		// A가 이기는 상황이라면 => 1은 모든 수의 약수이기 때문에 그대로 A의 승리
		// B가 이기는 상황이라면 => 시작할때 1을 지우고 시작하면 반대로 A의 승리
		// 결국 시작 숫자가 1이 아니라면 무조건 A의 승리!
		System.out.println(number == 1 ? 'B' : 'A');
	}
}
