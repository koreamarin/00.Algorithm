package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 메모리 :14504KB
 * 시간 : 184ms
 * 풀이방식:
 * 1. 조합으로 치킨집들을 M개수만큼 고른다.,
 * 2. 조합의 경우에서 치킨집과 집까지의 치킨거리를 구한 후, 모두 더하여 도시의 치킨거리를 구한다.
 * 3. 위 과정을 모든 조합의 경우에서 반복하여 모든 조합에서의 도시의 치킨거리를 구한다.
 * 4. 모든 조합에서 도시의 치킨거리중에서 가장 작은 도시의 치킨거리를 출력한다.
 *
 */
public class BJ_15686_치킨배달_류지원 {
	static int M; static int CKNum; static int houseNum;
	static boolean[] isSelected;
	static int[] numbers; static ArrayList<int[]> Combination=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(ST.nextToken()); M=Integer.parseInt(ST.nextToken());
		numbers=new int[M];
		int[][] map=new int[N][N];	// 맵 정보 배열
		CKNum=0;					// 치킨집 개수
		houseNum=0;					// 일반집 개수
		for(int i=0; i<N; i++) {	// 배열 입력 받기
			ST=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(ST.nextToken());
				if(map[i][j]==2) CKNum++;
				else if(map[i][j]==1) houseNum++; 
			}
		}
		isSelected=new boolean[CKNum];
		// 치킨집 위치 골라서 배열에 넣기.
		int[][] CKLoArr=new int[CKNum][2];	// 치킨집 위치 정보 배열
		int[][] houseLoArr=new int[houseNum][2];	// 치킨집 위치 정보 배열
		int k1=0;
		int k2=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==2) {
					CKLoArr[k1][0]=i; CKLoArr[k1][1]=j;
					k1++;
				} else if(map[i][j]==1) {
					houseLoArr[k2][0]=i; houseLoArr[k2][1]=j;
					k2++;
				}
			}
		}
		Combination(0);
		int[] chickenStr=new int[Combination.size()];
		for(int[] houseLo : houseLoArr) {
//			System.out.println("집 위치 : " + Arrays.toString(houseLo));
			for(int i=0; i<Combination.size(); i++) {
				int min=Integer.MAX_VALUE;
				for(int n=0; n<M; n++) {
					int cm=(Math.abs(houseLo[0]-CKLoArr[Combination.get(i)[n]][0])+ Math.abs(houseLo[1]-CKLoArr[Combination.get(i)[n]][1]));
//					System.out.print("치킨집"+(n+1)+"위치 : " + Arrays.toString(CKLoArr[Combinate[n]]) + "  ");
//					System.out.print("치킨집"+(n+1)+"거리 : " + cm+"          ");
					if(min>cm) min=cm;
				}
//				System.out.println("치킨거리 : " + min);
				chickenStr[i]+=min;
			}
//			System.out.println();
		}
		int min=Integer.MAX_VALUE;
		for(int i=0; i<Combination.size(); i++) {
			if(min>chickenStr[i]) min=chickenStr[i];
		}
		System.out.println(min);
	}
	
	public static void Combination(int cnt) {
		if(cnt==M) {
			Combination.add(Arrays.copyOf(numbers, M));
			return;
		}
		for(int i=0; i<CKNum; i++) {
			if(!isSelected[i] && (cnt==0 ||(cnt>0 && numbers[cnt-1]<i))) {
				numbers[cnt]=i;
				isSelected[i]=true;
				Combination(cnt+1);
				isSelected[i]=false;
			}
		}
	}
}
