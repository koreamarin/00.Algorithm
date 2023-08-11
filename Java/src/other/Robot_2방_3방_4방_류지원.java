package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 풀이방법 : 
 * 입력받은 map을 sweep하면서
 * A 또는 B 또는 C를 만나면
 * 각각의 이동할수 있는 거리를 계산하여
 * 그 거리를 합산하여 출력한다.
 */

public class Robot_2방_3방_4방_류지원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<T+1;t++) {
			int N=Integer.parseInt(br.readLine());	// N 입력받기
			char[][] map=new char[N][N];
			for(int i=0; i<N; i++) {	// map 입력받기
				ST=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) map[i][j]=ST.nextToken().charAt(0);
			}
			
			int sum=0;	// 이동거리를 합산할 변수
			// map을 sweep 하다가 A, B, C 로봇들을 만났을 때에 이동거리를 계산하여 그 이동거리를 합산하기.
			for(int i=0; i<N; i++) {	// map의 행을 sweep 하는 반복문
				for(int j=0; j<N; j++) {	// map의 열을 sweep하는 반복문
					if(map[i][j]=='A') {	// A를 만났을 때	
						for(int k=1; j+k<N && map[i][j+k]=='S'; k++) sum++;						
					} else if(map[i][j]=='B') {	// B를 만났을 때
						for(int k=1; j+k<N && map[i][j+k]=='S'; k++) sum++;
						for(int k=-1; j+k>=0 && map[i][j+k]=='S'; k--) sum++;
					} else if(map[i][j]=='C') {	// C를 만났을 때
						for(int k=1; j+k<N && map[i][j+k]=='S'; k++) sum++;
						for(int k=1; i+k<N && map[i+k][j]=='S'; k++) sum++;
						for(int k=-1; j+k>=0 && map[i][j+k]=='S'; k--) sum++;
						for(int k=-1; i+k>=0 && map[i+k][j]=='S'; k--) sum++;
					}
				}
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}
