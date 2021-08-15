import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14650_걷다보니신천역삼small {
	static int N, ans;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/07/걷다보니.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		// 0,1,2만 가지고 만들 수 있는 3의 배수
		// 1의 자리 X
		// 2의 자리 12 21
		// 3의 자리 102 111 120 201 210 222
		// 자리수를 다 더했을때 3으로 나눠지면 3의 배수!
		// dp로는 풀이를 봐야할듯...완탐으로 해보자
		
		for (int i = 1; i <= 2; i++) {
			// 시작은 더한값이 i이다
			ans += sumThree(N,i,i);			
		}
		System.out.println(N==1?0:ans);
		
		
	}
	private static int sumThree(int n, int i, int sum) {
		// 자리수가 1까지 재귀로 자리수를 더했을때, 다 더한값이 3으로 나눠지면 전체 가능 수 +1
		if(n == 1 && (sum % 3 == 0)) return 1;
		
		// 그냥 자리수가 1이 되면 0
		else if(n == 1) return 0;
		int result = 0;
		for (int j = 0; j <= 2; j++) {
			result += sumThree(n-1, j, sum+j);
		}
		return result;
	}

}
