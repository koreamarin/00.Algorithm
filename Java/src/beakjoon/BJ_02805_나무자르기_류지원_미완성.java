package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author "Ryu jiwon"
 * 시간 : 
 * 메모리 : 
 * 풀이방법 : 
 * 나무의 높이가 10억까지 있으므로 이분탐색이 필요하다.
 * 
 */



public class BJ_02805_나무자르기_류지원_미완성 {
	static int N, M, MaxHeight;
	static int[] trees;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(br.readLine());
        N=Integer.parseInt(ST.nextToken());
        M=Integer.parseInt(ST.nextToken());
        trees=new int[N];
        ST=new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
            trees[i]=Integer.parseInt(ST.nextToken());
            MaxHeight = Math.max(MaxHeight, trees[i]);
        }
        int add = MaxHeight/2;
		System.out.println(binarySearch(MaxHeight/2, add/2));
    }
    
    public static int binarySearch(int h, int add){
    	// 기저조건
    	int sum=0;
    	int sum1=0;
    	int sum2=0;
    	
//    	try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	for(int tree:trees) {
    		if(tree>h) {
    			sum += tree-h;
    			sum1 += tree-(h-1);
    			sum2 += tree-(h+1);
    		}
    	}

    	System.out.println(h + " " + sum + " " + sum1 + " " + sum2);
    	
    	if(sum==M) {
    		return h;
    	}
    	else if(sum<M && sum1>=M) {
    		return h-1;
    	}
    	else if(sum>M && sum2<=M) {
    		return h;
    	}
    	// 유도파트
    	else if(sum<M) 
    		return binarySearch(h-add, add/2);
    	else // sum>M
    		return binarySearch(h+add, add/2);
    	
    }
}
