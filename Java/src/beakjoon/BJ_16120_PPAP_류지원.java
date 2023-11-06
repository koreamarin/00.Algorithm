package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ_16120_PPAP_류지원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S  = br.readLine();
		int BFSize = 0;
		int AFSize = Integer.MAX_VALUE;
		while(BFSize!=AFSize) {
			BFSize = S.length();
			S = S.replaceAll("PPAP", "P");
			AFSize = S.length();
		}
		
		if(S.equals("P")) System.out.println("PPAP");
		else System.out.println("NP");
	}

}
