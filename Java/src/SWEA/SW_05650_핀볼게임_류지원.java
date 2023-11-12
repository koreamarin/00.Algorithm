package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 시간 : 663ms
 * 메모리 : 42056kb
 * 풀이방법 : 브루트포스 + 구현으로 풀이하였다.
 * 1. 0,0 부터 방향, 열, 행 순으로 순회하며 브루트포스를 한다.
 * 2. 선택된 위치, 방향으로 시작했을 때의 최대점수를 구하는 문제이다. 
 * 2-1. 벽, 블록에 부딪히면 1점씩 획득하고, 웜홀에 들어가면 다른 웜홀로 나온다. 벽에 부딪힐때 방향이 중요하며, 부딪히는 방향에 의해 이동방향이 바뀌게 된다.
 * 3. 블랙홀이나 제자리로 돌아오면 게임이 종료되고, 최대점수이면 MAX를 갱신한다.
 */

public class SW_05650_핀볼게임_류지원 {
	
	public static class Boll {
		int i, j, d;

		public Boll(int i, int j, int d) {
			super();
			this.i = i;
			this.j = j;
			this.d = d;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("boll [i=");
			builder.append(i);
			builder.append(", j=");
			builder.append(j);
			builder.append(", d=");
			builder.append(d);
			builder.append("]");
			return builder.toString();
		}
	}

	static int Max, N;
	static int[][] map;
	static int[] di= {-1, 0, 1, 0}, dj= {0,1,0,-1};		// 상=0, 우=1, 하=2, 좌=3
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<T+1; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				ST=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(ST.nextToken());
				}
			}
			Max=Integer.MIN_VALUE;
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(int d=0; d<4; d++) {
						if(map[i][j]==0) {
							go(i, j, d);
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + Max);
		}

	}
	
	public static void go(int stti, int sttj, int sttd) {
		Boll boll = new Boll(stti, sttj, sttd);
		
		int sum=0;

		int sttValue=map[stti][sttj];	// 초기위치 값 꺼내놓기
		map[stti][sttj]=-1;				// 초기위치를 -1로 넣어버리기. 종료를 단순하게 하기 위함.
		
		while(true) {
			boll.i = boll.i + di[boll.d];
			boll.j = boll.j + dj[boll.d];
			
			// 현재 위치가 벽이라면 방향 반대로 바뀌기. [점수 + 1]
			if(boll.i<0 || N<=boll.i || boll.j<0 || N<=boll.j) {
				boll.d=(boll.d+2)%4;
				sum+=1;
			}
			// 현재 위치가 벽이 아니라면 맵상에서 어디인지 먼저 보기
			else {
				int CrLo=map[boll.i][boll.j];		// 현재 위치. 벽인지 블록인지, 블랙홀인지 웜홀이지, 초기위치인지 찾기위함.
				// 현재 위치가 빈공간이라면 아무것도 안함.
				if(CrLo==0) continue;
				// 현재 위치가 블록이라면. [점수 + 1]
				else if(1<=CrLo && CrLo<=5) {
					// 각 블록에 이동방향에 맞게 부딪혔을 때 튕겨나가는 방향으로 이동방향 바꾸기.
					if(CrLo==1) { 
						if(boll.d==0) 		boll.d=(boll.d+2)%4;	// 위쪽으로 가면서 부딪혔을 떄
						else if(boll.d==1) 	boll.d=(boll.d+2)%4;	// 오른쪽으로 가면서 부딪혔을 때
						else if(boll.d==2) 	boll.d=1;				// 아래쪽으로 가면서 부딪혔을 떄
						else if(boll.d==3) 	boll.d=0;				// 왼쪽으로 가면서 부딪혔을 때
					}
					else if(CrLo==2) {
						if(boll.d==0) 		boll.d=1;				// 위쪽으로 가면서 부딪혔을 떄
						else if(boll.d==1) 	boll.d=(boll.d+2)%4;	// 오른쪽으로 가면서 부딪혔을 때
						else if(boll.d==2) 	boll.d=(boll.d+2)%4;	// 아래쪽으로 가면서 부딪혔을 떄
						else if(boll.d==3) 	boll.d=2;				// 왼쪽으로 가면서 부딪혔을 때
					}
					else if(CrLo==3) {
						if(boll.d==0) 		boll.d=3;				// 위쪽으로 가면서 부딪혔을 떄
						else if(boll.d==1) 	boll.d=2;				// 오른쪽으로 가면서 부딪혔을 때
						else if(boll.d==2) 	boll.d=(boll.d+2)%4;	// 아래쪽으로 가면서 부딪혔을 떄
						else if(boll.d==3) 	boll.d=(boll.d+2)%4;	// 왼쪽으로 가면서 부딪혔을 때
					}
					else if(CrLo==4) {
						if(boll.d==0) 		boll.d=(boll.d+2)%4;	// 위쪽으로 가면서 부딪혔을 떄
						else if(boll.d==1) 	boll.d=0;				// 오른쪽으로 가면서 부딪혔을 때
						else if(boll.d==2) 	boll.d=3;				// 아래쪽으로 가면서 부딪혔을 떄
						else if(boll.d==3) 	boll.d=(boll.d+2)%4;	// 왼쪽으로 가면서 부딪혔을 때
					}
					else if(CrLo==5) {
						boll.d=(boll.d+2)%4;						// 모든방향에서 반대방향으로 바뀜
					}
					sum++;
				}
					
				// 현재 위치가 웜홀이라면 다른 웜홀로 이동하기.
				else if(6<=CrLo && CrLo<=10) {
					loop:
					for(int i=0; i<N; i++) {
						for(int j=0; j<N; j++) {
							if(map[i][j]==CrLo) {					// 현재 있는 웜홀의 번호와 똑같은 번호의 웜홀을 찾았을 때
								if(i==boll.i && j==boll.j) continue;// 탐색한 웜홀의 위치가 현재 위치라면 워프 안함.
								else {boll.i=i;	boll.j=j;break loop;}			// 탐색한 웜홀의 위치가 현재 위치가 아니라면 워프함. 
							}
						}
					}
				}
					
				// 현재 위치가 블랙홀이라면 게임 종료 후 점수 갱신.
				// 현재 위치가 초기 위치라면 게임 종료 후 점수 갱신.
				else if(CrLo==-1) break;
			}
		}
		Max=Math.max(Max, sum);
		map[stti][sttj]=sttValue;		// 초기위치 값 원복하기.
	}
}
