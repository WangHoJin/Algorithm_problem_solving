import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14650_�ȴٺ��Ͻ�õ����small {
	static int N, ans;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/second/07/�ȴٺ���.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		// 0,1,2�� ������ ���� �� �ִ� 3�� ���
		// 1�� �ڸ� X
		// 2�� �ڸ� 12 21
		// 3�� �ڸ� 102 111 120 201 210 222
		// �ڸ����� �� �������� 3���� �������� 3�� ���!
		// dp�δ� Ǯ�̸� �����ҵ�...��Ž���� �غ���
		
		for (int i = 1; i <= 2; i++) {
			// ������ ���Ѱ��� i�̴�
			ans += sumThree(N,i,i);			
		}
		System.out.println(N==1?0:ans);
		
		
	}
	private static int sumThree(int n, int i, int sum) {
		// �ڸ����� 1���� ��ͷ� �ڸ����� ��������, �� ���Ѱ��� 3���� �������� ��ü ���� �� +1
		if(n == 1 && (sum % 3 == 0)) return 1;
		
		// �׳� �ڸ����� 1�� �Ǹ� 0
		else if(n == 1) return 0;
		int result = 0;
		for (int j = 0; j <= 2; j++) {
			result += sumThree(n-1, j, sum+j);
		}
		return result;
	}

}
