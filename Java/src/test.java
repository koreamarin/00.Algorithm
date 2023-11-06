import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class test {
	static int H, W;
	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[] A = new boolean[5];
		H = 5; W = 6;
		System.out.println(isRange(5, 0));
	}
	
	public static boolean isRange(int i, int j) {
		if(i<0 || H<=i) return false;
		if(j<0 || W<=j) return false;
		return true;
	}
}