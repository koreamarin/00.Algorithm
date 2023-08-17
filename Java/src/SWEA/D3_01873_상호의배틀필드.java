package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_01873_상호의배틀필드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			ST=new StringTokenizer(br.readLine());
			int H=Integer.parseInt(ST.nextToken());
			int W=Integer.parseInt(ST.nextToken());
			
			char[][] map=new char[H][W];
			for(int h=0; h<H; h++) {
				String mapOneLine= br.readLine();
				for(int w=0; w<W; w++) {
					map[h][w]=mapOneLine.charAt(w);
				}
			}
			
			int N=Integer.parseInt(br.readLine());
			
			String ctrLine=br.readLine();
			
			conductCtr(map, ctrLine, H, W, N);
			
		}
		
		
	}
	
	public static void conductCtr(char[][] map, String ctrLine, int H, int W, int N) {
		int r=0; int c=0; // 전차의 위치를 저장할 변수
		for(int i=0; i<H; i++) 
			for(int j=0; j<W; j++) 
				if(map[i][j]=='<' || map[i][j]=='^' || map[i][j]=='v' || map[i][j]=='>') {
					r=i; c=j;
				}

		
		
		for(int i=0; i<N; i++) {
			char ctr = ctrLine.charAt(i);
			System.out.println(ctr);
			
			if(ctr=='U') {
				// 위를 바라봄.
				map[r][c]='^';
				// 위쪽이 안막혀 있다면 위로 한칸 이동
				if(r>0 && map[r-1][c]=='.') {
					map[r][c]='.';
					map[r-1][c]='^';
					r-=1;
				}
			}
			else if(ctr=='D') {
				// 아래를 바라봄.
				map[r][c]='v';
				
				// 아래쪽이 안막혀 있다면 아래로 한칸 이동
				if(r<H-1 && map[r+1][c]=='.') {
					map[r][c]='.';
					map[r+1][c]='v';
					r+=1;
				}
			}
			else if(ctr=='L') {
				// 왼쪽를 바라봄.
				map[r][c]='<';
				// 왼쪽이 안막혀 있다면 위로 한칸 이동
				if(c>0 && map[r][c-1]=='.') {
					map[r][c]='.';
					map[r][c-1]='<';
					c-=1;
				}
			}
			else if(ctr=='R') {
				// 오른쪽를 바라봄.
				map[r][c]='>';
				// 오른쪽이 안막혀 있다면 위로 한칸 이동
				if(c<W-1 && map[r][c+1]=='.') {
					map[r][c]='.';
					map[r][c+1]='>';
					c+=1;
				}
			}
			else if(ctr=='S') {
				// 바라보는 방향에 벽돌이 있다면 평지로 만듦
				if(map[r][c]=='<') {
					int bulletRltLo=0;
					while(c+bulletRltLo>0 && map[r][c+bulletRltLo]!='#') {
						bulletRltLo-=1;
						if(map[r][c+bulletRltLo]=='*') {
							map[r][c+bulletRltLo]='.';
							break;
						}
					}
				}
				else if(map[r][c]=='>') {
					int bulletRltLo=0;
					while(c+bulletRltLo<W || map[r][c+bulletRltLo]!='#') {
						bulletRltLo+=1;
						if(map[r][c+bulletRltLo]=='*') {
							map[r][c+bulletRltLo]='.';
							break;
						}
					}
				}
				else if(map[r][c]=='^') {
					int bulletRltLo=0;
					while(r+bulletRltLo>0 || map[r+bulletRltLo][c]!='#') {
						bulletRltLo-=1;
						if(map[r+bulletRltLo][c]=='*') {
							map[r+bulletRltLo][c]='.';
							break;
						}
					}
				}
				else if(map[r][c]=='v') {
					int bulletRltLo=0;
					while(r+bulletRltLo<W-1 || map[r+bulletRltLo][c]!='#') {
						bulletRltLo+=1;
						if(map[r+bulletRltLo][c]=='*') {
							map[r+bulletRltLo][c]='.';
							break;
						}
					}
				}
			}
			for(int k=0;k<H; k++) System.out.println(map[k]);
			System.out.println();
		}
	}
}
