package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 문제 : SWEA D2 2001 파리퇴치
 *
 * 메모리 사용량 : 18700kb
 * 처리 시간 : 104ms
 *
 * 풀이 방식 :
 * 배열에 파리 개수를 입력받아 값을 적어 놓은 뒤
 * M*M 구간의 파리의 합을 리스트에 넣는다.
 * M*M크기로 방의 모든 구간을 sweep한 후
 * 리스트에 있는 최대값을 출력하면 끝
 */

public class D2_02001_파리퇴치_류지원 {
    public static void main(String[] args) throws IOException {
        // 키보드로부터 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 구분자로 구분되는 String을 자동으로 나눠주는 StringTokennizer 인스턴스 선언.
        StringTokenizer ST;

        // 첫째줄. T에 테스트케이스 입력받기
        int T = Integer.parseInt(br.readLine());
        // 테이스케이스만큼 반복하는 반복문
        for(int t=1;t<T+1;t++) {
            // 둘째줄. N, M입력받기
            ST = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(ST.nextToken());   // StringTokenizer에서 첫번쨰 토큰을 빼와 N에 저장
            int M = Integer.parseInt(ST.nextToken());   // StringTokenizer에서 두번쨰 토큰을 빼와 M에 저장

            // 셋째줄. N번쨰 줄에 거쳐 배열값 입력받기.
            int[][] arr= new int[N][N];     // 이차원 정수형배열 arr 선언 및 N*N 크기로 생성
            for(int i=0;i<N;i++) {          // N번 반복하는 반복문
                ST = new StringTokenizer(br.readLine());    // 문자열을 StringTokenizer로 받음.
                // StringTokenizer에서 토큰을 빼와 arr의 원소값으로 저장
                for(int j=0;j<N;j++) arr[i][j]=Integer.parseInt(ST.nextToken());
            }
            // 정수를 인덱스로 받는 리스트 선언
            ArrayList<Integer> SumList = new ArrayList<Integer>();
            for(int i=0;i<N-M+1;i++) {  // arr의 행을 sweep 할 반복문 실행
                for(int j=0;j<N-M+1;j++) {  // arr의 열을 sweep 할 반복문 실행
                    int sum=0;              // 파리채에 죽은 파리를 모두 더해 저장하기 위한 변수
                    for(int vi=0;vi<M;vi++) {   // M*M 위치 탐색. M*M 구간의 행을 sweep한다.
                        for(int vj=0;vj<M;vj++) {   // M*M 위치 탐색. M*M 구간의 열을 sweep한다.
                            sum += arr[i + vi][j + vj]; // 방 안에 있는 M*M 구간의 파리를 모두 더해 sum에 저장
                        }
                    }
                    SumList.add(sum);   // M*M 구간의 파리들의 수를 모두 더한 값 sum을 리스트에 추가.
                }
            }
            int max=0;      // sum에 있는 가장 큰 값을 찾기위해 max 정수형변수 선언
            // 리스트의 인덱스를 하나씩 탐색 및 max보다 인덱스값이 더 크다면 max에 인덱스값 저장.
            for (Integer n : SumList) if(n>max) max=n;
            // 테스트케이스와 max값 출력
            System.out.println("#" + t + " " + max);
        }
    }
}

/*
T=int(input())
for t in range(1, T+1):
    N, M = map(int, input().split())
    MAP = []
    for n in range(N):
        MAP.append(list(map(int, input().split())))

    sum_list=[]
    for y in range(N-M+1):
        for x in range(N-M+1):
            sum=0
            for vx in range(M):
                for vy in range(M):
                    sum+=MAP[y+vy][x+vx]
            sum_list.append(sum)

    print(f'#{t} {max(sum_list)}')
 */