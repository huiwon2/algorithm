package algorithm.recursion;

import java.util.Scanner;

public class d3_2805 {
	// 농작물 수확하기
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			// 농장의 크기 N
			int N = sc.nextInt();
			
			// 농장의 배열
			int garden[][] = new int[N][N];
			
			// 배열 농작물 입력
			for(int i = 0; i < garden.length; i++) {
				for(int j = 0; j < garden[i].length; j++) {
					garden[i][j] = sc.nextInt();
				}
			}
			
			int result = 0;
			
			System.out.println("#" + test_case + " " + result);
		}
		sc.close();
	}

}
