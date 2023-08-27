package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 14967KB, 시간 : 112ms
 * 풀이방법 :
 * 1. BFS를 하며 최단거리로 이동할 수 있는 맵을 제작한다.
 * 1-1. BFS를 할 때 여기서 상어보다 사이즈가 큰 곳은 이동할 수 없다는 조건을 추가한다.
 * 1-2. BFS를 할 때 맵에 먹을것이 있는지도 탐색한다. 만약 먹을것을 발견했다면 더 멀리 BFS를 돌릴 필요가 없으므로 다음 탐색구간을 큐에 담는 과정을 제외하고, 다음 큐를 꺼내어 루프를 계속한다.
 * 1-3. 1-2 과정을 하면 먹이가 있는 구간까지만 BFS 최단거리 지도가 완성되어 있을 것이다.
 *
 * 2. 가장 가까운 순으로 거리가 같을때에는 위, 왼쪽, 오른쪽, 아래 순으로 먹이를 탐색하여 상어를 이동시키고, 상어의 먹이먹은 수, 상어의 크기를 재설정하는 단계이다.
 * 2-1. 반복문을 이용하여 BFS 과정을 하면서 먹을 것을 발견했다면 먹이를 가장 가까운 경우, 위, 왼쪽, 오른쪽, 아래 순으로 먹이가 가장 가까운 곳으로 상어를 이동시키는 역할을 수행한다.
 * 2-2. 먹이를 먹었을 때 지금까지 먹은 먹이 수에 1을 더하고, 그 먹이수가 상어의 사이즈와 같다면 먹은 먹이수를 0으로 설정하고 크기를 1 높인다.
 * 2-2. BFS를 할 때 맵에서 먹을 것을 발견하지 못했다면 루프를 종료하고 지금까지의 turn을 출력한다.
 *
 * 3. 1번과 2번 과정을 먹을 수 있는 먹기가 없을때까지 계속해야하므로 큐와 방문지도를 초기화 시킨다. 그 후, 1,2번 과정을 반복한다.
 */

public class BJ_16236_아기상어_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;
        int N=Integer.parseInt(br.readLine());
        int[][] map=new int[N][N];      // 물고기 위치와 상어 위치 등 맵 상태를 나타내기 위한 배열
        int[] sharkLo=new int[2];       // 상어의 위치를 저장하기 위한 배열
        int sharkSize=2;                // 상어의 사이즈를 저장하기 위한 변수
        int eatingNum=0;                // 상어의 먹은 먹이 수를 저장하기 변수
        int time=0;                     // 흐른 시간을 나타내기 위한 변수

        for(int i=0; i<N; i++) {                            // 맵 공간 상태 배열 입력받기
            ST = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j]=Integer.parseInt(ST.nextToken());
                if(map[i][j]==9) {      // 만약 해당 위치가 9일 때, 즉, 상어일때 상어 위치를 sharkLo에 따로 저장.
                    sharkLo[0]= i;  sharkLo[1]= j;      // 상어 위치 저장.
                }
            }
        }

        int[] dr = {-1, 0, 0, 1};   // 상, 좌, 우, 하
        int[] dc = {0, -1, 1, 0};   // 상, 좌, 우, 하

        // BFS로 상어가 크기보다 작은 물고기들을 먹을 수 있을때까지 최단 거리 탐색.
        ArrayDeque<int[]> queue = new ArrayDeque<>();       // BFS에 쓰일 큐 생성. 큐에는 탐색위치가 들어가므로 배열이 들어감.
        int[][] visited=new int[N][N];                      // BFS에 쓰일 배열 생성. 배열에는 탐색위치를 방문했는지 여부가 들어가므로 이차원 배열로 생성.

        boolean ExistFishToHunt=true;                       // ExistFishToHunt가 false라면 먹이가 없는 것으로 상어는 엄마를 찾아간다. 처음에는 먹이가 있다고 가정하여 true로 설정한다.

        while(ExistFishToHunt) {        // 사냥할 수 있는 물고기가 있다면 수족관 탐색 및 사냥 실행
            ExistFishToHunt=false;      // 이번 턴이 끝나면 다음턴에는 사냥할 수 없는 물고기가 없다고 가정한다. BFS를 시도하며 다음 턴에 먹을 수 있는 물고기를 찾으면 true로 변환해준다.
            queue.offer(sharkLo);       // BFS로 상어의 위치로부터 이동할 수 있는 최단 거리들을 찾기위해 큐에 상어의 위치를 넣는다.
            visited[sharkLo[0]][sharkLo[1]]=1;  // 상어의 현재 위치를 이동거리 1로 한다.

            loop :
            while (!queue.isEmpty()) {      // 큐가 비어있지 않다면 계속 실행
                int[] current = queue.poll();   // 큐에서 하나를 뽑음
                int R=current[0], C=current[1]; // 큐에서 뽑은 배열로 행, 열 저장

                for (int i = 0; i < 4; i++) {   // 큐에서 뽑은 위치를 기반으로 상하좌우 탐색.
                    // valid는 탐색구간이 배열밖으로 나가지 않았는지 확인해주는 메서드이다.
                    // current의 상하좌우중에서 방문하지 않은곳이면서, 그 곳이 상어의 사이즈보다 작은 곳이면 탐색 가능.
                    if (valid(R + dr[i], C + dc[i], N) && visited[R + dr[i]][C + dc[i]] == 0 && map[R + dr[i]][C + dc[i]] <= sharkSize) {
                        visited[R + dr[i]][C + dc[i]] = visited[R][C] + 1;                                      // 현재 위치로부터 한칸 더 먼 곳이므로 1을 더하여 값을 할당
                        if(map[R + dr[i]][C + dc[i]] != 0 && map[R + dr[i]][C + dc[i]] < sharkSize) {           // 만약 0이 아니면서 상어사이즈보다 작으면, 즉 먹을수 있다면 더 깊이 탐색할 필요 없으므로 다음 큐로 진행
                            ExistFishToHunt=true;                                                               // 먹이를 찾았으므로 ExistFishToHunt를 true로 만듦.
                            continue loop;                                                                      // 먹이를 찾았으므로 더 멀리 탐색할 필요 없으므로 다음 탐색구간을 큐에 넣이않음으로서 더 깊이 탐색하지 않음. 아직 큐에 남은 곳들을 탐색하여 다른 구간들 탐색.
                        }
                        queue.offer(new int[]{R + dr[i], C + dc[i]});                                           // 먹이를 찾지못했다면 큐에 넣어 더 깊이 탐색하는 과정이 진행됨.
                    }
                }
            }

            if(ExistFishToHunt) {        // BFS로 거리를 재는 과정에서 먹이가 찾았다면 실행
                loop:
                for (int n = 2; ; n++) {               // 먹이 선택 우선순위 1 : 거리가 2인것부터 먹이를 찾을 떄까지 거리를 씩 늘려가는 반복문
                    for (int i = 0; i < N; i++) {        // 먹이 선택 우선순위 2 : 위에서부터 아래로 탐색
                        for (int j = 0; j < N; j++) {    // 먹이 선택 우선순위 3 : 왼쪽에서부터 오른쪽으로 탐색
                            if (visited[i][j] == n && map[i][j] > 0 && map[i][j] < sharkSize) {       // 탐색구간에 먹을 수 있는 사이즈의 물고기가 있다면
                                if (++eatingNum == sharkSize) {         // 먹이를 먹었으므로 eating에 1을 추가하고 sharkSize개수만큼 먹었는지 비교. 먹이를 상어 size만큼 먹었다면 아래 구현부 실행
                                    sharkSize++;
                                    eatingNum = 0;                      // 상어 사이즈를 1 늘림. 먹이를 0으로 만들어 초기화
                                }
                                map[sharkLo[0]][sharkLo[1]] = 0;        // 먹이를 먹으러 이동했으므로 원래 상어가 있던 위치를 0으로 만들어 빈공간으로 만듦.
                                sharkLo[0] = i; sharkLo[1] = j;         // 상어 위치에 먹이를 먹으러 온 현재 위치인 행,열 저장.
                                map[i][j] = Integer.MAX_VALUE;          // 먹이를 먹으러 온 현재 위치에 상어가 있다는 값을 저장. 상어의 값을 9로 하면 자기자신을 셀프로 먹는 무한루프가 실행되므로 Integer의 Max값을 넣었음.
                                time += (n - 1);                        // 상어가 이동한 거리가 곧 그만큼 시간이 지난 것이므로 n을 time에 더함. 최단거리 지도를 제작할 때 상어의 제자리가 1부터 시작했으므로 이동거리 n에서 1을 빼고 time에 더하였음.
                                break loop;                             // 먹이를 먹었으므로 턴 종료.
                            }
                        }
                    }
                }
                queue.clear();                                          // 다음 먹이를 찾기 위해 상어가 이동한 위치를 기반으로 BFS를 새로 실행해야하므로 queue를 초기화함.
                visited = new int[N][N];                                // 다음 먹이를 찾기 위해 BFS를 하여 알아냈던 최단거리 지도를 초기화함.
            }
        }
        System.out.print(time);                                         // 먹이를 더이상 찾을 수 없다면 소요된 시간을 출력함.
    }

    public static boolean valid(int R, int C, int N) {                  // 배열의 크기와 행, 열을 받아 행,열이 배열의 크기를 벗어나지않았는지 확인해주는 메서드.
        return (0<=R && R<N && 0<=C && C<N)? true : false;              // 행 또는 열이 0미만으로 내려갔거나 N 이상으로 올라갔다면 false를 반환. 모두 범위 내에 있다면 true를 반환.
    }
}