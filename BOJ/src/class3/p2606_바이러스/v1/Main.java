package class3.p2606_바이러스.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] computers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        computers = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[a].add(b);
            computers[b].add(a);
        }

        System.out.println(searchVirus());

    }

    static int searchVirus() {
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Integer next : computers[cur]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
