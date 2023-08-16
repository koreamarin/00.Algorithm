package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_06987_월드컵_류지원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		StringBuilder SB=new StringBuilder();
		for(int t=0; t<4; t++) {
			ST=new StringTokenizer(br.readLine());
			int[][] team = new int[6][3];
			for(int i=0; i<6;i++) for(int j=0; j<3; j++) team[i][j]=Integer.parseInt(ST.nextToken());
			SB.append(valid(team)?"1 " : "0 ");
		}
		System.out.println(SB);
	}
	
	public static boolean valid(int[][] team) {
		// 승무패 합이 5가 맞는지?
		for(int i=0; i<6; i++) {
			int sum=0;
			for(int j=0; j<3; j++) sum+=team[i][j];
			if(sum!=5) {
				System.out.println(1);
				return false;
			}
		}

		// 승-패 = 0 나오는지?
//		int sum=0;
//		for(int i=0; i<6; i++) sum+=(team[i][0]-team[i][2]);
//		if(sum!=0) {
//			System.out.println(2);
//			return false;
//		}
		// 내림차순으로 정렬된 승리수만큼 1씩 sweep하며 1씩 패배를 뺄 수 없다면 false 반환
		int[] Win=new int[6];
		
		
		int[] Lose=new int[6];
		for(int i=0; i<6; i++) {
			Win[i]=team[i][0];
			Lose[i]=team[i][2];
		}
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<Win[i]; j++) {
				int LoseMax=0;
				for(int k=0; k<6; k++) {
					if(k!=i) {
						if(LoseMax<Lose[k]) LoseMax=Lose[k];
					}
				}
				System.out.println(j+" " + LoseMax);
				for(int k=0; k<6; k++) {
					if(k!=i) {
						if(LoseMax==Lose[k]) {
							Lose[k]--;
							System.out.println(i + " " + Arrays.toString(Lose));
						}
					}
				}
			}
		}
		System.out.println(Arrays.toString(Lose));
	
		
		
		

//		// 최대 승리 수와 패배를 경험한 팀 수가 같은지?
//		int WinMax=0;
//		int WinExpTeam=0;
//		for(int i=0; i<6; i++) {
//			if(WinMax<team[i][0]) WinMax=team[i][0];
//			if(team[i][2]!=0) WinExpTeam++;
//		}
//		if(WinMax!=WinExpTeam) {
//			System.out.println(3);
//			System.out.println(WinMax + " " + WinExpTeam);
//			return false;
//		}
//		
//		// 최대 패배 수와 승리를 경험한 팀 수가 같은지?
//		int LoseMax=0;
//		int LoseExpTeam=0;
//		for(int i=0; i<6; i++) {
//			if(LoseMax<team[i][2]) LoseMax=team[i][2];
//			if(team[i][0]!=0) LoseExpTeam++;
//		}
//		if(LoseMax!=LoseExpTeam) {
//			System.out.println(4);
//			return false;
//		}
		
		
		
		
		// 내림차순으로 정렬된 무승부 수만큼 1씩 sweep하며 무승부를 땐 뒤에 마지막에 모두 0이 아니면
		

		

		
		return true;	// 다 통과했으면 true
	}
}
