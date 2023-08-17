package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 메모리 : 21024 kb
 * 시간 : 2,032 ms
 * 풀이 : 순열로 각 경우의 수를 조합하여 모든 순열대로 고객집을 탑색하고 집에 갔을때까지의
 * 모든 경우중에서 가장 짧은 경우를 출력하였다.
 */

public class D5_01247_최적경로_류지원 {
	static int[][] customerLo;	// 고객 집의 위치를 저장할 배열
	static int[] companyLo; static int[] houseLo;	// 회사의 위치 배열, 집의 위치 배열
	static int[] numbers; 	// 뽑은 원소순서를 저장할 배열
	static boolean[] isSelected; 	// 원소를 선택했는지 저장할 ㅂ열
	static int MinDistance; static int N;	// 최소거리를 넣을 변수, 원소의 개수 N

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST; StringBuilder SB= new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			N = Integer.parseInt(br.readLine());
			ST = new StringTokenizer(br.readLine());
			companyLo = new int [] {Integer.parseInt(ST.nextToken()), Integer.parseInt(ST.nextToken())};
			houseLo = new int [] {Integer.parseInt(ST.nextToken()), Integer.parseInt(ST.nextToken())};
			customerLo=new int[N][2];
			for(int i=0; i<N; i++) {
				customerLo[i][0]=Integer.parseInt(ST.nextToken());
				customerLo[i][1]=Integer.parseInt(ST.nextToken());
			}	// 여기까지 입력 완료
			
			isSelected=new boolean[N];	// isSelected 배열 생성
			numbers=new int[N];			// numbers 배열 생성
			MinDistance=Integer.MAX_VALUE;	
			permutation(0);				// 순열 시작.
			SB.append("#" + t +" " + MinDistance + "\n");
		}		
		System.out.println(SB);
	}
	
	public static void permutation(int digit) {
		if(digit==N) {
			int distance=0;	// 거리 구하기
			distance+=		// 회사에서부터 첫번째 고객까지의 거리 구하기
					Math.abs(companyLo[0]-customerLo[numbers[0]][0]) +
					Math.abs(companyLo[1]-customerLo[numbers[0]][1]);
			for(int i=0; i<N-1; i++)	// 고객에서부터 다음고객까지의 거리 구하기
				distance+=
						Math.abs(customerLo[numbers[i]][0]-customerLo[numbers[i+1]][0]) +
						Math.abs(customerLo[numbers[i]][1]-customerLo[numbers[i+1]][1]);
			distance+=		// 마지막 고객에서부터 집까지의 거리 구하기
					Math.abs(houseLo[0]-customerLo[numbers[N-1]][0]) +
					Math.abs(houseLo[1]-customerLo[numbers[N-1]][1]);
			if(MinDistance>distance) MinDistance=distance;	// 현재 저장된 최소 거리와 현재의 거리 비교하기
			return;
		}
		for(int i=0; i<N; i++) {
			if(!isSelected[i]) {
				isSelected[i]=true;
				numbers[digit]=i;
				permutation(digit+1);
				isSelected[i]=false;
			}
		}
	}
}