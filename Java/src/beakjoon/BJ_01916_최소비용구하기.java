package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author "Ryu jiwon"
 * 시간 : 
 * 메모리 : 
 * 풀이방법 : 다익스트라 알고리즘을 사용하여 두 노드 간 비용이 가장 낮은 구간 찾기.
 */

public class BJ_01916_최소비용구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int N = Integer.parseInt(br.readLine());	// 도시의 개수(노드 개수)
		int M = Integer.parseInt(br.readLine());	// 버서의 개수(간선 개수)
		
		int from, to, weight;
		
		for(int m=0; m<M; m++) {
			ST = new StringTokenizer(br.readLine());
			
			from = Integer.parseInt(ST.nextToken());
			to = Integer.parseInt(ST.nextToken());
			weight = Integer.parseInt(ST.nextToken());
			
			
			
		}

	}

}
