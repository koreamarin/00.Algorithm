package beakjoon;

import java.util.Scanner;

/**
 * 
 * @author 류지원
 * 메모리 : 12968kb
 * 시간 : 116ms
 *
 */

public class BJ_01138_한줄로서기_류지원 {
	static int n,cnt;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		arr=new int[n];
		for (int i = 1; i <=n; i++) {
			cnt=sc.nextInt();
			for (int j = 0; j < n; j++) {
				if(cnt==0 && arr[j]==0) {
					arr[j]=i;
					break;
				}else if(arr[j]==0) {
					cnt--;
				}
			}
			
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
