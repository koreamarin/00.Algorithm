import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test {
	static int H, W;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		
		int A= in.nextInt();
		int[][] B = new int [2][2];
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				B[i][j]=in.nextInt();
			}
		}
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				System.out.print(B[i][j]);
			}
			System.out.println();
		}
	}
	

}