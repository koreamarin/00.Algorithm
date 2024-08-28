package beakjoon;
import java.io.*;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(br.readLine());
        StringBuilder SB;
        int N = Integer.parseInt(ST.nextToken()), L = Integer.parseInt(ST.nextToken());
        boolean B = true;
        for(int i=L; i<=100; i++) {
        	int x = N-(i*(i+1)/2);
        	SB = new StringBuilder();
        	if(x%i!=0) continue; 
    		if((x=x/i)>=-1) {
    			for(int j=1; j<i+1; j++) SB.append((x+j)+" "); 
    			System.out.println(SB);
    			B = false;
    			break;
    		}
        }
        if(B) System.out.println("-1");
    }
}