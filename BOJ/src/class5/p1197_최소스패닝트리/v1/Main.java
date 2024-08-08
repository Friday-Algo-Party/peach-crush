package class5.p1197_최소스패닝트리.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V+1];
        for (int i = 0; i <= V; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a, b, c));
        }

        long result = kruskal();
        System.out.println(result);
    }

    static long kruskal() {
        int cnt = 0;
        long sum = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if(find(node.from) != find(node.to)) {
                union(node.from, node.to);
                cnt++;
                sum += node.cost;
            }

            if(cnt == V-1) break;
        }
        return sum;
    }

    static int find(int a) {
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b) {
        parents[find(b)] = find(a);
    }
}

class Node implements Comparable<Node> {
    int from;
    int to;
    int cost;

    public Node(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(cost, o.cost);
    }
}
