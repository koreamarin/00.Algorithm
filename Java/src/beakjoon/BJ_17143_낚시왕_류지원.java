package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 23600KB
 * 시간 : 544ms
 * 풀이방법 : 구현문제이다.
 * 상어의 위치정보, 속력, 방향, 크기를 포함하고 있는 상어객체를 생성하였다.
 * 그리고 그 객체가 들어갈 물 속의 위치를 나타낼 배열을 생성하였다.
 *
 * 낚시꾼을 한칸씩 이동시키고, 가장 위에 있는 상어를 한마리 잡은 뒤, 상어의 크기를 따로 합산해놓고,
 * 상어를 이동시키고, 상어끼리 잡아먹는 과정을 하나의 턴으로 하여 낚시꾼이 마지막 열까지 이동할때마다 해당 턴을 반복시켰다.
 */

public class BJ_17143_낚시왕_류지원 {
	static int R, C;		// 수족관 크기, 행 열
	public static class Shark implements Comparable<Shark>{		// 상어 객체
		int row, column, speed,direction,size;		// 상어 위치, 속력, 방향, 크기
		public Shark(int row, int column, int speed, int direction, int size) {		//생성자
			this.row = row;
			this.column = column;
			this.speed = (direction <= 2) ? speed%(2*R-2) : speed%(2*C-2);		// 속력이 커봤자 같은 자리를 반복하기에 속력 연산을 줄일 수 있도록 삼항연산자를 사용하여 속력을 행 또는 열의 크기로 나눴다.
			this.direction = direction;
			this.size = size;
		}
		@Override
		public int compareTo(Shark o) {			// 상어를 정렬할 때, size의 내림차순으로 정렬.
			return Integer.compare(o.size, this.size);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST=new StringTokenizer(br.readLine());
		R=Integer.parseInt(ST.nextToken()); C=Integer.parseInt(ST.nextToken());	// 행열 크기
		int M=Integer.parseInt(ST.nextToken());	// 상어 수
		ArrayList<Shark> sharkList= new ArrayList<>();	// 상어객체를 저장할 리스트
		Shark[][] map = new Shark[R][C];				// 상어가 들어갈 물 속 위치 배열
		
		for(int m=0; m<M; m++) {
			ST=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(ST.nextToken()), c=Integer.parseInt(ST.nextToken());	// 상어의 행, 열 위치
			Shark shark = new Shark(r-1,c-1, Integer.parseInt(ST.nextToken()), Integer.parseInt(ST.nextToken()), Integer.parseInt(ST.nextToken()));
			sharkList.add(shark);	// 행, 열, 속력, 방향, 크기를 넣어 객체 생성 후 할당
			map[r-1][c-1]=shark;		// 물 속의 각 위치에 생성한 상어를 배치.
		}
		// 상어를 크기의 내림차순으로 정렬. 그 이유는 나중에 상어를 잡어먹는 과정에서 상어 크기가 작은 것부터 수족관에 배치하여,
		// 그 이후 크기가 큰 상어를 배치할 때 먼저 자리잡고 있던 작은 상어 객체위에 큰 상어를 덮어씌우는 과정을 하기 위함.
		Collections.sort(sharkList);
		int SumSize=0;									// 잡은 상어 크기의 합.

		for(int kingLo=0; kingLo<C; kingLo++) {		// 낚시왕이 이동하면서 상어를 잡음.
			// 낚시해서 물고기 잡기
			for(int i=0; i<R; i++) {
				if(map[i][kingLo]!=null) {					// 낚시왕이 이동한 열에 상어가 있다면
					SumSize+=map[i][kingLo].size;			// 상어를 잡았으므로 상어 사이즈를 잡은 상어 크기의 합에 추가.
					for(int m=sharkList.size()-1; m>=0; m--) if(map[i][kingLo]==sharkList.get(m)) sharkList.remove(m);    // 잡은 상어를 상어리스트에서 제거.
					map[i][kingLo]=null;					// 상어를 물 속 배열에서 제거함.
					break;									// 한마리만 잡아야 하므로 반복문 종료.
				}
			}

			// 상어 이동하는 반복문. 먼저 sharkList에 있는 shark부터 이동을 계산함. 물 속에 있는 상어들의 배치는 추 후 계산할 예정.
			for(Shark shark : sharkList) {			// 리스트에 있는 상어 객체들을 하나씩 꺼냄
				if(shark.direction<=2) {			// 이동방향이 위,아래일 경우
					for(int s=shark.speed; s>0; s--) {		// 상어 속력만큼 반복하는 반복문
						if(shark.row==0) 			shark.direction=2;		// 상어의 위치가 0행이라면 이동방향을 아래로 향하게 함.
						else if(shark.row==R-1) 	shark.direction=1;		// 상어의 위치가 R-1행이라면 이동방향을 위로 향하게 함.
						if(shark.direction==1) 		shark.row-=1;			// 상어의 이동방향이 위라면 상어의 위치 행에서 1을 뺌.
						else if(shark.direction==2) shark.row+=1;			// 상어의 이동방향이 아래라면 상어의 위치 행에서 1을 더함.
					}
				}
				else if(shark.direction>=3) {		// 이동방향이 얖옆일 경우
					for(int s=shark.speed; s>0; s--) {		// 상어 속력만큼 반복하는 반복문
						if(shark.column==0)			shark.direction=3;		// 상어의 위치가 0열이라면 이동방향을 오른쪽으로 향하게 함.
						else if(shark.column==C-1)	shark.direction=4;		// 상어의 위치가 C-1열이라면 이동방향을 왼쪽으로 향하게 함.
						if(shark.direction==4)		shark.column-=1;		// 상어의 이동방향이 왼쪽이라면 상어의 위치 열에서 1을 뺌.
						else if(shark.direction==3)	shark.column+=1;		// 상어의 이동방향이 오른쪽이라면 상어의 위치 열에서 1을 더함.
					}
				}
			}

			// 크기 작은것부터 sharkList의 위치 기반으로 map에 위치이동. 이때 겹쳐지는 상어들은 삭제해버림.
			for(int i=0; i<R; i++) for(int j=0; j<C; j++) if(map[i][j]!=null) map[i][j]=null;		// 물 속 배열 초기화
			for(int m=sharkList.size()-1; m>=0; m--) {						// 상어가 작은 것부터 sharkList 순환하는 반복문, 상어를 map에 배치하고, 상어가 이미 있을 경우 잡아먹힌 것이므로 리스트에서 상어객체를 삭제할 예정이므로 감소연산자를 사용해야 함.
				Shark shark=sharkList.get(m);								// 상어 리스트에서 상어 객체를 빼 옴.
				// 상어객체가 할당되어야 할 자리에 이미 다른 상어 객체가 있는경우.
				// 먼저 배치된 상어는 작은 상어이므로 잡아먹힌다. 그러므로 상어 리스트에서 먼저 자리잡고 있던 작은 상어를 삭제한다.
				if(map[shark.row][shark.column]!=null) sharkList.remove(map[shark.row][shark.column]);
				map[shark.row][shark.column]=shark;							// 새로 들어온 상어를 map에 알맞은 자리에 할당.
			}
		}
		System.out.print(SumSize);
	}
}