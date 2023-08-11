package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author 류지원
 * 메모리 : 72668KB
 * 시간 : 408ms
 * 풀이방법 :
 * 주어진 회전 연산을 순서를 섞어서 배열 출력의 최소값을 찾으려고 하였다.
 * 순서를 섞기 위해서 순열을 사용하여 순서를 섞었으며,
 * 배열을 회전시킬때는 단순구현도 가능하지만 재귀를 사용해서 배열을 회전시켜보았다.
 */
public class BJ_17406_배열돌리기4_류지원 {
    static int[][] arr; static int[][] copyArr; static int[][] partArr;
    static int N; static int M; static int K;
    static boolean[] isSelected; static int[] numbers; static ArrayList<int[]> permutationArr=new ArrayList<>();
    static int PN; static int PM;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫번쨰 입력, N, M, K
        StringTokenizer ST=new StringTokenizer(br.readLine());
        N=Integer.parseInt(ST.nextToken()); M=Integer.parseInt(ST.nextToken()); K=Integer.parseInt(ST.nextToken());
        isSelected = new boolean[K]; numbers = new int[K];

        // 두번쨰 입력, 배열 값 입력
        arr=new int[N][M];
        for(int i=0; i<N;i++) {
            ST=new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) arr[i][j]=Integer.parseInt(ST.nextToken());
        }
        // 세번째 입력, K횟수만큼 회전 연산 입력받기.
        int[][] calArr=new int[K][3];
        for(int i=0; i<K; i++){
            ST=new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) calArr[i][j]=Integer.parseInt(ST.nextToken());
        }
        NM(0);  // 회전연산의 순열 경우의 수 구하기.

        ArrayList<Integer> minList = new ArrayList<>(); // 각 순열에서 회전연산을 한 후 나오는 arr의 출력값을 저장하는 리스트

        for(int[] permutation : permutationArr) {
            copyArr = new int[N][];
            for(int i=0; i<N; i++) copyArr[i]=Arrays.copyOf(arr[i], M);
            for (int i = 0; i < K; i++) CRotation(calArr[permutation[i]][0], calArr[permutation[i]][1], calArr[permutation[i]][2]);
            minList.add(ArrPrint());                    // arr 출력값 리스트에 추가.
        }
        int minValue=Integer.MAX_VALUE;
        for(int min:minList) if(minValue>min) minValue=min;
        System.out.print(minValue);
    }
    public static void CRotation(int r, int c, int s) {		// partArr 생성/할당, 회전 지시, copyarr의 해당 부위를 partArr에 붙여넣기
        int T=r-s-1; int L=c-s-1; int B=r+s-1; int R=c+s-1;
        partArr=new int[B-T+1][R-L+1];
        for(int i=T; i<B+1; i++) partArr[i-T]=Arrays.copyOfRange(copyArr[i], L, R+1);
        PN=B-T+1; PM=R-L+1;
        int G = (PN>PM) ? PM/2 : PN/2;				    // 회전할 껍질 개수
        Rotation(G, 0);	// 회전 1회 해주는 함수를 돌려야하는 횟수만큼 재실행
        for(int i=0; i<B-T+1; i++) for(int j=0; j<R-L+1; j++) copyArr[T+i][L+j]=partArr[i][j];
    }
    public static void Rotation(int G, int cnt) {	// arr는 회전할 배열, G는 껍질 넘버. cnt는 회전할 최외각 껍질에서 안쪽으로 세는 껍질 넘버(?)
        if(cnt==G) return; 			// 기저 조건
        int save = partArr[cnt][cnt];	// arr[cnt][cnt]는 덮어씌워져 사라질수 있으므로 따로 빼놓음.
        for(int i=cnt; i<PN-cnt-1; i++) partArr[i][cnt]=partArr[i+1][cnt];              // 서쪽 껍질 회전
        for(int j=cnt; j<PM-cnt-1; j++) partArr[PN-cnt-1][j]=partArr[PN-cnt-1][j+1];    // 남쪽 껍질 회전
        for(int i=PN-cnt-1; i>cnt; i--) partArr[i][PM-cnt-1]=partArr[i-1][PM-cnt-1];    // 동쪽 껍질 회전
        for(int j=PM-cnt-1; j>cnt+1; j--) partArr[cnt][j]=partArr[cnt][j-1];            // 북쪽 껍질 회전
        partArr[cnt][cnt+1]=save;	// 마지막 회전할 원소는 따로 저장해놓았던 save값 할당.
        Rotation(G, cnt+1);		// 다음 껍질 회전 실행. 재귀.
    }
    public static int ArrPrint(){
        int[] minArr = new int[N];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<N;i++) for(int j=0;j<M;j++) minArr[i]+=copyArr[i][j];
        for(int i=0;i<N;i++) if(min>minArr[i]) min=minArr[i];
        return min;
    }
    public static void NM(int cnt) {	// NM함수는 M개의 숫자 순열 번호들을 찾아주는 함수이다. cnt는 cnt번째 숫자를 탐색함을 의미한다.
        if(cnt==K) {	// 기저조건. cnt가 M이면 다 찾은 것이므로 지금까지 찾은 순열조합을 출력 한 후 리턴.
            permutationArr.add(Arrays.copyOf(numbers, K));
            return;	// 리턴
        }
        // 유도 파트
        for(int i=0; i<K; i++) {	// i를 0부터 N까지 sweep하며 반복작업을 하는 함수.
            if(isSelected[i]==false) {		// isSelected[i]가 false라면 i는 이전에 사용하지 않은 정수이므로 구현부 실행
                numbers[cnt]=i;			// numbers[cnt]에 i를 입력
                isSelected[i]=true;		// isSelected[i]에 true 입력하여 사용하는  번호임을 표시
                NM(cnt+1);				// cnt에 1을 추가하여 NM을 호출함으로서 다음 자리수를 찾는 재귀 시작
                isSelected[i]=false;	// 현재 자리수에 대한 모든 번호을 찾았다면 다음 번호로 넘어가기 위해 현재 자리수는 사용하지 않는 다는 뜻으로
                // false를 입력
            }
        }
    }
}
