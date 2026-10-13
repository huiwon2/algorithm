package inflearn.simulation;

import java.util.Scanner;

public class Problem08 {
	// 회의실 만남
	private static int[] filtering(int[] arr) {
		int[] filtered = new int[arr.length];
		for (int i = 0; i < filtered.length; i++) {
			filtered[i] = arr[i] - 1; 
		}
		return filtered;
	}
	private static int[] solution(int[] enter, int[] exit) {
		int[] answer = new int[enter.length];
		// index 입력 시 +1로 들어오기 때문에 filtering 작업
		// 편리한 index 작업을 위해 작업한다.
		enter = filtering(enter);
		exit = filtering(exit);
		
		// 들어온 순서 배열 정의
		int[] enterIdx = new int[enter.length];
		for (int i = 0; i < enterIdx.length; i++) {
			enterIdx[enter[i]] = i;
		}
		
		// 들어온 시간, 나간 시간 정의
		int[] enterTime = new int[enter.length];
		int[] exitTime = new int[exit.length];
		
		// exit 배열을 돌면서
		// enterTime과 exitTime에 시간 순서대로 정리
		// time은 한동작 시마다 +1 해줘야 함
		int time = 0;
		for (int i = 0, j = 0; i < exit.length; i++) {
			// enterIdx 배열에서 순서대로 넣어주고(이미 순서가 들어가 있음)
			while(j < exit.length && j <= enterIdx[exit[i]]){
				enterTime[enter[j]] = time++;
				j++;
			}
			// enterTime에 시간을 다 넣어줬다면, exitTime에 그 뒤에 바로 나가는 시간을 추가해준다.
			exitTime[exit[i]] = time++;
		}
		
		// i번과 j번 사람이 만나는가? 비교를 시작한다. 
		// + answer 값 추가
		for (int i = 0; i < enter.length; i++) {
			for(int j = i+1; j < enter.length; j++) {
				// 만나지 않는 경우를 not으로 처리해 만나는 경우만 체크한다.
				if(!(exit[j] < enter[i] || exit[i] < enter[j])) {
					answer[i] ++;
					answer[j] ++;
				}
			}
		}
		
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] enter = new int[n];
		int[] exit = new int[n];
		
		for (int i = 0; i < enter.length; i++) {
			enter[i] = sc.nextInt(); 
		}
		
		for (int i = 0; i < exit.length; i++) {
			exit[i] = sc.nextInt();
		}
		
		int[] answer = solution(enter, exit);
		
		// 출력 테스트
		System.out.print("[");
		for (int i = 0; i < answer.length - 1; i++) {
			System.out.print(answer[i] + ", ");
		}
		System.out.println(answer[answer.length - 1] + "]");
		
		sc.close();
	}

}
