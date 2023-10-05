package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SW_02382_미생물격리_류지원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<T+1; t++) {
			ST=new StringTokenizer(br.readLine());
			int N = Integer.parseInt(ST.nextToken());	// 정사각형 구역 한 변의 길이
			int M = Integer.parseInt(ST.nextToken());	// 격리 시간
			int K = Integer.parseInt(ST.nextToken());	// 미생물 군집의 개수
			
			List<int[]> cellInfoList = new ArrayList<>();
			// 미생물 위치, 군집크기, 이동방향 정보 입력받기
			for(int k=0; k<K; k++) {
				ST=new StringTokenizer(br.readLine());
				int[] cellInfo = new int[4];
				for(int i=0; i<4; i++) {
					cellInfo[i]=Integer.parseInt(ST.nextToken());
				}
				cellInfoList.add(cellInfo);
				
			}
			
			Show(cellInfoList, N ,K);
			
			for(int m=0; m<M; m++) {
				// 모든 미생물 이동 
				for(int k=0; k<cellInfoList.size(); k++) {
					int[] cellInfo = cellInfoList.get(k);
					if(cellInfo[3]==1) {		// 상
						cellInfo[0]-=1;
					} else if(cellInfo[3]==2) {	// 하
						cellInfo[0]+=1;
					} else if(cellInfo[3]==3) {	// 좌
						cellInfo[1]-=1;
					} else if(cellInfo[3]==4) {	// 우
						cellInfo[1]+=1;
					}
				}
				
				// 행이나 열이 0 또는 N이면 미생물이 절반으로 감소하고 이동방향이 반대가 됨
				for(int k=cellInfoList.size()-1; k>=0; k--) {
					int[] cellInfo = cellInfoList.get(k);
					// 행이나 열이 0 또는 N이면 미생물이 절반으로 감소하고 이동방향이 반대가 됨
					if(cellInfo[0]==0 || cellInfo[0]==N-1 
							|| cellInfo[1]==0 || cellInfo[1]==N-1) {
						cellInfo[2]=cellInfo[2]/2;		// 미생물 수 절반으로 감소
						if(cellInfo[3]==1) cellInfo[3]=2;		// 이동방향 반대로 변경
						else if(cellInfo[3]==2) cellInfo[3]=1;
						else if(cellInfo[3]==3) cellInfo[3]=4;
						else if(cellInfo[3]==4) cellInfo[3]=3;
					}
				}
				
				// 군집이 같은 곳에 있다면 미생물 수가 큰 쪽에 합쳐짐
				for(int k=cellInfoList.size()-1; k>=0; k--) {
					for(int i=0; i<cellInfoList.size(); i++) {
						if(k!=i) {
							int[] cellInfo1 = cellInfoList.get(k);
							int[] cellInfo2 = cellInfoList.get(i);
							
							if(cellInfo1[0]==cellInfo2[0] && cellInfo1[1]==cellInfo2[1]) {
								 if(cellInfo1[2]>cellInfo2[2]) {
									 cellInfo1[2]+=cellInfo2[2];
									 cellInfoList.remove(i);
								 } else if(cellInfo2[2]>cellInfo1[2]) {
									 cellInfo2[2]+=cellInfo1[2];
									 cellInfoList.remove(k);
								 }
							}
						}
						
					}
				}
				System.out.println(m+1 + "번째 이동");
				Show(cellInfoList, N ,K);
			}
			int sum=0;
			for(int k=0; k<cellInfoList.size(); k++) {
				int[] cellInfo = cellInfoList.get(k);
				sum+=cellInfo[2];
			}
			System.out.println("#"+ t + " " + sum);
				

				
			
			
			
			
			
			
		}

	}
	
	public static void Show(List<int[]> cellInfoList, int N, int K) {
		System.out.println("미생물 위치 표");
		for(int[] cellInfo : cellInfoList) {
			System.out.println(Arrays.toString(cellInfo));
		}
		
		System.out.println("구역 내 미생물 배치 현황");
		int[][] map = new int[N][N];
		
		for(int k=0; k<cellInfoList.size(); k++) {
			int[] cellInfo = cellInfoList.get(k);
			map[cellInfo[0]][cellInfo[1]]=cellInfo[2];
		}
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

}
