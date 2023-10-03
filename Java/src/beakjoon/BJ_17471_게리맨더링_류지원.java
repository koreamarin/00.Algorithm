package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 18424KB
 * 시간 : 176ms
 * 풀이방법 : 
 * 1. 부분집합을 이용하여 선거구들을 나눈다.
 * 2. 선거구들이 하나의 지역구로 묶이는지 서로소집합을 이용하여 이어진 지역구들은 하나의 집합으로 만든다.
 * 3. 2번과정을 거쳐서 지역구들을 하나의 선거구로 묶는게 가능하다면 A구역과 B구역의 인구수차를 구한다.
 * 4. 3번 과정에서 나온 인구수차의 최소값을 뽑는다. 
 */

public class BJ_17471_게리맨더링_류지원 {
	static int N;
	static int[] parents;
	static boolean[] isSelected;
	static List[] list;
	static int min=Integer.MAX_VALUE;
	static int[] popul;
	
	
	public static void make() {
		parents=new int[N+1];
		for(int i=1; i<N+1; i++) parents[i]=i;
	}
	
	public static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) return false;
		parents[bRoot]=aRoot;
		return true;
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		N = Integer.parseInt(br.readLine());		// 구역의 개수
		
		popul = new int[N];					// 각 구역별 인구수
		ST=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) popul[i]=Integer.parseInt(ST.nextToken());
		
		isSelected=new boolean[N];
		
		// 인접리스트
		list = new List[N];
		for(int i=0; i<N; i++) {
			List<Integer> l = new ArrayList<>();
			ST = new StringTokenizer(br.readLine());
			ST.nextToken();
			while(ST.countTokens()!=0) l.add(Integer.parseInt(ST.nextToken()));
			list[i]=l;
		}
		
		//////////////////////여기까지 입력받기///////////////////
		// 부분집합
		subset(0);
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);	
	}
	
	public static void subset(int cnt) {
		// 기저조건
		if(cnt==N) {
			if(!subsetValid()) {
				List<Integer> A = new ArrayList<Integer>();
				List<Integer> B = new ArrayList<Integer>();
				for(int i=0; i<N; i++) {
					if(isSelected[i]) A.add(i+1);
					else if(!isSelected[i]) B.add(i+1);
				}
				
				make();
				
				// A지역구를 순환하며 A에 해당하는 인접리스트끼리 묶는 용도의 반복문
				for(int a : A) {
					for(int i=0; i<list[a-1].size(); i++) {
						for(int aa:A) {
							if(list[a-1].get(i).equals(aa)) {
								union(a,aa);	// 합집합 처리
							}
						}
					}
				}
				// A끼리 잘 묶였는지 확인하는 구문. 같은 집합인지 확인
				int aRoot = find(A.get(0));
				for(int a : A) {
					if(aRoot!=find(parents[a])) {
						return;			// 같은 집합이 아니면 해당 부분집합은 종료
					}
				}
				
				
				// B지역구를 순환하며 B에 해당하는 인접리스트끼리 묶는 용도의 반복문
				for(int b : B) {
					for(int i=0; i<list[b-1].size(); i++) {
						for(int bb:B) {
							if(list[b-1].get(i).equals(bb)) {
								union(b,bb);	// 합집합 처리
							}
						}
					}
				}
				// B끼리 잘 묶였는지 확인하는 구문. 
				int bRoot = find(B.get(0));
				for(int b : B) {
					if(bRoot!=find(parents[b])) {
						return;			// 같은 집합이 아니면 해당 부분집합은 종료
					}
				}
				
				int sub;
				int APopul = 0;
				int BPopul = 0;
				for(int a : A) APopul += popul[a-1];
				for(int b : B) BPopul += popul[b-1];
				sub=Math.abs(APopul-BPopul);
				if(min>sub) min=sub;
			}
			return;
		}
		
		// 운용조건
		isSelected[cnt]=true;
		subset(cnt+1);
		isSelected[cnt]=false;
		subset(cnt+1);
	}
	
	public static boolean subsetValid() {
		for(int i=1; i<N; i++) if(isSelected[0]!=isSelected[i]) return false;
		return true;
	}
}
