package algorithm.treeandgraph;

import java.util.Scanner;

public class d4_1232 {
	// 사칙연산
	static int N;
	static char[] tree;
	static int[] left;
	static int[] right;
	static int result;
	private static double calculator(int node) {
		if(left[node] == 0 && right[node] == 0) {
			// root 노드만 있는 경우
//			return tree[node] - '0';
//			// 후위 순회
//			double left = calculator(left[node]);
//			double right = calculator(right[node]);
//			
//			// 연산자로 두 자식의 결합 결과
//			char op = tree[node];
//			switch(op) {
//			case '+' :
//				result = left + right;
//				return
//			}
//			
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 10개의 테스트 케이스 반복
		for(int test_case = 1; test_case <= 10; test_case++) {
			// 정점의 갯수
			N = sc.nextInt();
			sc.nextLine();
			
			// 정점 갯수 +1 의 배열(트리, 왼쪽, 오른쪽)
			tree = new char[N+1];
			left = new int[N+1];
			right = new int[N+1];
			
			// 정점 갯수만큼 반복
			for(int i = 1; i <= N; i++) {
				// 수정 : 한 줄로 받고 token으로 쪼개기(한번도 써보지 못함)
				// 쓰는 이유 : 자식 노드 번호를 안나오는 leaf node일 수 있음
				String line = sc.nextLine();
				// 공백 기준 토큰
				String[] tokens = line.split(" ");
				// 0과 1은 토큰에 무조건 있으니 지정 가능
				int node = Integer.parseInt(tokens[0]);
				String s = tokens[1];
				
				// 문자열 저장
				tree[node] = s.charAt(0);
				
				int left_node = 0;
				int right_node = 0;
				
				// 자식이 하나만 있을 때(왼쪽)
				if(tokens.length >= 3) {
					left_node = Integer.parseInt(tokens[2]);
					left[node] = left_node;
				}
				// 자식이 둘 다 있을 때(오른쪽까지)
				if(tokens.length >= 4) {
					right_node = Integer.parseInt(tokens[3]);
					right[node] = right_node;
				}
			}
			result = 0;
			System.out.println("#" + test_case + " " + result);
		}
	}

}
