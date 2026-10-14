package inflearn.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Problem04 {
	// 꽃이 피는 최단시간
	private static int solution(int n, int[] plantTime, int[] growTime) {
		int answer = 0;
		
		// plantTime과 growTime 2차원 배열로 재정의
		int[][] list = new int[n][2];
		
		for (int i = 0; i < list.length; i++) {
			list[i][0] = plantTime[i];
			list[i][1] = growTime[i];
		}
		
		// growTime을 기준으로 정렬(내림차순)
		Arrays.sort(list, (a, b) -> b[1] - a[1]);
		
		int start = 0;
		int end = 0;
		
		for (int i = 0; i < list.length; i++) {
			start += list[i][0];
			end = start + list[i][0] + list[i][1];
			
			if(answer <= end) {
				answer = end;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 심는 시간
		int[] plantTime = new int[n];
		for (int i = 0; i < plantTime.length; i++) {
			plantTime[i] = sc.nextInt(); 
		}
		// 자라는 시간
		int[] growTime = new int[n];
		for (int i = 0; i < growTime.length; i++) {
			growTime[i] = sc.nextInt(); 
		}
		
		System.out.println(solution(n, plantTime, growTime));
		sc.close();
	}

}
