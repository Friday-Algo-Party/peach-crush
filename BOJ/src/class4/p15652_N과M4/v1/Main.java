package class4.p15652_N과M4.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] sequence;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sequence = new int[N];

        findSequence(1, 0);
        System.out.print(sb);
    }

    static void findSequence(int idx, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = idx; i <= N; i++) {
                sequence[depth] = i;
                findSequence(i, depth + 1);
            }
        }
    }
}
