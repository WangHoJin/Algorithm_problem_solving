package study.week13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_튜플 {
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		String s = "{{20,111},{111}}";
//		solution.solution(s);
		System.out.println(Arrays.toString(solution.solution(s)));
	}
}

class Solution2 {
    public int[] solution(String s) {
        int[] answer = {};
        // 처음 "{"과 마지막 "}" 자르기
        s = s.substring(2, s.length()-2);
        // "}.{" -> "#" => 구분자로 사용하기위해
        s = s.replace("},{", "#");
        // "#"로 문자열 나누기
        String[] str = s.split("#");
        // 문자열 길이로 오름차순 정렬
        Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
        
        ArrayList<String> list = new ArrayList<>();	// 중복값 제거된 문자열 저장소
        // 하나의 집합씩 비교
        for (String string : str) {
        	// 한 집합에서 ","로 구분하여 중복여부 판단
            String[] ss = string.split(",");	
            for (int i = 0; i < ss.length; i++) {
				if(!list.contains(ss[i]))	// 중복이 아닌값만 저장
					list.add(ss[i]);
			}

		}
        
        answer = new int[list.size()];
        // 문자열을 정수로 변환하여 저장
        for (int i = 0; i < list.size(); i++) {
			answer[i] = Integer.parseInt(list.get(i));
		}
        
        return answer;
    }
}