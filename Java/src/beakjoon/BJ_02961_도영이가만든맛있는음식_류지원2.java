package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author "Ryu jiwon"
 * 시간 : 
 * 메모리 : 
 * 풀이방법 : 부분집합.
 */

public class BJ_02961_도영이가만든맛있는음식_류지원2 {
	static boolean[] isVisited;
	static int N;
	static List<Integer> list = new ArrayList<Integer>();
	static int[] sin, sseun;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		N = Integer.parseInt(br.readLine());
		isVisited = new boolean[N];
		sin = new int[N];
		sseun = new int[N];
		
		for(int n=0; n<N; n++) {
			ST=new StringTokenizer(br.readLine());
			sin[n]=Integer.parseInt(ST.nextToken());
			sseun[n]=Integer.parseInt(ST.nextToken());
		}
		
		subset(0, 0);
		
		int min = Integer.MAX_VALUE;
		for(Integer l : list) min = Math.min(min, l);
		System.out.println(min);
	}
	
	public static void subset(int cnt, int trueCount) {
		if(cnt==N) {
			if(trueCount>=1) {
				int sinSub=1, sseunSub=0;
				for(int n=0; n<N; n++) {
					if(isVisited[n]) {
						sinSub *= sin[n];
						sseunSub += sseun[n];
					}
				}
				list.add(Math.abs(sinSub - sseunSub));
			}
			return;
		}
		isVisited[cnt]=false;
		subset(cnt+1, trueCount);
		isVisited[cnt]=true;
		subset(cnt+1, trueCount+1);
	}

}
