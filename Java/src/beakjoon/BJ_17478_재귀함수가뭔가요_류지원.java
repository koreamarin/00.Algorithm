package beakjoon;

/** @author 류지원
 * 	<pre>
 * 	    숫자를 입력한 만큼 답변을 반복하므로, 재귀함수를 사용한다.
 * 	</pre>
 * 	처리시간 : 0초
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_17478_재귀함수가뭔가요_류지원 {
	static int m=0;			// 반복횟수를 저장할 m 변수 선언.
	public static void main(String[] args) throws IOException {
		// 키보드로부터 입력을 받기 위한 BufferedReader 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 키보드로 받은 정수에 1을 더하여 int i 변수에 저장.
		int i = Integer.parseInt(br.readLine())+1;
		// m에 i를 저장.
		m=i;
		// 해당 문자열 출력.
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		// 재귀 함수 실행. 매개변수 i는 재귀 횟수.
		recursion(i);
	}
	public static void recursion(int n) {
		// 재귀횟수만큼 "____"출력
		for(int i=0;i<m-n;i++) System.out.print("____");
		// 해당 문자열 출력.
		System.out.println("\"재귀함수가 뭔가요?\"");

		// 재귀의 남은 횟수가 1이라면 다른 답변을 출력.
		if(n==1) {
			for(int i=0;i<m-n;i++) System.out.print("____"); 	// 재귀횟수만큼 "____"출력
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");	 // 해당 문자열 출력.
			for(int i=0;i<m-n;i++) System.out.print("____");	// 재귀횟수만큼 "____"출력
			System.out.println("라고 답변하였지.");				// 해당 문자열 출력.
			return;								// 더 이상 재귀함수를 호출하지 않고 리턴.
		}
		// 해당 문자열 출력.
		for(int i=0;i<m-n;i++) System.out.print("____");	// 재귀횟수만큼 "____"출력
		// 해당 문자열 출력.
		System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		for(int i=0;i<m-n;i++) System.out.print("____");	// 재귀횟수만큼 "____"출력
		// 해당 문자열 출력.
		System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		for(int i=0;i<m-n;i++) System.out.print("____");	// 재귀횟수만큼 "____"출력
		// 해당 문자열 출력.
		System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		// 재귀함수 호출. n은 재귀의 남은 횟수.
		recursion(n-1);
		for(int i=0;i<m-n;i++) System.out.print("____");	// 재귀횟수만큼 "____"출력
		// 해당 문자열 출력.
		System.out.println("라고 답변하였지.");
	}
}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class BJ_17478_재귀함수가_뭔가요류지원 {
//    
//    static String quest="\"재귀함수가 뭔가요?\"";
//    static String quest2="\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
//    static String quest3="마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
//    static String quest4="그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
//    static String ans="\"재귀함수는 자기 자신을 호출하는 함수라네\"";
//    static String ans2="라고 답변하였지.";
//    static String underBar="____";
//    
//    public static void main(String[] args) throws Exception{
//        
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        int n=Integer.parseInt(br.readLine());
//        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
//        recursion(0,n,"");
//    }
//    
//    public static void recursion(int curr,int depth,String temp) {
//        
//        System.out.println(temp+quest);
//        if(depth==curr) {
//            System.out.println(temp+ans);
//            return;
//        }
//        System.out.println(temp+quest2);
//        System.out.println(temp+quest3);
//        System.out.println(temp+quest4);
//
//        recursion(++curr,depth,temp+underBar);
//        System.out.println(temp+ans2);
//        return;
//    }
//}