package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 1. 성능검사 통과 메서드
 * 2. 약품 투입 (조합별로)
 * 3. 조합끝까지 성능검사 통과 못할 시 투입횟수 올리기.
 */

public class SW_02112_보호필름_류지원 {
	static int[] numbers;
	static int D, W, K;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<T+1; t++) {
			ST=new StringTokenizer(br.readLine());
			D = Integer.parseInt(ST.nextToken());	// 보호필름의 두께 
			W = Integer.parseInt(ST.nextToken());	// 보호필름 가로 크기
			K = Integer.parseInt(ST.nextToken());	// 합격 기준
			
			map = new boolean[D][W];
			
			for(int d=0; d<D; d++) {
				ST = new StringTokenizer(br.readLine());
				for(int w=0; w<W; w++) {
					if(ST.nextToken().equals("1")) {
						map[d][w]=true;
					}
				}
			}
			
			if(inspection(map)) {
				System.out.println(0);
				return;
			}
			
			
//			for(int n=2; true; n++) {
//				// n개의 막을 고르는 조합
//					// 모든 조합 경우의 수에서 mapClone이 성능검사를 통과하는지 확인
//						// 통과한다면 n을 출력하고 종료.
//						// 통과하지 못한다면 반복문 계속하여 n에 1 추가하고 계속
//					
//				
//				
//			}
			
			
			
			
			numbers = new int[2];
//			combination(0, 0, 2);
			
			
			
			
			
		}
		

	}
	
	public static boolean[][] test() {
		boolean[][] mapClone = new boolean[D][];
		for(int d=0; d<D; d++) {
			mapClone[d]=Arrays.copyOf(map[d], W);
		}
		
		for(int i=0; i<numbers.length; i++) {
			Arrays.fill(mapClone[numbers[i]], true); 
		}
		
		
		
		
		
		
		return mapClone;
		
		
		
		
	}
	
	public static void combination(int cnt, int stt, int n) {
		if(cnt==n) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=stt; i<D; i++) {
			numbers[cnt]=i;
			combination(cnt+1, i+1, n);
		}
	}
	
	public static boolean inspection( boolean[][] map) {
		boolean[] inspection = new boolean[W];
		for(int w=0; w<W; w++) {
			int stack = K-1;
			for(int d=0; d<D-1; d++) {
				if(map[d][w] == map[d+1][w]) {
					if(--stack==0) {
						inspection[w]=true;
						break;
					}
				}
				else if(map[d][w] != map[d+1][w]) {
					stack=K-1;
				}
			}
		}
		
		for(int w=0; w<W; w++) {
			if(!inspection[w]) {
				return false;
			}
		}
		
		return true;
	}
}
