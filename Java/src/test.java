import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		int N = Integer.parseInt(br.readLine());
		int[][] PreferARR = new int[N*N][5];
		int[][] map = new int[N][N];
		
		for(int i=0; i<N*N; i++) {
			ST=new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) PreferARR[i][j]=Integer.parseInt(ST.nextToken());
		}		
		
		for(int k=0; k<N*N; k++) {
			int[] Student = PreferARR[k];
			int friendNumMax=0;
			int emptyNumMax = 0;
			
			int[] lo = null;
			
			Loop :
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==0) {
						lo=new int[] {i,j};
						break Loop;
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int friendNum = 0;
					int emptyNum = 0;
					if(map[i][j]==0) {
						if(i>0) {
							if(map[i-1][j]!=0) 		
								for(int l=1; l<5; l++) if(Student[l]==map[i-1][j]) friendNum++;	// 위쪽에 친구가 있으면

							else if(map[i-1][j]==0) 
								emptyNum++;														// 위쪽이 비어있으면

						}
						
						if(i<N-1) {
							if(map[i+1][j]!=0) 		{
								for(int l=1; l<5; l++) if(Student[l]==map[i+1][j]) friendNum++;	// 아래쪽에 친구가 있으면
							}
							else if(map[i+1][j]==0) {
								emptyNum++;														// 아래쪽이 비어있으면
							}
						}
						
						if(j>0) {
							if(map[i][j-1]!=0) 		{
								for(int l=1; l<5; l++) if(Student[l]==map[i][j-1]) friendNum++;	// 왼쪽에 친구가 있으면
							}
							else if(map[i][j-1]==0) {
								emptyNum++;														// 왼쪽이 비어있으면
							}
						}
						
						if(j<N-1) {
							if(map[i][j+1]!=0) 		{
								for(int l=1; l<5; l++) if(Student[l]==map[i][j+1]) friendNum++;	// 오른쪽에 친구가 있으면
							}
							else if(map[i][j+1]==0) {
								emptyNum++;														// 오른쪽이 비어있으면
							}
						}
					}
				
					
					if(friendNumMax<friendNum) {
						friendNumMax=friendNum;
						emptyNumMax=emptyNum;
						
						lo=new int[] {i,j};
					}
					else if(friendNumMax==friendNum) {
						if(emptyNumMax<emptyNum) {
							emptyNumMax=emptyNum;
							lo=new int[] {i,j};
						}
					}
					
				}
			}
			map[lo[0]][lo[1]]=Student[0];
			
			
		}
			
		int satisfactionTotal = 0;
		
		// 만족도 구하기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int[] Student = new int[5];
				Loop1 :
				for(int k=0; k<N*N;  k++) {
					if(PreferARR[k][0]==map[i][j]) {
						Student = PreferARR[k];
						break Loop1;
					}
				}
				
				int satisfaction = 0;
				
				if(i>0) {
					for(int l=1; l<5; l++) {
						if(Student[l]==map[i-1][j]) {
							satisfaction++;	
							break;
						}
					}
				}
				
				if(i<N-1) {
					for(int l=1; l<5; l++) {
						if(Student[l]==map[i+1][j]) {
							satisfaction++;	
							break;
						}
					}
				}
				
				if(j>0) {
					for(int l=1; l<5; l++) {
						if(Student[l]==map[i][j-1]) {
							satisfaction++;	
							break;
						}
					}
				}
				
				if(j<N-1) {
					for(int l=1; l<5; l++) {
						if(Student[l]==map[i][j+1]) {
							satisfaction++;	
							break;
						}
					}
				}
				
				if(satisfaction==4) satisfactionTotal+=1000;
				else if(satisfaction==3) satisfactionTotal+=100;
				else if(satisfaction==2) satisfactionTotal+=10;
				else if(satisfaction==1) satisfactionTotal+=1;
			}
		}
		System.out.println(satisfactionTotal);
	}
}