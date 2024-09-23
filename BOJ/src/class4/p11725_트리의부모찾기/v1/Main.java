package class4.p11725_트리의부모찾기.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        parent = new int[N+1];

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        findParent();

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }

    }

    static void findParent() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            for (Integer next : tree[cur]) {
                if(!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    parent[next] = cur;
                }
            }
        }
    }
}
