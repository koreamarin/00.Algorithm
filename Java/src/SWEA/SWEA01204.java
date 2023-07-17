package SWEA;
/**
 * @author 류지원
 * 문제 : 1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기
 * 
 * 풀이 방법
 * 0~100에 대한 점수 map을 생성하여 해당 점수가 입력될때마다 map의 키에 대한 value를 1씩 향상시켜
 * 각 점수에 대한 빈도를 arr에 담는다.
 * 그 후, arr를 순환하며 가장 큰 수가 value로 담겨있는 index를 찾으면 된다. 
 * 
 * 
 */

import java.util.Scanner;

public class SWEA01204 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
	
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sc.nextInt();
			int[] arr = new int[101];
			
			for (int i=0; i<1000; i++) {
				arr[sc.nextInt()]++;
			}
			
			
			int max = 0;
			int max_num = 0;
			
			for (int i=0; i<100; i++) {
				if (max <= arr[i]) {
					max = arr[i];
					max_num = i;
				}
			}
			
			System.out.println("#" + test_case + " " + max_num);
		}

	}

}
