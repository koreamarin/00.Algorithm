package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
/**
 * 
 * @author 류지원
 * 메모리 : 28460kb
 * 시간 : 199ms
 * 풀이방법 : 단순구현하였다.
 *
 */
public class SW_05658_보물상자비밀번호_류지원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			ST=new StringTokenizer(br.readLine());
			int N = Integer.parseInt(ST.nextToken());	// 숫자의 개수, N은 4의 배수이며 8<= N <= 28
			int K = Integer.parseInt(ST.nextToken());	// K번째로 큰 수 구하기
			int M = N/4;								// 한 윈도우의 숫자의 개수 
			String S = br.readLine();					// N개의 숫자 입력받기.
			S = S+S;
			
			List<Integer> list = new ArrayList<>();
			
			for(int i=0; i<M; i++) {
				String A = S.substring(0+i, M+i);
				String B = S.substring(M+i, (M*2)+i);
				String C = S.substring((M*2)+i, (M*3)+i);
				String D = S.substring((M*3)+i, (M*4)+i);
				
				list.add(Integer.parseInt(A, 16));
				list.add(Integer.parseInt(B, 16));
				list.add(Integer.parseInt(C, 16));
				list.add(Integer.parseInt(D, 16));
			}
			
			list = list.stream().distinct().collect(Collectors.toList());
			list.sort(Comparator.reverseOrder());
			System.out.println("#" + t + " " + list.get(K-1));
		}
	}
}
