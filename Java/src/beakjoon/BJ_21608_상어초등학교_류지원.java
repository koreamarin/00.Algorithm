package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 14568ms
 * 시간 : 120ms
 * 
 * 풀이방법 : 
 * 조건대로 구현하였다.
 * 1. 가장 친한 친구가 많은 자리에 배치
 * 2. 1번이 여러개라면 가장 빈자리가 많은 자리에 배치
 * 3. 2번이 여러개라면 가장 행이 낮은쪽으로 배치
 * 4. 3번이 여러개라면 가장 열이 낮은쪽으로 배치
 */

public class BJ_21608_상어초등학교_류지원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		int N = Integer.parseInt(br.readLine());
		int[][] PreferARR = new int[N*N][5];
		int[][] map = new int[N][N];
		
		for(int i=0; i<N*N; i++) {
			ST=new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) PreferARR[i][j]=Integer.parseInt(ST.nextToken());
		}		
		
		for(int k=0; k<N*N; k++) {
			int[] Student = PreferARR[k];	// 현재 탐색하는 학생과 좋아하는 학생 배열을 Student에 배열로 넣음
			int friendNumMax=0;				// 각 비어있는 자리에 앉았을 때 근처에 좋아하는 학생이 최대 몇명인지를 저장할 변수
			int emptyNumMax = 0;			// 각 비어있는 자리에 앉았을 때 근처에 비어있는 자리가 최대 몇개인지를 저장할 변수
			
			int[] lo = null;				// 학생이 앉을 자리 위치를 저장할 정수형 배열
			
			Loop :
			for(int i=0; i<N; i++) {		// 학생이 앉을 자리 배열 Lo의 초기값 할당. 행,열 순서대로 순환하여 비어있는 자리를 초기값으로 할당
				for(int j=0; j<N; j++) {
					if(map[i][j]==0) {
						lo=new int[] {i,j};
						break Loop;
					}
				}
			}
			
			for(int i=0; i<N; i++) {		// 행 순서대로 sweep
				for(int j=0; j<N; j++) {	// 열 순서대로 sweep
					int friendNum = 0;		// 해당 행, 열 자리에 앉았을 때 근처에 좋아하는 친구가 몇명인지 카운팅할 변수
					int emptyNum = 0;		// 해당 행, 열 자리에 앉았을 때 근처에 비어있는 자리가 몇개인지 카운팅할 변수
					if(map[i][j]==0) {		// 해당 자리가 비어있다면
						if(i>0) {					// 해당 자리가 맨 위쪽이 아닐때
							if(map[i-1][j]!=0) { 		// 위쪽에 좋아하는 친구가 있으면 friendNum을 1증가
								for(int l=1; l<5; l++) {
									if(Student[l]==map[i-1][j]) friendNum++;	
								}
							}
							else if(map[i-1][j]==0) emptyNum++;		// 위쪽이 비어있으면 emptyNum를 1증가
						}
						if(i<N-1) {				// 해당 자리가 맨 아래쪽이 아닐때
							if(map[i+1][j]!=0) {	// 아래쪽에 좋아하는 친구가 있으면 friendNum을 1증가
								for(int l=1; l<5; l++) {
									if(Student[l]==map[i+1][j]) friendNum++;	
								}
							}
							else if(map[i+1][j]==0) emptyNum++;		// 아래쪽이 비어있으면 emptyNum를 1증가
						}
						if(j>0) {				// 해당 자리가 맨 왼쪽이 아닐때
							if(map[i][j-1]!=0)	{
								for(int l=1; l<5; l++) {
									if(Student[l]==map[i][j-1]) friendNum++;	// 왼쪽에 좋아하는 친구가 있으면 friendNum을 1증가
								}
							}
							else if(map[i][j-1]==0) emptyNum++;		// 왼쪽이 비어있으면 emptyNum를 1증가
						}
						if(j<N-1) {				// 해당 자리가 맨 오른쪽이 아닐때
							if(map[i][j+1]!=0) {
								for(int l=1; l<5; l++) {
									if(Student[l]==map[i][j+1]) friendNum++;	// 오른쪽에 좋아하는 친구가 있으면 friendNum을 1증가
								}
							}
							else if(map[i][j+1]==0)	emptyNum++;		// 오른쪽이 비어있으면 emptyNum를 1증가
						}
					}
					if(friendNumMax<friendNum) {	// 현재 자리가 이전에 탐색했던 자리보다 근처에 좋아하는 친구수가 더 많다면
						friendNumMax=friendNum;		// 최대 친구수 갱신
						emptyNumMax=emptyNum;		// 최대 빈자리 갱신
						lo=new int[] {i,j};			// 앉을 자리위치 갱신
					}
					else if(friendNumMax==friendNum) {	// 현재 자리와 이전에 탐색했던 가장 많은 친구 수를 가진 자리와 친구수가 같다면
						if(emptyNumMax<emptyNum) {		// 현재 자리가 이전에 탐색했던 가장 많은 빈자리를 가진 자리보다 빈자리가 더 많다면
							emptyNumMax=emptyNum;		// 최대 빈자리 갱신
							lo=new int[] {i,j};			// 앉을 자리 위치 갱신
						}
					}
				}
			}
			map[lo[0]][lo[1]]=Student[0];				// 자리에 학생을 배치
		}
			
		int satisfactionTotal = 0;			// 총 만족도를 저장할 변수
		
		// 만족도 구하기
		for(int i=0; i<N; i++) {			// 행 순서대로 sweep
			for(int j=0; j<N; j++) {		// 열 순서대로 sweep
				int[] Student = new int[5];	
				Loop1 :
				for(int k=0; k<N*N;  k++) {	
					if(PreferARR[k][0]==map[i][j]) {	// 현재 탐색하고 있는 위치와 학생번호가 같다면
						Student = PreferARR[k];			// 해당 학생이 좋아하는 학생들을 Student 배열에 저장
						break Loop1;
					}
				}
				
				int satisfaction = 0;			// 만족도 변수
				
				if(i>0) {						// 위쪽에 좋아하는 학생이 있다면 만족도 1 추가
					for(int l=1; l<5; l++) {
						if(Student[l]==map[i-1][j]) {
							satisfaction++;	
							break;
						}
					}
				}
				
				if(i<N-1) {						// 아래쪽에 좋아하는 학생이 있다면 만족도 1 추가
					for(int l=1; l<5; l++) {
						if(Student[l]==map[i+1][j]) {
							satisfaction++;	
							break;
						}
					}
				}
				
				if(j>0) {						// 왼쪽에 좋아하는 학생이 있다면 만족도 1 추가
					for(int l=1; l<5; l++) {
						if(Student[l]==map[i][j-1]) {
							satisfaction++;	
							break;
						}
					}
				}
				
				if(j<N-1) {						// 오른쪽에 좋아하는 학생이 있다면 만족도 1 추가
					for(int l=1; l<5; l++) {
						if(Student[l]==map[i][j+1]) {
							satisfaction++;	
							break;
						}
					}
				}
				
				if(satisfaction==4) satisfactionTotal+=1000;		// 해당학생의 만족도가 4라면 총 만족도 1000 추가
				else if(satisfaction==3) satisfactionTotal+=100;	// 해당학생의 만족도가 3라면 총 만족도 100 추가
				else if(satisfaction==2) satisfactionTotal+=10;		// 해당학생의 만족도가 2라면 총 만족도 10 추가
				else if(satisfaction==1) satisfactionTotal+=1;		// 해당학생의 만족도가 1라면 총 만족도 1 추가
			}
		}
		System.out.println(satisfactionTotal);
	}
}
