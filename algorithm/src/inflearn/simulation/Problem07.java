package inflearn.simulation;

import java.util.Arrays;
import java.util.Scanner;

public class Problem07 {
	// 비밀번호 
	private static int[][] KeypadToMatrix(int[] keypad){
		int[][] matrix = new int[3][3];
		int index = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = keypad[index++];
			}
		}
		return matrix;
	}
	private static int solution(int[] keypad, String password) {
		int answer = 0;
		int[][] matrix = KeypadToMatrix(keypad);
		int[] password_arr = new int[password.length()];
		
		// password 탐색 배열
		for (int i = 0; i < password_arr.length; i++) {
			password_arr[i] = password.charAt(i) - '0';
		}
		
		
		// 거리 저장
		int[][] distance = new int[10][10];
		
		// 거리 초기값 저장
		for(int[] row : distance) {
			Arrays.fill(row, 2);
		}
		
		for(int i = 0; i < distance.length; i++) {
			// 자기 자신에서 자기 자신으로 가는 거리는 0이다.
			distance[i][i] = 0; 
		}
		
		// 방향 탐색 배열 정의
		int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
		int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
		
		// distance 배열 값 추가
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				int x = i;
				int y = j;
				for (int k = 0; k < 8; k++) {
					// 키패드 초기값
					int next_x = x + dx[k];
					int next_y = y + dy[k];
					
					// 방향이 matrix 배열을 벗어나지 않는 동안 distance 갱신
					if(next_x >= 0 && next_x < 3 && next_y >= 0 && next_y < 3) {
						distance[matrix[x][y]][matrix[next_x][next_y]] = 1;
					}
				}				
			}
		}
		
		// password 1차원 배열을 순회하면서 answer를 distance 값으로 누적
		for (int i = 0; i < password_arr.length - 1; i++) {
			answer += distance[password_arr[i]][password_arr[i+1]];
		}
		
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] keypad = new int[9];
		for (int i = 0; i < keypad.length; i++) {
			keypad[i] = sc.nextInt(); 
		}
		String password = sc.next();
		
		System.out.println(solution(keypad, password));
		sc.close();
	}

}
