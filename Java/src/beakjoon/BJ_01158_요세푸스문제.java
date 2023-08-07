package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_01158_요세푸스문제 {

	public static void main(String[] args) throws IOException {
		//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		StringBuilder SB = new StringBuilder();
		int N = Integer.parseInt(ST.nextToken());
		int K = Integer.parseInt(ST.nextToken());
		int[] arr = new int[N];
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) list.add(i+1);
		
		int j=K-1;
		int i=0;
		
		SB.append("<");
		while(list.size()>0) {
			arr[i++]=list.remove(j);
			if(list.size()!=0) j=j+K-1>=list.size() ? (j+K-1)%list.size() : j+K-1;
		}
		
		for(int n=0; n<N-1; n++) SB.append(arr[n] + ", ");
		SB.append(arr[N-1] + ">");
		System.out.println(SB);
	}
}
