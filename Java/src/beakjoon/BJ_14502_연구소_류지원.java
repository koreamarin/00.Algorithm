package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원 
 * 메모리 : 190232KB 시간 : 376ms
 * 
 *         풀이 방법 : 0인 구간 완전탐색으로 3개를 골라서 벽을 세운다. 벽을 세운 뒤에는 flood fill로 바이러스를 퍼쳐서
 *         0인 구간의 총합을 찾는다. 벽 3개를 세운 모든 경우에서 안전구역의 최대값을 찾아낸다.
 */

public class BJ_14502_연구소_류지원 {
	static int[][] map, copyMap;
	static boolean[][] isVisited;
	static int N, M;
	static List<int[]> virusList;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());

		N = Integer.parseInt(ST.nextToken());
		M = Integer.parseInt(ST.nextToken());

		map = new int[N][M];

		virusList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			ST = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(ST.nextToken());
				if (map[i][j] == 2) {
					virusList.add(new int[] { i, j });
				}
			}
		}

		dfs(0, 0, 0);
		System.out.println(max);
	}

	static void dfs(int cnt, int si, int sj) {
		// 기저조건
		if (cnt == 3) {
			copyMap = new int[N][M];
			for (int i = 0; i < N; i++)
				copyMap[i] = Arrays.copyOf(map[i], M);

			isVisited = new boolean[N][M];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					if (copyMap[i][j] != 0)
						isVisited[i][j] = true;

			for (int[] virus : virusList) {
				flood_fill(virus[0], virus[1]);
			}

			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copyMap[i][j] == 0) {
						sum++;
					}
				}
			}
			if (sum > max)
				max = sum;

			return;
		}

		// 유도파트
		for (int i = si; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (si == i && sj > j)
					continue;
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt + 1, i, j);
					map[i][j] = 0;
				}
			}
		}
	}

	static void flood_fill(int i, int j) {
		int[] di = { 1, -1, 0, 0 };
		int[] dj = { 0, 0, 1, -1 };

		for (int k = 0; k < 4; k++) {
			if (isValid(i + di[k], j + dj[k]) && copyMap[i + di[k]][j + dj[k]] == 0
					&& !isVisited[i + di[k]][j + dj[k]]) {
				copyMap[i + di[k]][j + dj[k]] = 2;
				isVisited[i + di[k]][j + dj[k]] = true;
				flood_fill(i + di[k], j + dj[k]);
			}
		}
	}

	static boolean isValid(int i, int j) {
		if (0 > i || i >= N)
			return false;
		if (0 > j || j >= M)
			return false;
		return true;
	}
	
}
