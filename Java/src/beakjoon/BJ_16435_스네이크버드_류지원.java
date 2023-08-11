package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 11848KB
 * 시간 : 84ms
 * 풀이방식 :
 * 과일의 높이를 배열로 받아 정렬을 한 후,
 * 뱀새의 키가 과일 높이보다 크다면 1씩 높인 후, 다음 과일들을 sweep하였다.
 */

public class BJ_16435_스네이크버드_류지원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(ST.nextToken()); int L=Integer.parseInt(ST.nextToken());
		int[] heightArr=new int[N];	// 과일의 높이를 받을 배열
		ST=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) heightArr[i]=Integer.parseInt(ST.nextToken());// 배열에 과일높이값 입력.
		Arrays.sort(heightArr);	// 과일 높이 배열 정렬
		for(int i=0; i<N; i++) if(heightArr[i]<=L) L++;	// 과일높이보다 뱀새의 키가 클 경우 키 1 증가.
		System.out.println(L);
	}
}
