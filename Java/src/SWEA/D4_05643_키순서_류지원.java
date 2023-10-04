package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * URL : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo
 * 시간 : 2638ms
 * 메모리 : 101980KB
 * 풀이방법 : 
 * 1. 주어진 연결상태로 인접행렬을 만들었다.
 * 2. 반복문을 이용하여 노드를 순차적으로 sweep하여 3번부터 시행한다.
 * 2. 인접행렬과 BFS를 사용하여 어느 한 노드보다 작은 모든 노드들의 개수를 구하였다.
 * 3. 인접행렬과 BFS를 사용하여 어느 한 노드보다 큰 모든 노드들의 개수를 구하였다.
 * 4. sweep하고있는 노드의 작은노드들 + 큰노드들의 개수가 N-1개라면 자신의 순서를 정확히 알 수 있는 노드이다. 이 노드들의 개수를 카운팅하였다.
 * 
 */
public class D4_05643_키순서_류지원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
	
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());	// 학생들의 수
			int M = Integer.parseInt(br.readLine());	// 키를 비교한 횟수
			
			boolean[][] adjMatrix = new boolean[N][N];			// 그래프 연결정보를 저장할 인접행렬
			
			for(int i=0; i<M; i++) {
				ST=new StringTokenizer(br.readLine());
				adjMatrix[Integer.parseInt(ST.nextToken())-1][Integer.parseInt(ST.nextToken())-1]=true;
			}

			// 자신의 순서를 아는 번호들을 카운팅할 변수
			int cnt = 0;
			
			// 1부터 N까지 sweep, 1부터 N번까지 자신의 위 아래로 몇개가 존재하는지 BFS로 찾아내어 자신의 위 아래가 N-1개일 경우 자신의 순서를 정확이아는 것이므로 그 숫자는 cnt+1을 하여 카운팅함
			for(int k=0; k<N; k++) {
				boolean[] isVisited;
				
				// 큰것들 개수찾기 BFS
				int BNum = 0;
				isVisited=new boolean[N];
				Queue<Integer> BQue = new ArrayDeque<Integer>();
				isVisited[k]=true;
				for(int j=0; j<N; j++) {
					if(adjMatrix[k][j]==true) {
						BQue.add(j);
						isVisited[j]=true;
						BNum++;
					}
				}
				while(!BQue.isEmpty()) {
					int crt = BQue.poll();
					for(int j=0; j<N; j++) {
						if(!isVisited[j] && adjMatrix[crt][j]==true) {
							BQue.add(j);
							isVisited[j]=true;
							BNum++;
						}
					}
				}
				
				// 작은것들 개수찾기 BFS
				int SNum = 0;
				isVisited=new boolean[N];
				Queue<Integer> SQue = new ArrayDeque<Integer>();
				isVisited[k]=true;
				for(int i=0; i<N; i++) {
					if(adjMatrix[i][k]==true) {
						SQue.add(i);
						isVisited[i]=true;
						SNum++;
					}
				}
				while(!SQue.isEmpty()) {
					int crt = SQue.poll();
					for(int i=0; i<N; i++) {
						if(!isVisited[i] && adjMatrix[i][crt]==true) {
							SQue.add(i);
							isVisited[i]=true;
							SNum++;
						}
					}
				}
				
				if((BNum+SNum)==N-1) cnt++;	// 큰거 - 작은거 == N-1이면 count+1
			}
			System.out.println("#" + (t+1) + " " + cnt);
		}
	}
}
