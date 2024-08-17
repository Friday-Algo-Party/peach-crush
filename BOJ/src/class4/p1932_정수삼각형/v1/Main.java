package class4.p1932_정수삼각형.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] sum = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++) {
                int num = Integer.parseInt(st.nextToken());
                sum[i][j] = num;

                if (i - 1 >= 0) {
                    if (j - 1 >= 0) sum[i][j] = Math.max(sum[i][j], num + sum[i - 1][j - 1]);
                    if (j <= i - 1) sum[i][j] = Math.max(sum[i][j], num + sum[i - 1][j]);
                }

            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, sum[n-1][i]);
        }

        System.out.println(max);
    }
}
