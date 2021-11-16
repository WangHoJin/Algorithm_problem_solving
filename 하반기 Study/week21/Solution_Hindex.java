package second.study.week21;

import java.io.IOException;
import java.util.*;

import sun.misc.Perf;

public class Solution_Hindex {

	public static void main(String[] args) throws IOException {
		int[] citations = {3, 0, 6, 1, 5,4};
		
		System.out.println(solution(citations));
	}

	public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int len = citations.length;
        for (int i = 0; i < len; i++) {
			int num = citations[i];
			int temp = len - i; 
			if(temp <= num)
				return temp; 
		}
        return answer;
    }
}
