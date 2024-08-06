package class2.p1546_평균.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            scores.add(Integer.parseInt(st.nextToken()));
        }

        int max = Collections.max(scores);
        int sum = scores.stream().mapToInt(Integer::intValue).sum();
        double avg = (double) sum / max * 100 / N;
        System.out.println(avg);
    }
}