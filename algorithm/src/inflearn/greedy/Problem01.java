package inflearn.greedy;
import java.util.Arrays;
import java.util.Scanner;


public class Problem01 {
	// 타이타닉 
	private static int solution(int n, int[] nums, int m) {
		int answer = 0;
		// nums를 오름차순으로 정렬
		Arrays.sort(nums);
		
		// 양쪽 포인터 선언
		int left = 0;
		int right = n-1;
		
		while(left <= right) {
			if(nums[left] + nums[right] > m) {
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
		
		int m = sc.nextInt();
		
		System.out.println(solution(n, nums, m));
		sc.close();
	}

}
