package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 
 * 풀이방법 : 
 * 1. floodfill로 각 구역 나누기
 * 2. 해변 위치 List 만들기
 * 3. 해변위치에서 바다 방향으로 일직선으로 뻗어서 섬을 만나면 적용시키기. (2칸 이상일 때에만)
 * 4. 각 다리들을 부분집합으로 적용했을때와 아닐때를 만들어서 다리를 적용시켰을 때 BFS를 돌려 모든 육지를 방문하는 지 확인하기.
 *
 */

public class BJ_17472_다리만들기2 {
	static int N, M, bridgeNum, IslandNum, min=Integer.MAX_VALUE;
	static boolean[] isSelected;
	static List<List<int[]>> bridgeList = new ArrayList<>();
	static int[][] map;
	static int[] dn = {-1, 1, 0, 0};
	static int[] dm = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(ST.nextToken());		// 세로크기
		M = Integer.parseInt(ST.nextToken());		// 가로크기
		
		map = new int[N][M];
		
		for(int n=0; n<N; n++) {
			ST = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				if(ST.nextToken().equals("1")) {
					map[n][m]=3;
				}
			}
		}
		
		System.out.println("섬 위치 입력받은 초기상태");
		for(int n=0; n<N; n++) {
			System.out.println(Arrays.toString(map[n]));
		}
		System.out.println();
		
		// 상하좌우

		
		// 해변을 찾아서 해변 위치에서 바다로 다리 일직선으로 뻗어어서 섬을 만나면 그 다리 위치를 리스트에 넣기(다리길이 2 이상만)
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(map[n][m]>=3) {
					for(int d=0; d<4; d++) {
						if(inRange(n+dn[d], m+dm[d]) && map[n+dn[d]][m+dm[d]]==0) {
							List<int[]> bridgeLoList = null;
							int K=1;
							while(true) {
								if(inRange(n+(dn[d]*K), m+(dm[d]*K)) && map[n+(dn[d]*K)][m+(dm[d]*K)]<3) {
									K+=1;
								}
								else if(inRange(n+(dn[d]*K), m+(dm[d]*K)) && map[n+(dn[d]*K)][m+(dm[d]*K)]>=3) {
									if(K>=3) {
										bridgeLoList = new ArrayList<>();
										if(d==0 || d==2) {
											for(int k=1; k<K; k++) {
												bridgeLoList.add(new int[] {n+(dn[d]*k), m+(dm[d]*k)}); 
											}
										}
										else if(d==1 || d==3) {
											for(int k=K-1; k>0; k--) {
												bridgeLoList.add(new int[] {n+(dn[d]*k), m+(dm[d]*k)}); 
											}
										}
									}
									break;
								}
								else if(!inRange(n+(dn[d]*K), m+(dm[d]*K))) {
									break;
								}
							}
							if(bridgeLoList!=null) bridgeList.add(bridgeLoList);
						}
					}
				}
				
			}
		}
		
		// 리스트에서 중복 제거
		for(int i=bridgeList.size()-1; i>=0; i--) {
			List<int[]> bridgeLoList1 = bridgeList.get(i);
			Loop :
			for(int j=i-1; j>=0; j--) {
				List<int[]> bridgeLoList2 = bridgeList.get(j);
				if(bridgeLoList1.size() == bridgeLoList2.size()) {
					for(int ii=0; ii<bridgeLoList1.size(); ii++) {
						int[] bridgeLo1 = bridgeLoList1.get(ii);
						int[] bridgeLo2 = bridgeLoList2.get(ii);
						if(bridgeLo1[0]!=bridgeLo2[0] || bridgeLo1[1]!=bridgeLo2[1]) {
							continue Loop;
						}
					}
					bridgeList.remove(j);
				}
			}
		}
		
		System.out.println("다리 위치");
		for(List<int[]> bridgeLoList : bridgeList) {
			for(int[] bridgeLo : bridgeLoList) {
				System.out.print(Arrays.toString(bridgeLo));
			}
			System.out.println();
		}
		System.out.println();
		
		IslandNum = floodFill();
		System.out.println("섬의 개수 : " + IslandNum);
		
		// 부분집합
		bridgeNum = bridgeList.size();
		isSelected = new boolean[bridgeNum];
		subset(0);
		
		
		System.out.println();
		if(min==Integer.MAX_VALUE) {
			System.out.println("최소값 : " + -1);
		} else {
			System.out.println("최소값 : " + min);
		}
		
		
		
		
		
		
		
		
	}
	
	public static void subset(int cnt) {
		if(cnt==bridgeNum) {
			int SelectedBridgeNum = 0;
			for(int i=0; i<bridgeNum; i++) {
				if(isSelected[i]) SelectedBridgeNum+=1;
			}
			if(SelectedBridgeNum<IslandNum-1) return;
			
			System.out.println(Arrays.toString(isSelected));
			// 배열 복사
			int[][] mapClone = new int[N][];
			for(int n=0; n<N; n++) {
				mapClone[n] = Arrays.copyOf(map[n], M);
			}
			
			// 선택된 다리 건설
			for(int i=0; i<bridgeNum; i++) {
				if(isSelected[i]) {
					List<int[]> bridgeLoList = bridgeList.get(i);
					for(int[] bridgeLo : bridgeLoList) {
//						System.out.print(Arrays.toString(bridgeLo));
						mapClone[bridgeLo[0]][bridgeLo[1]]++;
					}
//					System.out.println();
				}
			}
			
			for(int n=0; n<N; n++) {
				System.out.println(Arrays.toString(mapClone[n]));
			}
			
			// BFS로 섬들 모두 방문하는지 확인
			boolean[][] isVisited = new boolean[N][M];
			Queue<int[]> queue = new ArrayDeque<>();
			
			Loop :
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(mapClone[n][m]==3 && !isVisited[n][m]) {
						queue.add(new int[] {n, m});
						isVisited[n][m]=true;
						break Loop;
					}
				}
			}
			
			while(!queue.isEmpty()) {
				int[] crt = queue.poll();
				Loop :
				for(int d=0; d<4; d++) {
					if(inRange(crt[0]+dn[d], crt[1]+dm[d]) && !isVisited[crt[0]+dn[d]][crt[1]+dm[d]]) {
						if(mapClone[crt[0]+dn[d]][crt[1]+dm[d]]==3) {
							queue.add(new int[] {crt[0]+dn[d], crt[1]+dm[d]});
							isVisited[crt[0]+dn[d]][crt[1]+dm[d]]=true;
						}
						else if(mapClone[crt[0]+dn[d]][crt[1]+dm[d]]==1 || mapClone[crt[0]+dn[d]][crt[1]+dm[d]]==2) {
							for(int i=1; true; i++) {
								System.out.println(i + " " + (crt[0]+(dn[d]*i)) + " " + (crt[1]+(dm[d]*i)));
								if(!inRange(crt[0]+(dn[d]*i), crt[1]+(dm[d]*i))) {
									System.out.println("멈춰!");
									continue Loop;
								}
								if(mapClone[crt[0]+(dn[d]*i)][crt[1]+(dm[d]*i)]==3) {
									queue.add(new int[] {crt[0]+(dn[d]*i), crt[1]+(dm[d]*i)});
									isVisited[crt[0]+(dn[d]*i)][crt[1]+(dm[d]*i)]=true;
									System.out.println("멈춰!!");
									continue Loop;
								}
							}
						}
					}
				}
			}
			
			for(int n=0; n<N; n++) {
				System.out.println(Arrays.toString(isVisited[n]));
			}
			
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(mapClone[n][m]==3 && !isVisited[n][m]) {
						System.out.println("종료\n");
						return;
					}
					
				}
			}
			
			
			
			
			
			
			// 모두 방문한다면 다리 총 길이 세기.
			System.out.print("성공 : ");
			int totalBridgeLength=0;
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(mapClone[n][m]<3) {
						totalBridgeLength += mapClone[n][m];
					}
				}
			}
			System.out.println(totalBridgeLength);
			System.out.println();
			min = Math.min(min, totalBridgeLength);
			
			
			return;
		}
		
		isSelected[cnt] = false;
		subset(cnt+1);
		isSelected[cnt] = true;
		subset(cnt+1);		
	}
	
	public static boolean inRange(int n, int m) {
		if(n<0) return false;
		if(n>N-1) return false;
		if(m<0) return false;
		if(m>M-1) return false;
		return true;
	}
	
	public static int floodFill() {
		boolean[][] isVisited = new boolean[N][M];
		int IslandNum = 0;
		
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(map[n][m]==3 && !isVisited[n][m]) {
					Queue<int[]> queue = new ArrayDeque<>();
					queue.add(new int[] {n, m});
					isVisited[n][m]=true;
					IslandNum+=1;
					
					while(!queue.isEmpty()) {
						int[] crt = queue.poll();
						for(int d=0; d<4; d++) {
							if(inRange(crt[0]+dn[d], crt[1]+dm[d]) && map[crt[0]+dn[d]][crt[1]+dm[d]]==3 && !isVisited[crt[0]+dn[d]][crt[1]+dm[d]]) {
								queue.add(new int[] {crt[0]+dn[d], crt[1]+dm[d]});
								isVisited[crt[0]+dn[d]][crt[1]+dm[d]]=true;
							}
						}
					}
					
				}
			}
		}
		
		
		return IslandNum;
	}
}
