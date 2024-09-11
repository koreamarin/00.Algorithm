package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 48780KB
 * 시간 : 508ms
 * 풀이방법 :
 * 인접리스트를 이용하여 위상정렬하였다.
 */

public class BJ_02252_줄세우기_류지원2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		StringBuilder SB = new StringBuilder();
		int N = Integer.parseInt(ST.nextToken());	// 학생 수
		int M = Integer.parseInt(ST.nextToken());	// 키를 비교한 회수
		int[] inDegree = new int[N];
		List<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		for(int n=0; n<N; n++) adjList.add(new ArrayList<Integer>());
		for(int m=0; m<M; m++) {
			ST=new StringTokenizer(br.readLine());
			int from = Integer.parseInt(ST.nextToken())-1;
			int to = Integer.parseInt(ST.nextToken())-1;
			adjList.get(from).add(to);
			inDegree[to]++;	// 진입차수 행렬 계산하기
		}
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int n=0; n<N; n++) if(inDegree[n]==0) q.add(n);	// 큐에 차수 0인것 넣기
		while(!q.isEmpty()) {
			int cnt = q.poll();			// 큐에서 한개씩 빼서
			SB.append((cnt+1) + " "); 	// 출력하고
			for(int i : adjList.get(cnt)) if(--inDegree[i]==0) q.add(i); // 연결된 노드 차수 내리고 큐에넣기
		}
		System.out.println(SB);
	}
}