import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test {
	static int[] numbers;
	static boolean[] isVisited;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		isVisited=new boolean[N];
		
		subset(0);
	}
	
	public static void subset(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(isVisited));
			return;
		}
		isVisited[cnt]=true;
		subset(cnt+1);
		isVisited[cnt]=false;
		subset(cnt+1);
	}

}