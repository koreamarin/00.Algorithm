package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * 
 * @author 류지원
 * 메모리 : 76704KB, 시간 : 464ms
 * 풀이방법 : 
 * DP를 이용하였다. 미로에서 이동했을 때의 각 위치에서 얻을수 있는 사탕의 최대값을 저장하였다.
 * 어떤 위치로 이동할 때, 그 위치로 갈 수 있는 경우는 3가지 이므로, 그 3개 위치의 값에서 이동한 위치의 사탕의 개수를 더한 값을 추출한다.
 * 그 3가지의 값 중에서 최대값이 그 위치에서 얻을 수 있는 최대사탕의 개수이다. 
 * 그렇게 N,M까지 각 위치에서의 최대 사탕의 개수를 구한 뒤 배열에 저장된 N,M위치에서의 최대사탕의 개수를 출력하면 된다. 
 */

public class BJ_11048_이동하기_류지원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(ST.nextToken()), M = Integer.parseInt(ST.nextToken());
		int[][] maze = new int[N][M];	// 미로에 놓여져있는 사탕의 개수가 저장되어있는 배열,
		int[][] maxCandy=new int[N][M];	// maxCandy는 미로의 각 위치에서의 얻을 수 있는 사탕의 최대개수를 저장할 배열.
		for(int i=0; i<N; i++) {		// 미로에 놓여져있는 사탕 개수 입력받는 반복문
			ST=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) maze[i][j]=Integer.parseInt(ST.nextToken());
		}
		maxCandy[0][0]=maze[0][0];		// 초기값. 0,0 값은 참조하는 값이 없어 계산이 불가하므로 초기값을 넣어주었다.
		for(int i=0; i<N; i++) {		// 행을 0부터 sweep
			for(int j=0; j<M; j++) {	// 열을 0부터 sweep
				if(maxCandy[i][j]==0) {	// maxCandy[i][j]==0이라면 그 위치에서의 값이 아직 계산되지 않은 것이므로 
					int MAX = 0;		// 3자리에서 오는 최대값을 비교하기 위해서 변수 선언
					if(0<i && 0<j) MAX=maxCandy[i-1][j-1]+maze[i][j];								// 왼 위에서 오는 경우, 왼위쪽의 최대값과 현재 자리에서 얻을 수 있는 사탕의 개수를 더하여 값을 max에 저장
					if(0<i && MAX<maxCandy[i-1][j]+maze[i][j]) MAX=maxCandy[i-1][j]+maze[i][j];		// 위에서 내려오는 경우, 위쪽의 최대값과 현재 자리에서 얻을 수 있는 사탕의 개수를 더하여 그 값이 max보다 크다면 max 갱신
					if(0<j && MAX<maxCandy[i][j-1]+maze[i][j]) MAX=maxCandy[i][j-1] + maze[i][j];	// 왼쪽에서 오른쪽으로 온 경우, 왼쪽의 최대값과 현재 자리에서 얻을 수 있는 사탕의 개수를 더하여 그 값이 max보다 크다면 max 갱신
					maxCandy[i][j]=MAX;	// MAX값을 maxCandy[i][j]에 할당하여 최대값을 할당함
				}
			}
		}
		System.out.println(maxCandy[N-1][M-1]);	// N,M자리에서의 최대값 출력
	}
}
