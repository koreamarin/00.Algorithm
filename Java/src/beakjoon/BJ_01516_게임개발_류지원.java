package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * URL : https://www.acmicpc.net/problem/1516
 * 메모리 : 
 * 시간 : 
 * 풀이 방법 : 
 * 
 * 
 * 
 * 
 * 
 */


public class BJ_01516_게임개발_류지원 {
	static List[] adjList;
	static int N;
	static boolean[] isVisited;
	static int[] buildTime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		N = Integer.parseInt(br.readLine());
		buildTime = new int[N];
		adjList = new List[N];
		
		for(int n=0; n<N; n++) {
			ST = new StringTokenizer(br.readLine());
			List<Integer> list = new ArrayList<>();
			int STSize = ST.countTokens();
			for(int i=0; i<STSize-1; i++) list.add(Integer.parseInt(ST.nextToken()));
			ST.nextToken();
			adjList[n]=list;
		}
		
		for(int n=0; n<N; n++) {
			isVisited = new boolean[N];
			buildTime[n] = dfs(n);
		}
		
		for(int i=0; i<N; i++) System.out.println(buildTime[i]);
	}
	
	public static int dfs(int buildingNum) {
		int buildTime = 0;
		if(!isVisited[buildingNum]) {
			List<Integer> list = adjList[buildingNum];
			buildTime = list.get(0);
			for(int i=1; i<list.size(); i++) buildTime += dfs(list.get(i)-1);
			isVisited[buildingNum] = true;
		}
		return buildTime;
	}

}
