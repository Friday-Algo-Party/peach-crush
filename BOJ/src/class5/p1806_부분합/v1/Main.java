package class5.p1806_부분합.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] prefixSum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int start = 0;
        int end = 1;
        int sum = 0;
        int len = N + 1;

        while (end <= N) {
            sum = prefixSum[end] - prefixSum[start];

            if (sum >= S) {
                len = Math.min(len, end - start);
                start++;
            }

            if (sum < S) {
                end++;
            }

        }

        System.out.println(len == N+1 ? 0 : len);

    }
}
