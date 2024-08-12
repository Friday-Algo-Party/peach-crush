package class2.p2839_설탕배달.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MAX = (int) 1e9;
    static final int[] WEIGHTS = {3, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < WEIGHTS.length; j++) {
                int idx = i - WEIGHTS[j];

                if(idx >= 0 && dp[idx] != -1) {
                    dp[i] = Math.min(dp[i], dp[idx] + 1);
                }
            }

            if (dp[i] == MAX) {
                dp[i] = -1;
            }
        }

        System.out.println(dp[N]);
    }
}
