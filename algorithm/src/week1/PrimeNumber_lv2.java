package week1;

import java.util.Scanner;

// 프로그래머스 - 소수찾기 Level2
public class PrimeNumber_lv2 {
	public static int solution(String numbers) {
		int answer = 0;
		
		// String으로 받은 numbers를 가능한 숫자 배열로 전환
		int[] numbers_arr = new int[numbers.length()];
		
		// numbers를 이용해 배열 생성
		
		// 배열의 값으로 소수 판별(완전탐색)
		
		// 소수일 때 answer++
		
		return answer;
	}
	
	// Main Test 
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		
		System.out.print(solution(num));
		sc.close();
	}
}
