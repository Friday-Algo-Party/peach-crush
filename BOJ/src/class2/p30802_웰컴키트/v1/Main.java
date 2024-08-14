package class2.p30802_웰컴키트.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int SIZE = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tshirts = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            tshirts[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int tSum = 0;

        for (int i = 0; i < SIZE; i++) {
            tSum += tshirts[i] / T + (tshirts[i] % T == 0 ? 0 : 1);
        }

        System.out.println(tSum);
        System.out.println(N / P + " " + N % P);
    }
}
