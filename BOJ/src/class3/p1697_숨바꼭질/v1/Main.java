package class3.p1697_숨바꼭질.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100000;
    static int N, K;
    static int[] timesByPosition = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(timesByPosition, Integer.MAX_VALUE);
        timesByPosition[N] = 0;

        move(N);

        System.out.println(timesByPosition[K]);

    }

    static void move(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        while (!queue.isEmpty()) {
            int position = queue.poll();

            if(position == K) break;

            int time = timesByPosition[position] + 1;

            if (position + 1 <= MAX && time < timesByPosition[position + 1]) {
                timesByPosition[position + 1] = time;
                queue.offer(position + 1);
            }

            if (position - 1 >= 0 && time < timesByPosition[position - 1]) {
                timesByPosition[position - 1] = time;
                queue.offer(position - 1);
            }

            if (position * 2 <= MAX && time < timesByPosition[2 * position]) {
                timesByPosition[2 * position] = time;
                queue.offer(2 * position);
            }
        }
    }
}
