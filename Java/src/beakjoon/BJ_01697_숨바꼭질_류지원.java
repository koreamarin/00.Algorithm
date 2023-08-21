package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 메모리 : 14076 KB
 * 시간 : 120 ms
 * 풀이방식 : 
 * 그래프를 이용한 BFS 풀이방식으로 풀이하였다.
 *
 */
public class BJ_01697_숨바꼭질_류지원 {
	static int[] isSelected=new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(ST.nextToken()), K=Integer.parseInt(ST.nextToken());
		Arrays.fill(isSelected, -1);
		bfs(N,K);
	}
	public static void bfs(int N, int K) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(N);
		isSelected[N]+=1;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			if(current==K) break;
			if(0<=current+1 && current+1<=100000 && isSelected[current+1]==-1) {
				queue.offer(current+1);
				isSelected[current+1]=isSelected[current]+1;
			}
			if(0<=current-1 && current-1<=100000 && isSelected[current-1]==-1) {	
				queue.offer(current-1);
				isSelected[current-1]=isSelected[current]+1;
			}
			if(0<=current*2 && current*2<=100000 && isSelected[current*2]==-1) {
				queue.offer(current*2);
				isSelected[current*2]=isSelected[current]+1;
			}
		}
		System.out.println(isSelected[K]);
	}

}
