package class4.p9663_NQueen.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] board;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];

        nQueen(0);
        System.out.println(cnt);
    }

    static void nQueen(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isAvail(depth, i)) {
                board[depth] = i;
                nQueen(depth + 1);
            }
        }
    }

    static boolean isAvail(int depth, int x) {
        for (int i = 0; i < depth; i++) {
            if(x==board[i]) return false;
            if(Math.abs(depth-i)==Math.abs(x-board[i])) return false;
        }

        return true;
    }
}
