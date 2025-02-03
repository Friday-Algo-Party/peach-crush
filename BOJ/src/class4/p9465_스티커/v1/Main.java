package class4.p9465_스티커.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][n+1];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 2; i <= n; i++) {
                sticker[0][i] += Math.max(sticker[1][i-2], sticker[1][i-1]);
                sticker[1][i] += Math.max(sticker[0][i-2], sticker[0][i-1]);
            }

            System.out.println(Math.max(sticker[0][n], sticker[1][n]));
        }

    }
}
