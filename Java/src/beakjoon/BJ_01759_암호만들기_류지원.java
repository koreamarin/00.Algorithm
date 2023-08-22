package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 12388KB
 * 시간 : 112ms
 * 풀이방법 :
 * 조합문제이다. 받은 알파벳들을 오름차순으로 정렬 한 뒤, C개의 문자를 뽑았다.
 * 그 후, 뽑은 알파벳들에 자음2개 이상과, 모음 1개 이상이 있다면 그 알파벳들을 출력하였다.
 */

public class BJ_01759_암호만들기_류지원 {
    static char[] numbers, arr, vowels={'a','e','i','o','u'}; static boolean[] isSelected;
    static int L, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST=new StringTokenizer(br.readLine());
        L=Integer.parseInt(ST.nextToken()); C=Integer.parseInt(ST.nextToken());
        arr=new char[C]; numbers=new char[L]; isSelected=new boolean[C];
        ST=new StringTokenizer(br.readLine()); for(int i=0; i<C; i++) arr[i]=ST.nextToken().charAt(0);
        Arrays.sort(arr);   // 받은 알파벳들 정렬
        combination(0); // 조합시작
    }
    public static void combination(int cnt) {
        if(cnt==L) {    // 기저조건. cnt가 L이면 L개의 원소를 고른것이므로 기저조건을 실행한다.
            int vowelsNum=0;    // 모음의 개수를 저장할 변수.
            for(char num : numbers) for(char vowel : vowels) if(num == vowel) vowelsNum++;  // vowel에 들어있는 원소이면 모음이므로 vowelsNum을 1씩 증가
            if(vowelsNum >= 1 && L-vowelsNum >= 2) {    // 모음이 1개 이상이고, 자음이 2개 이상이라면
                for(char num : numbers) System.out.print(num);  // 뽑은 원소들을 출력
                System.out.println();
            }
            return; // 기저조건이므로 반환함.
        }
        for(int i=cnt; i<C; i++) {  // 중복이 없는 조합문제이므로 cnt부터 시작한다.
            if(!isSelected[i] && (cnt==0 || (numbers[cnt-1] < arr[i]))) {   // 선택되지 않은 원소일때, 이전에 선택한 원소보다 지금 참조하고 있는 원소가 더 클때
                isSelected[i]=true;     // 원소를 사용할 것이므로 true 할당
                numbers[cnt]=arr[i];    // numbers에 arr[i]할당
                combination(cnt+1); // 다음 조합번호 재귀
                isSelected[i]=false;    // 원소사용을 마쳤으면 false 할당
            }
        }
    }
}
