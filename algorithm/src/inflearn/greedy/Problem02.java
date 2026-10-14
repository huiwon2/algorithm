package inflearn.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Problem02 {
	// 이동 횟수
	/*
	 * 1번 문제와 동일하게, 
	 * 무게의 총합이 5 내일 때 여러 개를 적재할 수 있다고는 하지만,
	 * 개당 무게가 2kg ~ 5kg으로 정해져 있는 것으로 보아, 
	 * 최대 2개 가능하다는 사실을 알 수 있다.
	 * 그래서 문제 1번과 풀이를 동일하게 가져간다.
	 */
	private static int solution(int n, int[] nums) {
		int answer = 0;
		
		// nums 정렬
		Arrays.sort(nums);
		
		// 양끝 원소 지정
		int left = 0;
		int right = n-1;
		
		while(left <= right) {
			if(nums[left] + nums[right] > 5) {
				answer++;
				right--;
			}else {
				answer++;
				left++;
				right--;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt(); 
		}
		
		System.out.println(solution(n, nums));
		sc.close();
	}

}
