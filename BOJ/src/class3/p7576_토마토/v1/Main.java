package class3.p7576_토마토.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int RED = 1;
    static final int GREEN = 0;
    static final int EMPTY = -1;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static int N, M, total;
    static int[][] graph;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        int empty = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if(graph[i][j] == RED) queue.offer(new int[]{i, j});

                if(graph[i][j] == EMPTY) empty++;

            }
        }

        total = N * M - empty;

        search();

    }

    static void search() {
        int sum = 0;
        int max = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            sum++;

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M && graph[ny][nx] == GREEN) {
                    queue.offer(new int[]{ny, nx});
                    graph[ny][nx] = graph[cur[0]][cur[1]] + 1;
                    max = Math.max(max, graph[ny][nx]);
                }
            }
        }

        if(sum == total) System.out.println(max == 0 ? 0 : max - 1);
        else System.out.println(-1);
    }
}
