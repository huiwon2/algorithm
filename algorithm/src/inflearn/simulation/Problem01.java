package inflearn.simulation;
public class Problem01 {
	// 사다리 타기 
	public static char[] solution(int n, int[][] ladder) {
		char[] answer = new char[n];
		for (int i = 0; i < n; i++) {
			// 문자 배열 추가 
			answer[i] = (char)(i + 65);
		}
		for(int[] line : ladder) {
			for(int x : line) {
				// swap
				char tmp = answer[x];
				answer[x] = answer[x-1];
				answer[x-1] = tmp;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		
	}

}
