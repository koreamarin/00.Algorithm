package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_17478_재귀함수가_뭔가요_류지원 {
	static int m=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(br.readLine())+1;
		m=i;
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recursion(i);
		
	}
	public static void recursion(int n) {
		for(int i=0;i<m-n;i++) System.out.print("____");
		System.out.println("\"재귀함수가 뭔가요?\"");
		if(n==1) {
			for(int i=0;i<m-n;i++) System.out.print("____");
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			for(int i=0;i<m-n;i++) System.out.print("____");
			System.out.println("라고 답변하였지.");
			return;
		}
		for(int i=0;i<m-n;i++) System.out.print("____");
		System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		for(int i=0;i<m-n;i++) System.out.print("____");
		System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		for(int i=0;i<m-n;i++) System.out.print("____");
		System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		recursion(n-1);
		for(int i=0;i<m-n;i++) System.out.print("____");
		System.out.println("라고 답변하였지.");
		
		return;
	}

}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class BJ_17478_재귀함수가_뭔가요_류지원 {
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