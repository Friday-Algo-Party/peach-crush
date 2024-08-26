package class3.p2178_미로탐색.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] miro;
    static int[][] visited;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();

            for (int j = 0; j < M; j++) {
                miro[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        bfs();

        System.out.println(visited[N - 1][M - 1]);

    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && miro[ny][nx] == 1 && visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }
}
