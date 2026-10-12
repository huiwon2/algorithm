package inflearn.simulation;

import java.util.Scanner;

public class Problem04 {
	public static int[] solution(int c, int r, int k) {
		int[] answer = new int[2];
		// c*r 보다 k 값이 더 크다면 
		if(k > c * r) {
			return new int[] {0, 0};
		}
		int[][] grid = new int[c][r];
		// 방향 전
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int x = 0, y = 0, count = 0, direct = 1;
		
		while(count < k) {
			int next_x = x + dx[direct];
			int next_y = y + dy[direct];
			if(next_x < 0 || next_x >= c || next_y < 0 || next_y >= r) {
				direct = (direct + 1) % 4;
				continue;
			}
			
			// 좌석 번호 setting
			grid[x][y] = count;
			count ++;
			x = next_x;
			y = next_y;
		}
		answer[0] = x + 1;
		answer[1] = y + 1;
		
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int r = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(solution(c, r, k));
		sc.close();
	}
		
}
