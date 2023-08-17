package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 35176kb
 * 실행시간 : 187ms
 * 풀이방식 : 구현문제이므로 그냥 컨트롤대로 수행하도록 풀었다.
 */

public class D3_01873_상호의배틀필드_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<T+1; t++) {
            ST=new StringTokenizer(br.readLine());
            int H = Integer.parseInt(ST.nextToken()); int W = Integer.parseInt(ST.nextToken());
            char[][] map=new char[H][W];
            int row=0; int col=0;
            for(int h=0; h<H; h++) {
                String mapLine = br.readLine();
                for(int w=0; w<W; w++) {
                    map[h][w]=mapLine.charAt(w);
                    if(map[h][w]=='<' || map[h][w]=='^' || map[h][w]=='>' || map[h][w]=='v' ) {
                        row=h; col=w;
                    }
                }
            }
            int N = Integer.parseInt(br.readLine());
            String ctlLine=br.readLine();
            // 구현 시작
            for(int c=0; c<ctlLine.length(); c++) {
                char ctl=ctlLine.charAt(c);

                if(ctl=='U') {
                    map[row][col]='^';
                    if(row-1 >= 0 && map[row-1][col]=='.') {
                        map[row][col]='.';
                        map[row-1][col]='^';
                        row-=1;
                    }
                }
                else if(ctl=='D') {
                    map[row][col]='v';
                    if(row+1 < H && map[row+1][col]=='.') {
                        map[row][col]='.';
                        map[row+1][col]='v';
                        row+=1;
                    }
                }
                else if(ctl=='L') {
                    map[row][col]='<';
                    if(col-1 >= 0 && map[row][col-1]=='.') {
                        map[row][col]='.';
                        map[row][col-1]='<';
                        col-=1;
                    }
                }
                else if(ctl=='R') {
                    map[row][col]='>';
                    if(col+1 < W && map[row][col+1]=='.') {
                        map[row][col]='.';
                        map[row][col+1]='>';
                        col+=1;
                    }
                }
                else if(ctl=='S') {
                    if(map[row][col]=='>') {
                        int bullet=0;
                        while(col+bullet < W-1) {
                            bullet+=1;
                            if (map[row][col + bullet] == '#') {
                                break;
                            } else if (map[row][col + bullet] == '*') {
                                map[row][col + bullet] = '.';
                                break;
                            }
                        }
                    }
                    else if(map[row][col]=='<') {
                        int bullet=0;
                        while(col+bullet > 0) {
                            bullet-=1;
                            if (map[row][col + bullet] == '#') {
                                break;
                            } else if (map[row][col + bullet] == '*') {
                                map[row][col + bullet] = '.';
                                break;
                            }
                        }
                    }
                    else if(map[row][col]=='^') {
                        int bullet=0;
                        while(row+bullet > 0) {
                            bullet-=1;
                            if (map[row+bullet][col] == '#') {
                                break;
                            } else if (map[row + bullet][col] == '*') {
                                map[row + bullet][col] = '.';
                                break;
                            }
                        }
                    }
                    else if(map[row][col]=='v'){
                        int bullet=0;
                        while(row+bullet < H-1) {
                            bullet+=1;
                            if (map[row+bullet][col] == '#') {
                                break;
                            } else if (map[row+bullet][col] == '*') {
                                map[row+bullet][col] = '.';
                                break;
                            }
                        }
                    }
                }
            }
            System.out.print("#" + t +" ");
            for(int h=0; h<H; h++) {
                for (int w = 0; w < W; w++)
                    System.out.print(map[h][w]);
                System.out.println();
            }
        }
    }
}
