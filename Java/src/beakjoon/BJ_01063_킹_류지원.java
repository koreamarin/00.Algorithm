package beakjoon;

/**
 * @author ������
 * ���� : SWEA 1063
 * 
 * ���̵�� : 
 * �ܼ� ���������̹Ƿ� �Է¿� ���� ŷ�� ��ġ�� ���� ��ġ�� �����δ�.
 * ���� ŷ�̳� ���� ��ġ�� ü������ ��ġ�� ����ٸ� �� �̵��� �����Ѵ�.
 * 
 */

import java.io.*;
import java.util.*;

public class BJ_01063_ŷ_������ {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		String king = ST.nextToken();
		int kingx = king.charAt(1)-'0';
		int kingy = king.charAt(0)-'A'+1;
		
		String stone = ST.nextToken();
		int stonex = stone.charAt(1)-'0';
		int stoney = stone.charAt(0)-'A'+1;
		
		int movenum = Integer.parseInt(ST.nextToken());
		int[] dx = {1,-1,0,0,1, -1,1, -1};
		int[] dy = {0,0,-1,1,1, 1, -1,-1};
		
		for (int i=0; i<movenum; i++) {
			String move = br.readLine();
			int idx = 0;
			int tmpx = kingx;
			int tmpy = kingy;
			
			if (move=="R") {
				idx=0;
			} else if (move=="L") {
				idx=1;
			} else if (move=="B") {
				idx=2;
			} else if (move=="T") {
				idx=3;
			} else if (move=="RT") {
				idx=4;
			} else if (move=="LT") {
				idx=5;
			} else if (move=="RB") {
				idx=6;
			} else if (move=="LB") {
				idx=7;
			}
			tmpx += dx[idx];
			tmpy += dy[idx];
			
			if(tmpx>=1 && tmpx<=8 && tmpy>=1 && tmpy<=8) {
				if(tmpx==stonex && tmpy==stoney) {
					if(stonex+dx[idx]>=1 && stonex+dx[idx]<=8 && stoney+dy[idx]>=1 && stoney+dy[idx]<=8) {
						stonex += dx[idx];
						stoney += dy[idx];
					} else {
						continue;
					}
				}
				kingx = tmpx;
				kingy = tmpy;
			}
		}
		
		king = "";
		stone = "";
		
		king += Character.toString((char)(kingx+'A'-1)) + kingy;
		stone += Character.toString((char)(stonex+'A'-1)) + stoney;
		
		System.out.println(kingx);
		System.out.println(kingy);
		System.out.println(stonex);
		System.out.println(stoney);
		
		
	}

}
