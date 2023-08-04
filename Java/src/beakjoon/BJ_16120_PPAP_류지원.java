package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ_16120_PPAP_류지원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String PString = br.readLine();
		String[] ArrayPString;
		ArrayPString = PString.split("");
		
		System.out.println(Arrays.toString(ArrayPString));
		
		ArrayList<String> ListPString = (ArrayList<String>) Arrays.asList(ArrayPString);
		
		for(String a: ListPString) { System.out.println(a);}	
		
//		ArrayPString.
		
		
		
		
		
		
		
		
//		for(int i=0; i<PString.length(); i++) charList.add(PString.charAt(i));
		
//		for(int i=0; i<PString.length()-3; i++) {
//			System.out.println(charList.get(i).toString());
//		}
	}

}
