package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17143_낚시왕_류지원 {
	public static class shark implements Comparable<shark>{
		int speed,direction,size;
		public shark(int speed, int direction, int size) {
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}
		@Override
		public int compareTo(shark o) {
			return Integer.compare(this.size, o.size);
		}
		@Override
		public String toString() {
			return "[속도 : " + speed + ", 방향 : " + direction + ", 크기 : " + size + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST=new StringTokenizer(br.readLine());
		int R=Integer.parseInt(ST.nextToken()), C=Integer.parseInt(ST.nextToken());	// 행열 크기
		int M=Integer.parseInt(ST.nextToken());	// 상어 수
		shark[] sharkArr=new shark[M];	
		shark[][] map = new shark[R][C];
		
		for(int m=0; m<M; m++) {
			ST=new StringTokenizer(br.readLine());	
			int r=			Integer.parseInt(ST.nextToken());	// 상어의 행 위치
			int c=			Integer.parseInt(ST.nextToken());	// 상어의 열 위치
			int speed=		Integer.parseInt(ST.nextToken());	// 상어의 속력
			int direction=	Integer.parseInt(ST.nextToken());	// 상어의 방향
			int size=		Integer.parseInt(ST.nextToken());	// 상어의 크기
			sharkArr[m]=	new shark(speed,direction,size);	// 속력, 방향, 크기를 넣어 객체 생성 후 할당
			map[r-1][c-1]=	sharkArr[m];
		}
		
		System.out.println("초기 입력값 map");
		for(int r=0; r<R; r++) {
			System.out.print(Arrays.toString(map[r]));
			System.out.println();
		}
		
		Arrays.sort(sharkArr);
		
		
		System.out.println("\n초기 입력값, 정렬됨. 상어 배열");
		for(int m=0; m<M; m++) {
			System.out.print(sharkArr[m]);
			System.out.println();
		}
		System.out.println();
		
		
		int SumSize=0;									// 잡은 상어 크기의 합.
		
		for(int kingLo=0; kingLo<C; kingLo++) {		// 낚시왕이 이동하면서 상어를 잡음.
			System.out.println(kingLo + "번 열에 낚시꾼이 물고기를 잡는다.");
			
			// 낚시해서 물고기 잡기
			int minR=Integer.MAX_VALUE;
			int sangNum=0;		// 상어 번호
			for(int i=0; i<R; i++) {
				if(map[i][kingLo]!=null) {					// 낚시왕이 이동한 열에 상어가 있다면
					SumSize+=map[i][kingLo].size;			// 상어를 잡았으므로 상어 사이즈를 잡은 상어 크기의 합에 추가.
					for(int m=0; m<M; m++) if(map[i][kingLo].equals(sharkArr[m])) sharkArr[m]=null;	// 잡은 상어를 배열에서 제거.
					map[i][kingLo]=null;					// 상어를 맵에서 제거함.
				}
			}
			
			System.out.println("잡은 후");
			for(int m=0; m<M; m++) {
				System.out.print(sharkArr[m]);
				System.out.println();
			}
			
			for(int r=0; r<R; r++) {
				System.out.print(Arrays.toString(map[r]));
				System.out.println();
			}
			
			System.out.println();

			
			// 상어 이동		d가 1이면 위, 2이면 아래, 3이면 오른쪽, 4이면 왼쪽.
			for(int m=0; m<M; m++) {
				// 방향과 크기 파악하여 최종위치 결정
					// d가 1, 2이면 행만 이동하므로 map[m][0]만 바뀜.
					// d가 1인데 행이 1이면 d를 2로 바꿈.
					// d가 2인데 행이 R이면 d를 1로 바꿈.
				if(map[m][3]<=2) {
					for(int s=map[m][2]; s>0; s--) {
						if(map[m][0]==1) 		map[m][3]=2;
						else if(map[m][0]==R) 	map[m][3]=1;
						
						if(map[m][3]==1) 		map[m][0]--;
						else if(map[m][3]==2) 	map[m][0]++;
					}
				}
				// 방향과 크기 파악하여 최종위치 결정
					// d가 3, 4이면 열만 이동하므로 map[m][1]만 바뀜.
					// d가 3인데 열이 C이면 d를 4로 바꿈.
					// d가 4인데 열이 1이면 d를 3로 바꿈.
				else if(map[m][3]>=3) {
					for(int s=map[m][2]; s>0; s--) {
						if(map[m][1]==1) 		map[m][3]=3;
						else if(map[m][1]==C) 	map[m][3]=4;
						
						if(map[m][3]==4) 		map[m][1]--;
						else if(map[m][3]==3) 	map[m][1]++;
					}
				}
			}
////			System.out.println("이동 완료"); for(int m=0; m<M; m++) System.out.println(Arrays.toString(map[m])); System.out.println();
//			
//			// 만약 위치가 같은 상어들이 있다면 작은 상어는 0으로 만들고 큰상어만 남기기
//			for(int m=0; m<M-1; m++) {
//				for(int n=m+1; n<M; n++) {
//					if(map[m][0]!=0 && map[m][0]==map[n][0] && map[m][1]==map[n][1]) {
//						if(map[m][4]>map[n][4]) for(int k=0; k<5; k++)map[n][k]=0;
//						else for(int k=0; k<5; k++) map[m][k]=0;
////						System.out.println(m + "번 상어 잡아먹힘");
//					}
//				}
//			}
////			for(int m=0; m<M; m++) System.out.println(Arrays.toString(map[m])); System.out.println();
		}
		System.out.println(SumSize);
	}
}