package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 225740KB
 * 시간 : 264ms
 * 풀이방법 :
 * 1. bfs를 이용하여  flood fill를 사용하여 각 섬들을 다른 숫자로 표기함.
 * 2. 각 섬들의 해안가 위치를 List에 저장
 * 3. 해안가 위치에서 다른 섬에 닿는 가장 가까운 거리를 구하기 위해 bfs를 사용함.
 * 4. 각 해안가에서 다른 섬에 닿는 가장 가까운 거리끼리 비교하여 최단거리를 추출함. 
 */

public class BJ_02146_다리만들기_류지원 {
	static int N, min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        
        for(int i=0; i<N; i++) {
        	ST=new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		map[i][j]=Integer.parseInt(ST.nextToken());
        	}
        }
        
        // 섬들 다른 숫자로 표시한 배열 Map
        int[][] floodMap = floodFill(map);
        
        // 해안가 위치를 저장한 List
        List<int[]> adgeList = findAdge(map);
        for(int[] lo : adgeList) {
        	minDistance(lo, floodMap);	// 각 해안가에서 다른 섬까지의 거리를 구하는 메서드
        }
        System.out.println(min);	// 모든 해안가에서 다른 섬까지의 가장 가까운 거리를 출력

    }
    
    // 해안가에서 다른 섬까지의 가장 가까운 거리를 찾아내는 메서드.
    public static void minDistance(int[] lo, int[][] floodMap) {
    	int[][] isVisited;
    	int color;
    	Queue<int[]> queue;
    	
		isVisited = new int[N][N];
    	queue = new ArrayDeque<>();
    	queue.add(lo);
    	isVisited[lo[0]][lo[1]]=0;
    	color = floodMap[lo[0]][lo[1]];
    	
    	int d=1;
    	
    	while(!queue.isEmpty()) {
    		int[] crt=queue.poll();
    		int[] di = new int[] {-1, 1, 0, 0};	// 위, 아래, 왼, 오른
    		int[] dj = new int[] {0, 0, -1, 1}; // 위, 아래, 왼, 오른
    		
    		for(int i=0; i<4; i++) {
    			if(inRange(crt[0]+di[i], crt[1]+dj[i]) 
    					&& floodMap[crt[0]+di[i]][crt[1]+dj[i]]>0
    					&& floodMap[crt[0]+di[i]][crt[1]+dj[i]]!=color) {
    				min = Math.min(min, isVisited[crt[0]][crt[1]]);
    				return;
    			}
    			
    			if(inRange(crt[0]+di[i], crt[1]+dj[i]) 
    					&& floodMap[crt[0]+di[i]][crt[1]+dj[i]]==0
    					&& isVisited[crt[0]+di[i]][crt[1]+dj[i]]==0) {
    				queue.add(new int[] {crt[0]+di[i], crt[1]+dj[i]});
    				isVisited[crt[0]+di[i]][crt[1]+dj[i]]=isVisited[crt[0]][crt[1]]+1;
    			}
    		}
    	}
    }
    
    // 배열밖에 있는지 아닌지 확인하는 메서드
    public static boolean inRange(int i, int j) {
    	if(0<=i && i<N && 0<=j && j<N) {
    		return true;
    	}
    	return false;
    }
    
    
    // 해안가 위치를 모두 추출하여 List에 저장하여 반환하는 메서드
    public static List<int[]> findAdge(int[][] map) {
    	List<int[]> adgeList = new ArrayList<>();
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(map[i][j]>0) {
    				if(i>0 && map[i-1][j]==0) {
    					adgeList.add(new int[] {i,j});
    					continue;
    				}
    				if(i<N-1 && map[i+1][j]==0) {
    					adgeList.add(new int[] {i,j});
    					continue;
    				}
    				if(j>0 && map[i][j-1]==0) {
    					adgeList.add(new int[] {i,j});
    					continue;
    				}
    				if(j<N-1 && map[i][j+1]==0) {
    					adgeList.add(new int[] {i,j});
    					continue;
    				}
    			}
    		}
    	}
    	
    	return adgeList;
    }
    
    // 각 섬들을 다른 번호로 만드는 메서드.
    public static int[][] floodFill(int[][] map) {
    	int[][] floodMap = new int[N][N];
    	boolean[][] isVisited = new boolean[N][N]; 
    	
    	for(int i=0; i<N; i++) {
    		floodMap[i]=Arrays.copyOf(map[i], N);    	
    	}
    	
    	int colorNum=1;
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(floodMap[i][j]==1 && !isVisited[i][j]) {
    				Queue<int[]> queue = new ArrayDeque<int[]>();
    				
    				queue.add(new int[] {i,j});
    				isVisited[i][j]=true;
    			
    				while(!queue.isEmpty()) {
    					int[] current = queue.poll();
    					floodMap[current[0]][current[1]]=colorNum;
    					
    					if(current[0]>0 && floodMap[current[0]-1][current[1]]==1 && !isVisited[current[0]-1][current[1]]) {
    						queue.add(new int[] {current[0]-1, current[1]});
    						isVisited[current[0]-1][current[1]]=true;
    					}
    					if(current[0]<N-1 && floodMap[current[0]+1][current[1]]==1 && !isVisited[current[0]+1][current[1]]) {
    						queue.add(new int[] {current[0]+1, current[1]});
    						isVisited[current[0]+1][current[1]]=true;
    					}
    					if(current[1]>0 && floodMap[current[0]][current[1]-1]==1 && !isVisited[current[0]][current[1]-1]) {
    						queue.add(new int[] {current[0], current[1]-1});
    						isVisited[current[0]][current[1]-1]=true;
    					}
    					if(current[1]<N-1 && floodMap[current[0]][current[1]+1]==1 && !isVisited[current[0]][current[1]+1]) {
    						queue.add(new int[] {current[0], current[1]+1});
    						isVisited[current[0]][current[1]+1]=true;
    					}
    				}
    				colorNum++;
    			}
    		}
    	}
    	
    	return floodMap;
    }
}
