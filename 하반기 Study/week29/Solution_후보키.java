package second.study.week29;

import java.util.*;

public class Solution_후보키 {
	public static void main(String[] args) {
		int cacheSize = 3;
		String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
		System.out.println((solution(cacheSize, cities)));
	}

	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		
		if(cacheSize == 0) return 5 * cities.length;
		
		LinkedList<String> cache = new LinkedList<String>();
		
		for (int i = 0; i < cities.length; i++) {
			String data = cities[i].toUpperCase();
			// cache hit : 이미 데이터가 있을때
			if(cache.contains(data)) {
				cache.remove(data);
				cache.addFirst(data);
				answer += 1;
			}
			// cache miss : 데이터가 처음 들어올때
			else {
				int size = cache.size();
				if(size == cacheSize) {
					cache.removeLast();
				}
				cache.addFirst(data);
				answer += 5;
			}
		}
		return answer;
	}
}