package inflearn.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Problem03 {
	// 스프링쿨러
	private static int solution(int n, int[] nums) {
		int answer = 0;
		
		// start-end lines 정의
		int[][] lines = new int[n+1][2];
		for (int i = 0; i < lines.length; i++) {
			if(i - nums[i] <= 0) {
				lines[i][0] = 0;
			}else {
				lines[i][0] = i - nums[i];
			}
			lines[i][1] = i + nums[i];
		}
		
		// lines 정렬
		Arrays.sort(lines, (a, b) -> Integer.compare(a[0], b[0]));
		
		// 스프링쿨러 탐색 start
		int start = 0;
		int end = 0;
		int i = 0;
		while(i < lines.length){
			// lines[i][0]이 start 보다 작을 동안 반복 돌림
			while(i < lines.length && lines[i][0] <= start) {
				end = Math.max(end, lines[i][1]);
				i++;
			}
			
			// 그렇지 않을 때 answer 값 갱신(+1)
			answer++;
			
			// end과 n과 같아지면 더 순회할 필요가 없음
			if(end == n) {
				return answer;
			}
			
			// start와 end가 같아지면, 다음 칸의 스프링 쿨러를 찾을 수 없음
			if(start == end) {
				return -1;
			}
			// start 값 갱신
			start = end;
		}
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n+1];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt(); 
		}
		
		System.out.println(solution(n, nums));
		sc.close();
	}

}
