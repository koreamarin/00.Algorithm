package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 44928KB
 * 시간 : 376ms
 * 풀이방법 :
 * 인접행렬을 사용하였을 때 메모리 낭비가 심하여 메모리 초과가 뜸
 * 인접행렬은 빠르다는 장점이 있지만, 노드가 많으면 메모리가 n^2로 필요함.
 * 인접 리스트는 간선이 많아질 수록 메모리사용량이 커지고, 속도도 느려짐.
 * 하지만 간선이 적다면 인접행렬보다 빠르고, 메모리 낭비도 적을 수 있음.
 * 밀집 그래프일수록 인접행렬이 유리하고, 희소그래프일수록 인접리스트가 유리함.
 *
 * 아래는 밀집 그래프를 이용한 위상정렬 방식을 이용하여 풀이하였음.
 *
 */

public class BJ_02252_줄세우기_류지원 {
    static class Node{  // 인접리스트. 노드와 그 노드가 향하는 정점을 저장하는 클래스.
        int vertex; Node next;
        public Node(int vertex, Node next) {
            this.next = next;
            this.vertex = vertex;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST=new StringTokenizer(br.readLine());
        StringBuilder SB=new StringBuilder();
        int N=Integer.parseInt(ST.nextToken());
        int M=Integer.parseInt(ST.nextToken());
        Node adjList[] = new Node[N];   // Node를 N개 생성
        for(int i=0; i<M; i++) {        // adjList 배열의 각 Node에 간선정보 입력하는 반복문
            ST = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(ST.nextToken()) - 1;
            int to = Integer.parseInt(ST.nextToken()) - 1;
            adjList[from] = new Node(to, adjList[from]);
        }
        int[] inDegreeArr=new int[N];   // 각 노드의 진입차수를 저장할 배열
        for(int j=0; j<N; j++)          // 인접리스트로부터 각 노드의 진출차수를 파악하여 진입받는 노드의 진입차수를 카운팅함
            for(Node temp=adjList[j]; temp!=null; temp=temp.next) {
                inDegreeArr[temp.vertex]++;
            }
        // 위상정렬 시작
        // 1. 전처리 과정을 했으니 진입차수가 0인 노드부터 queue에 넣기.
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<N; i++) if(inDegreeArr[i]==0) queue.offer(i);
        // 2. queue에서 순차적으로 노드를 빼면서, 해당 노드와 다른 노드가 이어져있다면 진입받는 노드는 진입차수에서 1을 빼기.
        while(!queue.isEmpty()) {
            int current = queue.poll();     // queue에서 노드번호 빼기.
            for(Node temp=adjList[current]; temp!=null; temp=temp.next) {   // 해당 노드의 진출차수 탐색하는 배열
                inDegreeArr[temp.vertex]-=1;            // 진출차수는 곧 받는 쪽의 진입차수가 되므로 진입차수 -1 하기
                if(inDegreeArr[temp.vertex]==0) queue.offer(temp.vertex);   // 진입차수가 0이라면 queue에 추가
            }
            SB.append((current + 1) + " ");     // StringBuilder에 queue에서 순차적으로 나오는 노드번호들 추가.
        }
        System.out.print(SB);   // SB 출력
    }
}
