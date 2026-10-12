package week2;

import java.util.Scanner;
public class d3_5105 {
	// 미로의 거리
	static boolean[][] visited;
	static int[][] board;
	static int result = Integer.MAX_VALUE;
	static int N;
	private static void DFS(int x, int y, int sum) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		// Find Exit
		if(board[x][y] == 2) {
			result = Math.min(result, sum);
			return;
		}
		
		// Pruning 
		if(result < sum) {
			return;
		}
		
		// 상하좌우 움직임 
		for (int i = 0; i < 4; i++) {
			int next_x = x + dx[i];
			int next_y = y + dy[i];
			
			if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < N) {
				if(!visited[next_x][next_y]) {
					if(board[next_x][next_y] == 0 || board[next_x][next_y] == 2) {
						visited[next_x][next_y] = true;
						DFS(next_x, next_y, sum + 1);
						// 최소 몇개의 칸을 지나야 하는지.. 에 대한 문제이므로 
						// visited를 backtracking할 이유가 없다 
						// visited[next_x][next_y] = false;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			board = new int[N][N];
			visited = new boolean[N][N];
			// 현재 좌표(출발점)
			int current_x = 0;
			int current_y = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 파이썬 버전에서는 띄어쓰기 안하고 받지만
					// 자바는 띄어쓰기 하고 받는다.. 
					board[i][j] = sc.nextInt();
					// 출발점 찾기 
					if(board[i][j] == 3) {
						current_x = i;
						current_y = j;
					}
				}
			}
			
			// 0부터 시작 
			DFS(current_x, current_y, 0);
			if(result == Integer.MAX_VALUE) {
				result = 0;
			}else {
				// 2인 값도 sum + 1로 더하고 있음 
				result -= 1;
			}
			System.out.println("#" + test_case + " " + result);
		}
		sc.close();
	}

}
