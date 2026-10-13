package inflearn.simulation;

import java.util.Scanner;

public class Problem05 {
	// 바이토닉 수열
	public static int solution(int[] arr) {
		int answer = 0;
		// 배열을 순회하면서 바이토닉 수열의 길이의 max를 가져오는 로직
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			boolean flag = true;
			int curr = 0;
			for (int j = i; j < arr.length; j++) {
				// 현재 바이토닉 수열이 증가 과정인지 감소 과정인지
				// 증가 - true / 감소 - false				
				// 초기값 추가
				if(count == 0) {
					count++;
					curr = arr[j];
				}
				// count 가 1이라는 것은
				// 초기값만 현재 들어갔다는 것..
				// 감소하면 안되고.. 증가해야 함
				else if(count == 1){
					// 감소했거나 같을 때
					if(arr[j] <= curr) {
						break;
					}else {
						count++;
						// update
						curr = arr[j];
					}
				}else {
					// count가 2 이상이라면
					// 증감 여부를 검사
					// 값이 같다면 바이토닉 수열이 아님
					if(flag) {
						if(arr[j] > curr) {
							flag = true;
							count++;
							curr = arr[j];
						}
						// 증가 -> 감소로 변화함
						else if(arr[j] < curr){
							flag = false;
							count++;
							curr = arr[j];
						}else {
							break;
						}
					}
					// 감소배열 여부 검사
					else {
						if(arr[j] < curr) {
							count++;
						}else {
							break;
						}
					}
				}
			}
			answer = Math.max(answer, count);
		}
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n];
		for (int i = 0; i < data.length; i++) {
			data[i] = sc.nextInt();
		}
		
		System.out.println(solution(data));
		sc.close();
	}

}
