package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 44844kb
 * 시간 : 1256ms
 * 각 미생물의 위치와 군집의 크기, 이동방향을 담은 미생물정보 객체를 생성하였다.
 * 그 후, 미생물이 한 턴마다 이동방향으로 미생물을 움직이면서 만약 가장자기에 닿는다면 미생물의 개수를 절반으로 줄이고 이동방향을 반대방향으로 바꿨다.
 * 미생물이 같은 위치에 있다면 미생물을 하나로 합하였다.
 * 합하는 과정에서 3개 이상의 미생물이 합해질 떄 오류가 발생하였는데
 * a,b,c 군집을 합하는 과정에서 c가 가장 큰 군집임에도 불구하고 a,b를 먼저 합하는 과정에서 a+b군집이 c보다 커져버려 a+b군집의 이동방향을 따라가버리는 오류가 있었다.
 * 이를 해결하기 위해 군집크기의 내림차순으로 정렬하여 c 군집부터 합하도록 만들어서 오류를 해결하였다.
 */
public class SW_02382_미생물격리_류지원 {
	public static class cellInfo implements Comparable<cellInfo> {
		private int i, j, n, d;

		public cellInfo(int i, int j, int n, int d) {
			super();
			this.i = i;
			this.j = j;
			this.n = n;
			this.d = d;
		}

		@Override
		public int compareTo(cellInfo o) {
			if(o.n < n) {
				return 1;
			} else if(o.n > n) {
				return -1;
			}
			return 0;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("cellInfo 위치(");
			builder.append(i);
			builder.append(".");
			builder.append(j);
			builder.append("), 군집크기(");
			builder.append(n);
			builder.append(") 이동방향(");
			builder.append(d);
			builder.append(")");
			return builder.toString();
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<T+1; t++) {
			ST=new StringTokenizer(br.readLine());
			int N = Integer.parseInt(ST.nextToken());	// 정사각형 구역 한 변의 길이
			int M = Integer.parseInt(ST.nextToken());	// 격리 시간
			int K = Integer.parseInt(ST.nextToken());	// 미생물 군집의 개수
			
			List<cellInfo> cellInfoList = new ArrayList<>();
			// 미생물 위치, 군집크기, 이동방향 정보 입력받기
			for(int k=0; k<K; k++) {
				ST=new StringTokenizer(br.readLine());
				int i = Integer.parseInt(ST.nextToken());
				int j = Integer.parseInt(ST.nextToken());
				int n = Integer.parseInt(ST.nextToken());
				int d = Integer.parseInt(ST.nextToken());
				cellInfo cellInfo = new cellInfo(i,j,n,d);
				cellInfoList.add(cellInfo);
			}
			
//			Show(cellInfoList, N ,K);
			
			Collections.sort(cellInfoList, Collections.reverseOrder());
			
			for(int m=0; m<M; m++) {
				// 모든 미생물 이동 
				for(int k=0; k<cellInfoList.size(); k++) {
					cellInfo cellInfo = cellInfoList.get(k);
					if(cellInfo.d==1) {		// 상
						cellInfo.i-=1;
					} else if(cellInfo.d==2) {	// 하
						cellInfo.i+=1;
					} else if(cellInfo.d==3) {	// 좌
						cellInfo.j-=1;
					} else if(cellInfo.d==4) {	// 우
						cellInfo.j+=1;
					}
				}
				
				// 행이나 열이 0 또는 N이면 미생물이 절반으로 감소하고 이동방향이 반대가 됨
				for(int k=0; k<cellInfoList.size(); k++) {
					cellInfo cellInfo = cellInfoList.get(k);
					// 행이나 열이 0 또는 N이면 미생물이 절반으로 감소하고 이동방향이 반대가 됨
					if(cellInfo.i==0 || cellInfo.i==N-1 
							|| cellInfo.j==0 || cellInfo.j==N-1) {
						cellInfo.n=cellInfo.n/2;		// 미생물 수 절반으로 감소
						if(cellInfo.d==1) cellInfo.d=2;		// 이동방향 반대로 변경
						else if(cellInfo.d==2) cellInfo.d=1;
						else if(cellInfo.d==3) cellInfo.d=4;
						else if(cellInfo.d==4) cellInfo.d=3;
					}
				}
				
				// 군집이 같은 곳에 있다면 미생물 수가 큰 쪽에 합쳐짐
				for(int k=0; k<cellInfoList.size(); k++) {
					for(int i=0; i<cellInfoList.size(); i++) {
						if(k!=i) {
							cellInfo cellInfo1 = cellInfoList.get(k);
							cellInfo cellInfo2 = cellInfoList.get(i);
							
							if(cellInfo1.i==cellInfo2.i && cellInfo1.j==cellInfo2.j) {
								 if(cellInfo1.n>cellInfo2.n) {
									 cellInfo1.n+=cellInfo2.n;
									 cellInfoList.remove(i);
								 } else if(cellInfo2.n>cellInfo1.n) {
									 cellInfo2.n+=cellInfo1.n;
									 cellInfoList.remove(k);
								 }
							}
						}
						
					}
				}
//				System.out.println(m+1 + "번째 이동");
//				Show(cellInfoList, N ,K);
			}
			int sum=0;
			for(int k=0; k<cellInfoList.size(); k++) {
				cellInfo cellInfo = cellInfoList.get(k);
				sum+=cellInfo.n;
			}
			System.out.println("#"+ t + " " + sum);
			
		}

	}
	
	public static void Show(List<cellInfo> cellInfoList, int N, int K) {
		System.out.println("미생물 위치 표");
		for(cellInfo cellInfo : cellInfoList) {
			System.out.println(cellInfo);
		}
		
		System.out.println("구역 내 미생물 배치 현황");
		String[][] map = new String[N][N];
		for(int i=0; i<N; i++) Arrays.fill(map[i], "0");
		
		for(int k=0; k<cellInfoList.size(); k++) {
			cellInfo cellInfo = cellInfoList.get(k);
			map[cellInfo.i][cellInfo.j]=String.valueOf(cellInfo.n);
			if(cellInfo.d==1) map[cellInfo.i][cellInfo.j]+="^";
			else if(cellInfo.d==2) map[cellInfo.i][cellInfo.j]+="v";
			else if(cellInfo.d==3) map[cellInfo.i][cellInfo.j]+="<";
			else if(cellInfo.d==4) map[cellInfo.i][cellInfo.j]+=">";
					
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		
		int sum=0;
		for(int k=0; k<cellInfoList.size(); k++) {
			cellInfo cellInfo = cellInfoList.get(k);
			sum+=cellInfo.n;
		}
		System.out.println("총 " + sum + "마리");
		System.out.println();
	}

}
