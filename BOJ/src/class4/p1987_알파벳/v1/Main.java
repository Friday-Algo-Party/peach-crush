package class4.p1987_알파벳.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static int R, C;
    static char[][] board;
    static boolean[] visited;
    static int maxStep;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();

            for (int j = 0; j < C; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        visited[board[0][0] - 'A'] = true;
        move(0, 0, 1);

        System.out.println(maxStep);

    }

    static void move(int y, int x, int depth) {
        maxStep = Math.max(maxStep, depth);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 <= ny && ny < R && 0 <= nx && nx < C && !visited[board[ny][nx] - 'A']) {
                visited[board[ny][nx] - 'A'] = true;
                move(ny, nx, depth + 1);
                visited[board[ny][nx] - 'A'] = false;
            }
        }
    }
}
