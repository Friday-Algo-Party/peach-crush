package class5.p2166_다각형의면적.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] x = new long[N];
        long[] y = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        double result = 0;

        for (int i = 0; i < N - 1; i++) {
            result += ((x[i] * y[i + 1]) - (x[i + 1] * y[i]));
        }

        result += ((x[N-1] * y[0]) - (x[0] * y[N-1]));

        result = Math.abs(result) / 2;

        System.out.printf("%.1f", result);
    }
}
