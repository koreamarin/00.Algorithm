package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_15683_감시_류지원 {
	static ArrayList<int []> cameraLoList;
	static int min=Integer.MAX_VALUE, N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		N=Integer.parseInt(ST.nextToken()); M=Integer.parseInt(ST.nextToken());
		char[][] office=new char[N][M];			// 사무실 상태 배열
		cameraLoList=new ArrayList<>();	// 카메라의 위치를 저장해놓은 리스트
		
		for(int i=0; i<N; i++) {
			ST=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				office[i][j]=ST.nextToken().charAt(0);
				if('0'<office[i][j] && office[i][j]<'6') {
					cameraLoList.add(new int[] {i,j});
				}
			}
		}
		
		for(int i=0; i<N; i++) System.out.println(Arrays.toString(office[i]));
		
		System.out.println();
		
		for(int[] cameraLo : cameraLoList) System.out.print(Arrays.toString(cameraLo));
		
		System.out.println();
		System.out.println();
		
//		UpWatch(2,2, 'U', office);
		
		dfs(0, office);
		System.out.println(min);
		
	
	
	
	
	}
	
	
	// 어디까지 감시?
		// 상 감시 메서드
	public static char[][] UpWatch(int r, int c, char direction, char[][] office) {
		HashMap<Character, int[]> directionMap = new HashMap<>();
		directionMap.put('U', new int[] {-1,0});	// 상
		directionMap.put('D', new int[] {1,0});		// 하
		directionMap.put('L', new int[] {0,-1});	// 좌
		directionMap.put('R', new int[] {0,1});		// 우
		
		char[][] WatchedOffice = new char[N][M];
		for(int i=0; i<N; i++) WatchedOffice[i]=Arrays.copyOf(office[i], M);
		
		int R=r+directionMap.get(direction)[0]; int C=c+directionMap.get(direction)[1];
		while(0<=R && R<N && 0<=C && C<M) {
			
			if(WatchedOffice[R][C]=='0') WatchedOffice[R][C]='#';
			else if(WatchedOffice[R][C]>'0') break;
			R+=directionMap.get(direction)[0];	C+=directionMap.get(direction)[1];
		}

		return WatchedOffice;
	}
		// 하 감시 메서드
		// 좌 감시 메서드
		// 우 감시 메서드
	
	// dfs메서드
	public static void dfs(int cnt, char[][] office) {
		if(cnt==cameraLoList.size()) {
			int sum=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(office[i][j]=='0') sum++;
				}
			}
			System.out.println(sum);
			if(min>sum) min=sum;
			return;
		}
		
		int[] cameraLo = cameraLoList.get(cnt);
		if(office[cameraLo[0]][cameraLo[1]]=='1') {
			System.out.println(Arrays.toString(cameraLo) + " 위치의 " + office[cameraLo[0]][cameraLo[1]] + "번 카메라");
			char[][] WatchedOffice;
			// 상
			// 1. office를 [상 감시 메서드]에 넘겨서 탐색된 배열을 넘겨 받은 후
			WatchedOffice = UpWatch(cameraLo[0],cameraLo[1], 'U', office);
			for(int i=0; i<N; i++) System.out.println(Arrays.toString(WatchedOffice[i]));
			// 2. 복제본과 함께 다음 탐색에 넘기기.
			System.out.println();
			dfs(cnt+1, WatchedOffice);
			
			
			// 하
			// 1. office를 [상 감시 메서드]에 넘겨서 탐색된 배열을 넘겨 받은 후
			WatchedOffice = UpWatch(cameraLo[0],cameraLo[1], 'D', office);
			for(int i=0; i<N; i++) System.out.println(Arrays.toString(WatchedOffice[i]));
			// 2. 복제본과 함께 다음 탐색에 넘기기.
			System.out.println();
			dfs(cnt+1, WatchedOffice);
			
			// 좌
			// 1. office를 [상 감시 메서드]에 넘겨서 탐색된 배열을 넘겨 받은 후
			WatchedOffice = UpWatch(cameraLo[0],cameraLo[1], 'L', office);
			for(int i=0; i<N; i++) System.out.println(Arrays.toString(WatchedOffice[i]));
			// 2. 복제본과 함께 다음 탐색에 넘기기.
			System.out.println();
			dfs(cnt+1, WatchedOffice);
			
			// 우
			// 1. office를 [상 감시 메서드]에 넘겨서 탐색된 배열을 넘겨 받은 후
			WatchedOffice = UpWatch(cameraLo[0],cameraLo[1], 'R', office);
			for(int i=0; i<N; i++) System.out.println(Arrays.toString(WatchedOffice[i]));
			// 2. 복제본과 함께 다음 탐색에 넘기기.
			System.out.println();
			dfs(cnt+1, WatchedOffice);
		}
		else if(office[cameraLo[0]][cameraLo[1]]=='2') {
			System.out.println(Arrays.toString(cameraLo) + " 위치의 " + office[cameraLo[0]][cameraLo[1]] + "번 카메라");
			// 상하
			// 좌우
		}
		else if(office[cameraLo[0]][cameraLo[1]]=='3') {
			System.out.println(Arrays.toString(cameraLo) + " 위치의 " + office[cameraLo[0]][cameraLo[1]] + "번 카메라");
			// 상좌
			// 상우
			// 하좌
			// 하우
		}
		else if(office[cameraLo[0]][cameraLo[1]]=='4') {
			System.out.println(Arrays.toString(cameraLo) + " 위치의 " + office[cameraLo[0]][cameraLo[1]] + "번 카메라");
			// 상우하 ▷
				// office배열 복제본을 만들어서 상우하를 탐색한 배열을 만든 후, 복제본과 함께 다음 탐색에 넘기기.
			
			// 우하좌 ▽
			// 하우상 ◁
			// 우상좌 △
		}
		else if(office[cameraLo[0]][cameraLo[1]]=='5') {
			System.out.println(Arrays.toString(cameraLo) + " 위치의 " + office[cameraLo[0]][cameraLo[1]] + "번 카메라");
			// 상하좌우
		}
//			
		
	}
}
