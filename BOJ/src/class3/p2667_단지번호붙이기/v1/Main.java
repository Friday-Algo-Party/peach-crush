package class3.p2667_단지번호붙이기.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        List<Integer> houseCnts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    houseCnts.add(search(i, j));
                }
            }
        }

        Collections.sort(houseCnts);

        System.out.println(houseCnts.size());
        for (Integer houseCnt : houseCnts) {
            System.out.println(houseCnt);
        }
    }

    static int search(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx] && map[ny][nx] == 1) {
                    queue.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
