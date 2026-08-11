package week1;
import java.util.Scanner;
public class d2_26059 {
	// 과일 등급 분류
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
        T=sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	// 과일의 개수
        	int N = sc.nextInt();
        	// 최소 개수
        	int lo = sc.nextInt();
        	// 최대 개수
        	int hi = sc.nextInt();
        	
        	// 차이(return)
        	int diff = -1;
        	
        	// 과일 배열 입력
        	int[] fruits = new int[N];
        	for(int i = 0; i < N; i++) {
        		fruits[i] = sc.nextInt();
        	}
        	
        	System.out.println("#" + test_case + " " + diff);
        }
        
		sc.close();
	}

}
