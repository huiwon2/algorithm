package inflearn.simulation;

import java.util.Scanner;

public class Problem03 {
	// 잃어버린 강아지 찾기 
	public static int findDog(int hyunsuX, int hyunsuY, int dogX, int dogY, int[][] board) {
		int time;
		
		// 시계방향 배열 정의(12 - 3 - 6 - 9)
		int[] dx = {-1, 0, 1, 0}; // {-1, 0, 1, 0}
		int[] dy = {0, 1, 0, -1}; // {0, 1, 0, -1}
		int h_direct = 0;
		int d_direct = 0;
		
		// 10000분의 제한 시간 동안 강아지 찾기 start
		for (time = 1; time < 100001; time++) {
			// 현수 이동 
			int h_next_x = hyunsuX + dx[h_direct];
			int h_next_y = hyunsuY + dy[h_direct];
			
			// 벽에 부딪히거나 나무에 부딪혔을 때 
			if(h_next_x < 0 || h_next_x >= board.length || h_next_y < 0 || h_next_y >= board.length || board[h_next_x][h_next_y] == 1) {
				h_direct = (h_direct + 1) % 4;
			}else {
				hyunsuX = h_next_x;
				hyunsuY = h_next_y;
			}
			
			// 강아지 이동
			int d_next_x = dogX + dx[d_direct];
			int d_next_y = dogY + dy[d_direct];
			
			// 벽에 부딪히거나 나무에 부딪혔을 때 
			if(d_next_x < 0 || d_next_x >= board.length || d_next_y < 0 || d_next_y >= board.length || board[d_next_x][d_next_y] == 1) {
				d_direct = (d_direct + 1) % 4;
			}else {
				dogX = d_next_x;
				dogY = d_next_y;
			}
			
			// 개와 현수의 위치가 같아지면 
			if(h_next_x == d_next_x && h_next_y == d_next_y) {
				return time;
			}
		}
		// time이 10000분 이후에도 강아지를 찾지 못했다면 
		if(time == 10001) {
			time = 0;
		}
		return time;
	}
	public static int solution(int[][] board){
		int answer = 0;
		// board를 순회하면서 출발지(현수의 위치)를 찾는다.
		int hyunsuX = 0;
		int hyunsuY = 0;
		
		int dogX = 0;
		int dogY = 0;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == 2) {
					hyunsuX = i;
					hyunsuY = j;
				}else if(board[i][j] == 3) {
					dogX = i;
					dogY = j;
				}
			}
		}
		
		answer = findDog(hyunsuX, hyunsuY, dogX, dogY, board);
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[10][10];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(solution(board));
		
		sc.close();
	}

}
