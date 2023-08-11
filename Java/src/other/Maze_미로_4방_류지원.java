package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.xml.sax.InputSource;

public class Maze_미로_4방_류지원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		// 테스트 케이스 입력
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			ST=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(ST.nextToken());			// 배열 크기 입력
			int[] sttLo=new int[2];		
			sttLo[0]=Integer.parseInt(ST.nextToken());		// 출발점 row 좌표 입력
			sttLo[1]=Integer.parseInt(ST.nextToken());		// 출발점 column 좌표 입력
			int JumperNum=Integer.parseInt(ST.nextToken());	// 점퍼 개수 입력
			int[][] JumperLoArr=new int[JumperNum][2];		// 점퍼 좌표 배열
			ST=new StringTokenizer(br.readLine());			// 점퍼 입력받기
			for(int i=0; i<JumperNum; i++) {				// 입력받은 점퍼 좌표 할당.
				JumperLoArr[i][0]=Integer.parseInt(ST.nextToken());
				JumperLoArr[i][1]=Integer.parseInt(ST.nextToken());
			}
			int directionNum=Integer.parseInt(br.readLine());	// 이동지시 개수
			ST=new StringTokenizer(br.readLine());
			int[][] moveCtrArr=new int[directionNum][2];
			for(int i=0; i<directionNum; i++) {
				moveCtrArr[i][0]=Integer.parseInt(ST.nextToken());
				moveCtrArr[i][1]=Integer.parseInt(ST.nextToken());
			}
			
			
			
			for(int i=0; i<JumperNum; i++) System.out.print(Arrays.toString(JumperLoArr[i]));
			System.out.println();
			for(int i=0; i<directionNum; i++) System.out.print(Arrays.toString(moveCtrArr[i]));
			
			
			
					
		}

	}

}
