package class2.p1546_평균.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            max = Math.max(max, score);
            sum += score;
        }

        double avg = (double) sum / max * 100 / N;
        System.out.println(avg);
    }
}