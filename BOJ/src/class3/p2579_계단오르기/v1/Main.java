package class3.p2579_계단오르기.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[][] dp = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1) {
            System.out.println(arr[1]);
        } else if (N == 2) {
            System.out.println(arr[1] + arr[2]);
        } else {
            for (int i = 1; i < 3; i++) {
                dp[i][0] = dp[i-1][0] + arr[i];
                dp[i+1][1] = dp[i-1][0] + arr[i+1];
            }

            for (int i = 2; i < N-1; i++) {
                dp[i+2][1] = Math.max(dp[i+2][1], dp[i][0] + arr[i+2]);
                dp[i+1][0] = Math.max(dp[i+1][0], dp[i][1] + arr[i+1]);
                dp[i+2][1] = Math.max(dp[i+2][1], dp[i][1] + arr[i+2]);
            }

            dp[N][0] = Math.max(dp[N][0], dp[N-1][1] + arr[N]);

            System.out.println(Math.max(dp[N][0], dp[N][1]));
        }
    }
}
