package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17135_캐슬디펜스 {

	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(ST.nextToken());
		int M=Integer.parseInt(ST.nextToken());
		int D=Integer.parseInt(ST.nextToken());
		arr=new int[N][M];
		for(int i=0; i<N; i++) {
			ST=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) arr[i][j]=Integer.parseInt(ST.nextToken());
		}
		
		
		// 궁수에게서 거리D 안에있는 애들한테 동시에 활쏨. 활맞은애들은 제거.
		
		
		// 적이동.
		nextTurn();
		
		// 출력
		for(int i=0; i<N; i++)
		System.out.println(Arrays.toString(arr[i]));
		
		
		
		
	}
	
	public static void nextTurn() {		
		for(int i=arr.length-1; i>0; i--) arr[i]=Arrays.copyOf(arr[i-1], arr[0].length);
		Arrays.fill(arr[0], 0);
	}
}
