package class4.p14502_연구소.v1;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] origin;
    static ArrayList<int[]> virus = new ArrayList<>();
    static ArrayList<int[]> empty = new ArrayList<>();
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        origin = new int[N][M];
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = origin[i][j];

                if (origin[i][j] == EMPTY) empty.add(new int[]{i, j});
                if (origin[i][j] == VIRUS) virus.add(new int[]{i, j});
            }
        }

        int emptySize = empty.size();

        for (int i = 0; i < emptySize - 2; i++) {
            for (int j = i + 1; j < emptySize - 1; j++) {
                for (int k = j + 1; k < emptySize; k++) {
                    map[empty.get(i)[0]][empty.get(i)[1]] = WALL;
                    map[empty.get(j)[0]][empty.get(j)[1]] = WALL;
                    map[empty.get(k)[0]][empty.get(k)[1]] = WALL;

                    int cnt = emptySize - 3 - spreadVirus();
                    max = Math.max(max, cnt);

                    copy();
                }
            }
        }

        System.out.println(max);
    }

    static int spreadVirus() {
        int cnt = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < virus.size(); i++) {
            int[] vpos = virus.get(i);
            queue.offer(new int[]{vpos[0], vpos[1]});
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int y = pos[0];
            int x = pos[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == EMPTY) {
                    map[ny][nx] = VIRUS;
                    queue.offer(new int[]{ny, nx});
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void copy() {
        for (int i = 0; i < N; i++) {
            map[i] = origin[i].clone();
        }
    }
}
