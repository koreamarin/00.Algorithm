import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
	static int[] numbers;
	static boolean[] isVisited;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int M=5;
		List<Integer>[] adjList = new ArrayList[M];
		for(int m=0; m<M; m++) adjList[m]=new ArrayList<>();
		
		for(List<Integer> list : adjList) {
			System.out.println(list);
		}
	}
	

}