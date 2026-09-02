package algorithm.recursion;

import java.util.Scanner;

public class d3_6808 {
	// 규영이와 인영이의 카드게임	
	// 규영이의 카드배열 
	static int[] gyuyoungCards = new int[9];
	static boolean[] isGyuyoung;
	static boolean[] visited;
	// 인영이가 낼 카드 순서
	static int[] inyoungOrder = new int[9];
	
	// 이기는 경우의 수, 지는 경우의 수
	static int winCount;
	static int loseCount;
	// 경우의 수 계산 
	private static void permutation(int depth) {
		// basis rule : depth가 9라면 게임을 호출  
		if(depth == 9) {
			playGame();
			return;
		}
		// 인영이의 카드 순서 배치
		for(int i = 1; i <= 18; i++) {
			// 규영이의 카드셋에도 없고, 방문한 적도 없다면 
			if(!isGyuyoung[i] && !visited[i]) {
				visited[i] = true;
				// 인영이가 낼 카드에 배치 
				inyoungOrder[depth] = i;
				permutation(depth + 1);
				// 원상복구(순열로 경우의 수를 따져야 함)
				visited[i] = false;
			}
		}
	}
	// 게임 진행 메서드
	private static void playGame() {
		// 규영이의 점수 
		int score1 = 0;
		// 인영이의 점수 
		int score2 = 0;
		for(int i = 0; i < 9; i++) {
			int sum = gyuyoungCards[i] + inyoungOrder[i];
			if(gyuyoungCards[i] > inyoungOrder[i]) {
				score1 += sum;
			}else if(gyuyoungCards[i] < inyoungOrder[i]){
				score2 += sum;
			}
		}
		// 게임이 끝난 후 총 점수 비교
		if(score1 > score2) {
			winCount++;
		}else if(score1 < score2) {
			loseCount++;
		}
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			// 총 카드 배열(1 ~ 18) 
			// 1번부터 18번 인덱스가 필요해서 19로 받는다.
			isGyuyoung = new boolean[19];
			visited = new boolean[19];
			
			// for문을 돌면서 규영이의 카드 값을 받고 cards 배열에 1 체크 
			for(int i = 0; i < 9; i++) {
				gyuyoungCards[i] = sc.nextInt();
				// 규영이의 카드 조합이 1로 채워진다. 
				isGyuyoung[gyuyoungCards[i]] = true;
			}
			winCount = 0;
			loseCount = 0;
			
			// 인영이의 카드 조합 탐색 permutation 호출
			permutation(0);
			
			System.out.println("#" + test_case + " " + winCount + " " + loseCount);
		}
		sc.close();
	}

}
