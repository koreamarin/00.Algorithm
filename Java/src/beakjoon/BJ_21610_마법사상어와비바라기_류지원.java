package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 19684KB
 * 시간 : 168ms;
 * 풀이방법 : 단순구현하였다.
 * 1. 비바라기 소환
 * 2. 구름 이동
 * 3. 구름 없어지고 물 1씩 증가
 * 4. 물복사 마법 시전
 * 5. 비바라기가 사라진 구간 제외한 곳에 물이 2이상인 곳에 구름 생성. 양동이 물 2씩 줄어듦
 * 6. 2~5 반복
 */



public class BJ_21610_마법사상어와비바라기_류지원 {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(ST.nextToken());	// 맵 크기
		int M = Integer.parseInt(ST.nextToken());	// 구름 이동 명령 횟수
		
		int[][] map = new int[N][N];				// 지역의 물 보유 맵
		boolean[][] cloudMap = new boolean[N][N];	// 구름 존재 맵
		
		for(int i=0; i<N; i++) {					// 지역 물 보유현황 입력받는 반복문
			ST=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(ST.nextToken());
			}
		}
		
		Queue<int[]> moveCntQueue = new ArrayDeque<int[]>();
		for(int m=0; m<M; m++) {
			ST=new StringTokenizer(br.readLine());
			moveCntQueue.add(new int[] {Integer.parseInt(ST.nextToken()),Integer.parseInt(ST.nextToken())});
		}
		
		
		// 1. 비바라기 소환
		cloudMap[N-1][0]=true;
		cloudMap[N-1][1]=true;
		cloudMap[N-2][0]=true;
		cloudMap[N-2][1]=true;

		while(!moveCntQueue.isEmpty()) {
			// 2. 구름이동
			cloudMap = cloudMove(cloudMap, moveCntQueue.poll());
			
			// 3. 구름 있는 곳에 물 1씩 증가.
			map=rainning(map, cloudMap);
			
			// 4. 구름 있는 곳에 물복사 마법 시전. 그 후 구름 사라짐.
			map=waterCopyMagic(map, cloudMap);
			boolean[][] bibaragi = new boolean[N][N];		// 비바라기 없어진 위치 남겨놓기
			for(int i=0; i<N; i++) bibaragi[i]=Arrays.copyOf(cloudMap[i], N);
			cloudMap=new boolean[N][N];
			
			// 5. 비바라기가 사라진 구간 제외한 곳에 물이 2이상인 곳에 구름 생성. 양동이 물 2씩 줄어듦
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>=2 && !bibaragi[i][j]) {
						cloudMap[i][j]=true;
						map[i][j]-=2;
					}
				}
			}
		}
		
		int sum=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum+=map[i][j];
			}
		}
		System.out.println(sum);

	}
	
	// 물복사마법 메서드
	public static int[][] waterCopyMagic(int[][] map, boolean[][] cloudMap) {
		int[][] mapClone = new int[N][N];
		for(int i=0; i<N; i++) mapClone[i]=Arrays.copyOf(map[i], N);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int cnt=0;
				if(cloudMap[i][j]) {
					if(0<i && 0<j && mapClone[i-1][j-1]!=0) {
						cnt++;
					}
					if(i<N-1 && 0<j && mapClone[i+1][j-1]!=0) {
						cnt++;
					}
					if(0<i && j<N-1 && mapClone[i-1][j+1]!=0) {
						cnt++;
					}
					if(i<N-1 && j<N-1 && mapClone[i+1][j+1]!=0) {
						cnt++;
					}
					mapClone[i][j]+=cnt;
				}
			}
		}
		
		return mapClone;
	}
	
	// 비오면 저수량 반환해주는 메서드
	public static int[][] rainning(int[][] map, boolean[][] cloudMap) {
		int[][] mapClone = new int[N][N];
		for(int i=0; i<N; i++) mapClone[i]=Arrays.copyOf(map[i], N);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(cloudMap[i][j]) {
					mapClone[i][j]+=1;
				}
			}
		}
		
		return mapClone;
	}
	
	// 구름 이동해주는 메서드
	public static boolean[][] cloudMove(boolean[][] cloudMap, int[] moveCnt) {
		boolean[][] cloudMapClone = new boolean[N][N];

		int D = moveCnt[0];		// 이동 방향
		int dt = moveCnt[1]%N;	// 이동 거리
		
		if(D==1) {			// 왼
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cloudMapClone[i][j]=cloudMap[i][(j+dt)%N];
				}
			}
		} else if(D==2) {	// 왼위
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cloudMapClone[i][j]=cloudMap[(i+dt)%N][(j+dt)%N];
				}
			}
		} else if(D==3) {	// 위
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					 cloudMapClone[i][j]=cloudMap[(i+dt)%N][j];
				}
			}
		} else if(D==4) {	// 오위
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					 cloudMapClone[i][j]=cloudMap[(i+dt)%N][(j+(N-dt))%N];
				}
			}
		} else if(D==5) {	// 오
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cloudMapClone[i][j]=cloudMap[i][(j+(N-dt))%N];
				}
			}
		} else if(D==6) {	// 오아
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cloudMapClone[i][j]=cloudMap[(i+(N-dt))%N][(j+(N-dt))%N];
				}
			}
		} else if(D==7) {	// 아
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cloudMapClone[i][j]=cloudMap[(i+(N-dt))%N][j];
				}
			}
		} else if(D==8) {	// 왼아
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cloudMapClone[i][j]=cloudMap[(i+(N-dt))%N][(j+dt)%N];
				}
			}
		}
		
		return cloudMapClone;
	}
	
}




