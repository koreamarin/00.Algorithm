package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

// 1. 큐에 넣어서 isDistroy를 true로 만든다
// 2. 큐에서 빼고 주변 상하좌우에 해당하는 벽돌들을 큐에 넣고 isdistroy를 true로 만든다. 이미 true인 것들은 넣지않는다.
// 3. isDistroy인 것들은 값을 0으로 만든다.
// 4. 아래로 착착 다시 쌓는다.
// 5. 이것들을 중복순열로 쏜다.

public class SW_05656_벽돌깨기_류지원 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			ST = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(ST.nextToken());	// 구슬 쏘는 횟수
			int W = Integer.parseInt(ST.nextToken());	// Width
			int H = Integer.parseInt(ST.nextToken());	// height
			
			List[] map = new List[W];
			
			
			
			
			
			
		}

	}

}
