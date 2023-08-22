package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
/**
 * @author 류지원
 * 메모리 : 187496KB
 * 시간 : 632ms
 * 풀이방법 :
 * dfs를 이용한 완전탐색과 구현을 이용하였다.
 * 카메라를 순차적으로 90도씩 돌려가며 각 케이스마다 사각지대를 계산하였다.
 */
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
				if('0'<office[i][j] && office[i][j]<'6') cameraLoList.add(new int[] {i,j});	// 카메라가 있다면 그 카메라의 위치를 리스트에 추가
			}
		}
		dfs(0, office);		// 카메라를 90도씩 돌리는 탐색 시작.
		System.out.print(min);	// 최소 사각지대 출력
	}
	public static char[][] Watch(int r, int c, char direction, char[][] office) {	// 카메라 위치 r,c와 상하좌우 어느쪽을 탐색할 것인지를 선택하는 direction, 현재 오피스의 정보 배열 office를 매개변수로 하며 카메라 시야정보를 넣은 후 배열상태 반환하는 메서드
		HashMap<Character, int[]> directionMap = new HashMap<>();
		directionMap.put('U', new int[] {-1,0});	// 상
		directionMap.put('D', new int[] {1,0});		// 하
		directionMap.put('L', new int[] {0,-1});	// 좌
		directionMap.put('R', new int[] {0,1});		// 우
		char[][] WatchedOffice = new char[N][M];
		for(int i=0; i<N; i++) WatchedOffice[i]=Arrays.copyOf(office[i], M);	// 배열 복제
		int R=r+directionMap.get(direction)[0]; int C=c+directionMap.get(direction)[1];	// 탐색해야하는 행과 열 초기값 지정
		while(0<=R && R<N && 0<=C && C<M) {	// 배열밖으로 나가지 않는다면 반복문 실행
			if(WatchedOffice[R][C]=='0') WatchedOffice[R][C]='#';	// 바닥이 0이면 탐색한다는 의미로 # 넣기
			else if(WatchedOffice[R][C]=='6') break;	//6이면 벽이므로 탐색 종료
			R+=directionMap.get(direction)[0];	C+=directionMap.get(direction)[1];	// 행과 열을 진행방향으로 더하기.
		}
		return WatchedOffice;		// 오피스 정보 배열 반환
	}
	public static void dfs(int cnt, char[][] office) {	// dfs메서드
		if(cnt==cameraLoList.size()) {		// 기저조건. 탐색깊이가 카메라 개수와 같다면
			int sum=0;						// sum을 0으로 생성 및 할당
			for(int i=0; i<N; i++) for(int j=0; j<M; j++) if(office[i][j]=='0') sum++;	// 탐색되지 않은 부분인 0을 찾고, 0을 찾을때마다 sum에 1씩 더함
			if(min>sum) min = sum;	// sum이 min보다 작다면 min에 sum값 ㅊ가
			return;		// 함수 반환.
		}
		int[] cameraLo = cameraLoList.get(cnt);		// 카메라 위치리스트에서 현재 탐색깊이 번호에 해당하는 카메라 위치를 가져옴.
		if(office[cameraLo[0]][cameraLo[1]]=='1') {		// 카메라 번호가 1이라면
			dfs(cnt+1, Watch(cameraLo[0],cameraLo[1], 'U', office));	// 상 탐색 후, 복제본과 함께 다음 탐색에 넘기기.
			dfs(cnt+1, Watch(cameraLo[0],cameraLo[1], 'D', office));	// 하 탐색 후, 복제본과 함께 다음 탐색에 넘기기.
			dfs(cnt+1, Watch(cameraLo[0],cameraLo[1], 'L', office));	// 좌 탐색 후, 복제본과 함께 다음 탐색에 넘기기.
			dfs(cnt+1, Watch(cameraLo[0],cameraLo[1], 'R', office));	// 우 탐색 후, 복제본과 함께 다음 탐색에 넘기기.
		}
		else if(office[cameraLo[0]][cameraLo[1]]=='2') {	// 카메라 번호가 2라면
			dfs(cnt+1, Watch(cameraLo[0],cameraLo[1], 'U', Watch(cameraLo[0],cameraLo[1], 'D', office)));	// 상,하 탐색 후 복제본과 함께 다음 탐색에 넘기기.
			dfs(cnt+1, Watch(cameraLo[0],cameraLo[1], 'L', Watch(cameraLo[0],cameraLo[1], 'R', office)));	// 좌,우 탐색 후 복제본과 함께 다음 탐색에 넘기기.
		}
		else if(office[cameraLo[0]][cameraLo[1]]=='3') {	// 카메라 번호가 3이라면
			dfs(cnt+1, Watch(cameraLo[0],cameraLo[1], 'U',Watch(cameraLo[0],cameraLo[1], 'L', office)));	// 상,좌 탐색 후 복제본과 함께 다음 탐색에 넘기기.
			dfs(cnt+1, Watch(cameraLo[0],cameraLo[1], 'U',Watch(cameraLo[0],cameraLo[1], 'R', office)));	// 상,우 탐색 후 복제본과 함께 다음 탐색에 넘기기.
			dfs(cnt+1, Watch(cameraLo[0],cameraLo[1], 'D',Watch(cameraLo[0],cameraLo[1], 'L', office)));	// 하,좌 탐색 후 복제본과 함께 다음 탐색에 넘기기.
			dfs(cnt+1, Watch(cameraLo[0],cameraLo[1], 'D',Watch(cameraLo[0],cameraLo[1], 'R', office)));	// 하,우 탐색 후 복제본과 함께 다음 탐색에 넘기기.
		}
		else if(office[cameraLo[0]][cameraLo[1]]=='4') {	// 카메라 번호가 4라면
			dfs(cnt+1,
				Watch(cameraLo[0],cameraLo[1], 'U',
					Watch(cameraLo[0],cameraLo[1], 'R',
						Watch(cameraLo[0],cameraLo[1], 'D', office))));	// 상,우,하 탐색 후 복제본과 함께 다음 탐색에 넘기기.
			dfs(cnt+1,
				Watch(cameraLo[0],cameraLo[1], 'R',
					Watch(cameraLo[0],cameraLo[1], 'D',
						Watch(cameraLo[0],cameraLo[1], 'L', office))));	// 우,하,좌 탐색 후 복제본과 함께 다음 탐색에 넘기기.
			dfs(cnt+1,
				Watch(cameraLo[0],cameraLo[1], 'D',
					Watch(cameraLo[0],cameraLo[1], 'L',
						Watch(cameraLo[0],cameraLo[1], 'U', office))));	// 하,좌,상 탐색 후 복제본과 함께 다음 탐색에 넘기기.
			dfs(cnt+1,
				Watch(cameraLo[0],cameraLo[1], 'L',
					Watch(cameraLo[0],cameraLo[1], 'U',
						Watch(cameraLo[0],cameraLo[1], 'R', office))));	// 좌,상,우 탐색 후 복제본과 함께 다음 탐색에 넘기기.
		}
		else if(office[cameraLo[0]][cameraLo[1]]=='5') {	// 카메라 번호가 5라면
			dfs(cnt+1,
				Watch(cameraLo[0],cameraLo[1], 'L',
					Watch(cameraLo[0],cameraLo[1], 'R',
						Watch(cameraLo[0],cameraLo[1], 'D',
							Watch(cameraLo[0],cameraLo[1], 'U', office)))));	// 상하좌우 탐색 후, 복제본과 함께 다음 탐색에 넘기기.
		}
	}
}
