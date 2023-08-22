package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 메모리 : 100252kb
 * 실행시간 : 430ms
 * 풀이방법 : 
 * 서로소 집합을 생성하여, 명령에 따라 합집합하고, 서로 같은 집합인지 확인하는 작업을 하였다. 
 *
 */
public class D4_03289_서로소집합_류지원 {
	static int N;			// 원소의 개수
	static int parents[];	// 원소번호는 즉 원소번호이고, 그 원소번호가 어느 원소를 대표자로 참조하고 있는지 저장하는 링크용 배열
	
	private static void make() {	// 집합 N개 생성하는 메서드.
		parents=new int[N];			// 부모를 참조하는 링크 배열도 N개 생성한다.
		for(int i=0; i<N; i++) parents[i]=i;
	}
	
	private static int find(int a) {	// a원소가 어떤 집합에 속해있는지 확인하는 메서드. 대표자 원소를 반환함.
		if(a==parents[a]) return a;		// a원소가 자기 자신을 참조하고 있으면 대표자 원소이므로 a 자신을 반환함.
		// a원소가 다른 대표자를 참조하고 있으면 대표자원소가 아니므로, 참조한 원소의 부모를 다시 찾는 방식으로 재귀를 실행함.
		// 링크가 계속 연결된 형태가 아닌, 최종적으로 리턴받은 대표자원소를 참조하도록 parents[a]를 다시 할당하여 최적화 시도.
		return parents[a]=find(parents[a]);
	}
	
	private static boolean union(int a, int b) {	// 합집합에 성공하였다면 true를, 성공하지 못했다면 false를 반환하는 메서드.
		int aRoot=find(a);	// 합집합을 진행하기 전 a원소가 있는 집합의 대표자 원소를 찾음
		int bRoot=find(b);	// 합집합을 진행하기 전 b원소가 있는 집합의 대표자 원소를 찾음 
		
		if(aRoot==bRoot) return false;	// aRoot와 bRoot가 같다면 같은 집합이므로 합집합 실행하지 않고, false를 반환
		parents[bRoot]=aRoot;		// 서로 다른집합이다면 이 라인이 실행됨. bRoot의 부모원소에 aRoot를 참조하도록 함.
		return true;	// 합집합에 성공하였으므로 true 리턴.
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST; StringBuilder SB;
		int T= Integer.parseInt(br.readLine());
		
		for(int t=1; t<T+1; t++) {
			ST=new StringTokenizer(br.readLine());
			SB=new StringBuilder("#" + t + " ");
			N=Integer.parseInt(ST.nextToken()); int M=Integer.parseInt(ST.nextToken());
			
			make();	// 각 원소들로 집합 만들기
			
			for(int m=0; m<M; m++) {
				ST=new StringTokenizer(br.readLine());
				int c=Integer.parseInt(ST.nextToken());
				int a=Integer.parseInt(ST.nextToken())-1;
				int b=Integer.parseInt(ST.nextToken())-1;
				if(c==0) union(a,b);	// 0이면 합집합 시도
				else if(c==1) {			// 1이면 대표자 출력
					if(find(a)==find(b)) SB.append(1);	// 같은 집합이라면 SB에 1 넣음
					else SB.append(0);		// 다른 집합이라면 SB에 0 넣음
				}
			}
			System.out.println(SB);	// 테스트케이스에 대한 최종 출력
		}
	}
}
