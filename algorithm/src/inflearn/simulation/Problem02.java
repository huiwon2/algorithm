package inflearn.simulation;

import java.util.Scanner;

public class Problem02 {
	// 청소
	public static int[] cleaning(int x, int y, int[][] board, int k) {
		// 종착지 return
		int[] destination = new int[2];
		
		// 시계방향으로 돌리기 위한 dx, dy 선언
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		
		// 현재 시계방향 중 어디 방향으로 돌고 있는지 index 선언(기본 0 -> 처음은 3시방향으로 돌아감)
		int direct = 0;
		int next_x = x;
		int next_y = y;
		// time이 k에 도달할 때까지 시작..
		for(int time = 0; time < k; time++) {
			next_x = x + dx[direct];
			next_y = y + dy[direct];
			
			if (next_x < 0 || next_x >= board.length || next_y < 0 || next_y >= board.length || board[next_x][next_y] == 1) {
				direct = (direct + 1) % 4;
				continue;
			}
			else {
				// 갱신 
				x = next_x;
				y = next_y;
			}
		}
		destination[0] = next_x;
		destination[1] = next_y;
		return destination;
	}
	public static int[] solution(int n, int[][] board, int k) {
		int[] answer = new int[2];
		answer = cleaning(0, 0, board, k);
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		int k = sc.nextInt();
		
		int[] sol = new int[2];
		sol = solution(n, board, k);
		
		for (int i = 0; i < sol.length; i++) {
			System.out.print(sol[i] + " ");
		}
		System.out.println();
		sc.close();
	}

}
