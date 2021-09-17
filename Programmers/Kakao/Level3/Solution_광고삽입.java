package second.study.week12;

public class Solution_광고삽입 {
	public static void main(String[] args) {
//		String play_time = "02:03:55";
//		String adv_time = "00:14:15";
//		String[] logs = { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29",
//				"01:37:44-02:02:30" };
		String play_time = "00:00:20";
		String adv_time = "00:00:20";
		String[] logs = { "00:00:05-00:00:10"};
		System.out.println(solution(play_time, adv_time, logs));
	}

	public static String solution(String play_time, String adv_time, String[] logs) {
		String answer = "";
		// 시간을 초 단위로 바꾸는 함수
		int size = hourToSec(play_time);
		long[] sec = new long[size + 1];
		// 시작과 종료 시간에 +1,-1 체크
		for (int i = 0; i < logs.length; i++) {
			String[] split = logs[i].split("-");
			int start = hourToSec(split[0]);
			int end = hourToSec(split[1]);
			sec[start]++;
			sec[end]--;
		}
		long add = 0;
		for (int i = 0; i < sec.length; i++) {
			sec[i] += add;
			add = sec[i];
//			sec[i] = sec[i] + sec[i-1]; 이것도됌
		}
		for (int i = 0; i < sec.length; i++) {
			sec[i] += add; 
			add = sec[i];
//			sec[i] = sec[i] + sec[i-1]; 이것도됌
		}
		int adv = hourToSec(adv_time);
		long max = sec[adv-1];
		int max_time = 0;
		for (int i = 0; i + adv <= size; i++) {
			long cnt = sec[i+adv] - sec[i];
			if (max < cnt) {
				max = cnt;
				max_time = i+1;
			}
		}
		answer = secToHour(max_time);
		return answer;
	}

	private static String secToHour(int max_time) {
		StringBuilder sb = new StringBuilder();
		int hour = max_time / 3600;
		if (hour < 10)
			sb.append("0");
		sb.append(hour);
		sb.append(":");
		max_time = max_time % 3600;
		int min = max_time / 60;
		if (min < 10)
			sb.append("0");
		sb.append(min);
		sb.append(":");

		int sec = max_time % 60;
		if (sec < 10)
			sb.append("0");
		sb.append(sec);
		return sb.toString();
	}

	private static int hourToSec(String time) {
		String[] split = time.split(":");
		return (Integer.parseInt(split[0]) * 60 * 60) + (Integer.parseInt(split[1]) * 60) + Integer.parseInt(split[2]);
	}
}
