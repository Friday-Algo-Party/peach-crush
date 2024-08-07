package class4.p1149_RGB거리.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[3][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rgb[0][i] = Integer.parseInt(st.nextToken());
            rgb[1][i] = Integer.parseInt(st.nextToken());
            rgb[2][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            rgb[0][i] += Math.min(rgb[1][i - 1], rgb[2][i - 1]);
            rgb[1][i] += Math.min(rgb[0][i - 1], rgb[2][i - 1]);
            rgb[2][i] += Math.min(rgb[0][i - 1], rgb[1][i - 1]);
        }

        System.out.println(Math.min(Math.min(rgb[0][N-1], rgb[1][N-1]), rgb[2][N-1]));
    }
}
