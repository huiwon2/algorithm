package inflearn.simulation;
import java.util.Scanner;

public class Problem06 {
	// 과일 가져가기 
	public static int getMin(int[] arr) {
		int min = Integer.MAX_VALUE;
		for(int x : arr) {
			min = Math.min(x, min);
		}
		return min;
	}
	private static int solution(int n, int[][] fruit) {
		int answer = 0;
		boolean[] check = new boolean[n];
		/*
		 * 2중 for문을 돌면서, 최솟값 교환 시 이득이 나는지 안나는지 확인
		 * 1) 각 최솟값이 unique한지?
		 * 2) 두 학생의 최솟값인 과일이 다른지
		 * 3) 교환 시 1개 증가한 과일 갯수가 계속 그 행의 최솟값을 유지하는
		 */
		// index 저장
		int[] minVal = new int[n];
		int[] minIdx = new int[n];
		for (int i = 0; i < n; i++) {
			minVal[i] =  fruit[i][0];
			minIdx[i] = 0;
			for (int j = 1; j < 3; j++) {
				if(fruit[i][j] < minVal[i]) {
					minVal[i] = fruit[i][j];
					minIdx[i] = j;
				}
			}
		}
		
		boolean[] unique = new boolean[n];
		for (int i = 0; i < unique.length; i++) {
			int count = 0;
			for (int j = 0; j < 3; j++) {
				if(fruit[i][j] == minVal[i]) {
					count++;
				}
			}
			unique[i] = (count == 1);
		}
		
		// 비교 
		for (int i = 0; i < n; i++) {
			if(check[i]) {
				continue;
			}
			if(!unique[i]) {
				continue;
			}
			for (int j = i + 1; j < n; j++) {
				if(check[j]) {
					continue;
				}
				// 1. 각 최솟값이 unique한지?
				if(!unique[j]) {
					continue;
				}
				// 2. 두 학생의 최솟값의 과일이 다른지?
				if(minIdx[i] != minIdx[j] && fruit[i][minIdx[j]] > 0 && fruit[j][minIdx[i]] > 0) {
					if(fruit[i][minIdx[i]] + 1 <=  fruit[i][minIdx[j]] - 1 && fruit[j][minIdx[j]] + 1 <= fruit[j][minIdx[i]] - 1) {
						fruit[i][minIdx[i]] ++;
						fruit[i][minIdx[j]] --;
						fruit[j][minIdx[j]] ++;
						fruit[j][minIdx[i]] --;
						check[i] = true;
						check[j]  = true;
						break;
					}
				}
			}
			for(int[] x : fruit) {
				answer += getMin(x);
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		
		// 출력 테스트 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] fruit = new int[n][3];
		for (int i = 0; i < fruit.length; i++) {
			for (int j = 0; j < 3; j++) {
				fruit[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(solution(n, fruit));
		sc.close();
	}

}
