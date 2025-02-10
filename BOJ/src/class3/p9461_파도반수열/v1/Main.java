package class3.p9461_파도반수열.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] padovan = new long[101];

        for (int i = 1; i < 4; i++) {
            padovan[i] = 1;
        }

        for (int i = 4 ; i < 101 ; i++) {
            padovan[i] = padovan[i-3] + padovan[i-2];
        }

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(padovan[N]);
        }

    }
}
